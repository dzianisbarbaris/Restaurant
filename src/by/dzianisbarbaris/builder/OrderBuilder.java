package by.dzianisbarbaris.builder;

import by.dzianisbarbaris.model.Customer;
import by.dzianisbarbaris.model.MenuItem;
import by.dzianisbarbaris.model.Order;
import by.dzianisbarbaris.model.Status;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    private static int orderIdCounter = 0;
    private final int orderId;
    private Customer customer;
    private List<MenuItem> listOfDishes = new ArrayList<>();
    private Status orderStatus;
    private double orderAmount;

    public OrderBuilder() {
        this.orderId = ++orderIdCounter;
    }

    public OrderBuilder customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public OrderBuilder listOfDishes(List<MenuItem> listOfDishes) {
        this.listOfDishes = listOfDishes;
        return this;
    }

    public OrderBuilder orderStatus(Status status) {
        this.orderStatus = status;
        return this;
    }

    public Order build() {
        return new Order(this);
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<MenuItem> getListOfDishes() {
        return listOfDishes;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

}
