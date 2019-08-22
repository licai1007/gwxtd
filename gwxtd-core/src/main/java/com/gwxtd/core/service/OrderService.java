package com.gwxtd.core.service;

import java.util.List;

import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.pojo.Order;

public interface OrderService {
	public boolean saveOrder(Order order,List<Goods> goodss);
}
