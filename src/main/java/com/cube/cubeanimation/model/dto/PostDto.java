package com.cube.cubeanimation.model.dto;

import com.cube.cubeanimation.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

    private long id;
    private String title;
    private String description;

    public PostDto() {
    }

    public PostDto(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public PostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.description = post.getDescrition();
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
