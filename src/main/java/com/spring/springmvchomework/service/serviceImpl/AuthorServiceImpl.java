package com.spring.springmvchomework.service.serviceImpl;

import com.spring.springmvchomework.model.Author;
import com.spring.springmvchomework.repository.AuthorRepository;
import com.spring.springmvchomework.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
//    @Autowired
  private final AuthorRepository authorRepository;
    AuthorServiceImpl(){
        authorRepository = new AuthorRepository();
    }
    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.getAuthors();
    }

    @Override
    public Author getAuthorById(int id) {
        return authorRepository.getAuthorById(id);
    }


}
