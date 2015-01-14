package com.jun.xiaoquren.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jun.xiaoquren.model.ParkingStallInfo;
import com.jun.xiaoquren.model.UserEntity;
import com.jun.xiaoquren.model.Xiaoqu;
import com.jun.xiaoquren.service.ParkingStallInfoService;
import com.jun.xiaoquren.service.XiaoquService;
import com.jun.xiaoquren.util.StringUtil;

@Controller
public class ParkingStallInfoController {
	
	private static final Logger logger = Logger.getLogger(ParkingStallInfoController.class);  
		
	@Autowired
	ParkingStallInfoService parkingStallInfoService;
	@Autowired
	XiaoquService xiaoquService;
		
	@Autowired
	private ParkingStallInfoValidation parkingStallInfoValidation; // 用户自定义验证
	
	@RequestMapping(value = "/toParkingStallInfoAdd", method = RequestMethod.GET)
    public ModelAndView toParkingStallInfoAdd(HttpServletRequest request, Map<String, Object> model) {
		
		List<Xiaoqu> xiaoquList = xiaoquService.selectAll();
		model.put("xiaoquList", xiaoquList);
		
		ParkingStallInfo parkingStallInfo = new ParkingStallInfo();
		model.put("parkingStallInfo", parkingStallInfo);
		
		Map<String, String> supplyDemandTypeList = new HashMap<String, String>();  
		supplyDemandTypeList.put("出租", "出租");
		supplyDemandTypeList.put("求租", "求租"); 
		model.put("supplyDemandTypeList", supplyDemandTypeList);
		
		Map<String, String> yourIdentityList = new HashMap<String, String>();  
		yourIdentityList.put("个人", "个人");
		yourIdentityList.put("经纪人", "经纪人"); 
		model.put("yourIdentityList", yourIdentityList);
		
		Map<String, String> priceUnitList = new HashMap<String, String>();  
		priceUnitList.put("元/月", "元/月");
		priceUnitList.put("元/平米/天", "元/平米/天"); 
		model.put("priceUnitList", priceUnitList);
		
		 
        return new ModelAndView("parking_stall_info_add");
    }

	@RequestMapping(value = "/toParkingStallInfoList", method = RequestMethod.GET)
    public ModelAndView toParkingStallInfoList(HttpServletRequest request) {
        return new ModelAndView("parking_stall_info_list");
    }

	@RequestMapping(value = "/toParkingStallInfoUpdate", method = RequestMethod.GET)
    public ModelAndView toParkingStallInfoUpdate(HttpServletRequest request) {
        return new ModelAndView("parking_stall_info_update");
    }
	
	@RequestMapping(value = "/parking_stall_info/index", method = RequestMethod.GET)
	public @ResponseBody List<ParkingStallInfo> getAllParkingStallInfoList() {
		    
		List<ParkingStallInfo> allParkingStallInfoList = parkingStallInfoService.selectAll();
		return allParkingStallInfoList;
	}
	
	@RequestMapping(value = "/xiaoqu_parking_stall_infos/{id:\\d+}", method = RequestMethod.GET)
	public @ResponseBody List<ParkingStallInfo> getXiaoquParkingStallInfoList(@PathVariable("id") int id) {
		    
		List<ParkingStallInfo> xiaoquParkingStallInfoList = parkingStallInfoService.selectByXiaoquId(id);
		return xiaoquParkingStallInfoList;
	}
	
	@RequestMapping(value = "/parking_stall_info/{id:\\d+}", method = RequestMethod.GET)  
    public @ResponseBody ParkingStallInfo getParkingStallInfo(@PathVariable("id") int id) {  
		
        logger.info("Get ParkingStallInfo by id " + id);  
        ParkingStallInfo parkingStallInfo = parkingStallInfoService.selectByPrimaryKey(id);
        return parkingStallInfo;  
    }

	@RequestMapping(value = "/parking_stall_info/{id:\\d+}", method = RequestMethod.DELETE)  
    public @ResponseBody Object deleteParkingStallInfo(@PathVariable("id") String id) {
		
		logger.info("Delete ParkingStallInfo by id " + id);  
		String result = "success";
		if (!StringUtil.isEmpty(id) && parkingStallInfoService.deleteByPrimaryKey(Integer.valueOf(id)) > 0) {
	   	} else {
	   		result = "Failed";
	   	}
		
        JSONObject jsonObject = new JSONObject();  
        jsonObject.put("result", result);  
        return jsonObject;  
    }  
		
	@RequestMapping(value = "/parking_stall_info", method = RequestMethod.POST)  
    public @ResponseBody Object addParkingStallInfo(@RequestBody ParkingStallInfo parkingStallInfo) {  
		
        logger.info("Add ParkingStallInfo with title " + parkingStallInfo.getTitle());
        logger.info("Add ParkingStallInfo with content " + parkingStallInfo.getContent());
        
        String result = "failed";
        Map<String, String> errorMsg = new HashMap<String, String>();
        
        String title = parkingStallInfo.getTitle();
        if (StringUtil.isEmpty(title)) {
        	errorMsg.put("title", "标题不能为空.");
        } else if ((title.length()) > 200) {
			errorMsg.put("title", "标题不能多于200个字符.");
		}
		
		String content = parkingStallInfo.getContent();
		if (StringUtil.isEmpty(content)) {
        	errorMsg.put("content", "内容不能为空.");
        }
		
		if (errorMsg.isEmpty()) {
			try {
				 if (parkingStallInfoService.save(parkingStallInfo) > 0) {
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
		
	@RequestMapping(value = "/parking_stall_info", method = RequestMethod.PUT)  
    public @ResponseBody Object updateParkingStallInfo(@RequestBody ParkingStallInfo parkingStallInfo) {  
		
        logger.info("Update ParkingStallInfo by id " + parkingStallInfo.getId());  
        String result = "failed";
        Map<String, String> errorMsg = new HashMap<String, String>();
        
        String title = parkingStallInfo.getTitle();
        if (StringUtil.isEmpty(title)) {
        	errorMsg.put("title", "标题不能为空.");
        } else if ((title.length()) > 200) {
			errorMsg.put("title", "标题不能多于200个字符.");
		}
		
		String content = parkingStallInfo.getContent();
		if (StringUtil.isEmpty(content)) {
        	errorMsg.put("content", "内容不能为空.");
        }
		
		if (errorMsg.isEmpty()) {
			try {
				 if (parkingStallInfoService.save(parkingStallInfo) > 0) {
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

}
