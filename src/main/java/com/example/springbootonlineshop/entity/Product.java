package com.example.springbootonlineshop.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String price;
    @Column(nullable = false)
    int quantity;
    @Column(nullable = false, columnDefinition = "TEXT")
    String summary;
    @Column(nullable = false, columnDefinition = "TEXT")
    String description;
    String imageUrl;
    String availability;
    String specification;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    Brand brand;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "color_id")
    Color color;
}
