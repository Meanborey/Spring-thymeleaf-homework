package com.spring.springmvchomework.controller;

import com.spring.springmvchomework.model.Article;
import com.spring.springmvchomework.model.Author;
import com.spring.springmvchomework.model.Category;
import com.spring.springmvchomework.model.request.ArticleRequest;
import com.spring.springmvchomework.service.ArticleService;
import com.spring.springmvchomework.service.AuthorService;
import com.spring.springmvchomework.service.CategoryService;
import com.spring.springmvchomework.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Comparator;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
ArticleService articleService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AuthorService authorService;
    @Autowired
    FileUploadService fileUploadService;
    // inject article service
    @GetMapping("/index")
public String index(Model model){
        List<Article>articles = articleService.getAllArticle();
        List<Category>categories=categoryService.getAllCategory();
        model.addAttribute("article", articles);
        model.addAttribute("category",categories);
        return "index";
}
@GetMapping("/AllUser")
public String alluser(Model model){
        List<Article> articles= articleService.getAllArticle();
        model.addAttribute("article",articles);
        return "AllUser";
}
    @GetMapping("/ViewProfile")
    public String viewUser(Model model){

        return "ViewProfile";
    }
    @GetMapping("/formpost")
    String addFormPost(Model model){
        List<Category> categories = categoryService.getAllCategory();
        List<Author> authors = authorService.getAllAuthor();
        System.out.println(authors);
        model.addAttribute("article",new ArticleRequest());
        model.addAttribute("categories",categories);
        model.addAttribute("authors", authors);
        return "AddPost";
    }
//    @GetMapping("/AddPost")
//    public String addpost(@ModelAttribute("article") ArticleRequest article, @RequestParam("file") MultipartFile file, BindingResult bindingResult, Model model) {
//
//        if(bindingResult.hasErrors()){
//            System.out.println("Erorr has happened!!!");
////            model.addAttribute("article", new ArticleRequest());
//            model.addAttribute("authors", authorService.getAllAuthor());
//            return "new-article";
//        }
//        Article newArticle = new Article();
//        try{
//            String filenames ="http://localhost:8080/images/"+ fileUploadService.uploadFile(file);
//
//            newArticle.setImgUrl(filenames);
//        }catch (Exception ex){
//            newArticle.setImgUrl("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png");
//            System.out.println("Error : "+ex.getMessage());
//        }
//
//        // mapstruct vs model mapper
//        newArticle.setArticle(article.getArticle());
//        newArticle.setDescription(article.getDescription());
////        newArticle.setImgUrl(article.getImgUrl());
//
//        // find the article by ID
//        newArticle.setAuthor(authorService.getAllAuthor().stream().filter(e -> e.getId() == article.getAuthorID())
//                .findFirst().orElse(null));
//
//        // id , author
//        // get the max article id and add the value by 1
//        newArticle.setId(articleService.getAllArticle().stream().max(Comparator.comparingInt(Article::getId)).stream().toList().get(0).getId()+1);
//
//        articleService.addArticle(newArticle);
//        return "redirect:/AddPost";
//    }
    @GetMapping("/DisplayCategory")
    public String displaycategory(Model model){
        List<Article> articles= articleService.getAllArticle();
        model.addAttribute("article",articles);
        return "DisplayCategory";
    }
}
