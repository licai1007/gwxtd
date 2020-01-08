package com.gwxtd.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.appbean.RSecondKill;
import com.gwxtd.core.dao.AppSecondKillMapper;
import com.gwxtd.core.service.AppSecondKillService;
@Service
@Transactional
public class AppSecondKillServiceImpl implements AppSecondKillService{
	@Autowired
	private AppSecondKillMapper appSecondKillMapper;
	@Override
	public List<RSecondKill> selectAll() {
		return appSecondKillMapper.getAll();
	}

}
