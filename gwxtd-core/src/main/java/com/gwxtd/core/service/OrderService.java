package com.gwxtd.core.service;

import java.util.List;

import com.gwxtd.core.appbean.ROrderDetails;
import com.gwxtd.core.appbean.ROrderListBean;
import com.gwxtd.core.appbean.ROrderParam;
import com.gwxtd.core.appbean.SAddOrderParam;
import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.pojo.Order;
import com.gwxtd.core.pojo.OrderCriteria;
import com.qingniao.common.page.PageInfo;

public interface OrderService {
	boolean saveOrder(Order order,List<Goods> goodss);
	PageInfo orderShow(OrderCriteria orderCriteria);
	Order selectOrderById(Integer oid);
	boolean deleteById(Integer oid);
	boolean delivery(Order order);
	ROrderParam handleAppOrder(SAddOrderParam paramsBean);
	List<ROrderListBean>getOrderByStatus(int status,long userId);
	boolean confirmOrder(long oid);
	ROrderDetails getOrderDetail(long oid);
	int getCountByStatus(String ostate,Integer uid);
}
