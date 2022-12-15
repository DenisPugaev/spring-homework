package com.geekbrains.repositories;

import com.geekbrains.data.Product;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    Product findByName(String name);

    List<Product> findAll();

    void updateCostById(Product product);

    void save(Product product);
    void deleteById(Long id);
}
