package com.sicc.stream.kafka.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface UserChannel {

	String INPUT = "user-in";
	String OUTPUT = "user-out";

	@Input(INPUT)
	MessageChannel inboundUser();
	
	@Output(OUTPUT)
	MessageChannel outboundUser();
}
