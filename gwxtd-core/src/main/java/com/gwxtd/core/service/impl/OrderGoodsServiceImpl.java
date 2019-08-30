package com.gwxtd.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.dao.GoodsBackupMapper;
import com.gwxtd.core.dao.GoodsMapper;
import com.gwxtd.core.dao.OrderGoodsMapper;
import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.pojo.GoodsBackup;
import com.gwxtd.core.pojo.OrderGoods;
import com.gwxtd.core.pojo.OrderGoodsCriteria;
import com.gwxtd.core.service.OrderGoodsService;

@Service
@Transactional
public class OrderGoodsServiceImpl implements OrderGoodsService{
	@Autowired
	private OrderGoodsMapper orderGoodsMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsBackupMapper goodsBackupMapper;
	@Override
	public List<OrderGoods> selectByOid(Integer oid) {
		OrderGoodsCriteria example = new OrderGoodsCriteria();
		example.createCriteria().andOidEqualTo(oid);
		List<OrderGoods> list = orderGoodsMapper.selectByExample(example);
		for(OrderGoods orderGoods:list){
			GoodsBackup goodsBackup = goodsBackupMapper.selectById(orderGoods.getGid());
			orderGoods.setGname(goodsBackup.getGname());
		}
		return list;
	}

}
