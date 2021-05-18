package com.evolv.blogCRUD.services;

import com.evolv.blogCRUD.entities.Blog;

import java.util.List;

public interface BlogService {
    Blog getBlogById(long blogId);
    List<Blog> getAllBlogs();
    void addBlog(Blog blog);
    void deleteBlogById(long blogId);
    void updateBlogById(long blogId,Blog blog) throws Exception;
}
