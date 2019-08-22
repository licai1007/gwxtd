package com.gwxtd.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.dao.GoodsMapper;
import com.gwxtd.core.dao.OrderGoodsMapper;
import com.gwxtd.core.dao.OrderMapper;
import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.pojo.GoodsCriteria;
import com.gwxtd.core.pojo.Order;
import com.gwxtd.core.pojo.OrderGoods;
import com.gwxtd.core.service.OrderService;
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderGoodsMapper orderGoodsMapper;
	@Autowired
	private GoodsMapper goodsMapper;
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
				
				//修改库存
				int amount = goods.getGamount().intValue()-goods.getBuynum();
				goods.setGamount(amount);
				GoodsCriteria example = new GoodsCriteria();
				example.createCriteria().andGidEqualTo(goods.getGid());
				goodsMapper.updateByExample(goods,example);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//订单记录失败
			return false;
		}
		//订单记录成功
		return true;
	}
	
}
