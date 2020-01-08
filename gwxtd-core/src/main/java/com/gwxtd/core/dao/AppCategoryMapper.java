package com.gwxtd.core.dao;

import java.util.List;

import com.gwxtd.core.appbean.RCategory;

public interface AppCategoryMapper {
	List<RCategory> getByParentId(long parentId);
}
