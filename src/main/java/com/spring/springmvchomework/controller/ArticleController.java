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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class ArticleController {
    ArticleService articleService;
    CategoryService categoryService;
    AuthorService authorService;
    FileUploadService fileUploadService;
    // inject article service
    ArticleController(ArticleService articleService, CategoryService categoryService, AuthorService authorService, FileUploadService fileUploadService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.fileUploadService = fileUploadService;
    }

        @GetMapping("ViewProfile/{id}/{name}")
    public String test(@PathVariable int id,@PathVariable String name, Model model){
            model.addAttribute("article",articleService.getArticleByAuthorName(name));
        model.addAttribute("author",authorService.getAuthorById(id));

//            authorService.getAllAuthor().stream().forEach(System.out::println);
        model.addAttribute("categories",categoryService.getAllCategory());
        return "ViewProfile";
    }
    @GetMapping("/index")
public String index(Model model){
        List<Article>articles = articleService.getAllArticle();
        List<Category>categories=categoryService.getAllCategory();
        model.addAttribute("article", articles);
        System.out.println("===================================");
        articles.stream().forEach(System.out::println);
        model.addAttribute("category",categories);
        return "index";
}
@GetMapping("/AllUser")
public String alluser( Model model){
//        List<Article> articles= articleService.getAllArticle();
        model.addAttribute("article",articleService.getAllArticle());
        model.addAttribute("viewProfile",authorService.getAllAuthor());
    model.addAttribute("categories",categoryService.getAllCategory());
        return "AllUser";
}
//    @GetMapping("/author-view-profile/")
//    public String viewuser(@PathVariable int id, Model model){
//        model.addAttribute("article",articleService.getAllArticle());
//        model.addAttribute("author",articleService.getArticleByid(id));
//        model.addAttribute("categories",categoryService.getAllCategory());
//        return "ViewProfile";
//    }
//    handle-add-article
    @PostMapping("/handle-add-article")
    public String addpost(@ModelAttribute("article") ArticleRequest article, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            List<Category> categories = categoryService.getAllCategory();
        List<Author> authors = authorService.getAllAuthor();
        System.out.println(authors);
        model.addAttribute("categories",categories);
        model.addAttribute("authors", authors);
        return "/AddPost";
        }
        Article newArticle = new Article();
        System.out.println("hERE IS THE VQLUE FO THE ARTICLE : "+article);
        try{
            String filenames ="http://localhost:8080/images/"+ fileUploadService.uploadFile(article.getFile());
            newArticle.setImgUrl(filenames);
        }catch (Exception ex){
            newArticle.setImgUrl("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png");
            System.out.println("Error : "+ex.getMessage());
        }
        newArticle.setTitle(article.getTitle());
        newArticle.setDescription(article.getDescription());
        newArticle.setAuthor(authorService.getAllAuthor().stream().filter(e -> e.getId() == article.getAuthorID())
                .findFirst().orElse(null));
        newArticle.setId(articleService.getAllArticle().stream().max(Comparator.comparingInt(Article::getId)).stream().toList().get(0).getId()+1);
         newArticle.setName(newArticle.getAuthor().getUsername());// setting the name for hte post

        // Create the categories for the article

        newArticle.setCategory(categoryService.getAllCategory().stream().filter(e-> e.getId()==article.getCategoryID()).findFirst()
                .orElse(null));
        // category  vs name
        //        List<Category> categories = new ArrayList<>();
//        for (int cate : article.){
//            categories.add(categoryService.getAllCategory().stream().filter(e->e.getId() == cate).findFirst().orElse(null));
//        }
//        Category categorieslist = categories;
//        newArticle.setCategory(categorieslist);
        articleService.addArticle(newArticle);
//        System.out.println("here is the new articl *****e : "+newArticle);
        return "redirect:/index";
    }
    @GetMapping("/DisplayCategory")
    public String displaycategory(Model model){
        model.addAttribute("article",new ArticleRequest());
        model.addAttribute("author",authorService.getAllAuthor());
        model.addAttribute("categories",categoryService.getAllCategory());
        return "DisplayCategory";
    }
    @GetMapping("/article-post")
    public String publicpost(Model model){
        model.addAttribute("article",new ArticleRequest());
        model.addAttribute("author",authorService.getAllAuthor());
        authorService.getAllAuthor().stream().forEach(System.out::println);
        model.addAttribute("categories",categoryService.getAllCategory());
        return "AddPost";
    }
}
