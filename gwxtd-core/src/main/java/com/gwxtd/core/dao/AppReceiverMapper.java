package com.gwxtd.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwxtd.core.appbean.RReceiver;

public interface AppReceiverMapper {
	List<RReceiver> select(@Param("userId")int userId,@Param("isDefault")Boolean isDefault);
	int insert(RReceiver receiver);
	RReceiver selectById(int id);
}
