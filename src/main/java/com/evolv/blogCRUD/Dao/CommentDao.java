package com.evolv.blogCRUD.Dao;

import com.evolv.blogCRUD.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Long> {

}
