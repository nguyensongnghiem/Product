package org.codegym.product.repository;

import org.codegym.product.model.Category;
import org.codegym.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
//    public List<Product> findProductsByNameContainingIgnoreCaseAndCategory_NameContainingIgnoreCase(String name, String category);
    Page<Product> findProductsByNameContainingIgnoreCaseAndCategory_NameContainingIgnoreCase(String name, String category, Pageable pageable);

}
