package com.cube.cubeanimation.repository;

import com.cube.cubeanimation.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
