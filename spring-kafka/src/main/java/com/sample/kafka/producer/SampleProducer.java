package com.sample.kafka.producer;

import java.util.function.Supplier;

import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.sample.kafka.common.SampleMessage;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Component
@RequiredArgsConstructor
public class SampleProducer implements Supplier<Flux<Message<SampleMessage>>> {

	private final Sinks.Many<Message<SampleMessage>> sinks = Sinks.many().unicast().onBackpressureBuffer();

	public void sendMessage(SampleMessage message) {
		Message<SampleMessage> sampleMessageMessage = MessageBuilder.withPayload(message)
																	.setHeader(KafkaHeaders.KEY, message.getAge())
																	.build();

		sinks.emitNext(sampleMessageMessage, Sinks.EmitFailureHandler.FAIL_FAST);
	}

	@Override
	public Flux<Message<SampleMessage>> get() {
		return sinks.asFlux();
	}
}
