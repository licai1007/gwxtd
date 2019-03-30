package com.gwxtd.core.dao;

import com.gwxtd.core.pojo.Admin;
import com.gwxtd.core.pojo.AdminCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int countByExample(AdminCriteria example);

    int deleteByExample(AdminCriteria example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminCriteria example);

    Admin selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminCriteria example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminCriteria example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}