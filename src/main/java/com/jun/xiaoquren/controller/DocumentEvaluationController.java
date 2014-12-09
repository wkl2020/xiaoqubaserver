package com.jun.xiaoquren.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jun.xiaoquren.model.DocumentEvaluation;
import com.jun.xiaoquren.service.DocumentEvaluationService;
import com.jun.xiaoquren.util.StringUtil;


@Controller
public class DocumentEvaluationController {
	
	private static final Logger logger = Logger.getLogger(DocumentEvaluationController.class);  
		
	@Autowired
	DocumentEvaluationService documentEvaluationService;
	
	@RequestMapping(value = "/toDocumentEvaluationAdd", method = RequestMethod.GET)
    public ModelAndView todocumentEvaluationAdd(HttpServletRequest request) {
        return new ModelAndView("document_evaluation_add");
    }

	@RequestMapping(value = "/toDocumentEvaluationList", method = RequestMethod.GET)
    public ModelAndView todocumentEvaluationList(HttpServletRequest request) {
        return new ModelAndView("document_evaluation_list");
    }

	@RequestMapping(value = "/toDocumentEvaluationUpdate", method = RequestMethod.GET)
    public ModelAndView todocumentEvaluationUpdate(HttpServletRequest request) {
        return new ModelAndView("document_evaluation_update");
    }
	
	@RequestMapping(value = "/documentEvaluation/index", method = RequestMethod.GET)
	public @ResponseBody List<DocumentEvaluation> getAlldocumentEvaluationList() {
		    
		List<DocumentEvaluation> alldocumentEvaluationList = documentEvaluationService.selectAll();
		return alldocumentEvaluationList;
	}
	
	@RequestMapping(value = "/documentEvaluation/{id:\\d+}", method = RequestMethod.GET)  
    public @ResponseBody DocumentEvaluation getdocumentEvaluation(@PathVariable("id") int id) {  
		
        logger.info("Get documentEvaluation by id " + id);  
        DocumentEvaluation documentEvaluation = documentEvaluationService.selectByPrimaryKey(id);
        return documentEvaluation;  
    }

	@RequestMapping(value = "/documentEvaluation/{id:\\d+}", method = RequestMethod.DELETE)  
    public @ResponseBody Object deletedocumentEvaluation(@PathVariable("id") String id) {
		
		logger.info("Delete documentEvaluation by id " + id);  
		String result = "success";
		if (!StringUtil.isEmpty(id) && documentEvaluationService.deleteByPrimaryKey(Integer.valueOf(id)) > 0) {
	   	} else {
	   		result = "Failed";
	   	}
		
        JSONObject jsonObject = new JSONObject();  
        jsonObject.put("result", result);  
        return jsonObject;  
    }  
		
	@RequestMapping(value = "/documentEvaluation", method = RequestMethod.POST)  
    public @ResponseBody Object adddocumentEvaluation(@RequestBody DocumentEvaluation documentEvaluation) {  
		
        logger.info("Add documentEvaluation for documentId " + documentEvaluation.getDocumentId());
        
        String result = "failed";
        Map<String, String> errorMsg = new HashMap<String, String>();
        
        Long documentId = documentEvaluation.getDocumentId();
        if (documentId == null) {
        	errorMsg.put("documentId", "公告Id不能为空.");
        }
		
		String evaluationType = documentEvaluation.getEvaluationType();
		if (StringUtil.isEmpty(evaluationType)) {
        	errorMsg.put("content", "评价类型不能为空.");
        }
		
		if (errorMsg.isEmpty()) {
			try {
				 if (documentEvaluationService.saveEvaluation(documentEvaluation) > 0) {
					 result = "success";
				 }
			 } catch (Exception e) {			 
				 errorMsg.put("title", e.getMessage());
			 }
		}

		JSONObject jsonObject = new JSONObject(); 
		jsonObject.put("result", result);  
		for (String key : errorMsg.keySet()) {
			jsonObject.put(key, errorMsg.get(key));  
		}

        return jsonObject;  
    }	
		
	@RequestMapping(value = "/documentEvaluation", method = RequestMethod.PUT)  
    public @ResponseBody Object updatePerson(@RequestBody DocumentEvaluation documentEvaluation) {  
		
		logger.info("Add documentEvaluation for documentId " + documentEvaluation.getDocumentId());
		
        String result = "failed";
        Map<String, String> errorMsg = new HashMap<String, String>();
        
        Long documentId = documentEvaluation.getDocumentId();
        if (documentId == null) {
        	errorMsg.put("documentId", "公告Id不能为空.");
        }
		
		String evaluationType = documentEvaluation.getEvaluationType();
		if (StringUtil.isEmpty(evaluationType)) {
        	errorMsg.put("content", "评价类型不能为空.");
        }
		
		if (errorMsg.isEmpty()) {
			try {
				 if (documentEvaluationService.saveEvaluation(documentEvaluation) > 0) {
					 result = "success";
				 }
			 } catch (Exception e) {			 
				 errorMsg.put("title", e.getMessage());
			 }
		}

		JSONObject jsonObject = new JSONObject(); 
		jsonObject.put("result", result);  
		for (String key : errorMsg.keySet()) {
			jsonObject.put(key, errorMsg.get(key));  
		}

        return jsonObject; 
    }  

}
