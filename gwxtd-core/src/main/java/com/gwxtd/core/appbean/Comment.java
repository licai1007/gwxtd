package com.gwxtd.core.appbean;

import java.util.Date;

public class Comment {
	private int id;
	private String imgUrls;//评论图片路径  多个
	private Date time;//评论时间
	private int uid;//评论用户id
	private int rate;//星星数  最多5个
	private int type;//评论类型
	private String comment;//评论内容
	private int pid;//评论商品id
	private int loveCount;//喜欢数
	private int subComment;//回复评论数
	private int oid;
	private String uName;
	private int uLevel;
	private String uIcon;
	private String productType;
	private int ogid;
	
	public int getOgid() {
		return ogid;
	}
	public void setOgid(int ogid) {
		this.ogid = ogid;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public int getuLevel() {
		return uLevel;
	}
	public void setuLevel(int uLevel) {
		this.uLevel = uLevel;
	}
	public String getuIcon() {
		return uIcon;
	}
	public void setuIcon(String uIcon) {
		this.uIcon = uIcon;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImgUrls() {
		return imgUrls;
	}
	public void setImgUrls(String imgUrls) {
		this.imgUrls = imgUrls;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getLoveCount() {
		return loveCount;
	}
	public void setLoveCount(int loveCount) {
		this.loveCount = loveCount;
	}
	public int getSubComment() {
		return subComment;
	}
	public void setSubComment(int subComment) {
		this.subComment = subComment;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	
}
