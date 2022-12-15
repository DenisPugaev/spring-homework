package com.geekbrains.repositories;

import com.geekbrains.data.Product;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainRepository {

    public static void main(String[] args) {
        SessionFactoryUtils factory = new SessionFactoryUtils();
        factory.init();
        try {

            ProductDao productDao = new ProductDaoImpl(factory);
          Product product=  productDao.findById(2L);
            log.info(product.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.shutdown();
        }
    }

}
