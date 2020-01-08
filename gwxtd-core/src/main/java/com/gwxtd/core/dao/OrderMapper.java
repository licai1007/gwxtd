package com.gwxtd.core.dao;

import com.gwxtd.core.pojo.Order;
import com.gwxtd.core.pojo.OrderCriteria;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    int countByExample(OrderCriteria example);

    int deleteByExample(OrderCriteria example);

    int deleteByPrimaryKey(Integer oid);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderCriteria example);

    Order selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderCriteria example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderCriteria example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    //通过订单明细表id获取购买时间
    Date getDateByOgid(int oGid);
    
    List<Order> getOrderByStatus(@Param("ostate")String ostate,@Param("uid")Integer uid);
    
    int getCountByStatus(@Param("ostate")String ostate,@Param("uid")Integer uid);
    
    //获取订单中的图片
    List<String> getOrderImg(Integer oid);
    
    //确认订单
    int confirmOrder(Integer oid);
}