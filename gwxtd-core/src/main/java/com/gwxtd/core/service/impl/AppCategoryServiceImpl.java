package com.gwxtd.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.appbean.RCategory;
import com.gwxtd.core.dao.AppCategoryMapper;
import com.gwxtd.core.service.AppCategoryService;
@Service
@Transactional
public class AppCategoryServiceImpl implements AppCategoryService{
	@Autowired
	private AppCategoryMapper appCategoryMapper;
	@Override
	public List<RCategory> selectByParentId(long parentId) {
		return appCategoryMapper.getByParentId(parentId);
	}

}
