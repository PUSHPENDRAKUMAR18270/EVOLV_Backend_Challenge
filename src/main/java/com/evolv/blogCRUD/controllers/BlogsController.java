package com.evolv.blogCRUD.controllers;

import com.evolv.blogCRUD.entities.Blog;
import com.evolv.blogCRUD.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BlogsController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public String home()
    {
        return "Welcome to Blogs API";
    }

    @GetMapping("/blogs")
    public List<Blog> getAllBlogs()
    {
        return blogService.getAllBlogs();
    }

    @GetMapping("/blogs/{blogId}")
    public Blog getBlogById(@PathVariable String blogId)
    {
        return blogService.getBlogById(Long.parseLong(blogId));
    }

    @PostMapping("/blogs")
    public Map<String,String> addBlog(@RequestBody Blog blog)
    {
        return blogService.addBlog(blog);
    }

    @PutMapping("/blogs/{blogId}")
    public Map<String,String> updateBlog(@PathVariable String blogId, @RequestBody Blog blog )
    {
        return blogService.updateBlogById(Long.parseLong(blogId),blog);
    }

    @DeleteMapping("/blogs/{blogId}")
    public Map<String,String> deleteBlogById(@PathVariable String blogId)
    {
        return blogService.deleteBlogById(Long.parseLong(blogId));
    }
}
