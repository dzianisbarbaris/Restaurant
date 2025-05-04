package service;


import builder.OrderBuilder;
import exception.MenuItemNotFoundException;
import model.Customer;
import model.MenuItem;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    private final List<MenuItem> listOfOrderedDishes = new ArrayList<>();
    private MenuService menuService = new MenuService();

    public Order createOrder(Customer customer){
        Order order = new OrderBuilder().customer(customer).listOfDishes(listOfOrderedDishes).build();
        orders.add(order);
        System.out.println("Ваш заказ: " + order);
        return order;
    }

    public void addMenuItemsToOrder(String itemName){
        try {
            listOfOrderedDishes.add(menuService.findItem(itemName));
        } catch (MenuItemNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeMenuItemsFromOrder(){

    }

    public void watchAllOrders(){
        System.out.println(orders);
    }
}
