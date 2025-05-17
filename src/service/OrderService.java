package service;


import builder.OrderBuilder;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderService {

    public Order createOrder(Customer customer) {
        return new OrderBuilder().customer(customer).orderStatus(Status.CREATED).build();
    }

    public void addMenuItemToOrder(Order order, MenuItem menuItem) {
        order.getListOfDishes().add(menuItem);
    }

    public void removeMenuItemsFromOrder(Order order, MenuItem menuItem) {
        order.getListOfDishes().remove(menuItem);
    }

    public void recalculateOrderAmount(Order order) {
        double orderAmount = order.getListOfDishes().stream().mapToDouble(MenuItem::getItemPrice).sum();
        order.setOrderAmount(orderAmount);
    }

}
