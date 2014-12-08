package com.jun.xiaoquren.service;

import java.util.List;

import com.jun.xiaoquren.exception.InvalidDataException;
import com.jun.xiaoquren.model.Document;

public interface DocumentService {
	
    int deleteByPrimaryKey(Integer id) throws InvalidDataException;

    int saveDocument(Document document) throws InvalidDataException;
    
    int insertSelective(Document document) throws InvalidDataException;

    Document selectByPrimaryKey(Integer id) throws InvalidDataException;
    
    List<Document> selectAll() throws InvalidDataException;
    
    List<Document> selectByXiaoquId(Integer xiaoquId) throws InvalidDataException;

    int updateByPrimaryKeySelective(Document document) throws InvalidDataException;

    int updateByPrimaryKey(Document document) throws InvalidDataException;

}
