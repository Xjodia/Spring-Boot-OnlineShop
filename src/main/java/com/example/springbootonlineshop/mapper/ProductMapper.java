package com.example.springbootonlineshop.mapper;

import com.example.springbootonlineshop.dto.product.ProductDTOResponse;
import com.example.springbootonlineshop.entity.Product;

public class ProductMapper {
    public static ProductDTOResponse toProductResponse(Product product) {
        return ProductDTOResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .summary(product.getSummary())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .availability(product.getAvailability())
                .specification(product.getSpecification())
                .category(product.getCategory())
                .build();
    }
}
