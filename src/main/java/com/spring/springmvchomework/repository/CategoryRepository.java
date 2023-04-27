package com.spring.springmvchomework.repository;

import com.spring.springmvchomework.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CategoryRepository {
        List<Category> categories= new ArrayList<>(){{
       add(new Category(1001,"Education","it have a lot of AI"));
       add(new Category(1002,"Sport","it have a lot of AI"));
       add(new Category(1003,"Programming","it have a lot of AI"));
       add(new Category(1004,"Science","it have a lot of AI"));
       add(new Category(1005,"Biology","it have a lot of AI"));
    }};
    public List<Category> getCategories(){
        return categories;
    }
    public List<Category> getCategoryByName(String name){

        return categories.stream().filter(e-> Objects.equals(e.getCategory(),name)).toList();
    }
}
