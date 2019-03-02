package com.bjg.dao;

import com.bjg.entity.Type;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    @Select("select * from t_type")
    List<Type> findAllType();
}