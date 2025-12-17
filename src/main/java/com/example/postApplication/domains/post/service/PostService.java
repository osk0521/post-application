package com.example.postApplication.domains.post.service;

import com.example.postApplication.domains.post.domain.model.Post;
import com.example.postApplication.domains.post.domain.repository.PostRepo;
import com.example.postApplication.domains.post.service.dto.PostResponse;
import com.example.postApplication.domains.post.service.dto.RegisterPostRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepo postRepo;

    @Transactional
    public void create(RegisterPostRequest request) {
        Post post = request.toEntity();
        Post savedPost = postRepo.save(post);
    }

    public PostResponse getPost(Long id) {
        return postRepo.findById(id)
                .map(PostResponse::of)
                .orElseThrow();
    }
}