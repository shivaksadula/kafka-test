package com.example.kafkatest.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @KafkaListener(topics = "dremio")
    public void listen(ConsumerRecord<String, String> record) {
        log.info("consumed from partition " + record.partition() + " with offset " + record.offset());
    }
}
