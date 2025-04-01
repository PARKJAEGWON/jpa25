package com.ll.jpa25.domain.post.service;

import com.ll.jpa25.domain.post.entity.Post;
import com.ll.jpa25.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
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
        postRepository.findById(1L);
        postRepository.findByUsername(username);
        return postRepository.findByUsername(username);
    }

    @SneakyThrows
    public Optional<Post> findWithShareLockById(Long id) {
        postRepository.findWithShareLockById(id);
        Thread.sleep(20000);
        return postRepository.findWithShareLockById(id);
    }

    public Post create(String subject, String content, String username) {
        Post post =  Post.builder()
                .subject(subject)
                .content(content)
                .username(username)
                .build();
        return postRepository.save(post);
    }

    @SneakyThrows//없어야 정상적인 동작 테스트를 위함
    @Transactional
    public Post modifyOptimistic(Long id){
        Post post =postRepository.findById(id).orElseThrow();

        Thread.sleep(10_000);//없어야 정상적인 동작 테스트를 위함

        post.setUsername(post.getUsername() + "!");
        return post;
    }
}