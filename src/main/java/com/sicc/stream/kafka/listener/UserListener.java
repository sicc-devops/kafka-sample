package com.sicc.stream.kafka.listener;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.sicc.stream.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sicc.stream.domain.UserVO;
import com.sicc.stream.kafka.channel.UserChannel;

@Component
public class UserListener {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserListener.class);

	@StreamListener(UserChannel.INPUT)
	public void listenNewUser(@Payload UserVO user) {

    	logger.info("kafka received: "+ user.toStringJson());
    	
    	try {
    		
    		int insert = userService.insertUser(user);
    		
	    } catch(Exception e) {
	    	logger.info("context", e);
	    }
   	
	}
}
