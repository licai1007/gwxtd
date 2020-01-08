package com.gwxtd.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.appbean.RReceiver;
import com.gwxtd.core.appbean.RResult;
import com.gwxtd.core.dao.AppReceiverMapper;
import com.gwxtd.core.service.AppReceiverService;
@Service
@Transactional
public class AppReceiverServiceImpl implements AppReceiverService{
	@Autowired
	private AppReceiverMapper appReceiverMapper;
	@Override
	public List<RReceiver> select(int userId, Boolean isDefault) {
		return appReceiverMapper.select(userId, isDefault);
	}
	@Override
	public RResult addReceiver(long userId, String name, String phone,
			String addressDetails, Boolean isDefault) {
		RResult result = null;
		if(isDefault){
			List<RReceiver> list = appReceiverMapper.select((int)userId,true);
			if(list.size()!=0){
				result = new RResult(false,"您已经有默认地址","");
				return result;
			}
		}
		RReceiver receiver = new RReceiver();
		receiver.setIsDefault(isDefault);
		receiver.setReceiverAddress(addressDetails);
		receiver.setReceiverName(name);
		receiver.setReceiverPhone(phone);
		receiver.setUserId((int)userId);
		int insert = appReceiverMapper.insert(receiver);
		if(insert==0){
			result = new RResult(false,"数据异常","");
		}else{
			result = new RResult(true,"","");
		}
		return result;
	}

}
