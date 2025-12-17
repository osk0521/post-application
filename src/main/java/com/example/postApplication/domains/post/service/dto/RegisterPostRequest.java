package com.example.postApplication.domains.post.service.dto;

import com.example.postApplication.domains.post.domain.model.Post;

public record RegisterPostRequest(
        String title,
        String content
) {
    public Post toEntity() {
        return new Post(title, content);
    }
}