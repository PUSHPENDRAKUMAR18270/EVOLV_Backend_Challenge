package com.evolv.blogCRUD.controllers;

import com.evolv.blogCRUD.entities.Comment;
import com.evolv.blogCRUD.services.BlogService;
import com.evolv.blogCRUD.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/blogs/{blogId}/comment")
    public List<Comment> getAllCommentsOnPost(@PathVariable String blogId)
    {
        return commentService.getAllCommentsOnBlog(Long.parseLong(blogId));
    }

    @PostMapping("/blogs/{blogId}/comment")
    public Map<String,String> addComment(@PathVariable String blogId,@RequestBody Comment comment)
    {
        return commentService.addComment(Long.parseLong(blogId),comment);
    }
}
