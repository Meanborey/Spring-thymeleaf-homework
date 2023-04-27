package com.spring.springmvchomework.repository;

import com.spring.springmvchomework.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {
     List<Author> authors = new ArrayList<>(){{
        add(new Author(1001,"Muny Yat","Muny","https://i.pinimg.com/originals/cc/c4/06/ccc406dbafc09f3ac2f066a494af21e7.jpg","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRwhV8QsSAGGsmpd0sEWh5npKurrBTBe1XA63AAw1M1GZ8rCB0m14pJ6j1V3muYgYKY5rA&usqp=CAU","female","Takeo","thydayat11@gamil.com"));
        add(new Author(1002,"Thyda Yat","Thyda","https://i.pinimg.com/736x/01/57/d3/0157d301917541f15677dc43f31f1fcb.jpg","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMZU5ChQ8hH2H2AxZJL-AMNjOj9NPbLm5poQ&usqp=CAU","female","pp","munyyat11@gamil.com"));
        add(new Author(1003,"num Yat","num","https://i.pinimg.com/564x/9f/aa/a1/9faaa1fedc94c355a4256ba6207c7714.jpg","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMZU5ChQ8hH2H2AxZJL-AMNjOj9NPbLm5poQ&usqp=CAU","female","kps","bmunat11@gamil.com"));
        add(new Author(1004,"koko Yat","koko","https://i.pinimg.com/736x/dc/83/3c/dc833c7e268ce5837966729956efdd64.jpg","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnImC20dnb57_ss0--ivz3pCeKCHH6CTG9xI9x0Vs53x_hfhQ8yAsxlFZHjxpzHOQjKVk&usqp=CAU","female","kps","kokoyat11@gamil.com"));
        add(new Author(1005,"muy Yat","koko","https://i.pinimg.com/736x/71/fe/83/71fe83b3f2423bb24a925ff72565fd0e.jpg","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHqyXe6zcqMIIEkYjbjtg6Y0RrTxaNrGZNnRbQIP94Nc9D-gR1yVCw1plDAfCegcCHBI4&usqp=CAU","male","kps","boyyat11@gamil.com"));
    }};
    public List<Author> getAuthors(){
        return authors;
    }

    public Author getAuthorById(int id){
        return authors.stream().filter(e->e.getId()==id).findFirst().orElse(null);
    }
}
