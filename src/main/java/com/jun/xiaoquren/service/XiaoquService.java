package com.jun.xiaoquren.service;

import java.util.List;

import com.jun.xiaoquren.model.Xiaoqu;

public interface XiaoquService {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Xiaoqu record);

    int insertSelective(Xiaoqu record);

    Xiaoqu selectByPrimaryKey(Integer id);
    
    List<Xiaoqu> selectAll();

    int updateByPrimaryKeySelective(Xiaoqu record);

    int updateByPrimaryKey(Xiaoqu record);

}
