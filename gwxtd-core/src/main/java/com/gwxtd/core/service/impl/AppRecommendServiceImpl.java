package com.gwxtd.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.appbean.RRecommendProduct;
import com.gwxtd.core.dao.AppRecommendMapper;
import com.gwxtd.core.service.AppRecommendService;
@Service
@Transactional
public class AppRecommendServiceImpl implements AppRecommendService{
	@Autowired
	private AppRecommendMapper appRecommendMapper;
	@Override
	public List<RRecommendProduct> selectAll() {
		return appRecommendMapper.getAll();
	}

}
