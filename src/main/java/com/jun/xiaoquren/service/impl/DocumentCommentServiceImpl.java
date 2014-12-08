package com.jun.xiaoquren.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.xiaoquren.exception.InvalidDataException;
import com.jun.xiaoquren.model.DocumentComment;
import com.jun.xiaoquren.persistence.DocumentCommentMapper;
import com.jun.xiaoquren.service.DocumentCommentService;

@Service("commentService")
public class DocumentCommentServiceImpl implements DocumentCommentService {
	
	@Autowired
	DocumentCommentMapper documentCommentMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) throws InvalidDataException {
		return documentCommentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int saveComment(DocumentComment comment) throws InvalidDataException {
		int result = -1;
		
		if (comment.getId() == null) {			
			comment.setCreateDate(new Date());
			comment.setUpdateDate(new Date());
			comment.setDeleted(false);
			comment.setVersion(0l);			
			result = documentCommentMapper.insert(comment);
			
		} else {
			result = documentCommentMapper.updateByPrimaryKey(comment);
		}		
		
		return result;
	}

	@Override
	public int insertSelective(DocumentComment record)
			throws InvalidDataException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DocumentComment selectByPrimaryKey(Integer id)
			throws InvalidDataException {
		return documentCommentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DocumentComment> selectAll() throws InvalidDataException {
		return documentCommentMapper.selectAll();
	}

	@Override
	public List<DocumentComment> selectByDocumentId(Integer documentId)
			throws InvalidDataException {
		return documentCommentMapper.selectByDocumentId(documentId);
	}

	@Override
	public int updateByPrimaryKeySelective(DocumentComment comment)
			throws InvalidDataException {
		return documentCommentMapper.updateByPrimaryKeySelective(comment);
	}

	@Override
	public int updateByPrimaryKey(DocumentComment comment)
			throws InvalidDataException {
		
		comment.setUpdateDate(new Date());
		return documentCommentMapper.updateByPrimaryKey(comment);	
	}

	

}
