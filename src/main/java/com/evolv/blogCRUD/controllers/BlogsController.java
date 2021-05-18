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
        Map<String,String>responseMap=new HashMap<>();
        try{
            blog.setDateOfPublish(new Date());
            blogService.addBlog(blog);
            responseMap.put("status","OK");
            responseMap.put("msg","successfully added blog");
        }
        catch(Exception e)
        {
            responseMap.put("status","Internal server error");
        }
        return responseMap;
    }

    @PutMapping("/blogs/{blogId}")
    public Map<String,String> updateBlog(@PathVariable String blogId, @RequestBody Blog blog )
    {
        Map<String,String>responseMap=new HashMap<>();
        try{
            blogService.updateBlogById(Long.parseLong(blogId),blog);
            responseMap.put("status","OK");
            responseMap.put("msg","successfully updated blog with id "+blogId);
        }
        catch(NoSuchElementException e)
        {
            responseMap.put("status","Error");
            responseMap.put("msg","Blog with id "+blogId+" does not exists");
        }
        catch(Exception e)
        {
            responseMap.put("status","Internal Server Error");
            responseMap.put("msg",e.getMessage());
        }
        return responseMap;
    }

    @DeleteMapping("/blogs/{blogId}")
    public Map<String,String> deleteBlogById(@PathVariable String blogId)
    {
        Map<String,String> responseMap = new HashMap<>();
        try{
            blogService.deleteBlogById(Long.parseLong(blogId));
            responseMap.put("status","OK");
            responseMap.put("msg","successfully deleted blog with id "+blogId);
        }
        catch(NoSuchElementException e)
        {
            responseMap.put("status","error");
            responseMap.put("msg","Blog with id "+blogId+" does not exists");
        }
        catch(Exception e)
        {
            responseMap.put("status","Internal Server Error");
        }
        return responseMap;
    }
}
