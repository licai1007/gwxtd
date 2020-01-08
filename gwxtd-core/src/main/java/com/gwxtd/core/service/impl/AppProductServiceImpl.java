package com.gwxtd.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.appbean.RCommentCount;
import com.gwxtd.core.appbean.RProductInfo;
import com.gwxtd.core.appbean.RProductList;
import com.gwxtd.core.appbean.SProductList;
import com.gwxtd.core.dao.AppCommentMapper;
import com.gwxtd.core.dao.AppProductMapper;
import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.service.AppProductService;
@Service
@Transactional
public class AppProductServiceImpl implements AppProductService{
	@Autowired
	private AppProductMapper appProductMapper;
	@Autowired
	private AppCommentMapper appCommentMapper;
	@Override
	public List<RProductList> selectList(SProductList sProductList) {
		List<Goods> list = appProductMapper.getList(sProductList);
		List<RProductList> rProductLists = new ArrayList<>();
		RProductList rProductList = null;
		for(Goods goods:list){
			rProductList = new RProductList();
			rProductList.setId(goods.getGid());
			rProductList.setName(goods.getGname());
			rProductList.setPrice(goods.getGprice());
			rProductList.setIconUrl(goods.getGimgurl());
			rProductList.setFavcomRate(goods.getFavcomRate());
			int commentCount = appCommentMapper.countByPid(goods.getGid(),0,0);
			rProductList.setCommentCount(commentCount);
			rProductLists.add(rProductList);
		}
		return rProductLists;
	}
	@Override
	public RProductInfo selectById(long id) {
		Goods goods = appProductMapper.getById((int)id);
		RProductInfo rProductInfo = new RProductInfo();
		rProductInfo.setId(goods.getGid());
		rProductInfo.setName(goods.getGname());
		String[] imgUrls = goods.getImgUrls().split(",");
		rProductInfo.setImgUrls(imgUrls);
		rProductInfo.setPrice(goods.getGprice());
		rProductInfo.setIfSaleOneself(goods.getIfSaleOneself()==1);
		String[] typeList = goods.getTypeList().split("#");
		rProductInfo.setTypeList(typeList);
		rProductInfo.setStockCount(goods.getGamount());
		int count = appCommentMapper.countByPid((int)id,0,0);
		rProductInfo.setCommentCount(count);
		rProductInfo.setFavcomRate(goods.getFavcomRate());
		rProductInfo.setRecomProductId(goods.getRecomProductId());
		rProductInfo.setRecomProduct(goods.getRecomProduct());
		return rProductInfo;
	}

}
