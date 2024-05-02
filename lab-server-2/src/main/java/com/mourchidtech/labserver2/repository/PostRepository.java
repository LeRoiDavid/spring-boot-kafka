package com.mourchidtech.labserver2.repository;

import com.mourchidtech.labserver2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
