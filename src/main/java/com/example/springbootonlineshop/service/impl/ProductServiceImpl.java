package com.example.springbootonlineshop.service.impl;

import com.example.springbootonlineshop.dto.PagingDTOResponse;
import com.example.springbootonlineshop.dto.product.ProductDTOFilter;
import com.example.springbootonlineshop.dto.product.ProductDTOResponse;
import com.example.springbootonlineshop.repository.criteria.ProductRepositoryCriteria;
import com.example.springbootonlineshop.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {

    ProductRepositoryCriteria productRepositoryCriteria;
    @Override
    public PagingDTOResponse searchProduct(ProductDTOFilter productDTOFilter) {
        return productRepositoryCriteria.search(productDTOFilter);
    }
}
