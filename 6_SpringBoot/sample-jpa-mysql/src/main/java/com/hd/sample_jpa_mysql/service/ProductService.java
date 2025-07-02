package com.hd.sample_jpa_mysql.service;

import com.hd.sample_jpa_mysql.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public com.hd.sample_jpa_mysql.model.Product save(com.hd.sample_jpa_mysql.model.Product product) {
        return productRepository.save(product);
    }

    public List<com.hd.sample_jpa_mysql.model.Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<com.hd.sample_jpa_mysql.model.Product> findById(String id) {
        return productRepository.findById(id);
    }

    public com.hd.sample_jpa_mysql.model.Product update(String id, com.hd.sample_jpa_mysql.model.Product product) {
        product.setId(id);
        return productRepository.save(product);
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }
}