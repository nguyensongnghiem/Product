package org.codegym.product.service.impl;

import org.codegym.product.model.Product;
import org.codegym.product.repository.IProductRepository;
import org.codegym.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findALl() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<Product> searchByNameAndCategory(String name, String category, Pageable pageable) {
        return productRepository.findByNameContainingIgnoreCaseAndCategory_NameContainingIgnoreCase(name, category, pageable);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
