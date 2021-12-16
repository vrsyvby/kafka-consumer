package com.course.kafkaconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CommodityConsumer {

    private static Logger log = LoggerFactory.getLogger(CommodityConsumer.class);


    @KafkaListener(topics = "t_commodity",groupId = "cg-dashboard")
    public void consumeDashboardMessage(String message) throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextLong(500,1000));
        log.info("Dashboard received this message: "+message);
    }

    @KafkaListener(topics = "t_commodity",groupId = "cg-notification")
    public void consumeNotificationMessage(String message){
        log.info("Notification received this message: "+message);
    }

}
