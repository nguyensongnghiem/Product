package org.codegym.product.service;

import org.codegym.product.model.Category;
import org.codegym.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> findALl();
    public Optional<Product> findById(String id);
    public Page<Product> searchByNameAndCategory(String name, String category, Pageable pageable);
    public void deleteById(String id);

    void save(Product product);
}
