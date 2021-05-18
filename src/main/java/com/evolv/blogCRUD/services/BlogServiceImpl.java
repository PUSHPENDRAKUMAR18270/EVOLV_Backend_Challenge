package com.evolv.blogCRUD.services;

import com.evolv.blogCRUD.Dao.BlogDao;
import com.evolv.blogCRUD.entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public void deleteBlogById(long blogId) throws NoSuchElementException{
        if(blogDao.existsById(blogId)) {
            blogDao.deleteById(blogId);
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public void updateBlogById(long blogId,Blog blog) throws NoSuchElementException {
        if(blogDao.existsById(blogId)) {
            Blog b = blogDao.getOne(blogId);
            b.setLastUpdated(new Date());
            if(blog.getContent()!=null)
            {
                b.setContent(blog.getContent());
            }

            if(blog.getTitle()!=null)
            {
                b.setTitle(blog.getTitle());
            }
            if(blog.getSummary()!=null)
            {
                b.setSummary(blog.getSummary());
            }
            if(blog.getSlug()!=null)
            {
                b.setSlug(blog.getSlug());
            }
            blogDao.save(b);
        }
        else{
            throw new NoSuchElementException();
        }
    }
}
