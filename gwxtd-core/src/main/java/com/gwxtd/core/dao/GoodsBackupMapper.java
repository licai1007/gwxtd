package com.gwxtd.core.dao;

import com.gwxtd.core.pojo.GoodsBackup;

public interface GoodsBackupMapper {
	public int insert(GoodsBackup goodsBackup);
	public GoodsBackup selectById(Integer gid);
}
