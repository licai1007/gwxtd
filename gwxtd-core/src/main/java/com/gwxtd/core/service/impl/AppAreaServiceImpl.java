package com.gwxtd.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.appbean.Area;
import com.gwxtd.core.appbean.City;
import com.gwxtd.core.appbean.Province;
import com.gwxtd.core.appbean.RArea;
import com.gwxtd.core.dao.AppAreaMapper;
import com.gwxtd.core.service.AppAreaService;
@Service
@Transactional
public class AppAreaServiceImpl implements AppAreaService{
	@Autowired
	private AppAreaMapper appAreaMapper;
	@Override
	public List<RArea> selectAll() {
		List<RArea> areas = new ArrayList<>();
		List<Province> list = appAreaMapper.selectAll();
		for(Province province:list){
			RArea area = new RArea();
			area.setCode(province.getPROVINCE_CODE());
			area.setName(province.getPROVINCE_NAME());
			areas.add(area);
		}
		return areas;
	}
	@Override
	public List<RArea> selectCityByParentCode(String parentCode) {
		List<RArea> areas = new ArrayList<>();
		List<City> cities = appAreaMapper.selectCityByParentCode(parentCode);
		for (City city : cities) {
			RArea area = new RArea();
			area.setCode(city.getCITY_CODE());
			area.setName(city.getCITY_NAME());
			areas.add(area);
		}
		return areas;
	}
	@Override
	public List<RArea> selectAreaByParentCode(String parentCode) {
		List<RArea> areas = new ArrayList<>();
		List<Area> list = appAreaMapper.selectAreaByParentCode(parentCode);
		for (Area area : list) {
			RArea rArea = new RArea();
			rArea.setCode(area.getAREA_CODE());
			rArea.setName(area.getAREA_NAME());
			areas.add(rArea);
		}
		return areas;
	}

}
