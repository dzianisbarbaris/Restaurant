package ui;

import exception.MenuItemNotFoundException;
import exception.OrderAlreadyPaidException;
import model.*;
import service.MenuService;
import service.OrderService;
import service.PaymentService;

import java.util.*;

public class ConsoleMenu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final OrderService orderService = new OrderService();
    private static final MenuService menuService = new MenuService();
    private static final PaymentService paymentService = new PaymentService();
    private static Order order;
    private static Map<Order, Payment> listOfOrders = new HashMap<>();

    public void start() {
        menuService.createTodayMenu();
        while (true) {
            mainMenu();
            System.out.print("Выберите действие: ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.println("Список блюд в меню:");
                    menuService.printMenuItems();
                    break;
                case 2:
                    order = createOrderConsoleMenu();
                    break;
                case 3:
                    addOrRemoveItems(order);
                    break;
                case 4:
                    payOrder(order);
                    break;
                case 5:
                    System.out.println(listOfOrders);
                    break;
                case 6:
                    return;
            }
        }
    }

    private void mainMenu() {
        System.out.println("==== Система онлайн-заказов ====");
        System.out.println("1. Просмотр меню.");
        System.out.println("2. Создание клиента.");
        System.out.println("3. Добавление/удаление блюд.");
        System.out.println("4. Оплата.");
        System.out.println("5. Просмотр всех заказов.");
        System.out.println("6. Выход из программы.");
    }

    private void addOrRemoveItemsMenu() {
        System.out.println("==== Добавить/удалить блюдо ====");
        System.out.println("1. Добавить блюдо в заказ.");
        System.out.println("2. Удалить блюдо из заказа.");
        System.out.println("3. Сформировать заказ и вернуться в главное меню.");
    }

    public Order createOrderConsoleMenu() {
        System.out.print("Введите имя: ");
        String name = scanner.next();
        System.out.print("Введите номер телефона: ");
        String phone = scanner.next();
        Customer customer = new Customer(name, phone);
        return orderService.createOrder(customer);
    }

    public void addOrRemoveItems(Order order) {
        while (true) {
            addOrRemoveItemsMenu();
            System.out.print("Выберите действие: ");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    MenuItem addedItem;
                    System.out.println("Введите название блюда:");
                    String addedMenuItemName = scanner.next();
                    try {
                        addedItem = menuService.findItem(addedMenuItemName);
                    } catch (MenuItemNotFoundException e) {
                        System.out.println(e);
                        break;
                    }
                    orderService.addMenuItemToOrder(order, addedItem);
                    break;

                case 2:
                    MenuItem removedItem;
                    System.out.println("Введите название блюда:");
                    String reMovedMenuItemName = scanner.next();
                    try {
                        removedItem = menuService.findItem(reMovedMenuItemName);
                    } catch (MenuItemNotFoundException e) {
                        System.out.println(e);
                        break;
                    }
                    orderService.removeMenuItemsFromOrder(order, removedItem);
                    break;

                case 3:
                    orderService.recalculateOrderAmount(order);
                    System.out.println("Ваш " + order);
                    return;
            }
        }
    }

    public void payOrder(Order order) {
        System.out.println("Введите способ оплаты:");
        PaymentMethod paymentMethod = PaymentMethod.valueOf(scanner.next().toUpperCase());
        try {
            paymentService.checkOrderStatus(order);
        } catch (OrderAlreadyPaidException e) {
            System.out.println(e);
        }
        Payment payment = paymentService.createPayment(order, paymentMethod);
        listOfOrders.put(order, payment);
    }

}
