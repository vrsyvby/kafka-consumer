package com.course.kafkaconsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HelloKafkaConsumer {

    @KafkaListener(topics = "t_hello")
    public void consumeMessage(String message){
        System.out.println(message);
    }
}
