package com.jun.xiaoquren.persistence;

import java.util.List;

import com.jun.xiaoquren.model.Xiaoqu;

public interface XiaoquMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xiaoqu record);

    int insertSelective(Xiaoqu record);

    Xiaoqu selectByPrimaryKey(Integer id);
    
    List<Xiaoqu> selectAll();

    int updateByPrimaryKeySelective(Xiaoqu record);

    int updateByPrimaryKey(Xiaoqu record);
}