package com.evolv.blogCRUD.controllers;

import com.evolv.blogCRUD.entities.Blog;
import com.evolv.blogCRUD.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
    public void addBlog(@RequestBody Blog blog)
    {
        blog.setDateOfPublish(new Date());
        blogService.addBlog(blog);
    }

    @PutMapping("/blogs/{blogId}")
    public ResponseEntity<HttpStatus> updateBlog(@PathVariable String blogId, @ModelAttribute("blog") Blog blog )
    {
        try{
            blog.setLastUpdated(new Date());
            blogService.updateBlogById(Long.parseLong(blogId),blog);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/blogs/{blogId}")
    public ResponseEntity<HttpStatus> deleteBlogById(@PathVariable String blogId)
    {
        try{
            blogService.deleteBlogById(Long.parseLong(blogId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
