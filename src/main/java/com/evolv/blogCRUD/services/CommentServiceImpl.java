package com.evolv.blogCRUD.services;

import com.evolv.blogCRUD.Dao.BlogDao;
import com.evolv.blogCRUD.Dao.CommentDao;
import com.evolv.blogCRUD.entities.Blog;
import com.evolv.blogCRUD.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentDao commentDao;

    @Autowired
    BlogDao blogDao;

    @Override
    public List<Comment> getAllCommentsOnBlog(long blogId) {
        if(blogDao.existsById(blogId))
        {
            return blogDao.getOne(blogId).getComments();
        }
        return null;
    }

    @Override
    public Map<String,String> addComment(long blogId,Comment comment) {
        Map<String,String> responseMap = new HashMap<>();
        comment.setCreatedAt(new Date());
        try{
            if(blogDao.existsById(blogId))
            {
                Blog b=blogDao.getOne(blogId);
                b.getComments().add(comment);
                blogDao.save(b);
                responseMap.put("status","Ok");
                responseMap.put("msg","comment done successfully on blog");
            }
            else{
                responseMap.put("status","error");
                responseMap.put("msg","No blog with id "+blogId);
            }
        }
        catch(Exception e)
        {
            responseMap.put("status","Internal Server Error");
        }
        return responseMap;
    }
}
