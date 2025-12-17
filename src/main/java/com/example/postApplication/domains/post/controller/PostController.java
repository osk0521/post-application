package com.example.postApplication.domains.post.controller;

import com.example.postApplication.domains.post.service.PostService;
import com.example.postApplication.domains.post.service.dto.PostResponse;
import com.example.postApplication.domains.post.service.dto.RegisterPostRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    ResponseEntity<Void> register(@RequestBody RegisterPostRequest request) {
        postService.create(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
        PostResponse response = postService.getPost(id);
        return ResponseEntity.ok().body(response);
    }
}