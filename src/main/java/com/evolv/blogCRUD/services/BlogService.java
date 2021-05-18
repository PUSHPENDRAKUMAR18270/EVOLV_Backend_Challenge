package com.evolv.blogCRUD.services;

import com.evolv.blogCRUD.entities.Blog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface BlogService {
    Blog getBlogById(long blogId);
    List<Blog> getAllBlogs();
    Map<String,String> addBlog(Blog blog);
    Map<String,String> deleteBlogById(long blogId);
    Map<String,String> updateBlogById(long blogId,Blog blog);
}
