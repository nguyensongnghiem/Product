package org.codegym.product.repository;

import org.codegym.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,String> {
//    public List<Product> findProductsByNameContainingIgnoreCaseAndCategory_NameContainingIgnoreCase(String name, String category);
    Page<Product> findByNameContainingIgnoreCaseAndCategory_NameContainingIgnoreCase(String name, String category, Pageable pageable);

}
