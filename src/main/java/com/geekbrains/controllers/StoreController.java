package com.geekbrains.controllers;

import com.geekbrains.model.Product;
import com.geekbrains.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller

public class StoreController {

    ProductRepository productRepository;

    public StoreController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping("/products")
    public String showAllProduct(Model model) {
        model.addAttribute("AllProducts", productRepository.getAllProducts());
        return "AllProducts";
    }

    @GetMapping("/products/{id}")
    public String productInfoById ( Model model, @PathVariable long id){
        Product product = productRepository.getProductById(id);
        model.addAttribute("product", product );
        return "ProductInfo";
    }


}
