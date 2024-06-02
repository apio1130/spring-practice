package com.sample.kafka.producer;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.kafka.common.SampleMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SampleProducerController {

	private final SampleProducer sampleProducer;

	@PostMapping("/send-message")
	public void publishMessage(@RequestBody SampleMessage message) {
		sampleProducer.sendMessage(message);
	}
}
