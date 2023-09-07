package com.example.springbootonlineshop.controller;

import com.example.springbootonlineshop.dto.PagingDTOResponse;
import com.example.springbootonlineshop.dto.product.ProductDTOFilter;
import com.example.springbootonlineshop.dto.product.ProductDTOResponse;
import com.example.springbootonlineshop.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.springbootonlineshop.utils.Constant.API_VERSION;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(API_VERSION + "/products")
public class ProductController {

    ProductService productService;

    @GetMapping("/search")
    public PagingDTOResponse searchProduct(@ModelAttribute ProductDTOFilter productDTOFilter){
        return productService.searchProduct(productDTOFilter);
    }
}
