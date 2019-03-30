package com.gwxtd.core.dao;

import com.gwxtd.core.pojo.OrderGoods;
import com.gwxtd.core.pojo.OrderGoodsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderGoodsMapper {
    int countByExample(OrderGoodsCriteria example);

    int deleteByExample(OrderGoodsCriteria example);

    int deleteByPrimaryKey(Integer ogid);

    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);

    List<OrderGoods> selectByExample(OrderGoodsCriteria example);

    OrderGoods selectByPrimaryKey(Integer ogid);

    int updateByExampleSelective(@Param("record") OrderGoods record, @Param("example") OrderGoodsCriteria example);

    int updateByExample(@Param("record") OrderGoods record, @Param("example") OrderGoodsCriteria example);

    int updateByPrimaryKeySelective(OrderGoods record);

    int updateByPrimaryKey(OrderGoods record);
}