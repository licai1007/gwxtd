package com.gwxtd.core.service;

import java.util.List;

import com.gwxtd.core.appbean.RBrand;

public interface AppBrandService {
	public List<RBrand> selectByCid(long cid);
}
