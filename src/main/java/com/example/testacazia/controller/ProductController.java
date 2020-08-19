package com.example.testacazia.controller;

import com.example.testacazia.entity.Product;
import com.example.testacazia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping(value = "/catetag/{catetag}")
    public ResponseEntity<String> getNameProductByCategory(@PathVariable String catetag){
        List<Product> list = productService.findByCategoryTag(catetag);
        if(list.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>(productService.namesProductByCategoryTag(catetag), HttpStatus.OK);
    }
}
