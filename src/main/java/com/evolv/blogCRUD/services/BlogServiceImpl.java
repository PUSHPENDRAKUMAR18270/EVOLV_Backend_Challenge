package com.evolv.blogCRUD.services;

import com.evolv.blogCRUD.Dao.BlogDao;
import com.evolv.blogCRUD.entities.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Blog getBlogById(long blogId) {
        if(blogDao.existsById(blogId))
        {
            return blogDao.findById(blogId).get();
        }
        return null;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogDao.findAll();
    }

    @Override
    public Map<String,String> addBlog(Blog blog) {
        Map<String,String> responseMap = new HashMap<>();
        blog.setDateOfPublish(new Date());
        try{
            blogDao.save(blog);
            responseMap.put("status","OK");
            responseMap.put("msg","successfully added blog");
        }
        catch(Exception e)
        {
            responseMap.put("status","Internal server error");
        }
        return responseMap;
    }

    @Override
    public Map<String,String> deleteBlogById(long blogId){
        Map<String,String> responseMap=new HashMap<>();
        try{

            if(blogDao.existsById(blogId)) {
                blogDao.deleteById(blogId);
                responseMap.put("status","OK");
                responseMap.put("msg","successfully deleted blog with id "+blogId);
            }
            else{
                responseMap.put("status","error");
                responseMap.put("msg","Blog with id "+blogId+" does not exists");
            }
        }
        catch(Exception e)
        {
            responseMap.put("status","Internal Server Error");
        }
        return responseMap;
    }

    @Override
    public Map<String,String> updateBlogById(long blogId,Blog blog) throws NoSuchElementException {
        Map<String,String>responseMap=new HashMap<>();
        try{
            if(blogDao.existsById(blogId)) {
                Blog b = blogDao.findById(blogId).get();
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

                blogDao.save(b);
                responseMap.put("status","OK");
                responseMap.put("msg","successfully updated blog with id "+blogId);
            }
            else{
                responseMap.put("status","Error");
                responseMap.put("msg","Blog with id "+blogId+" does not exists");
            }
        }
        catch(Exception e)
        {
            responseMap.put("status","Internal Server Error");
        }
        return responseMap;
    }
}
