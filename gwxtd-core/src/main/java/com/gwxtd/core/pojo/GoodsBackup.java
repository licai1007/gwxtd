package com.gwxtd.core.pojo;

import java.io.Serializable;

public class GoodsBackup implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer gid;
	private String gname;
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	
}
