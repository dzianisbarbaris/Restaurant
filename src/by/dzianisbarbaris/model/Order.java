package by.dzianisbarbaris.model;

import by.dzianisbarbaris.builder.OrderBuilder;

import java.util.List;

public class Order{
    private final Integer orderId;
    private final Customer customer;
    private final List<MenuItem> listOfDishes;
    private Status orderStatus;
    private double orderAmount;

    public Order(OrderBuilder orderBuilder) {
        this.orderId = orderBuilder.getOrderId();
        this.customer = orderBuilder.getCustomer();
        this.listOfDishes = orderBuilder.getListOfDishes();
        this.orderStatus = orderBuilder.getOrderStatus();
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

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "Номер заказа - " + orderId + ", на имя - " + customer.getCustomerName() +
                ", список блюд" + listOfDishes +
                ", общая сумма заказа - " + orderAmount;
    }
}
