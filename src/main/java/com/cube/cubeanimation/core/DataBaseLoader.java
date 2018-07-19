package com.cube.cubeanimation.core;

import com.cube.cubeanimation.Repository.PostRepository;
import com.cube.cubeanimation.model.Post;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements ApplicationRunner {

    private final PostRepository postRepository;

    public DataBaseLoader(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for(int i=0;i<10;i++) {
            postRepository.save(new Post("Lorem Ipsum",
                    "Dolor sit amet, consectetur adipiscing elit, " +
                            "sed do eiusmod tempor incididunt ut labore et dolore " +
                            "magna aliqua. Ut enim ad minim veniam, quis nostrud " +
                            "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."));
        }
    }
}