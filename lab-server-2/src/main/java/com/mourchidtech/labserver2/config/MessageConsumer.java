package com.mourchidtech.labserver2.config;

import com.mourchidtech.labserver2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageConsumer {

//    @Value(value = "${spring.kafka.consumer.group-id}")
    private String consumer = "my-group-id";

    private final PostService postService;

    @KafkaListener(topics = "createPost", groupId = "my-group-id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
        postService.create(message);
    }

}