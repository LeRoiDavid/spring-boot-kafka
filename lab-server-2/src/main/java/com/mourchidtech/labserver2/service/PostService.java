package com.mourchidtech.labserver2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mourchidtech.labserver2.entity.Post;
import com.mourchidtech.labserver2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository repository;

    public Post create(Post post) {
        return repository.save(post);
    }

    public void create(String post)  {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        try {
            Post postToCreate =  objectMapper.readValue(post, Post.class);
            System.out.println(postToCreate);
            this.create(postToCreate);
        } catch (JsonProcessingException ex ) {
            System.out.println(ex.getMessage());
        }
    }
}
