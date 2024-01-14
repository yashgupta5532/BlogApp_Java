package com.codewithyash.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithyash.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer>{
    
}
