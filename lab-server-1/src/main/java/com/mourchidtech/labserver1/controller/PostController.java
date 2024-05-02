package com.mourchidtech.labserver1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mourchidtech.labserver1.config.MessageProducer;
import com.mourchidtech.labserver1.dto.Post.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final MessageProducer messageProducer;

    @PostMapping
    public String createPost(@RequestBody Post post) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        String message = objectMapper.writeValueAsString(post);

        System.out.println(message);
        messageProducer.sendMessage("createPost", message);

        return "Post sent";
    }
}

