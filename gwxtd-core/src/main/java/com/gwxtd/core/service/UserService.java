package com.gwxtd.core.service;

import com.gwxtd.core.pojo.User;

public interface UserService {
	public User selectUser(User user);
	public boolean userRegister(User user);
	public User selectUserByUname(String uname);
	public boolean modifyUserByUname(User user,String uname);
}
