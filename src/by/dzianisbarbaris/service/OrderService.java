package by.dzianisbarbaris.service;
import by.dzianisbarbaris.builder.OrderBuilder;
import by.dzianisbarbaris.model.Customer;
import by.dzianisbarbaris.model.MenuItem;
import by.dzianisbarbaris.model.Order;
import by.dzianisbarbaris.model.Status;

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
