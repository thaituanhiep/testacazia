package com.example.testacazia.service;

import com.example.testacazia.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    List<Product> findByCategoryTag(String categoryTag);

    String namesProductByCategoryTag(String categoryTag);
}
