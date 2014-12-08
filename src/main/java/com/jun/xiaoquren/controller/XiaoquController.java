package com.jun.xiaoquren.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jun.xiaoquren.model.Xiaoqu;
import com.jun.xiaoquren.service.XiaoquService;
import com.jun.xiaoquren.util.StringUtil;

@Controller
public class XiaoquController {
	
	private static final Logger logger = Logger.getLogger(XiaoquController.class);  
		
	@Autowired
	XiaoquService xiaoquService;

	
	@RequestMapping(value = "/xiaoqu/index", method = RequestMethod.GET)
	public @ResponseBody List<Xiaoqu> getAllXiaoquList() {
		    
		logger.info("Get all xiaoqu list ");  
		List<Xiaoqu> allXiaoquList = xiaoquService.selectAll();
		return allXiaoquList;
	}
	
	@RequestMapping(value = "/xiaoqu/{id:\\d+}", method = RequestMethod.GET)  
    public @ResponseBody Xiaoqu getXiaoqu(@PathVariable("id") int id) {  
		
        logger.info("Get xiaoqu by id " + id);  
        Xiaoqu xiaoqu = xiaoquService.selectByPrimaryKey(id);
        return xiaoqu;  
    }

	@RequestMapping(value = "/xiaoqu/{id:\\d+}", method = RequestMethod.DELETE)  
    public @ResponseBody Object deleteXiaoqu(@PathVariable("id") String id) {
		
		logger.info("Delete xiaoqu by id " + id);  
		String result = "success";
		if (!StringUtil.isEmpty(id) && xiaoquService.deleteByPrimaryKey(Integer.valueOf(id)) > 0) {
	   	} else {
	   		result = "Failed";
	   	}
		
        JSONObject jsonObject = new JSONObject();  
        jsonObject.put("result", result);  
        return jsonObject;  
    }  
		
	@RequestMapping(value = "/xiaoqu", method = RequestMethod.POST)  
    public @ResponseBody Object addXiaoqu(Xiaoqu xiaoqu) {  
		
        logger.info("Add xiaoqu with name " + xiaoqu.getName());  
        
        String result = "failed";
        Map<String, String> errorMsg = new HashMap<String, String>();
        
        String name = xiaoqu.getName();
        if (StringUtil.isEmpty(name)) {
        	errorMsg.put("name", "小区名不能为空.");
        }
		if ((name.length()) > 100) {
			errorMsg.put("name", "小区名不能多于100个字符.");
		}

		if (errorMsg.isEmpty()) {
			try {
				 if (xiaoquService.saveXiaoqu(xiaoqu) > 0) {
					 result = "success";
				 }
			 } catch (Exception e) {			 
				 errorMsg.put("name", e.getMessage());
			 }
		}

		JSONObject jsonObject = new JSONObject(); 
		jsonObject.put("result", result);  
		for (String key : errorMsg.keySet()) {
			jsonObject.put(key, errorMsg.get(key));  
		}

        return jsonObject;  
    }	
		
	@RequestMapping(value = "/xiaoqu", method = RequestMethod.PUT)  
    public @ResponseBody Object updateXiaoqu(Xiaoqu xiaoqu) {  
		
        logger.info("Update xiaoqu by id " + xiaoqu.getId());  
        String result = "failed";
        Map<String, String> errorMsg = new HashMap<String, String>();
        
        String name = xiaoqu.getName();
        if (StringUtil.isEmpty(name)) {
        	errorMsg.put("name", "标题不能为空.");
        }
		if ((name.length()) > 100) {
			errorMsg.put("name", "标题不能多于100个字符.");
		}
		
		if (errorMsg.isEmpty()) {
			try {
				 if (xiaoquService.saveXiaoqu(xiaoqu) > 0) {
					 result = "success";
				 }
			 } catch (Exception e) {			 
				 errorMsg.put("name", e.getMessage());
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
