package com.evolv.blogCRUD.services;

import com.evolv.blogCRUD.entities.Blog;

import java.util.List;
import java.util.NoSuchElementException;

public interface BlogService {
    Blog getBlogById(long blogId);
    List<Blog> getAllBlogs();
    void addBlog(Blog blog);
    void deleteBlogById(long blogId) throws NoSuchElementException;
    void updateBlogById(long blogId,Blog blog) throws NoSuchElementException;
}
