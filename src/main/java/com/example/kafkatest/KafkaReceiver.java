package com.example.kafkatest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class KafkaReceiver {

	@Value(value = "${spring.kafka.group-id}")
	private String groupId;

	@KafkaListener(topics = "dexxisTopic", groupId = "dexxisGroup")
	public void processMessage(String content){
		log.info("Received message from dexxisTopic and dexxisGroup: " + content);
	}
}
