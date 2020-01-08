package com.gwxtd.core.service;

import java.util.List;

import com.gwxtd.core.appbean.RCommentCount;
import com.gwxtd.core.appbean.RGoodComment;
import com.gwxtd.core.appbean.RProductComment;

public interface AppCommentService {
	public List<RGoodComment> selectByPid(int pid,int type);
	public RCommentCount selectCommentCount(long id);
	public List<RProductComment> selectComment(int pid,int type,boolean isImg);
}
