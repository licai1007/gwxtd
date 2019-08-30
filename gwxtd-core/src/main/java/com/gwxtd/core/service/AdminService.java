package com.gwxtd.core.service;

import java.util.List;

import com.gwxtd.core.pojo.Admin;

public interface AdminService {
	//查询管理员
	public Admin selectAdmin(Admin admin);
	//查询所有管理员
	public List<Admin> selectAll();
	//通过id查询管理员
	public Admin selectById(Integer aid);
	//通过id删除管理员
	public boolean deleteById(Integer aid);
	//通过名字来查询管理员
	public Admin selectByName(String aname);
	//添加管理员
	public boolean addAdmin(Admin admin);
	//更新管理员
	public boolean updateAdmin(Admin admin);
}
