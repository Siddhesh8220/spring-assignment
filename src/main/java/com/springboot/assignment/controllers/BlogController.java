package com.springboot.assignment.controllers;


import java.util.*;

import com.springboot.assignment.entities.Blog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BlogController {

    ArrayList<Blog> blogs = new ArrayList<>();

    void populateBlogs() {
        blogs.add(new Blog("Test Blog", "hey there", "Siddhesh Chavan"));
        blogs.add(new Blog("Test Blog2","Lola","Rohan Sawant"));
    }

    BlogController(){
        populateBlogs();
    }

    @GetMapping(path="/blogs")
    public ArrayList<Blog> getAllUsers() {
        return blogs;
    }

}
