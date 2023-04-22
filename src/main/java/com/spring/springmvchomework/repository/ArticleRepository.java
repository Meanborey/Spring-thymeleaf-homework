package com.spring.springmvchomework.repository;

import com.spring.springmvchomework.model.Article;
import com.spring.springmvchomework.model.Category;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepository {
    List<Article>articleList=new ArrayList<>(){{
       add(new Article(1001,"java","https://images.pexels.com/photos/807842/pexels-photo-807842.jpeg?auto=compress&cs=tinysrgb&w=600","Hello","java is popular language",new AuthorRepository().getAuthors().get(0),new CategoryRepository().getCategories().get(0) ));
       add(new Article(1002,"Spring","https://i.pinimg.com/736x/a7/26/ba/a726baa5a6d522e24ef546d8a2d3e32d.jpg","Hello world","Spring is popular language",new AuthorRepository().getAuthors().get(2),new CategoryRepository().getCategories().get(2) ));
       add(new Article(1003,"css","https://i.pinimg.com/736x/d2/30/72/d23072bafb2719f4fd07ddcfb5b4465b.jpg","for design","css is popular language for design",new AuthorRepository().getAuthors().get(1),new CategoryRepository().getCategories().get(1) ));
       add(new Article(1004,"HTML","https://i.pinimg.com/736x/28/bb/ce/28bbce5c0fa2e6bc2b786937be1c2ed9.jpg","for design","css is popular language for design",new AuthorRepository().getAuthors().get(3),new CategoryRepository().getCategories().get(3) ));
       add(new Article(1005,"Boolscript","https://i.pinimg.com/736x/e8/17/e0/e817e045d7a4cf0fa73f5a7bbb413149.jpg","for design","css is popular language for design",new AuthorRepository().getAuthors().get(4),new CategoryRepository().getCategories().get(4) ));
    }};

    public List<Article> getArticleList(){
        return articleList;
    }
}
