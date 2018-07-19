package com.cube.cubeanimation.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    protected BaseEntity() {
    }
}