package com.gwxtd.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.common.MD5Utils;
import com.gwxtd.core.dao.UserMapper;
import com.gwxtd.core.pojo.User;
import com.gwxtd.core.pojo.UserCriteria;
import com.gwxtd.core.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User selectUser(User user) {
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.createCriteria().andUnameEqualTo(user.getUname()).andUpwdEqualTo(MD5Utils.md5(user.getUpwd()));
		List<User> users = userMapper.selectByExample(userCriteria);
		if(users.size()>0){
			return users.get(0);
		}else{
			return null;
		}
	}
	@Override
	public boolean userRegister(User user) {
		user.setUpwd(MD5Utils.md5(user.getUpwd()));
		int i = userMapper.insertSelective(user);
		return (i == 1)?true:false;
	}
	@Override
	public User selectUserByUname(String uname) {
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.createCriteria().andUnameEqualTo(uname);
		List<User> user = userMapper.selectByExample(userCriteria);
		if(user.size()>0){
			return user.get(0);
		}else{
			return null;			
		}
	}
	@Override
	public boolean modifyUserByUname(User user,String uname) {
		UserCriteria userCriteria = new UserCriteria();
		userCriteria.createCriteria().andUnameEqualTo(uname);
		user.setUpwd(MD5Utils.md5(user.getUpwd()));
		int i = userMapper.updateByExampleSelective(user,userCriteria);
		return (i==1)?true:false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
