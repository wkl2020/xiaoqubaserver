package com.jun.xiaoquren.service;

import java.util.List;

import com.jun.xiaoquren.model.Document;

public interface DocumentService {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Document record);

    int insertSelective(Document record);

    Document selectByPrimaryKey(Integer id);
    
    List<Document> selectAll();
    
    List<Document> selectByXiaoquId(Integer xiaoquId);

    int updateByPrimaryKeySelective(Document record);

    int updateByPrimaryKey(Document record);

}
