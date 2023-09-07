package com.example.springbootonlineshop.service;

import com.example.springbootonlineshop.dto.PagingDTOResponse;
import com.example.springbootonlineshop.dto.product.ProductDTOFilter;
import com.example.springbootonlineshop.dto.product.ProductDTOResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    PagingDTOResponse searchProduct(ProductDTOFilter productDTOFilter);
}
