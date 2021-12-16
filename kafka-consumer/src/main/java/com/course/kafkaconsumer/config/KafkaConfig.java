package com.course.kafkaconsumer.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;

import java.util.Map;

@Configuration
public class KafkaConfig {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ConsumerFactory<Object,Object> consumerFactory(){
        Map<String, Object> consumerProperties= kafkaProperties.buildConsumerProperties();
        consumerProperties.put(ConsumerConfig.METADATA_MAX_AGE_CONFIG,5000);
        return new DefaultKafkaConsumerFactory<>(consumerProperties);
    }

}

