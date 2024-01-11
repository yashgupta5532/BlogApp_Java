package com.codewithyash.blog.services;

import java.util.List;
import com.codewithyash.blog.payloads.CategoryDto;

public interface CategoryService {
    
    //create
    CategoryDto createCategory(CategoryDto categoryDto);

    //update
    CategoryDto updateCategoryDto(CategoryDto categoryDto,Integer categoryId);

    //delete
    void deleteCategory(Integer categoryId);

    //get single category
    CategoryDto getSingleCategory(Integer categoryId);

    //get all category
    List<CategoryDto> getAllCategory();
}
