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
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class ProductDTO  {
    @Pattern(regexp = "^SP[0-9]{3}$",message = "Sai format SPxxx")
    private String id;
//    @NotNull(message = "Không được null")
//    @NotBlank(message = "Không được là khoảng trắng")
//    @NotEmpty(message = "Không được để trống")
    private String name;
    @NotNull(message = "Không được null")
    @DecimalMin(value = "0.0",message = "Lớn hơn 0")
    @DecimalMax(value = "100",message = "Nhỏ hơn 100")
    private float price;
    @NotNull(message = "Không được null")
    @Min(value = 1,message = "Lớn hơn hoặc bằng 1")
    @Max(value = 1000, message = "Nhỏ hơn 1000")
    private Integer quantity;
    private String color;
    @NotNull(message = "Không được null")
    @PastOrPresent(message = "Không được sau ngày hiện tại")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufactureDate;
    private String description;
    private Category category;



}
