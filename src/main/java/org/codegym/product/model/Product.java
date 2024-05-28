package org.codegym.product.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    private Integer id;
    private String name;
    private float price;
    private int quantity;
    private String color;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;



}
