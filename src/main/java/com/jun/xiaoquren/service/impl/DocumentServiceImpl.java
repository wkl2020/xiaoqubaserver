package com.jun.xiaoquren.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.xiaoquren.exception.InvalidDataException;
import com.jun.xiaoquren.model.Document;
import com.jun.xiaoquren.persistence.DocumentMapper;
import com.jun.xiaoquren.service.DocumentService;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	DocumentMapper documentMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) throws InvalidDataException {
		return documentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int saveDocument(Document document) throws InvalidDataException {
		int result = -1;
		
		if (document.getId() == null) {			
			document.setCreateDate(new Date());
			document.setUpdateDate(new Date());
			document.setDeleted(false);
			document.setVersion(0l);
			document.setReplayCount(0l);
			result = documentMapper.insert(document);
			
		} else {
			result = this.updateByPrimaryKey(document);			
		}		
		
		return result;
	}

	@Override
	public int insertSelective(Document record) throws InvalidDataException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Document selectByPrimaryKey(Integer id) throws InvalidDataException {
		return documentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Document> selectAll() throws InvalidDataException {
		return documentMapper.selectAll();
	}

	@Override
	public List<Document> selectByXiaoquId(Integer xiaoquId)
			throws InvalidDataException {
		return documentMapper.selectByXiaoquId(xiaoquId);
	}

	@Override
	public int updateByPrimaryKeySelective(Document document)
			throws InvalidDataException {
		document.setUpdateDate(new Date());
		return documentMapper.updateByPrimaryKeySelective(document);	
	}

	@Override
	public int updateByPrimaryKey(Document document) throws InvalidDataException {
		document.setUpdateDate(new Date());
		return documentMapper.updateByPrimaryKey(document);	
	}

	

}
