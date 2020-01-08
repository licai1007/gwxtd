package com.gwxtd.core.service;

import java.util.List;

import com.gwxtd.core.appbean.RCategory;

public interface AppCategoryService {
	public List<RCategory> selectByParentId(long parentId);
}
