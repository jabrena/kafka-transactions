package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService producerService;

    @GetMapping("/produce")
    public String produceMessage() {
        try {
            producerService.sendMessage("Hello, Kafka!");
            return "Message sent successfully!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
