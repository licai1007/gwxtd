package com.gwxtd.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.appbean.RShopCar;
import com.gwxtd.core.dao.GoodsBackupMapper;
import com.gwxtd.core.dao.GoodsMapper;
import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.pojo.GoodsBackup;
import com.gwxtd.core.pojo.GoodsCriteria;
import com.gwxtd.core.pojo.GoodsWithBLOBs;
import com.gwxtd.core.service.GoodsService;
import com.qingniao.common.page.PageInfo;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsBackupMapper goodsBackupMapper;
	@Override
	public List<String> selectClass() {
		List<String> classs = goodsMapper.getGclass();
		return classs;
	}
	@Override
	public PageInfo goodsShow(GoodsCriteria goodsCriteria) {
		int totalCount = goodsMapper.countByExample(goodsCriteria);
		PageInfo pageInfo = new PageInfo(goodsCriteria.getPageNo(),goodsCriteria.getPageSize(),totalCount);
		goodsCriteria.setPageNo(pageInfo.getPageNo());//矫正当前页
		List<Goods> goodss = goodsMapper.selectByExample(goodsCriteria);
		pageInfo.setList(goodss);
		return pageInfo;
	}
	@Override
	public Goods selectGoods(Integer gid) {
		Goods goods = goodsMapper.selectByPrimaryKey(gid);
		return goods;
	}
	@Override
	public void updateLook(Integer gid,Goods goods) {
		GoodsCriteria goodsCriteria = new GoodsCriteria();
		goodsCriteria.createCriteria().andGidEqualTo(gid);
		goods.setGlook(goods.getGlook()+1);
		goodsMapper.updateByExample(goods,goodsCriteria);
	}
	@Override
	public boolean addGoods(GoodsWithBLOBs goods) {
		try{
			goodsMapper.insertSelective(goods);
			GoodsBackup goodsBackup = new GoodsBackup();
			goodsBackup.setGid(goods.getGid());
			goodsBackup.setGname(goods.getGname());
			goodsBackupMapper.insert(goodsBackup);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean deleteGoodsById(Integer gid) {
		try {
			goodsMapper.deleteByPrimaryKey(gid);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean updateGoods(GoodsWithBLOBs goods) {
		try {
			GoodsCriteria example = new GoodsCriteria();
			example.createCriteria().andGidEqualTo(goods.getGid());
			goodsMapper.updateByExampleSelective(goods,example);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public RShopCar selectByProductId(Integer gid) {
		Goods goods = goodsMapper.selectByProductId(gid);
		RShopCar shopCar = new RShopCar();
		shopCar.setPid(goods.getGid());
		shopCar.setPname(goods.getGname());
		shopCar.setPimageUrl(goods.getGimgurl());
		shopCar.setPprice(goods.getGprice());
		shopCar.setStockCount(goods.getGamount());
		shopCar.setStoreId(goods.getSid());
		shopCar.setStoreName(goods.getStoreName());
		return shopCar;
	}

}
