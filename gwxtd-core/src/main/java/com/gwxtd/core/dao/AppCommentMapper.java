package com.gwxtd.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gwxtd.core.appbean.Comment;

public interface AppCommentMapper {
	List<Comment> getListByPid(@Param("pid")int pid,@Param("type")int type,@Param("isImg")int isImg);
	int countByPid(@Param("pid")int pid,@Param("type")int type,@Param("isImg")int isImg);
}
