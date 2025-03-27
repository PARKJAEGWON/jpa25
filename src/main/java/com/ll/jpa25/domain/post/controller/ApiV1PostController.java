package com.ll.jpa25.domain.post.controller;

import com.ll.jpa25.domain.post.entity.Post;
import com.ll.jpa25.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
//@Transactional
public class ApiV1PostController {

    private final PostService postService;

    @GetMapping("{id}")
    public Post viewPost(@PathVariable("id") Long id) {
        return postService.view(id);
    }

    @GetMapping("/findByUsername/{username}")
    public List<Post> findByUsername(@PathVariable("username")String username) {
        return postService.findByUsername(username);
    }
}
