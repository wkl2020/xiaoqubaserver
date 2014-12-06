package com.jun.xiaoquren.persistence;

import com.jun.xiaoquren.model.DocumentEvaluation;
import com.jun.xiaoquren.model.DocumentEvaluationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DocumentEvaluationMapper {
    int countByExample(DocumentEvaluationExample example);

    int deleteByExample(DocumentEvaluationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DocumentEvaluation record);

    int insertSelective(DocumentEvaluation record);

    List<DocumentEvaluation> selectByExample(DocumentEvaluationExample example);

    DocumentEvaluation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DocumentEvaluation record, @Param("example") DocumentEvaluationExample example);

    int updateByExample(@Param("record") DocumentEvaluation record, @Param("example") DocumentEvaluationExample example);

    int updateByPrimaryKeySelective(DocumentEvaluation record);

    int updateByPrimaryKey(DocumentEvaluation record);
}