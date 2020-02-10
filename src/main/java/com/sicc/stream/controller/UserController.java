package com.sicc.stream.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sicc.stream.domain.UserVO;
import com.sicc.stream.kafka.source.UserInsertEventSource;

@RestController
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserInsertEventSource userInsertEventSource;

    @PostMapping(value = "/prd")
    public String sendMessage(HttpServletRequest req, @RequestBody UserVO userVO) {
    	
    	userInsertEventSource.publishOrderEvent(userVO);
    	logger.info("kafka sent :" + userVO.toStringJson());
    	return "Kafka sent user "+ userVO.toStringJson();
    }
}
