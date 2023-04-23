package com.spring.springmvchomework.service;

import com.spring.springmvchomework.controller.ArticleController;
import com.spring.springmvchomework.model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticle();
    List<Article> getArticleByAuthorName(String authorName);

    List<Article> getArticleByid(int id);

    void addArticle(Article article);
    void editArticle(Article article);
}
