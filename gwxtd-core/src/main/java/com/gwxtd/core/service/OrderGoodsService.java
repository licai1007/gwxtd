package com.gwxtd.core.service;

import java.util.List;

import com.gwxtd.core.pojo.OrderGoods;

public interface OrderGoodsService {
	public List<OrderGoods> selectByOid(Integer oid);
}
