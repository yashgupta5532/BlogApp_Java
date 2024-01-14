package com.codewithyash.blog.services;

import com.codewithyash.blog.payloads.CommentDto;

public interface CommentService {
    
    CommentDto createComment(CommentDto commentDto,Integer postId);

    void deleteComment(Integer commentId);
}
