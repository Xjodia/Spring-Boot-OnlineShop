package com.example.springbootonlineshop.service.impl;

import com.example.springbootonlineshop.dto.category.CategoryDTOCreate;
import com.example.springbootonlineshop.dto.category.CategoryDTOResponse;
import com.example.springbootonlineshop.entity.Category;
import com.example.springbootonlineshop.exception.OnlineShopException;
import com.example.springbootonlineshop.mapper.CategoryMapper;
import com.example.springbootonlineshop.repository.CategoryRepository;
import com.example.springbootonlineshop.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    @Override
    public CategoryDTOResponse createCategory(CategoryDTOCreate categoryDTOCreate) {
        Category category = CategoryMapper.toCategory(categoryDTOCreate);
        categoryRepository.save(category);
        return CategoryMapper.toCategoryDTOResponse(category);
    }

    @Override
    public List<CategoryDTOResponse> getAllCategory() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toCategoryDTOResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTOResponse getCategoryById(int cateId) {
        Optional<Category> optionalCategory = categoryRepository.findById(cateId);
        if(optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            return CategoryMapper.toCategoryDTOResponse(category);
        }else {
            throw OnlineShopException.notFound("Category Not Found");
        }
    }


}
