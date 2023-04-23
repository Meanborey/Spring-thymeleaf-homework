package com.spring.springmvchomework.service.serviceImpl;

import com.spring.springmvchomework.model.Article;
import com.spring.springmvchomework.repository.BlogRepository;
import com.spring.springmvchomework.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {



    // inject Repository

    private final BlogRepository articleRepository;
    @Override
    public List<Article> getAllArticle() {

        return articleRepository.getArticleList();
    }

    @Override
    public List<Article> getArticleByAuthorName(String Name) {

        return articleRepository.getArticleByAuthorName(Name);
    }
    @Override
    public List<Article> getArticleByid(int id) {

        return articleRepository.getArticleByid(id);
    }

    @Override
    public void addArticle(Article article) {
articleRepository.addArticle(article);
    }

    @Override
    public void editArticle(Article article) {

    }
}
