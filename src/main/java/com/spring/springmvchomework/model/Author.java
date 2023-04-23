package com.spring.springmvchomework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
        private int id;
        private String f_name;
        private String username;
        private String p_userImage;
        private String cover;
        private String sex;
        private String address;
        private String email;


}
