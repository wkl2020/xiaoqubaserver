package com.jun.xiaoquren.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.xiaoquren.exception.InvalidDataException;
import com.jun.xiaoquren.model.UserEntity;
import com.jun.xiaoquren.model.UserEntityExample;
import com.jun.xiaoquren.persistence.UserEntityMapper;
import com.jun.xiaoquren.service.UserService;
import com.jun.xiaoquren.util.StringUtil;
import com.jun.xiaoquren.util.UserRole;



@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserEntityMapper userEntityMapper;

	public UserEntityMapper getUserEntityMapper() {
		return userEntityMapper;
	}

	public void setUserEntityMapper(UserEntityMapper userEntityMapper) {
		this.userEntityMapper = userEntityMapper;
	}

	@Override
	public String userLogin(UserEntity user) {
		UserEntity currentUser = userEntityMapper.selectByUsername(user.getUsername());
		
		if (currentUser != null && currentUser.getPassword().equals(user.getPassword())) {
            return "success";  
        } else {  
            return "false";  
        }  
	}
	
	public int saveUser(UserEntity user)
			throws InvalidDataException {
		
		user.setCreateDate(new Date());
		user.setUpdateDate(new Date());
		user.setEnable(true);
		user.setDeleted(false);
		user.setVersion(0l);
		if (StringUtil.isEmpty(user.getRole())) {
			user.setRole(UserRole.ANONYM);
		}
		return userEntityMapper.insert(user);
	}
	
	public UserEntity findUserByUsername(String username) throws InvalidDataException {
		
		return userEntityMapper.selectByUsername(username);
	}	
	
	@Override
	public List<UserEntity> findAll() {
		UserEntityExample userExample = new UserEntityExample();
		return this.userEntityMapper.selectByExample(userExample);
	}

	@Override
	public int deleteUser(Integer userId) throws InvalidDataException {
		return userEntityMapper.deleteByPrimaryKey(userId);
	}
	
	@Override
	public String enableUser(Integer userId, Boolean isEnable) throws InvalidDataException {
		String result = "success";
		try {
			UserEntity user = userEntityMapper.selectByPrimaryKey(userId);
			
			if (user != null) {
				user.setEnable(isEnable);
				userEntityMapper.updateByPrimaryKey(user);
			} else {
				result = "Failed";
			}			
			
		} catch (Exception e) {
			result = "Error: " + e.getMessage();
		}
		
		System.out.println("SERVICE: result: " + result);
		
		return result;
	}
	
	@Override
	public String changeUserPwd(Integer userId, String newPwd) throws InvalidDataException {
		String result = "success";
		try {
			UserEntity user = userEntityMapper.selectByPrimaryKey(userId);
			
			if (user != null) {
				user.setPassword(newPwd);
				user.setConfirmPassword(newPwd);
				userEntityMapper.updateByPrimaryKey(user);
			} else {
				result = "Failed";
			}			
			
		} catch (Exception e) {
			result = "Error: " + e.getMessage();
		}
		
		System.out.println("SERVICE: result: " + result);
		
		return result;
	}

}
