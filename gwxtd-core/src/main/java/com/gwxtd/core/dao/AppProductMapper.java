package com.gwxtd.core.dao;

import java.util.List;

import com.gwxtd.core.appbean.SProductList;
import com.gwxtd.core.pojo.Goods;

public interface AppProductMapper {
	List<Goods> getList(SProductList sProductList);
	Goods getById(Integer gid);
}
