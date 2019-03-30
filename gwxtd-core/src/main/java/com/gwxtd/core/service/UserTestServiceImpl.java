package com.gwxtd.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.dao.UserTestMapper;
import com.gwxtd.core.pojo.UserTest;

/**
 * UserTest的service类
 * 测试事务
 * @author licai
 *
 */
@Service
@Transactional
public class UserTestServiceImpl {
	@Autowired
	UserTestMapper userTestMapper;
	public void insertUserTest(UserTest user){
		userTestMapper.insertUserTest(user);
		int a = 1/0;
	}
}
