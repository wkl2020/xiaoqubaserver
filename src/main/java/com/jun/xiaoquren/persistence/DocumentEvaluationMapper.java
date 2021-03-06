package com.jun.xiaoquren.persistence;

import java.util.List;

import com.jun.xiaoquren.model.DocumentEvaluation;

public interface DocumentEvaluationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DocumentEvaluation record);

    int insertSelective(DocumentEvaluation record);

    DocumentEvaluation selectByPrimaryKey(Integer id);
    
    List<DocumentEvaluation> selectAll();
    
    List<DocumentEvaluation> selectByDocumentId(Integer documentId);

    int updateByPrimaryKeySelective(DocumentEvaluation record);

    int updateByPrimaryKey(DocumentEvaluation record);
}