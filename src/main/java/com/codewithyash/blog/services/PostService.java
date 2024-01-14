package com.codewithyash.blog.services;

import java.util.List;

import com.codewithyash.blog.payloads.PostDto;
import com.codewithyash.blog.payloads.PostResponse;

public interface PostService {
    
    //create post
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

    //update post
    PostDto updatePost(PostDto postDto,Integer postId);

    //delete post
    void deletePost(Integer postId);

    //get all posts
    PostResponse getAllPosts(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);

    //get post by id
    PostDto getPostById(Integer postId);

    //get all posts of user
    List<PostDto>getPostsByUser(Integer userId);

    //get all posts of a categoryId
    List<PostDto>getPostsByCategory(Integer categoryId);

    //search posts
    List<PostDto>searchPosts(String keyword);
}
