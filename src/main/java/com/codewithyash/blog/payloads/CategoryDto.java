package com.codewithyash.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    //tomorrow start with 4:55 with validation
    
    private Integer categoryId;

    @NotBlank
    @Size(min=4 , message="Title must be minimum of 4 chars")
    private String categoryTitle;

    @NotBlank
    @Size(min=10,message = "Description must be minimum of 10 chars")
    private String categoryDescription;
}
