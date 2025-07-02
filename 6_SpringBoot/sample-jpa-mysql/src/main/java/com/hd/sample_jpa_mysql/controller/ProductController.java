package com.hd.sample_jpa_mysql.controller;

import com.hd.sample_jpa_mysql.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public com.hd.sample_jpa_mysql.model.Product create(@RequestBody com.hd.sample_jpa_mysql.model.Product product) {
        return productService.save(product);
    }

    @GetMapping
    public List<com.hd.sample_jpa_mysql.model.Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.hd.sample_jpa_mysql.model.Product> getOne(@PathVariable String id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public com.hd.sample_jpa_mysql.model.Product update(@PathVariable String id, @RequestBody com.hd.sample_jpa_mysql.model.Product product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }
}
