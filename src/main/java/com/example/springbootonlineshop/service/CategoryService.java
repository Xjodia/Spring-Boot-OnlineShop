package com.example.springbootonlineshop.service;

import com.example.springbootonlineshop.dto.category.CategoryDTOCreate;
import com.example.springbootonlineshop.dto.category.CategoryDTOResponse;
import org.springframework.stereotype.Service;

public interface CategoryService {
    CategoryDTOResponse createCategory(CategoryDTOCreate categoryDTOCreate);
}
