package com.gwxtd.core.pojo;
//购物项   由于cookie只能存储4k，所以购物项只存id和购物数量
public class CartItem {
	private Integer cid;
	private Integer cnum;
	
	public CartItem() {
		super();
	}
	public CartItem(Integer cid, Integer cnum) {
		super();
		this.cid = cid;
		this.cnum = cnum;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getCnum() {
		return cnum;
	}
	public void setCnum(Integer cnum) {
		this.cnum = cnum;
	}
	
}
