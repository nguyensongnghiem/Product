package org.codegym.product.validator;

import org.codegym.product.dto.ProductDTO;
import org.codegym.product.repository.IProductRepository;
import org.codegym.product.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class ProductValidator implements Validator {
    @Autowired
    IProductRepository productRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
//        Validate name
        ProductDTO productDTO = (ProductDTO) target;
        if (productDTO.getName().equals("")) {
            errors.rejectValue("name", null,"Không để trống");
        }
        else if (!productDTO.getName().matches("^[A-Za-z0-9\\s]+$")) {
            errors.rejectValue("name", null,"Tên chỉ chưa ký tự chữ");
        }

//        validate Id
        if (productRepository.findById(productDTO.getId()).isPresent()) {
            errors.rejectValue("id", null,"Id đã tồn tại");
        }


    }
}
