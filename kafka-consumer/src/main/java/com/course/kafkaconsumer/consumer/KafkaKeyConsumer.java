package com.course.kafkaconsumer.consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaKeyConsumer {

    private static final Logger log= LoggerFactory.getLogger(KafkaKeyConsumer.class);

    @KafkaListener(topics = "t_multi_partitions",concurrency = "3")
    public void consumeMessage(ConsumerRecord<String,String> record){
        log.info("key is: "+record.key()+" value is :"+record.value());
    }

}
