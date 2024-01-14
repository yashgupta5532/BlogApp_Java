package com.codewithyash.blog.services.impl;

import com.codewithyash.blog.entities.Comment;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithyash.blog.entities.Post;
import com.codewithyash.blog.exceptions.ResourceNotFoundException;
import com.codewithyash.blog.payloads.CommentDto;
import com.codewithyash.blog.repositories.CommentRepo;
import com.codewithyash.blog.services.CommentService;
import com.codewithyash.blog.repositories.PostRepo;

@Service
public class CommentServiceImpl implements CommentService {

    // starts from 8:14

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));

        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);

        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment=this.commentRepo.findById(commentId)
        .orElseThrow(()->new ResourceNotFoundException("Comment", "comment id", commentId));
        this.commentRepo.delete(comment);
    }

}
