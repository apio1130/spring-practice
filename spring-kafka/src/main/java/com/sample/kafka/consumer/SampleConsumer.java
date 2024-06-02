package com.sample.kafka.consumer;

import java.util.function.Consumer;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.sample.kafka.common.SampleMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SampleConsumer implements Consumer<Message<SampleMessage>> {
	@Override
	public void accept(Message<SampleMessage> sampleMessageMessage) {
		log.info("Message Received - {}", sampleMessageMessage.getPayload());
	}
}
