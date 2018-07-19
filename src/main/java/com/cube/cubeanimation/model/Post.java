package com.cube.cubeanimation.model;

import com.cube.cubeanimation.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Post extends BaseEntity {

    @NotNull
    private String title;
    private String descrition;

    protected Post() {
        super();
    }

    public Post(String title, String descrition) {
        this.title = title;
        this.descrition = descrition;
    }
}
