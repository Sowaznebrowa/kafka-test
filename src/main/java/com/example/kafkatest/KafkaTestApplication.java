package com.example.kafkatest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Scanner;

@SpringBootApplication
public class KafkaTestApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory
			.getLogger(KafkaTestApplication.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(KafkaTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		LOG.info("TYPE SOME MESSAGE TO KAFKA TOPIC");
		while(true){
			if(scanner.hasNext()){
				kafkaTemplate.send("dexxisTopic",scanner.next());
			}
		}
	}
}
