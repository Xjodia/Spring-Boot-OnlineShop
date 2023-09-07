package com.example.springbootonlineshop.dto.product;

import com.example.springbootonlineshop.utils.Constant;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTOFilter {
    Integer pageIndex = 1;
    Integer pageSize = Constant.DEFAULT_PAGE_SIZE;
    Integer categoryId;
    Integer brandId;
    Integer colorId;
    Double priceFrom = 0d;
    Double priceTo = Double.MAX_VALUE;
    String sortByPrice;
    String name = "";

}
