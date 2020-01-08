package com.gwxtd.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwxtd.core.appbean.Area;
import com.gwxtd.core.appbean.City;
import com.gwxtd.core.appbean.Province;

public interface AppAreaMapper {
	List<Province> selectAll();
	List<City> selectCityByParentCode(@Param("parentCode")String parentCode);
	List<Area> selectAreaByParentCode(@Param("parentCode")String parentCode);
}
