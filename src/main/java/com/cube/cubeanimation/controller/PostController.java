package com.cube.cubeanimation.controller;

import com.cube.cubeanimation.model.dto.PostDto;
import com.cube.cubeanimation.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<PostDto> getPosts() {
        return postService.getPostsDto();
    }

    @GetMapping("/posts/{id}")
    public PostDto getPost(@PathVariable long id) {
        return postService.getPostDto(id);
    }

    @PostMapping("/posts")
    public void addPost(@RequestBody PostDto postDto) {
        postService.addPost(postDto);
    }

    @PutMapping("/posts")
    public void editPost(@RequestBody PostDto postDto) {
        System.out.println(postDto);
        postService.editPost(postDto);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable long id) {
        postService.deletePost(id);
    }
}
