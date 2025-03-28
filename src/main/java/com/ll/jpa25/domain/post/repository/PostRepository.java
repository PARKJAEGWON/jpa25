package com.ll.jpa25.domain.post.repository;

import com.ll.jpa25.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUsername(String username);
}
