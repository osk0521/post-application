package com.example.postApplication.domains.post.domain.repository;

import com.example.postApplication.domains.post.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}