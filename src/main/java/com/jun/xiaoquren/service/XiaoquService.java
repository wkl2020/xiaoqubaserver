package com.jun.xiaoquren.service;

import java.util.List;

import com.jun.xiaoquren.exception.InvalidDataException;
import com.jun.xiaoquren.model.Xiaoqu;

public interface XiaoquService {
	
    int deleteByPrimaryKey(Integer id) throws InvalidDataException;

    int saveXiaoqu(Xiaoqu xiaoqu) throws InvalidDataException;

    int insertSelective(Xiaoqu xiaoqu) throws InvalidDataException;

    Xiaoqu selectByPrimaryKey(Integer id) throws InvalidDataException;
    
    List<Xiaoqu> selectAll() throws InvalidDataException;

    int updateByPrimaryKeySelective(Xiaoqu xiaoqu) throws InvalidDataException;

    int updateByPrimaryKey(Xiaoqu xiaoqu) throws InvalidDataException;

}
