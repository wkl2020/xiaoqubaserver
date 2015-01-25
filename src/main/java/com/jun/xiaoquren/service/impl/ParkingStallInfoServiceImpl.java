package com.jun.xiaoquren.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.xiaoquren.exception.InvalidDataException;
import com.jun.xiaoquren.model.ParkingStallInfo;
import com.jun.xiaoquren.model.search.ParkingStallInfoSearch;
import com.jun.xiaoquren.persistence.ParkingStallInfoMapper;
import com.jun.xiaoquren.service.ParkingStallInfoService;


@Service("parkingStallInfoService")
public class ParkingStallInfoServiceImpl implements ParkingStallInfoService {
	
	@Autowired
	ParkingStallInfoMapper parkingStallInfoMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) throws InvalidDataException {
		return parkingStallInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int save(ParkingStallInfo obj) throws InvalidDataException {
		int result = -1;
		
		if (obj.getId() == null) {			
			obj.setCreateDate(new Date());
			obj.setUpdateDate(new Date());
			obj.setDeleted(false);
			obj.setVersion(0l);
			obj.setReadCount(0l);
			result = parkingStallInfoMapper.insert(obj);
			
		} else {
			result = this.updateByPrimaryKey(obj);			
		}		
		
		return result;
	}

	@Override
	public int insertSelective(ParkingStallInfo record) throws InvalidDataException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ParkingStallInfo selectByPrimaryKey(Integer id) throws InvalidDataException {
		return parkingStallInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ParkingStallInfo> search(ParkingStallInfoSearch obj) throws InvalidDataException {		
		return parkingStallInfoMapper.search(obj);
	}

	@Override
	public List<ParkingStallInfo> selectAll() throws InvalidDataException {
		return parkingStallInfoMapper.selectAll();
	}

	@Override
	public List<ParkingStallInfo> selectByXiaoquId(Integer xiaoquId)
			throws InvalidDataException {
		return parkingStallInfoMapper.selectByXiaoquId(xiaoquId);
	}

	@Override
	public int updateByPrimaryKeySelective(ParkingStallInfo document)
			throws InvalidDataException {
		document.setUpdateDate(new Date());
		return parkingStallInfoMapper.updateByPrimaryKeySelective(document);	
	}

	@Override
	public int updateByPrimaryKey(ParkingStallInfo document) throws InvalidDataException {
		document.setUpdateDate(new Date());
		return parkingStallInfoMapper.updateByPrimaryKey(document);	
	}

	

}
