package com.jun.xiaoquren.persistence;

import java.util.List;

import com.jun.xiaoquren.model.ParkingStallInfo;
import com.jun.xiaoquren.model.search.ParkingStallInfoSearch;

public interface ParkingStallInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ParkingStallInfo record);

    int insertSelective(ParkingStallInfo record);

    ParkingStallInfo selectByPrimaryKey(Integer id);
    
    List<ParkingStallInfo> selectAll();
    
    List<ParkingStallInfo> search(ParkingStallInfoSearch obj);
    
    List<ParkingStallInfo> selectByXiaoquId(Integer xiaoquId);

    int updateByPrimaryKeySelective(ParkingStallInfo record);

    int updateByPrimaryKey(ParkingStallInfo record);
}