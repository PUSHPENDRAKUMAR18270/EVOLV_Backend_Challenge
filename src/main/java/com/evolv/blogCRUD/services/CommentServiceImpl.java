package com.evolv.blogCRUD.services;

import com.evolv.blogCRUD.Dao.CommentDao;
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

    @Override
    public List<Comment> getAllCommentsOnBlog(long postId) {
        return commentDao.findAll();
    }

    @Override
    public Map<String,String> addCommentOnBlog(Comment comment) {
        Map<String,String> responseMap = new HashMap<>();
        comment.setCreatedAt(new Date());
        try{
            commentDao.save(comment);
            responseMap.put("status","Ok");
            responseMap.put("msg","comment done successfully on blog");
        }
        catch(Exception e)
        {
            responseMap.put("status","Internal Server Error");
        }
        return responseMap;
    }
}
