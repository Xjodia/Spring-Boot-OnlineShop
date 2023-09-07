package com.example.springbootonlineshop.service;

import com.example.springbootonlineshop.dto.category.CategoryDTOCreate;
import com.example.springbootonlineshop.dto.category.CategoryDTOResponse;

import java.util.List;

public interface CategoryService {
    CategoryDTOResponse createCategory(CategoryDTOCreate categoryDTOCreate);
    List<CategoryDTOResponse> getAllCategory();

    CategoryDTOResponse getCategoryById(int cateId);
}
