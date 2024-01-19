package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "my-topic")
    @Transactional
    public void consumeMessage(ConsumerRecord<String, String> record) {
        System.out.println("Received message: " + record.value());
        // Process the message

        // Uncomment the line below to simulate an error and trigger a rollback
        // throw new RuntimeException("Simulated error");

        // Acknowledge the message
        System.out.println("Acknowledging message");
    }
}

