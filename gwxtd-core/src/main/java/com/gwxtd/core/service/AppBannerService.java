package com.gwxtd.core.service;

import java.util.List;

import com.gwxtd.core.appbean.Banner;

public interface AppBannerService {
	/**
	 * @param adKind 1为导航banner，2为广告banner
	 * @return List<Banner>
	 */
	public List<Banner> selectByKind(int adKind);
}
