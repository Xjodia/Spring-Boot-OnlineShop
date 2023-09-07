package com.example.springbootonlineshop.controller;

import com.example.springbootonlineshop.dto.category.CategoryDTOCreate;
import com.example.springbootonlineshop.dto.category.CategoryDTOResponse;
import com.example.springbootonlineshop.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public List<CategoryDTOResponse> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryDTOResponse getCategoryById(@PathVariable(name = "id") int cateId){
        return categoryService.getCategoryById(cateId);
    }
}
