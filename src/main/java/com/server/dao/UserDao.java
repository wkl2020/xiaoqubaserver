package com.server.dao;

import com.server.dao.model.UserEntity;
import com.server.exception.InvalidDataException;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * User: ryan
 * Date: 2/20/13
 */
public interface UserDao extends CrudRepository<UserEntity,Long> {
	
	@Query("select u from UserEntity u where u.username=:username")  
	public UserEntity findByUsername(@Param("username") String username) throws InvalidDataException;
	
}
