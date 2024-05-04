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

    public void update(com.mourchidtech.dto.Post post)  {
        try {
            Post postToUpdate =  repository.findById(post.getId()).orElseThrow(() -> new RuntimeException("Post with id not found"));
            postToUpdate.setTitle(post.getTitle());
            postToUpdate.setContent(post.getContent());
            postToUpdate.setContent(post.getContent());
            repository.save(postToUpdate);
        } catch (Exception ex ) {
            System.out.println(ex.getMessage());
        }
    }
}

