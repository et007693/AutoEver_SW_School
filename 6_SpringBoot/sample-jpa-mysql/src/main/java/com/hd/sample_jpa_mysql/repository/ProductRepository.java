package com.hd.sample_jpa_mysql.repository;

import com.hd.sample_jpa_mysql.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByPriceGreaterThan(int price);
}