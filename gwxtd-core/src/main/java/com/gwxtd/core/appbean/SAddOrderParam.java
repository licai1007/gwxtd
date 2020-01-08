package com.gwxtd.core.appbean;
import java.util.ArrayList;

public class SAddOrderParam {
	private long userId;//用户id
	private long addrId;//地址id
	private int payWay = -1;//0在线支付 1货到付款
	private ArrayList<SAddOrderProductParam> products;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getAddrId() {
		return addrId;
	}
	public void setAddrId(long addrId) {
		this.addrId = addrId;
	}
	public int getPayWay() {
		return payWay;
	}
	public void setPayWay(int payWay) {
		this.payWay = payWay;
	}
	public ArrayList<SAddOrderProductParam> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<SAddOrderProductParam> products) {
		this.products = products;
	}
	
}
