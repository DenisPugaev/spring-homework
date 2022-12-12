package com.geekbrains.servises;

import com.geekbrains.data.Product;
import com.geekbrains.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void changeCost(Long id, Integer delta) {
        Product product = productRepository.getProductById(id);
        product.setCost(product.getCost()+delta);
    }


    public void addProduct(Long id, String name, Double cost, String description) {
        Product newProduct = new Product(id,name,cost,description);
        productRepository.addProduct(newProduct);
    }
}
