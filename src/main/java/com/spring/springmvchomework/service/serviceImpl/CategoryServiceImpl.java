package com.spring.springmvchomework.service.serviceImpl;

import com.spring.springmvchomework.model.Category;
import com.spring.springmvchomework.repository.CategoryRepository;
import com.spring.springmvchomework.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
//    CategoryServiceImpl(){
//        categoryRepository=new CategoryRepository();
//    }


    @Override
    public List<Category> getAllCategory() {

        return categoryRepository.getCategories();
    }
}
