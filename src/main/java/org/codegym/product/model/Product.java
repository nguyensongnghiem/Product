package org.codegym.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
