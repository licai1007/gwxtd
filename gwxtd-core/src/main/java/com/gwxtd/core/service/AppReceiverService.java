package com.gwxtd.core.service;

import java.util.List;

import com.gwxtd.core.appbean.RReceiver;
import com.gwxtd.core.appbean.RResult;

public interface AppReceiverService {
	public List<RReceiver> select(int userId,Boolean isDefault);
	public RResult addReceiver(long userId,String name,
			String phone,String addressDetails,Boolean isDefault);
}
