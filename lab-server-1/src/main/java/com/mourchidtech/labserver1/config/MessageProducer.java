package com.mourchidtech.labserver1.config;


import com.mourchidtech.dto.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProducer {

//    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaTemplate<String, Post> kafkaTemplateObject;

    public void sendMessage(String topic, Post message) {
        kafkaTemplateObject.send(topic, message);
    }

}