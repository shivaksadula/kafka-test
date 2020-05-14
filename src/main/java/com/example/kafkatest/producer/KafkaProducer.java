package com.example.kafkatest.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() {
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("dremio", "{\"hello\": \"world\"}");
        Header eventType = new RecordHeader("eventType", "test".getBytes());
        producerRecord.headers().add(eventType);
        kafkaTemplate.send(producerRecord);
    }
}
