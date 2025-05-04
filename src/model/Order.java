package model;

import builder.OrderBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order{
    private Integer orderId;
    private Customer customer;
    private List<MenuItem> listOfDishes = new ArrayList<>();
    private Status orderStatus;
    private double orderAmount;

    public Order(OrderBuilder orderBuilder) {
        this.orderId = orderBuilder.getOrderId();
        this.customer = orderBuilder.getCustomer();
        this.listOfDishes = orderBuilder.getListOfDishes();
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

    public double getOrderAmount() {
        return orderAmount;
    }

    @Override
    public String toString() {
        return "Номер заказа " + orderId + " {customer=" + customer +
                ", listOfDishes=" + listOfDishes +
                ", orderStatus=" + orderStatus +
                ", orderAmount=" + orderAmount +
                "}\n";
    }
}
