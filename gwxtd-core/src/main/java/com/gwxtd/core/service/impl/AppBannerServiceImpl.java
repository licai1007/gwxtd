package com.gwxtd.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.appbean.Banner;
import com.gwxtd.core.dao.AppBannerMapper;
import com.gwxtd.core.service.AppBannerService;
@Service
@Transactional
public class AppBannerServiceImpl implements AppBannerService{
	@Autowired
	private AppBannerMapper appBannerMapper;
	@Override
	public List<Banner> selectByKind(int adKind) {
		return appBannerMapper.getBannerByKind(adKind);
	}

}
