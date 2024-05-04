package com.mourchidtech.labserver1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mourchidtech.labserver1.config.MessageProducer;
import com.mourchidtech.dto.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final MessageProducer messageProducer;

    @PostMapping
    public String createPost(@RequestBody Post post) throws JsonProcessingException {
        messageProducer.sendMessage("createPost", post);
        return "Post sent";
    }

    @GetMapping
    public String fetchAll(@RequestBody Post post) throws JsonProcessingException {
        return "Fetch post";
    }

    @PatchMapping("/{id}")
    public String updatePost(@PathVariable("id") Long id, @RequestBody Post post) {
        post.setId(id);
        messageProducer.sendMessage("updatePost", post);
        return "Post sent";
    }
}

