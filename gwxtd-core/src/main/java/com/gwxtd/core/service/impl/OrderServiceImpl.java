package com.gwxtd.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	
}
