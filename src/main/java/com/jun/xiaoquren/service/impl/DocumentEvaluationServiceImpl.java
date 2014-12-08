package com.jun.xiaoquren.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.xiaoquren.exception.InvalidDataException;
import com.jun.xiaoquren.model.DocumentEvaluation;
import com.jun.xiaoquren.persistence.DocumentEvaluationMapper;
import com.jun.xiaoquren.service.DocumentEvaluationService;

@Service("evaluationService")
public class DocumentEvaluationServiceImpl implements DocumentEvaluationService {
	
	@Autowired
	DocumentEvaluationMapper documentEvaluationMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) throws InvalidDataException {
		return documentEvaluationMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int saveEvaluation(DocumentEvaluation evaluation) throws InvalidDataException {
		int result = -1;
		
		if (evaluation.getId() == null) {			
			evaluation.setCreateDate(new Date());
			evaluation.setDeleted(false);
			evaluation.setVersion(0l);			
			result = documentEvaluationMapper.insert(evaluation);
			
		} else {
			result = documentEvaluationMapper.updateByPrimaryKey(evaluation);			
		}		
		
		return result;
	}

	@Override
	public int insertSelective(DocumentEvaluation record)
			throws InvalidDataException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DocumentEvaluation selectByPrimaryKey(Integer id)
			throws InvalidDataException {
		return documentEvaluationMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<DocumentEvaluation> selectAll() throws InvalidDataException {
		return documentEvaluationMapper.selectAll();
	}

	@Override
	public List<DocumentEvaluation> selectByDocumentId(Integer documentId)
			throws InvalidDataException {
		return documentEvaluationMapper.selectByDocumentId(documentId);
	}

	@Override
	public int updateByPrimaryKeySelective(DocumentEvaluation evaluation)
			throws InvalidDataException {
		return documentEvaluationMapper.updateByPrimaryKeySelective(evaluation);
	}

	@Override
	public int updateByPrimaryKey(DocumentEvaluation evaluation)
			throws InvalidDataException {
		return documentEvaluationMapper.updateByPrimaryKey(evaluation);			
	}

}
