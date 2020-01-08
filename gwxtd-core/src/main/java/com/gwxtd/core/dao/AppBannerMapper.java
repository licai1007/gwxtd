package com.gwxtd.core.dao;

import java.util.List;

import com.gwxtd.core.appbean.Banner;

public interface AppBannerMapper {
	//通过种类来获取广告
	List<Banner> getBannerByKind(int adKind);
}
