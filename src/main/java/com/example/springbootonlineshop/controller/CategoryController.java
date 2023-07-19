package com.example.springbootonlineshop.controller;

import com.example.springbootonlineshop.dto.category.CategoryDTOCreate;
import com.example.springbootonlineshop.dto.category.CategoryDTOResponse;
import com.example.springbootonlineshop.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.springbootonlineshop.utils.Constant.API_VERSION;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(API_VERSION + "/category")
public class CategoryController {

    CategoryService categoryService;
    @PostMapping()
    public CategoryDTOResponse createCategory(@RequestBody CategoryDTOCreate categoryDTOCreate){
        return categoryService.createCategory(categoryDTOCreate);
    }
}
