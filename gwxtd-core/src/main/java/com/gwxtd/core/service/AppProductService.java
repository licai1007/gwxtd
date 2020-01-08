package com.gwxtd.core.service;

import java.util.List;
import com.gwxtd.core.appbean.RProductInfo;
import com.gwxtd.core.appbean.RProductList;
import com.gwxtd.core.appbean.SProductList;

public interface AppProductService {
	public List<RProductList> selectList(SProductList sProductList);
	public RProductInfo selectById(long id);
}
