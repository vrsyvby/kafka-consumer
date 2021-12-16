package com.course.kafkaconsumer.consumer;

import com.course.kafkaconsumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaEmployeeConsumer {

    private static final Logger log= LoggerFactory.getLogger(KafkaEmployeeConsumer.class);

    @KafkaListener(topics = "t_employee")
    public void consumMessage(String message) throws JsonProcessingException {

        ObjectMapper om = new ObjectMapper();
        log.info("Employee value received: {}",om.readValue(message, Employee.class).toString());

    }
}
