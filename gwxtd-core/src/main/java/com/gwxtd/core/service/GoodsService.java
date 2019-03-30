package com.gwxtd.core.service;

import java.util.List;

import com.gwxtd.core.pojo.GoodsCriteria;
import com.qingniao.common.page.PageInfo;
import com.gwxtd.core.pojo.Goods;

public interface GoodsService {
	public List<String> selectClass();
	public PageInfo goodsShow(GoodsCriteria goodsCriteria);
	public Goods selectGoods(Integer gid);
	public void updateLook(Integer gid,Goods goods);
}
