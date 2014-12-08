package com.jun.xiaoquren.service;

import java.util.List;

import com.jun.xiaoquren.exception.InvalidDataException;
import com.jun.xiaoquren.model.DocumentComment;

public interface DocumentCommentService {

    int deleteByPrimaryKey(Integer id) throws InvalidDataException;

    int saveComment(DocumentComment comment) throws InvalidDataException;

    int insertSelective(DocumentComment comment) throws InvalidDataException;

    DocumentComment selectByPrimaryKey(Integer id) throws InvalidDataException;
    
    List<DocumentComment> selectAll() throws InvalidDataException;
    
    List<DocumentComment> selectByDocumentId(Integer documentId) throws InvalidDataException;

    int updateByPrimaryKeySelective(DocumentComment comment) throws InvalidDataException;

    int updateByPrimaryKey(DocumentComment comment) throws InvalidDataException;
}
