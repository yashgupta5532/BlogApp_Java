package com.codewithyash.blog.entities;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import com.codewithyash.blog.payloads.CategoryDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="post")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name="post_title",length=100,nullable=false)
    private String title;

    @Column(name="post_content",length=100,nullable = false)
    private String content;

    private String imageName;

    private Date addedDate;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne
    private User user;
}
