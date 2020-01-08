package com.gwxtd.core.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AppPayService {
	String getAlipayInfo(long oid,double money);
	void notifyOrderInfo(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
