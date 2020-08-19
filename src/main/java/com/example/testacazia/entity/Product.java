package com.example.testacazia.entity;

import javax.persistence.*;

@Table(name = "product")
@Entity
public class Product {
    @Id
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_tag")
    private Category category;

    public Product() {
    }

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
