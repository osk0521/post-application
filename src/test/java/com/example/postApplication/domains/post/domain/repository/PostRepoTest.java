package com.example.postApplication.domains.post.domain.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.NoSuchElementException;

import com.example.postApplication.domains.post.domain.model.Post;
import com.example.postApplication.global.config.JpaConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(JpaConfig.class)
@DataJpaTest
@DisplayName("Repo:Post")
class PostRepoTest {
    @Autowired
    PostRepo postRepo;

    @Test
    @DisplayName("Post Entity를 저장한다.")
    void save() {
        // Given
        Post post = new Post("제목", "내용");

        // When
        Post savedResult = postRepo.save(post);

        // Then
        assertThat(savedResult.getId()).isNotNull();
        assertThat(savedResult.getCreatedAt()).isNotNull();
    }

    @Test
    @DisplayName("Post Entity를 조회한다.")
    void findById() {
        // Given
        Post post = new Post("제목", "내용");
        Post savedResult = postRepo.save(post);

        // When
        Post findPost = postRepo.findById(savedResult.getId()).orElseThrow();

        // Then
        assertThat(findPost.getId()).isEqualTo(savedResult.getId());
    }

    @Test
    @DisplayName("Post Entity 조회 시 존재하지 않는 경우 예외가 발생한다.")
    void throwException_whenNotExistPost() {
        // When & Then
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> postRepo.findById(1L).orElseThrow());
    }
}