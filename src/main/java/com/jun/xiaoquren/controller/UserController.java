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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jun.xiaoquren.model.UserEntity;
import com.jun.xiaoquren.model.Xiaoqu;
import com.jun.xiaoquren.service.UserService;
import com.jun.xiaoquren.service.impl.SimpleJMSSender;
import com.jun.xiaoquren.util.StringUtil;
import com.jun.xiaoquren.util.UserRole;
import com.jun.xiaoquren.service.XiaoquService;

@Controller
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);  
	
	 @Autowired
	 UserService userService;
	 @Autowired
	 XiaoquService xiaoquService;
	 
	 @Autowired
	 SimpleJMSSender simpleJMSSender;
		
	@Autowired
	private UserValidation userValidation; // 用户自定义验证
	 
	 @RequestMapping(value = "/login.html", method = RequestMethod.GET)
     public ModelAndView loginPage() {
         return new ModelAndView("login");
     }
	 
	 @RequestMapping(value = "/denied", method = RequestMethod.GET)
     public ModelAndView deniedPage() {
         return new ModelAndView("denied");
     }
	 
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
     public ModelAndView logoutPage(HttpServletRequest request) {
		 request.getSession().invalidate();
         return new ModelAndView("login");
     }
	 
	 @RequestMapping(value = "/toAdminPage", method = RequestMethod.GET)
     public ModelAndView adminPage(HttpServletRequest request) {
         return new ModelAndView("admin");
     }
	 
	 @RequestMapping(value = "/toUserManagePage", method = RequestMethod.GET)
     public ModelAndView toUserManagePage(HttpServletRequest request) {
		 
		 simpleJMSSender.sendMessage("KKKKKKKKK First Test MSG.");
		 
         return new ModelAndView("usermanage");
     }
	 
	 @RequestMapping(value = "/toRegisterUsrPage", method = RequestMethod.GET)
     public ModelAndView registerUsr(HttpServletRequest request, Map<String, Object> model) {
		 
		 UserEntity user = new UserEntity();
		 model.put("user", user);
		 
		 Map<String, String> userRoleList = new HashMap<String, String>();  
		 userRoleList.put(UserRole.ADMIN, UserRole.ADMIN);  
		 userRoleList.put(UserRole.PROPERTY, UserRole.PROPERTY);  
		 userRoleList.put(UserRole.NORMAL, UserRole.NORMAL);  
		 userRoleList.put(UserRole.ANONYM, UserRole.ANONYM); 
		 
		 List<Xiaoqu> xiaoquList = xiaoquService.selectAll();
		 
		 model.put("userRoleList", userRoleList);
		 model.put("xiaoquList", xiaoquList);
		   
         return new ModelAndView("register");
     }
		
	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public @ResponseBody List<UserEntity> getAllUserEntities() {
		    
		List<UserEntity> allUserList = userService.findAll();
		return allUserList;
	}
	
	@RequestMapping(value = "/getUserbyName", method = RequestMethod.GET)
    public @ResponseBody UserEntity getUserByUsername(@RequestParam(value="username") String username) { 
       
		String result = "success";
		System.out.println("Get user by username: " + username);
		
		UserEntity user = null;
	   	if (!StringUtil.isEmpty(username)) {
	   		user = userService.findUserByUsername(username);
	   	} else {
	   		result = "Failed";
	   	}
	   	
	   	System.out.println("result: " + result);
	   	
	   	return user;
    }
	 
	 @RequestMapping(value = "/user", method = RequestMethod.POST)  
     public @ResponseBody Object addUser(@RequestBody  UserEntity user) {  
		
        logger.info("Add user with name " + user.getUsername());
        
        String result = "failed";
        Map<String, String> errorMsg = new HashMap<String, String>();
        
        String username = user.getUsername();
        if (StringUtil.isEmpty(username)) {
        	errorMsg.put("username", "用户名不能为空.");
        }
		
        String password = user.getPassword() == null ? "" : user.getPassword();
        if ((user.getPassword() != user.getConfirmPassword()) && !password.equals(user.getConfirmPassword())) {
        	errorMsg.put("password", "密码和确认密码不匹配.");
        }
		
		if (errorMsg.isEmpty()) {
			try {
				 user.setPassword(StringUtil.makeMD5(user.getPassword()));
				 user.setConfirmPassword((StringUtil.makeMD5(user.getConfirmPassword())));
				 if (userService.saveUser(user) > 0) {
					 result = "success";
				 }
			 } catch (Exception e) {			 
				 errorMsg.put("username", e.getMessage());
			 }
		}

		JSONObject jsonObject = new JSONObject(); 
		jsonObject.put("result", result);  
		for (String key : errorMsg.keySet()) {
			jsonObject.put(key, errorMsg.get(key));  
		}

        return jsonObject;  
     }	
	 
	 
	 
	 @RequestMapping(value = "/getAllUserList", method = RequestMethod.GET)
	 public @ResponseBody List<UserEntity> getAllUserList() { 
	        
		 List<UserEntity> alluserlist = userService.findAll();   	
		 return alluserlist;
	 }
	 
	 
	 @RequestMapping(value = "/createUser", method = RequestMethod.POST)
     public String createUser(@Valid @ModelAttribute("user") UserEntity user,
    		 BindingResult result, Model model) {
		 
		 userValidation.validate(user, result);
		 if (result.hasErrors()) {
			 model.addAttribute("user",user);
			 return "register";
		 }
		 
		 try {
			 user.setPassword(StringUtil.makeMD5(user.getPassword()));
			 user.setConfirmPassword((StringUtil.makeMD5(user.getConfirmPassword())));
			 
			 if (userService.saveUser(user) > 0) {
				 return "admin";
			 }
		 } catch (Exception e) {			 
			 result.rejectValue("username",
						"save.error",
						e.getMessage());
		 }
		 
		 model.addAttribute("user",user);
		 return "register";
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
	 
	 @RequestMapping(value = "/changeUserPwd", method = RequestMethod.GET)
     public @ResponseBody String changeUserPwd(@RequestParam(value="userId") String userId, 
    		 @RequestParam(value="newPwd") String newPwd) { 
        
		String result = "success";
    	System.out.println("enableUser: userId: " + userId + " : newPwd: " + newPwd);
    	
    	if (!StringUtil.isEmpty(userId) && !StringUtil.isEmpty(newPwd)) {
    		result = userService.changeUserPwd(Integer.valueOf(userId), StringUtil.makeMD5(newPwd));
    	} else {
    		result = "Failed";
    	}
    	
    	System.out.println("result: " + result);
    	
    	return result;
     } 
	 
	 @RequestMapping(value = "/enableUser", method = RequestMethod.GET)
     public @ResponseBody String enableUser(@RequestParam(value="userId") String userId, 
    		 @RequestParam(value="isEnable") Boolean isEnable) { 
        
		String result = "success";
    	System.out.println("enableUser: userId: " + userId + " : isEnable: " + isEnable);
    	
    	if (!StringUtil.isEmpty(userId) && isEnable != null) {
    		result = userService.enableUser(Integer.valueOf(userId), isEnable);
    	} else {
    		result = "Failed";
    	}
    	
    	System.out.println("result: " + result);
    	
    	return result;
     } 
	 
	 
	 @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
     public @ResponseBody String deleteUser(@RequestParam(value="userId") String userId) { 
        
		String result = "success";
    	System.out.println("delete user: userId: " + userId);
    	
    	if (!StringUtil.isEmpty(userId) && userService.deleteUser(Integer.valueOf(userId)) > 0) {
    	} else {
    		result = "Failed";
    	}
    	
    	System.out.println("result: " + result);
    	
    	return result;
     } 
	 
}
