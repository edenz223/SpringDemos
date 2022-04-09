package com.edenz223.springbootthymeleaf.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private Long id;

    private String name;
}
