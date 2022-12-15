package com.geekbrains.servises;

import com.geekbrains.data.Product;
import com.geekbrains.repositories.ProductDao;
import com.geekbrains.repositories.ProductDaoImpl;
import com.geekbrains.repositories.SessionFactoryUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ProductService {

    private final SessionFactoryUtils factory;

    private  ProductDao productDao;


    public ProductService(SessionFactoryUtils factory, ProductDaoImpl productDaoImpl) {
        this.factory = factory;
        factory.init();
        productDao = new ProductDaoImpl(factory);
    }
    public List<Product> getAllProducts() {
        return productDao.findAll();

    }

    public Product getProductById(Long id) {
        return productDao.findById(id);
    }


    public void deleteProduct(Long id) {
        productDao.deleteById(id);
    }

    public void changeCost(Long id, Integer delta) {
        Product product = productDao.findById(id) ;
        Double newCost = product.getCost()+delta;
        product.setCost(newCost);
        productDao.save(product);
    }


    public void addProduct(Long id, String name, Double cost, String description) {
        Product newProduct = new Product(id,name,cost,description);
       productDao.save(newProduct);
    }
}
