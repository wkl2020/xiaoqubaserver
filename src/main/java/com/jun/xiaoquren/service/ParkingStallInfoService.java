package com.jun.xiaoquren.service;

import java.util.List;

import com.jun.xiaoquren.exception.InvalidDataException;
import com.jun.xiaoquren.model.ParkingStallInfo;

public interface ParkingStallInfoService {
	
    int deleteByPrimaryKey(Integer id) throws InvalidDataException;

    int save(ParkingStallInfo obj) throws InvalidDataException;
    
    int insertSelective(ParkingStallInfo obj) throws InvalidDataException;

    ParkingStallInfo selectByPrimaryKey(Integer id) throws InvalidDataException;
    
    List<ParkingStallInfo> selectAll() throws InvalidDataException;
    
    List<ParkingStallInfo> selectByXiaoquId(Integer xiaoquId) throws InvalidDataException;

    int updateByPrimaryKeySelective(ParkingStallInfo obj) throws InvalidDataException;

    int updateByPrimaryKey(ParkingStallInfo obj) throws InvalidDataException;

}