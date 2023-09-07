package com.example.springbootonlineshop.repository.criteria;


import com.example.springbootonlineshop.dto.PagingDTOResponse;
import com.example.springbootonlineshop.dto.product.ProductDTOFilter;
import com.example.springbootonlineshop.dto.product.ProductDTOResponse;
import com.example.springbootonlineshop.entity.Product;
import com.example.springbootonlineshop.mapper.ProductMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductRepositoryCriteria  {

    EntityManager entityManager;

    public PagingDTOResponse search(ProductDTOFilter productDTOFilter) {
        entityManager.createQuery("SELECT p FROM Product p WHERE 1=1 and p.price between :priceFrom and :priceTo ");
        StringBuilder sql = new StringBuilder("SELECT p FROM Product p WHERE 1=1");
        HashMap<String, Object> params = new HashMap<>();
        //Dynamic Query
        if(productDTOFilter.getCategoryId() != null) {
            sql.append(" and p.category.id = :categoryId ");
            params.put("categoryId", productDTOFilter.getCategoryId());
        }
        if(productDTOFilter.getBrandId() != null){
            sql.append(" and p.brand.id = :brandId ");
            params.put("brandId", productDTOFilter.getBrandId());
        }
        if(productDTOFilter.getColorId() != null){
            sql.append(" and p.color.id = :colorId ");
            params.put("colorId", productDTOFilter.getColorId());
        }

        sql.append(" and p.price between :priceFrom and :priceTo ");
        params.put("priceFrom", productDTOFilter.getPriceFrom());
        params.put("priceTo", productDTOFilter.getPriceTo());

        sql.append(" and p.name like :name ");
        params.put("name", "%" + productDTOFilter.getName() + "%");

        Query countQuery = entityManager.createQuery(sql.toString().replace("SELECT p", "SELECT COUNT(p.id) "));

        if(productDTOFilter.getSortByPrice() != null){
            sql.append(" order by p.price ").append(productDTOFilter.getSortByPrice());
        }

        TypedQuery<Product> productTypedQuery =  entityManager.createQuery(sql.toString(), Product.class);

        //set param
        params.forEach((key, value) -> {
            productTypedQuery.setParameter(key, value);
            countQuery.setParameter(key, value);
        });

        Integer pageIndex = productDTOFilter.getPageIndex();
        Integer pageSize = productDTOFilter.getPageSize();

        //get total product
        long totalProduct = (long) countQuery.getSingleResult();
        long totalPage = totalProduct / pageSize;
        if(totalPage % pageSize != 0){
            totalPage++;
        }

        //Paging
        productTypedQuery.setFirstResult((pageIndex - 1) * pageSize);
        System.out.println(productTypedQuery.setFirstResult((pageIndex - 1) * pageSize));
        productTypedQuery.setMaxResults(pageSize);

        List<Product> productList = productTypedQuery.getResultList();

        List<ProductDTOResponse> productDTOResponse = productList.stream()
                .map(ProductMapper::toProductResponse)
                .collect(Collectors.toList());

        return PagingDTOResponse.builder()
                .totalPage((int) totalPage)
                .totalElements((int) totalProduct)
                .returnData(productDTOResponse)
                .build();
    }
}
