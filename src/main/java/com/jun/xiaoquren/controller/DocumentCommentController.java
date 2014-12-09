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

import com.jun.xiaoquren.model.DocumentComment;
import com.jun.xiaoquren.service.DocumentCommentService;
import com.jun.xiaoquren.util.StringUtil;


@Controller
public class DocumentCommentController {
	
	private static final Logger logger = Logger.getLogger(DocumentCommentController.class);  
		
	@Autowired
	DocumentCommentService documentCommentService;
		
	
	@RequestMapping(value = "/toDocumentCommentAdd", method = RequestMethod.GET)
    public ModelAndView toDocumentCommentAdd(HttpServletRequest request) {
        return new ModelAndView("document_comment_add");
    }

	@RequestMapping(value = "/toDocumentCommentList", method = RequestMethod.GET)
    public ModelAndView toDocumentCommentList(HttpServletRequest request) {
        return new ModelAndView("document_comment_list");
    }

	@RequestMapping(value = "/toDocumentCommentUpdate", method = RequestMethod.GET)
    public ModelAndView toDocumentCommentUpdate(HttpServletRequest request) {
        return new ModelAndView("document_comment_update");
    }
	
	@RequestMapping(value = "/documentComment/index", method = RequestMethod.GET)
	public @ResponseBody List<DocumentComment> getAllDocumentCommentList() {
		    
		List<DocumentComment> allDocumentCommentList = documentCommentService.selectAll();
		return allDocumentCommentList;
	}
	
	@RequestMapping(value = "/documentComment/{id:\\d+}", method = RequestMethod.GET)  
    public @ResponseBody DocumentComment getDocumentComment(@PathVariable("id") int id) {  
		
        logger.info("Get documentComment by id " + id);  
        DocumentComment documentComment = documentCommentService.selectByPrimaryKey(id);
        return documentComment;  
    }

	@RequestMapping(value = "/documentComment/{id:\\d+}", method = RequestMethod.DELETE)  
    public @ResponseBody Object deleteDocumentComment(@PathVariable("id") String id) {
		
		logger.info("Delete documentComment by id " + id);  
		String result = "success";
		if (!StringUtil.isEmpty(id) && documentCommentService.deleteByPrimaryKey(Integer.valueOf(id)) > 0) {
	   	} else {
	   		result = "Failed";
	   	}
		
        JSONObject jsonObject = new JSONObject();  
        jsonObject.put("result", result);  
        return jsonObject;  
    }  
		
	@RequestMapping(value = "/documentComment", method = RequestMethod.POST)  
    public @ResponseBody Object addDocumentComment(@RequestBody DocumentComment documentComment) {  
		
        logger.info("Add documentComment with documentId " + documentComment.getDocumentId());
        
        String result = "failed";
        Map<String, String> errorMsg = new HashMap<String, String>();
        
        Long documentId = documentComment.getDocumentId();
        if (documentId == null) {
        	errorMsg.put("documentId", "公告Id不能为空.");
        }
		
		String content = documentComment.getContent();
		if (StringUtil.isEmpty(content)) {
        	errorMsg.put("content", "内容不能为空.");
        }
		
		if (errorMsg.isEmpty()) {
			try {
				 if (documentCommentService.saveComment(documentComment) > 0) {
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
		
	@RequestMapping(value = "/documentComment", method = RequestMethod.PUT)  
    public @ResponseBody Object updatePerson(@RequestBody DocumentComment documentComment) {  
		
        logger.info("Update documentComment by id " + documentComment.getId());  
        String result = "failed";
        Map<String, String> errorMsg = new HashMap<String, String>();
        
        Long documentId = documentComment.getDocumentId();
        if (documentId == null) {
        	errorMsg.put("documentId", "公告Id不能为空.");
        }
		
		String content = documentComment.getContent();
		if (StringUtil.isEmpty(content)) {
        	errorMsg.put("content", "内容不能为空.");
        }
		
		if (errorMsg.isEmpty()) {
			try {
				 if (documentCommentService.saveComment(documentComment) > 0) {
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
