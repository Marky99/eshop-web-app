package com.marky99.ecommerce.dao;

import com.marky99.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.domain.Pageable;

@CrossOrigin(origins="http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
    @CrossOrigin
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable); //quety method

}
