package com.evolv.blogCRUD.controllers;

import com.evolv.blogCRUD.entities.Comment;
import com.evolv.blogCRUD.services.BlogService;
import com.evolv.blogCRUD.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/all/{blogId}")
    public List<Comment> getAllCommentsOnPost(@PathVariable String blogId)
    {
        return commentService.getAllCommentsOnBlog(Long.parseLong(blogId));
    }

    @PostMapping("/comments}")
    public void postComment(@RequestBody Comment comment)
    {
        commentService.addCommentOnBlog(comment);
    }
}
