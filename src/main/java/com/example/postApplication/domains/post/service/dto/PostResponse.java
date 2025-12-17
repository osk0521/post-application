package com.example.postApplication.domains.post.service.dto;

import com.example.postApplication.domains.post.domain.model.Post;

import java.time.LocalDateTime;

public record PostResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt
) {

    public static PostResponse of(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt()
        );
    }
}