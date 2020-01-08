package com.gwxtd.core.appbean;

import java.util.Date;

public class AppOrder {
	private int oId;
	private String orderNum;
	private Date oDate;
	private int aId;
	private String oState;
	private String oRecname;
	private String oRecadr;
	private String oRectel;
	private int uId;
	private double oTotalPrice;
	private int payWay;
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getoDate() {
		return oDate;
	}
	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getoState() {
		return oState;
	}
	public void setoState(String oState) {
		this.oState = oState;
	}
	public String getoRecname() {
		return oRecname;
	}
	public void setoRecname(String oRecname) {
		this.oRecname = oRecname;
	}
	public String getoRecadr() {
		return oRecadr;
	}
	public void setoRecadr(String oRecadr) {
		this.oRecadr = oRecadr;
	}
	public String getoRectel() {
		return oRectel;
	}
	public void setoRectel(String oRectel) {
		this.oRectel = oRectel;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public double getoTotalPrice() {
		return oTotalPrice;
	}
	public void setoTotalPrice(double oTotalPrice) {
		this.oTotalPrice = oTotalPrice;
	}
	public int getPayWay() {
		return payWay;
	}
	public void setPayWay(int payWay) {
		this.payWay = payWay;
	}
	

}
