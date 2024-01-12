package com.codewithyash.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithyash.blog.entities.Category;
import com.codewithyash.blog.entities.Post;
import com.codewithyash.blog.entities.User;

public interface PostRepo extends JpaRepository<Post,Integer>{
    
    List<Post>findByUser(User user);
    List<Post>findByCategory(Category category);

    List<Post>findByTitleContaining(String title);
}
