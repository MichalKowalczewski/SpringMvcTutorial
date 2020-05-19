package com.example.model;

public class Order {
    private int id;
    private double price;
    private String title;
    private User user;

    public Order() {
    }

    public Order(int id, double price, String title, User user) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.user = user;
    }

    public Order(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
