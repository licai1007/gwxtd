package com.gwxtd.usertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gwxtd.core.dao.UserTestMapper;
import com.gwxtd.core.pojo.UserTest;
import com.gwxtd.core.service.UserTestServiceImpl;

/**
 * 测试配置是否成功
 * @author licai
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-*.xml"})
public class UserDemo {
	@Autowired
	UserTestMapper userTestMapper;
	@Autowired
	UserTestServiceImpl userService;
	@Test
	public void demo1(){
		UserTest userTest = new UserTest();
		userTest.setId(11);
		userTest.setUsername("一一");
		userTest.setPassword("123456");
		userTestMapper.insertUserTest(userTest);
	}
	//测试事务
	@Test
	public void demo2(){
		UserTest userTest = new UserTest();
		userTest.setId(22);
		userTest.setUsername("二二");
		userTest.setPassword("123456");
		userService.insertUserTest(userTest);
	}	
}
