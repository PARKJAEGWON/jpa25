package com.ll.jpa25.global.initData;

import com.ll.jpa25.domain.post.entity.Post;
import com.ll.jpa25.domain.post.service.PostService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitData {

    @Bean
    public ApplicationRunner applicationRunner(PostService chatRoomService) {
        return args -> {
            Post post = chatRoomService.create("제목", "내용", "작성자");
        };
    }

}
