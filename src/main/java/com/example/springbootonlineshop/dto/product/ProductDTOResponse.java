package com.example.springbootonlineshop.dto.product;

import com.example.springbootonlineshop.entity.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTOResponse {
    int id;
    String name;
    String price;
    int quantity;
    String summary;
    String description;
    String imageUrl;
    String availability;
    String specification;
    Category category;
}
