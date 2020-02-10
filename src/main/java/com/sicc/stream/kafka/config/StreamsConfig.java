package com.sicc.stream.kafka.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.sicc.stream.kafka.channel.UserChannel;

@EnableBinding(UserChannel.class)
public class StreamsConfig {

}
