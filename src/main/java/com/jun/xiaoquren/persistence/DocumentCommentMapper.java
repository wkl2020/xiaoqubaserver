package com.jun.xiaoquren.persistence;

import java.util.List;

import com.jun.xiaoquren.model.DocumentComment;

public interface DocumentCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DocumentComment record);

    int insertSelective(DocumentComment record);

    DocumentComment selectByPrimaryKey(Integer id);
    
    List<DocumentComment> selectAll();
    
    List<DocumentComment> selectByDocumentId(Integer documentId);

    int updateByPrimaryKeySelective(DocumentComment record);

    int updateByPrimaryKey(DocumentComment record);
}