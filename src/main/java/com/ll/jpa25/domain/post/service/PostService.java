package com.ll.jpa25.domain.post.service;

import com.ll.jpa25.domain.post.entity.Post;
import com.ll.jpa25.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post view(Long id){
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isPresent()){
            return optionalPost.get();
        }else {
            throw new IllegalArgumentException("Post not found");
        }
    }

    public List<Post> findByUsername(String username) {
        return postRepository.findByUsername(username);
    }
}
