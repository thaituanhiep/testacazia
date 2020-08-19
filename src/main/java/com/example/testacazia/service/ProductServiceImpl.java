package com.example.testacazia.service;

import com.example.testacazia.entity.Product;
import com.example.testacazia.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByCategoryTag(String categoryTag) {
        return productRepository.findByCategoryTag(categoryTag);
    }

    @Override
    public String namesProductByCategoryTag(String categoryTag) {
        List<Product> list = productRepository.findByCategoryTag(categoryTag);

        list.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));

        String str = "";
        for (Product product:
                list) {
            str = str.concat(product.getName() + "\n");
        }
        str = str.trim();
        System.out.println(str);

        return str;
    }
}
