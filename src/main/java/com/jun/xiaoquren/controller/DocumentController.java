package com.jun.xiaoquren.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jun.xiaoquren.model.Document;
import com.jun.xiaoquren.model.UserEntity;
import com.jun.xiaoquren.service.DocumentService;
import com.jun.xiaoquren.util.StringUtil;

@Controller
public class DocumentController {
	
	private static final Logger logger = Logger.getLogger(DocumentController.class);  
		
	@Autowired
	DocumentService documentService;
		
	@Autowired
	private DocumentValidation documentValidation; // 用户自定义验证
	
	@RequestMapping(value = "/toDocumentAdd", method = RequestMethod.GET)
    public ModelAndView toDocumentAdd(HttpServletRequest request) {
        return new ModelAndView("document_add");
    }

	@RequestMapping(value = "/toDocumentList", method = RequestMethod.GET)
    public ModelAndView toDocumentList(HttpServletRequest request) {
        return new ModelAndView("document_list");
    }

	@RequestMapping(value = "/toDocumentUpdate", method = RequestMethod.GET)
    public ModelAndView toDocumentUpdate(HttpServletRequest request) {
        return new ModelAndView("document_update");
    }
	
	@RequestMapping(value = "/document/index", method = RequestMethod.GET)
	public @ResponseBody List<Document> getAllDocumentList() {
		    
		List<Document> allDocumentList = documentService.selectAll();
		return allDocumentList;
	}
	
	@RequestMapping(value = "/document/{id:\\d+}", method = RequestMethod.GET)  
    public @ResponseBody Document getDocument(@PathVariable("id") int id) {  
		
        logger.info("Get document by id " + id);  
        Document document = documentService.selectByPrimaryKey(id);
        return document;  
    }

	@RequestMapping(value = "/document/{id:\\d+}", method = RequestMethod.DELETE)  
    public @ResponseBody Object deleteDocument(@PathVariable("id") String id) {
		
		logger.info("Delete document by id " + id);  
		String result = "success";
		if (!StringUtil.isEmpty(id) && documentService.deleteByPrimaryKey(Integer.valueOf(id)) > 0) {
	   	} else {
	   		result = "Failed";
	   	}
		
        JSONObject jsonObject = new JSONObject();  
        jsonObject.put("result", result);  
        return jsonObject;  
    }  
		
	@RequestMapping(value = "/document", method = RequestMethod.POST)  
    public @ResponseBody Object addDocument(@RequestBody Document document) {  
		
        logger.info("Add document with title " + document.getTitle());
        logger.info("Add document with content " + document.getContent());
        
        String result = "failed";
        Map<String, String> errorMsg = new HashMap<String, String>();
        
        String title = document.getTitle();
        if (StringUtil.isEmpty(title)) {
        	errorMsg.put("title", "标题不能为空.");
        } else if ((title.length()) > 100) {
			errorMsg.put("title", "标题不能多于100个字符.");
		}
		
		String content = document.getContent();
		if (StringUtil.isEmpty(content)) {
        	errorMsg.put("content", "内容不能为空.");
        }
		
		if (errorMsg.isEmpty()) {
			try {
				 if (documentService.saveDocument(document) > 0) {
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
		
	@RequestMapping(value = "/document", method = RequestMethod.PUT)  
    public @ResponseBody Object updatePerson(@RequestBody Document document) {  
		
        logger.info("Update document by id " + document.getId());  
        String result = "failed";
        Map<String, String> errorMsg = new HashMap<String, String>();
        
        String title = document.getTitle();
        if (StringUtil.isEmpty(title)) {
        	errorMsg.put("title", "标题不能为空.");
        } else if ((title.length()) > 100) {
			errorMsg.put("title", "标题不能多于100个字符.");
		}
		
		String content = document.getContent();
		if (StringUtil.isEmpty(content)) {
        	errorMsg.put("content", "内容不能为空.");
        }
		
		if (errorMsg.isEmpty()) {
			try {
				 if (documentService.saveDocument(document) > 0) {
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
	
	 
	@RequestMapping(value = "/createDocument", method = RequestMethod.POST)
	public String createDocument(@Valid @ModelAttribute("document") Document document,
			BindingResult result, Model model) {
		
		documentValidation.validate(document, result);
		 if (result.hasErrors()) {
			 model.addAttribute("document",document);
			 return "documentCreate";
		 }
		 
		 try {
			 if (documentService.saveDocument(document) > 0) {
				 return "admin";
			 }
		 } catch (Exception e) {			 
			 result.rejectValue("title",
						"save.error",
						e.getMessage());
		 }
		 
		 model.addAttribute("document", document);
		 return "documentCreate";
	}	
	 
	public UserEntity getUser() {
		//取得登录用户      
	 	UserEntity user = null;
        SecurityContext ctx = SecurityContextHolder.getContext();              
        Authentication auth = ctx.getAuthentication();                    
        if(auth.getPrincipal() instanceof UserDetails) {      
                user   =   (UserEntity)auth.getPrincipal();                        
        }     
        return user;      
    }
	 
	@RequestMapping(value = "/deleteDocument", method = RequestMethod.GET)
    public @ResponseBody String deleteDocument2(@RequestParam(value="documentId") String documentId) {
		
		String result = "success";
	   	System.out.println("delete document: documentId: " + documentId);
	   	
	   	if (!StringUtil.isEmpty(documentId) && documentService.deleteByPrimaryKey(Integer.valueOf(documentId)) > 0) {
	   	} else {
	   		result = "Failed";
	   	}
	   	
	   	System.out.println("result: " + result);
	   	
	   	return result;
    }

}
