package com.demo.sample.retry;

import org.springframework.stereotype.Service;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleService {

	private static final String config = "sampleRetry";

	@Retry(name = config, fallbackMethod = "fallback")
	public String getSample() {
		throw new RetryException("This is a sample");
	}

	private String fallback(Exception e) {
		log.error(e.getMessage(), e);
		return "fallback";
	}
}
