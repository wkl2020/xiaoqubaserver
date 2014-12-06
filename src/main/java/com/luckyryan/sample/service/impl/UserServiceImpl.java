package com.luckyryan.sample.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luckyryan.sample.exception.InvalidDataException;
import com.luckyryan.sample.model.UserEntity;
import com.luckyryan.sample.model.UserEntityExample;
import com.luckyryan.sample.persistence.UserEntityMapper;
import com.luckyryan.sample.service.UserService;
import com.socket.server.util.StringUtil;
import com.socket.server.util.UserRole;



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
		
		user.setCreatedate(new Date());
		user.setUpdatedate(new Date());
		user.setEnable(true);
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
	public int deleteUser(Long userId) throws InvalidDataException {
		return userEntityMapper.deleteByPrimaryKey(userId);
	}
	
	@Override
	public String enableUser(Long userId, Boolean isEnable) throws InvalidDataException {
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
	public String changeUserPwd(Long userId, String newPwd) throws InvalidDataException {
		String result = "success";
		try {
			UserEntity user = userEntityMapper.selectByPrimaryKey(userId);
			
			if (user != null) {
				user.setPassword(newPwd);
				user.setConfirmpassword(newPwd);
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
