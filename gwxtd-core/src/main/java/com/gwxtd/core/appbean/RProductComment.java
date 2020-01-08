package com.gwxtd.core.appbean;
public class RProductComment {
	private long id;//评论id
	private int rate;//星星数
	private String comment;//评论内容
	private String[] imgUrls;//评论图片路径
	private String buyTime;//购买时间
	private String productType = "";//产品版本类型
	
	private int userLevel;//用户等级
	private String userName;//用户名称
	private String userImg;//用户头像路径
	private String commentTime;//评论时间
	
	private int loveCount;//喜欢数
	private int subComment;//回复评论数
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
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
	public String[] getImgUrls() {
		return imgUrls;
	}
	public void setImgUrls(String[] imgUrls) {
		this.imgUrls = imgUrls;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
}
