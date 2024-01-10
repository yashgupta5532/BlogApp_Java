package com.codewithyash.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithyash.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

    
}
