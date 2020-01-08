package com.gwxtd.core.service;

import java.util.List;
import com.gwxtd.core.appbean.RArea;

public interface AppAreaService {
	public List<RArea> selectAll();
	public List<RArea> selectCityByParentCode(String parentCode);
	public List<RArea> selectAreaByParentCode(String parentCode);
}
