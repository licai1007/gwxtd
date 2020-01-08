package com.gwxtd.core.dao;

import com.gwxtd.core.pojo.Goods;
import com.gwxtd.core.pojo.GoodsCriteria;
import com.gwxtd.core.pojo.GoodsWithBLOBs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    int countByExample(GoodsCriteria example);

    int deleteByExample(GoodsCriteria example);

    int deleteByPrimaryKey(Integer gid);

    int insert(GoodsWithBLOBs record);

    int insertSelective(GoodsWithBLOBs record);

    List<GoodsWithBLOBs> selectByExampleWithBLOBs(GoodsCriteria example);

    List<Goods> selectByExample(GoodsCriteria example);

    Goods selectByPrimaryKey(Integer gid);

    int updateByExampleSelective(@Param("record") GoodsWithBLOBs record, @Param("example") GoodsCriteria example);

    int updateByExampleWithBLOBs(@Param("record") GoodsWithBLOBs record, @Param("example") GoodsCriteria example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsCriteria example);

    int updateByPrimaryKeySelective(GoodsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GoodsWithBLOBs record);

    int updateByPrimaryKey(Goods record);
    
    List<String> getGclass();
    
    //app购物车详情
    Goods selectByProductId(Integer gid);
    
    
 
}