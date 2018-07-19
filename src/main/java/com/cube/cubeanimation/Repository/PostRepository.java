package com.cube.cubeanimation.Repository;

import com.cube.cubeanimation.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Override
    List<Post> findAll();
}
