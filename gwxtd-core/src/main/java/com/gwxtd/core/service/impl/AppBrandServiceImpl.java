package com.gwxtd.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.appbean.RBrand;
import com.gwxtd.core.dao.AppBrandMapper;
import com.gwxtd.core.service.AppBrandService;
@Service
@Transactional
public class AppBrandServiceImpl implements AppBrandService{
	@Autowired
	private AppBrandMapper appBrandMapper;
	@Override
	public List<RBrand> selectByCid(long cid) {
		return appBrandMapper.getByCid(cid);
	}

}
