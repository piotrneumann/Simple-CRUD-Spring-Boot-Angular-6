package com.cube.cubeanimation.services;

import com.cube.cubeanimation.Repository.PostRepository;
import com.cube.cubeanimation.model.Post;
import com.cube.cubeanimation.model.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDto getPostDto(long id) throws RuntimeException {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()) {
            return new PostDto(post.get());
        } else {
            throw new RuntimeException("Post id: " + id + " not found");
        }
    }

    public List<PostDto> getPostsDto() {
        return postRepository.findAll().stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }

    public void editPost(PostDto postDto) {
        Post post = convertPostDto(postDto);
        postRepository.save(post);
    }

    public void addPost(PostDto postDto) {
        Post post = convertPostDto(postDto);
        postRepository.save(post);
    }

    private Post convertPostDto(PostDto postDto) {
        Optional<Post> post = postRepository.findById(postDto.getId());
        if (post.isPresent()) {
            post.get().setTitle(postDto.getTitle());
            post.get().setDescrition(postDto.getDescription());
            return post.get();
        } else {
            return new Post(postDto.getTitle(), postDto.getDescription());
        }
    }

    public void deletePost(long id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent()) {
            postRepository.delete(post.get());
        } else {
            throw new RuntimeException("Post id: " + id + " not found");
        }
    }
}
