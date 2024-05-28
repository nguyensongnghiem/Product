package org.codegym.product;

import org.codegym.product.repository.IProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest
class ProductApplicationTests {
@Autowired
private IProductRepository productRepository;
    @Test
    void contextLoads() {
    }
    @Test
    void search(){


    }

}
