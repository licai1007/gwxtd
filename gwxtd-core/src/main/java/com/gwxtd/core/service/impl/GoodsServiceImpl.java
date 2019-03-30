package com.gwxtd.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gwxtd.core.dao.GoodsMapper;
import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.pojo.GoodsCriteria;
import com.gwxtd.core.service.GoodsService;
import com.qingniao.common.page.PageInfo;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;
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

}
