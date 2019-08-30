package com.gwxtd.core.service;

import java.util.List;

import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.pojo.Order;
import com.gwxtd.core.pojo.OrderCriteria;
import com.qingniao.common.page.PageInfo;

public interface OrderService {
	public boolean saveOrder(Order order,List<Goods> goodss);
	public PageInfo orderShow(OrderCriteria orderCriteria);
	public Order selectOrderById(Integer oid);
	public boolean deleteById(Integer oid);
	public boolean delivery(Order order);
}
