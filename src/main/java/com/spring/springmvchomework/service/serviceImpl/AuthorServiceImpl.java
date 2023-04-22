package com.spring.springmvchomework.service.serviceImpl;

import com.spring.springmvchomework.model.Author;
import com.spring.springmvchomework.repository.AuthorRepository;
import com.spring.springmvchomework.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.getAuthors();
    }
}
