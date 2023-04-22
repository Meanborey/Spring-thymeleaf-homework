package com.spring.springmvchomework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private int id;
    private String name;
    private String imgUrl;
    private String title;
    private String description;
    private Author author;
    private Category category;
}
