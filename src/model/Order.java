package model;

import java.util.List;
import java.util.Objects;

public class Order {
    private final int orderID;
    private final Customer customer;
    private final List<MenuItem> listOfDishes;
    private final Status orderStatus;
    private final double orderAmount;

    public Order(int orderID, Customer customer, List<MenuItem> listOfDishes, Status orderStatus, double orderAmount) {
        this.orderID = orderID;
        this.customer = customer;
        this.listOfDishes = listOfDishes;
        this.orderStatus = orderStatus;
        this.orderAmount = orderAmount;
    }

    public int getOrderID() {
        return orderID;
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
    public boolean equals(Object o) {
        if (!(o instanceof Order order)) return false;
        return orderID == order.orderID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orderID);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customer=" + customer +
                ", listOfDishes=" + listOfDishes +
                ", orderStatus=" + orderStatus +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
