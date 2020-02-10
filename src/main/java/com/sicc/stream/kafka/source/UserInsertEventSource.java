package com.sicc.stream.kafka.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import com.sicc.stream.domain.UserVO;
import com.sicc.stream.kafka.channel.UserChannel;

@Component
public class UserInsertEventSource {
	
	@Autowired
	private UserChannel userChannel;

	public void publishOrderEvent(UserVO user) {
		
		MessageChannel messageChannel = userChannel.outboundUser();
		messageChannel.send(MessageBuilder.withPayload(user)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}
}
