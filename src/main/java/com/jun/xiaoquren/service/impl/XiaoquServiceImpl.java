package com.jun.xiaoquren.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.xiaoquren.exception.InvalidDataException;
import com.jun.xiaoquren.model.Xiaoqu;
import com.jun.xiaoquren.persistence.XiaoquMapper;
import com.jun.xiaoquren.service.XiaoquService;

@Service("xiaoquService")
public class XiaoquServiceImpl implements XiaoquService {
	
	@Autowired
	XiaoquMapper xiaoquMapper;

	@Override
	public int saveXiaoqu(Xiaoqu xiaoqu) throws InvalidDataException {
		int result = -1;
		
		if (xiaoqu.getId() == null) {			
			xiaoqu.setCreateDate(new Date());
			xiaoqu.setUpdateDate(new Date());
			xiaoqu.setDeleted(false);
			xiaoqu.setVersion(0l);			
			result = xiaoquMapper.insert(xiaoqu);
			
		} else {
			result = this.updateByPrimaryKey(xiaoqu);			
		}		
		
		return result;
	}

	@Override
	public int deleteByPrimaryKey(Integer id) throws InvalidDataException {
		return xiaoquMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(Xiaoqu record) throws InvalidDataException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Xiaoqu selectByPrimaryKey(Integer id) throws InvalidDataException {
		return xiaoquMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Xiaoqu> selectAll() throws InvalidDataException {
		return xiaoquMapper.selectAll();
	}

	@Override
	public int updateByPrimaryKeySelective(Xiaoqu xiaoqu)
			throws InvalidDataException {
		xiaoqu.setUpdateDate(new Date());
		return xiaoquMapper.updateByPrimaryKey(xiaoqu);	
	}

	@Override
	public int updateByPrimaryKey(Xiaoqu xiaoqu) throws InvalidDataException {
		xiaoqu.setUpdateDate(new Date());
		return xiaoquMapper.updateByPrimaryKey(xiaoqu);		
	}


}
