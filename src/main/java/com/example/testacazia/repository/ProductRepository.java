package com.example.testacazia.repository;

import com.example.testacazia.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT p" +
            " FROM Product p " +
            "WHERE p.category.tag like %?1 ")
    public List<Product> findByCategoryTag(String categoryTag);
}
