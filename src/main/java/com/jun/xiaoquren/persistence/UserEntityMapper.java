package com.jun.xiaoquren.persistence;

import java.util.List;

import com.jun.xiaoquren.model.UserEntity;

public interface UserEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(Integer id);
    
    List<UserEntity> selectAll();
    
    UserEntity selectByUsername(String username);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}