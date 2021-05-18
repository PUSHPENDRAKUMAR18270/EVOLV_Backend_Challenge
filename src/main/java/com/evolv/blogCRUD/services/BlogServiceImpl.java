package com.evolv.blogCRUD.services;

import com.evolv.blogCRUD.Dao.BlogDao;
import com.evolv.blogCRUD.entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Blog getBlogById(long blogId) {
        return blogDao.getOne(blogId);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogDao.findAll();
    }

    @Override
    public void addBlog(Blog blog) {
        blogDao.save(blog);
    }

    @Override
    public void deleteBlogById(long blogId) {
        blogDao.deleteById(blogId);
    }

    @Override
    public void updateBlogById(long blogId,Blog blog) throws Exception {
        if(blogDao.existsById(blogId)) {
            blogDao.save(blog);
        }
        else{
            throw new Exception("No blog with given Id");
        }
    }
}
