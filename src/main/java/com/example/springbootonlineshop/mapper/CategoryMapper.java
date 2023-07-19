package com.example.springbootonlineshop.mapper;

import com.example.springbootonlineshop.dto.category.CategoryDTOCreate;
import com.example.springbootonlineshop.dto.category.CategoryDTOResponse;
import com.example.springbootonlineshop.entity.Category;

public class CategoryMapper {
    public static Category toCategory(CategoryDTOCreate categoryDTOCreate){
        return Category.builder()
                .categoryName(categoryDTOCreate.getCategoryName())
                .build();
    }

    public static CategoryDTOResponse categoryDTOResponse(Category category){
        return CategoryDTOResponse.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .build();
    }
}
