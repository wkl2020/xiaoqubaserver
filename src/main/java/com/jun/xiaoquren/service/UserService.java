package com.jun.xiaoquren.service;

import java.util.List;

import com.jun.xiaoquren.exception.InvalidDataException;
import com.jun.xiaoquren.model.UserEntity;

public interface UserService {
	
	 public String userLogin(UserEntity user);  
	 public int saveUser(UserEntity user);
	 
	 public List<UserEntity> findAll() throws InvalidDataException;
	 public int deleteUser(Integer userId) throws InvalidDataException;
	 public String enableUser(Integer userId, Boolean isEnable) throws InvalidDataException;
	 public String changeUserPwd(Integer userId, String newPwd) throws InvalidDataException;
	 public UserEntity findUserByUsername(String username) throws InvalidDataException;
}
