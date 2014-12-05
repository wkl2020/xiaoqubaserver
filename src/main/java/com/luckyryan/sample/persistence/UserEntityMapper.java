package com.luckyryan.sample.persistence;

import java.util.List;

import com.luckyryan.sample.model.UserEntity;
import com.luckyryan.sample.model.UserEntityExample;

import org.apache.ibatis.annotations.Param;

/**
 * User: ryan
 * Date: 2/20/13
 */
public interface UserEntityMapper {	

    int countByExample(UserEntityExample example);

    int deleteByExample(UserEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    List<UserEntity> selectByExample(UserEntityExample example);

    UserEntity selectByPrimaryKey(Long id);
    
    UserEntity selectByUsername(String username);

    int updateByExampleSelective(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByExample(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}