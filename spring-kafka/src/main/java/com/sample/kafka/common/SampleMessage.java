package com.sample.kafka.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class SampleMessage {
	private String name;
	private String age;
}
