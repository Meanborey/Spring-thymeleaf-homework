package com.spring.springmvchomework.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {
    int id;
    private String title;
    private String description;
    private MultipartFile file;
    private int authorID;
    private int categoryID;
}
