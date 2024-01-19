package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Transactional
    public void sendMessage(String message) {
        kafkaTemplate.sendDefault(message);
        // Uncomment the line below to simulate an error and trigger a rollback
        // throw new RuntimeException("Simulated error");
    }
}
