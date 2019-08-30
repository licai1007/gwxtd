package com.gwxtd.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.common.MD5Utils;
import com.gwxtd.core.dao.AdminMapper;
import com.gwxtd.core.pojo.Admin;
import com.gwxtd.core.pojo.AdminCriteria;
import com.gwxtd.core.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper adminMapper;
	@Override
	public Admin selectAdmin(Admin admin) {
		AdminCriteria example = new AdminCriteria();
		example.createCriteria().andAnameEqualTo(admin.getAname().trim()).
		andApwdEqualTo(MD5Utils.md5(admin.getApwd()));
		List<Admin> list = adminMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	@Override
	public List<Admin> selectAll() {
		AdminCriteria criteria = new AdminCriteria();
		return adminMapper.selectByExample(criteria);
	}
	@Override
	public Admin selectById(Integer aid) {
		return adminMapper.selectByPrimaryKey(aid);
	}
	@Override
	public boolean deleteById(Integer aid) {
		try {
			adminMapper.deleteByPrimaryKey(aid);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public Admin selectByName(String aname) {
		AdminCriteria example = new AdminCriteria();
		example.createCriteria().andAnameEqualTo(aname);
		List<Admin> list = adminMapper.selectByExample(example);
		if(list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}
	@Override
	public boolean addAdmin(Admin admin) {
		try {
			adminMapper.insert(admin);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean updateAdmin(Admin admin) {
		try {
			adminMapper.updateByPrimaryKeySelective(admin);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
