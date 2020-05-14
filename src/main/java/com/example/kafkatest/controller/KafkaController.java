package com.example.kafkatest.controller;

import com.example.kafkatest.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping
    public ResponseEntity<Object> test() {
        kafkaProducer.sendMessage();
        return ResponseEntity.noContent().build();
    }
}
