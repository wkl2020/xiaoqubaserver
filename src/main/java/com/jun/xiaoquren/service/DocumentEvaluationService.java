package com.jun.xiaoquren.service;

import java.util.List;

import com.jun.xiaoquren.exception.InvalidDataException;
import com.jun.xiaoquren.model.DocumentEvaluation;

public interface DocumentEvaluationService {

    int deleteByPrimaryKey(Integer id) throws InvalidDataException;

    int saveEvaluation(DocumentEvaluation evaluation) throws InvalidDataException;

    int insertSelective(DocumentEvaluation evaluation) throws InvalidDataException;

    DocumentEvaluation selectByPrimaryKey(Integer id) throws InvalidDataException;
    
    List<DocumentEvaluation> selectAll() throws InvalidDataException;
    
    List<DocumentEvaluation> selectByDocumentId(Integer documentId) throws InvalidDataException;

    int updateByPrimaryKeySelective(DocumentEvaluation evaluation) throws InvalidDataException;

    int updateByPrimaryKey(DocumentEvaluation evaluation) throws InvalidDataException;

}
