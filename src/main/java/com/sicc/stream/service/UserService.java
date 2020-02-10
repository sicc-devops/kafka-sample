package com.sicc.stream.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sicc.stream.domain.UserVO;
import com.sicc.stream.mapper.UserMapper;


@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private UserMapper userMapper;

    
    public UserVO selectUser(String UserId) {
        return userMapper.selectUser(UserId);
    }
    
    public int deleteUser(String UserId) {
        return userMapper.deleteUser(UserId);
    }
    
    public int insertUser(UserVO user) {
    	  
        try {
  		  
          int result = userMapper.insertUser(user);
  		  return result;
  		  
    	  } catch (Exception e) {
    		  log.info(e.getMessage());
    	      return 0;
    	  }
     }
}
