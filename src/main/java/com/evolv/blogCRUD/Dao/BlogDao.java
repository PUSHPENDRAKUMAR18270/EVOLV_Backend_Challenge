package com.evolv.blogCRUD.Dao;

import com.evolv.blogCRUD.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDao extends JpaRepository<Blog,Long> {

}
