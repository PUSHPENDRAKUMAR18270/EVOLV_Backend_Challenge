package com.evolv.blogCRUD.services;

import com.evolv.blogCRUD.entities.Comment;

import java.util.List;
import java.util.Map;


public interface CommentService {
    List<Comment> getAllCommentsOnBlog(long blogId);
    Map<String,String> addComment(long blogId,Comment comment);
}
