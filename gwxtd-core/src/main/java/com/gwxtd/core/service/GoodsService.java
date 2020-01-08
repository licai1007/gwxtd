package com.gwxtd.core.service;

import java.util.List;
import com.gwxtd.core.appbean.RShopCar;
import com.gwxtd.core.pojo.GoodsCriteria;
import com.gwxtd.core.pojo.GoodsWithBLOBs;
import com.qingniao.common.page.PageInfo;
import com.gwxtd.core.pojo.Goods;

public interface GoodsService {
	List<String> selectClass();
	PageInfo goodsShow(GoodsCriteria goodsCriteria);
	Goods selectGoods(Integer gid);
	void updateLook(Integer gid,Goods goods);
	boolean addGoods(GoodsWithBLOBs goods);
	boolean deleteGoodsById(Integer gid);
	boolean updateGoods(GoodsWithBLOBs goods);
	//app购物车详情
    RShopCar selectByProductId(Integer gid);
}
