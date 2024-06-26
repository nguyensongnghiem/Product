package org.codegym.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private float price;
    private int quantity;
    private String color;
    private LocalDate manufactureDate;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;

}
