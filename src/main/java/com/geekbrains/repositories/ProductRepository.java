package com.geekbrains.repositories;

import com.geekbrains.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    private void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "MyPhoneX", 25000.00, "Самый ультрасовременный мобильный телефон,новго поколения,в отличии от старого поколения увеличин экран на 0.01 дюйма, также добавлена новая мелодия звонка."),
                new Product(2L, "TV Samgnus", 20000.00,"Самая большая диагональ среди конкурентов,сочная картинка и разрешение 64K,позволяет расмотреть все электроны протоны и нейтроны и многое другое."),
                new Product(3L, "TVbox IM", 10000.00, "С данной приставкой вы можете смотреть все межгалактические каналы,узнавайте все свежие новсти с галактики Андромеда."),
                new Product(4L, "StantionPlay III", 13000.00,"Погрузитесь в реалистичный идеальный игровой мир с виртуальной  реальностью. Исправлены все недароботки реального мира!"),
                new Product(5L, "Headphones SuperSound2", 5000.00, "Кристально чистый звук, перепонкораздирающие басы, что еще нужно для меломана")
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList) ;
    }

    public Product getProductById(long id) {
        return productList.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

}
