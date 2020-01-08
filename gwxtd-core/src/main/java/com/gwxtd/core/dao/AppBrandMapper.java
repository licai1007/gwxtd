package com.gwxtd.core.dao;

import java.util.List;

import com.gwxtd.core.appbean.RBrand;

public interface AppBrandMapper {
	List<RBrand> getByCid(long cid);
}
