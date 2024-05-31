package org.codegym.product.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codegym.product.model.Category;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class ProductDTO {
    private Integer id;
    @NotNull(message = "Không được null")
    @NotBlank(message = "Không được là khoảng trắng")
    @NotEmpty(message = "Không được để trống")
    private String name;
    @NotNull(message = "Không được null")
    @Digits(integer = Integer.MAX_VALUE,fraction = 0, message = "Số nguyên")
    private float price;
    @NotNull(message = "Không được null")
    @Digits(integer = Integer.MAX_VALUE,fraction = 0,message = "Số nguyên")
    private Integer quantity;
    private String color;
    @PastOrPresent(message = "Không được sau ngày hiện tại")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufactureDate;
    private String description;
    private Category category;
}
