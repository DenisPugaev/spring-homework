package com.geekbrains.model;

public class Product {
    private long id;
    private String name;
    private double cost;

    private String description;

    public Product(long id, String name, double cost, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "[ID" + id + "] " + name + " " + cost + " р";
    }
}
