package com.gwxtd.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.appbean.AppOrder;
import com.gwxtd.core.appbean.AppOrdergoods;
import com.gwxtd.core.appbean.ROrderDetails;
import com.gwxtd.core.appbean.ROrderDetailsProducts;
import com.gwxtd.core.appbean.ROrderListBean;
import com.gwxtd.core.appbean.ROrderParam;
import com.gwxtd.core.appbean.RReceiver;
import com.gwxtd.core.appbean.SAddOrderParam;
import com.gwxtd.core.appbean.SAddOrderProductParam;
import com.gwxtd.core.common.Constant;
import com.gwxtd.core.common.GenerateId;
import com.gwxtd.core.dao.AppOrderMapper;
import com.gwxtd.core.dao.AppOrdergoodsMapper;
import com.gwxtd.core.dao.AppReceiverMapper;
import com.gwxtd.core.dao.GoodsMapper;
import com.gwxtd.core.dao.OrderGoodsMapper;
import com.gwxtd.core.dao.OrderMapper;
import com.gwxtd.core.dao.UserMapper;
import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.pojo.GoodsCriteria;
import com.gwxtd.core.pojo.Order;
import com.gwxtd.core.pojo.OrderCriteria;
import com.gwxtd.core.pojo.OrderGoods;
import com.gwxtd.core.pojo.OrderGoodsCriteria;
import com.gwxtd.core.pojo.User;
import com.gwxtd.core.service.OrderService;
import com.qingniao.common.page.PageInfo;
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderGoodsMapper orderGoodsMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AppOrderMapper appOrderMapper;
	@Autowired
	private AppReceiverMapper appReceiverMapper;
	@Autowired
	private AppOrdergoodsMapper appOrdergoodsMapper;
	@Override
	public boolean saveOrder(Order order,List<Goods> goodss){
		try {
			//记录订单
			orderMapper.insertSelective(order);
			for(Goods goods:goodss){
				//记录订单明细
				OrderGoods record = new OrderGoods();
				record.setOid(order.getOid());
				record.setUid(order.getUid());
				record.setGid(goods.getGid());
				record.setOgamount(goods.getBuynum());
				double totalPrice = goods.getGprice()*(goods.getBuynum().intValue());
				record.setOgtotalprice(totalPrice);
				orderGoodsMapper.insertSelective(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//订单记录失败
			return false;
		}
		//订单记录成功
		return true;
	}
	@Override
	public PageInfo orderShow(OrderCriteria orderCriteria) {
		int totalCount = orderMapper.countByExample(orderCriteria);
		List<Order> orders = orderMapper.selectByExample(orderCriteria);
		for(Order order:orders){
			User user = userMapper.selectByPrimaryKey(order.getUid());
			order.setUname(user.getUname());
		}
		PageInfo pageInfo = new PageInfo(orderCriteria.getPageNo(),orderCriteria.getPageSize(),totalCount,orders);
		orderCriteria.setPageNo(pageInfo.getPageNo());//矫正当前页
		return pageInfo;
	}
	@Override
	public Order selectOrderById(Integer oid) {
		return orderMapper.selectByPrimaryKey(oid);
	}
	@Override
	public boolean deleteById(Integer oid) {
		try {
			OrderGoodsCriteria example = new OrderGoodsCriteria();
			example.createCriteria().andOidEqualTo(oid);
			orderGoodsMapper.deleteByExample(example);
			orderMapper.deleteByPrimaryKey(oid);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean delivery(Order order) {
		try {
			orderMapper.updateByPrimaryKeySelective(order);
			//修改库存
			OrderGoodsCriteria criteria = new OrderGoodsCriteria();
			criteria.createCriteria().andOidEqualTo(order.getOid());
			List<OrderGoods> orderGoodss = orderGoodsMapper.selectByExample(criteria);
			for(OrderGoods orderGoods:orderGoodss){
				Goods goods = goodsMapper.selectByPrimaryKey(orderGoods.getGid());
				int amount = goods.getGamount().intValue()-orderGoods.getOgamount();
				goods.setGamount(amount);
				GoodsCriteria example = new GoodsCriteria();
				example.createCriteria().andGidEqualTo(orderGoods.getGid());
				goodsMapper.updateByExample(goods,example);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public ROrderParam handleAppOrder(SAddOrderParam paramsBean) {
		AppOrder order = new AppOrder();
		order.setaId(0);//默认为0
		Date date = new Date();
		order.setoDate(date);
		String orderNumber = GenerateId.generateId();
		order.setOrderNum(orderNumber);
		RReceiver receiver = appReceiverMapper.selectById((int)paramsBean.getAddrId());
		order.setoRecadr(receiver.getReceiverAddress());
		order.setoRecname(receiver.getReceiverName());
		order.setoRectel(receiver.getReceiverPhone());
		String stateStr = "";
		if(paramsBean.getPayWay()==0){
			//在线支付
			stateStr = "待支付";
		}else if(paramsBean.getPayWay()==1){
			//货到付款
			stateStr = "未发货";
		}
		order.setoState(stateStr);
		double totalPrice = 0;
		for(SAddOrderProductParam param:paramsBean.getProducts()){
			Goods goods = goodsMapper.selectByPrimaryKey((int)param.getPid());
			totalPrice += goods.getGprice()*param.getBuyCount();
		}
		order.setoTotalPrice(totalPrice+Constant.FREIGHT);
		order.setPayWay(paramsBean.getPayWay());
		order.setuId((int)paramsBean.getUserId());
		appOrderMapper.insertOrder(order);
		
		AppOrdergoods appOrdergoods = null;
		for(SAddOrderProductParam param:paramsBean.getProducts()){
			appOrdergoods = new AppOrdergoods();
			appOrdergoods.setgId((int)param.getPid());
			appOrdergoods.setoGamount(param.getBuyCount());
			Goods goods = goodsMapper.selectByPrimaryKey((int)param.getPid());
			double price = goods.getGprice()*param.getBuyCount();
			appOrdergoods.setoGtotalprice(price);
			appOrdergoods.setOId(order.getoId());
			appOrdergoods.setProductType(param.getType());
			appOrdergoods.setuId((int)paramsBean.getUserId());
			appOrdergoodsMapper.insert(appOrdergoods);
		}
		
		ROrderParam orderParam = new ROrderParam();
		orderParam.setAllPrice(totalPrice);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		orderParam.setBuyTime(sdf.format(date));
		orderParam.setErrorType(0);
		orderParam.setFreight(Constant.FREIGHT);
		orderParam.setOid(order.getoId());
		orderParam.setOrderNum(orderNumber);
		orderParam.setPayWay(paramsBean.getPayWay());
		orderParam.setPname("京东商品");
		orderParam.setTn("");
		orderParam.setTotalPrice(totalPrice+Constant.FREIGHT);
		return orderParam;
	}
	@Override
	public List<ROrderListBean> getOrderByStatus(int status, long userId) {
		String ostate = "";
		switch (status) {
			case -1:
				ostate = "取消订单";
				break;
			case 0:
				ostate = "待支付";
				break;
			case 1:
				ostate = "未发货";
				break;
			case 2:
				ostate = "已发货";
				break;
			case 3:
				ostate = "完成交易";
				break;
			case 4:
				ostate = "所有订单";
				break;
		}
		List<Order> orders = orderMapper.getOrderByStatus(ostate,(int)userId);
		List<ROrderListBean> rList = new ArrayList<>();
		for (Order order : orders) {
			ROrderListBean rOrder = new ROrderListBean();
			rOrder.setOid(order.getOid());
			rOrder.setOrderNum(order.getOrderNum());
			List<String> orderImg = orderMapper.getOrderImg(order.getOid());
			rOrder.setItems(orderImg);
			rOrder.setPaid(order.isPaid());
			int state = setState(order.getOstate());
			rOrder.setStatus(state);
			//TODO rOrder.setTn("");
			rOrder.setTotalPrice(order.getOtotalprice());
			rOrder.setPname("京东商品");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String buyTime = sdf.format(order.getOdate());
			rOrder.setBuyTime(buyTime);
			rList.add(rOrder);
		}
		return rList;
	}
	@Override
	public boolean confirmOrder(long oid) {
		int i = orderMapper.confirmOrder((int)oid);
		return i==1;
	}
	@Override
	public ROrderDetails getOrderDetail(long oid) {
		Order order = orderMapper.selectByPrimaryKey((int)oid);
		ROrderDetails details = new ROrderDetails();
		details.setOrderNum(order.getOrderNum());
		int i = setState(order.getOstate());
		details.setStatus(i);
		details.setReceiverName(order.getOrecname());
		details.setReceiverAddress(order.getOrecadr());
		details.setReceiverPhone(order.getOrectel());
		loadItems(details,oid);
		details.setTotalPrice(order.getOtotalprice()+10);
		details.setFreight(10.0);//运费默认10元
		setCreateTime(details,order.getOdate());
		return details;
	}
	private int setState(String state){
		if(state.equals("取消订单")){
			return -1;
		}else if(state.equals("待支付")){
			return 0;
		}else if(state.equals("未发货")){
			return 1;
		}else if(state.equals("已发货")){
			return 2;
		}else if(state.equals("完成交易")){
			return 3;
		}
		return 4;
	}
	private void loadItems(ROrderDetails details,long oid){
		OrderGoodsCriteria criteria = new OrderGoodsCriteria();
		criteria.createCriteria().andOidEqualTo((int)oid);
		List<OrderGoods> orderGoodss = orderGoodsMapper.selectByExample(criteria);
		List<ROrderDetailsProducts> products = new ArrayList<>();
		for(OrderGoods orderGoods:orderGoodss){
			ROrderDetailsProducts product = new ROrderDetailsProducts();
			Goods goods = goodsMapper.selectByPrimaryKey(orderGoods.getGid());
			product.setAmount(orderGoods.getOgtotalprice());
			product.setBuyCount(orderGoods.getOgamount());
			product.setPiconUrl(goods.getGimgurl());
			product.setPid(orderGoods.getGid());
			product.setPname(goods.getGname());
			product.setVersion(orderGoods.getProductType());
			products.add(product);
		}
		details.setItems(products);
	}
	private void setCreateTime(ROrderDetails details,Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(date);
		details.setBuyTime(dateStr);
	}
	@Override
	public int getCountByStatus(String ostate, Integer uid) {
		return orderMapper.getCountByStatus(ostate,uid);
	}

	
}
