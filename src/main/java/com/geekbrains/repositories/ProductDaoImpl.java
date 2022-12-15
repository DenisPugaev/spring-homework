package com.geekbrains.repositories;

import com.geekbrains.data.Product;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class ProductDaoImpl implements ProductDao {

    private final SessionFactoryUtils factory;

    public ProductDaoImpl(SessionFactoryUtils factory) {
        this.factory = factory;
    }


    @Override
    public Product findById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public Product findByName(String name) {

        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Product product = session.createQuery("select  p from Product p where p.name=:name", Product.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Product> listProduct = session.createQuery("select p from Product p", Product.class).getResultList();
            session.getTransaction().commit();
            return listProduct;
        }
    }


    @Override
    public void save(Product product) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
//                session.saveOrUpdate(product);
            session.merge(product);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            session.createQuery("delete from Product p where p.id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
            log.info("Удален продукт с ID: " + id);

        }
    }
}

