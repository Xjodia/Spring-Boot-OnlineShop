package com.example.springbootonlineshop.service.impl;

import com.example.springbootonlineshop.dto.category.CategoryDTOCreate;
import com.example.springbootonlineshop.dto.category.CategoryDTOResponse;
import com.example.springbootonlineshop.entity.Category;
import com.example.springbootonlineshop.mapper.CategoryMapper;
import com.example.springbootonlineshop.repository.CategoryRepository;
import com.example.springbootonlineshop.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryImpl implements CategoryService {

    CategoryRepository categoryRepository;
    @Override
    public CategoryDTOResponse createCategory(CategoryDTOCreate categoryDTOCreate) {
        Category category = CategoryMapper.toCategory(categoryDTOCreate);
        categoryRepository.save(category);
        return CategoryMapper.categoryDTOResponse(category);
    }
}
