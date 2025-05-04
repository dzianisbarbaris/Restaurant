package ui;

import model.Customer;
import model.MenuItem;
import model.Order;
import service.MenuService;
import service.OrderService;

import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);
    private OrderService orderService = new OrderService();

    private void mainMenu() {
        System.out.println("==== Система онлайн-заказов ====");
        System.out.println("1. Просмотр меню.");
        System.out.println("2. Создание заказа.");
        System.out.println("3. Добавление/удаление блюд.");
        System.out.println("4. Оплата.");
        System.out.println("5. Просмотр всех заказов.");
        System.out.println("6. Выход из программы.");
    }

    private void addItemsMenu(){
        System.out.println("==== Добавить блюдо/создать заказ ====");
        System.out.println("1. Добавить блюдо.");
        System.out.println("2. Создать заказ.");
    }

    public void start(MenuService menuService){
        while (true) {
            mainMenu();
            System.out.print("Выберите действие: ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.println("Список блюд в меню:");
                    menuService.watchMenuItems();
                    break;
                case 2:
                    while (true){
                        addItemsMenu();
                        System.out.print("Выберите действие: ");
                        int itemAction = scanner.nextInt();
                        switch (itemAction) {
                            case 1:
                                System.out.print("добавьте блюдо в заказ: ");
                                String dishName = scanner.next();
                                orderService.addMenuItemsToOrder(dishName);
                                break;
                            case 2:
                                System.out.print("Введите имя: ");
                                String name = scanner.next();
                                System.out.print("Введите номер телефона: ");
                                String phone = scanner.next();
                                orderService.createOrder(new Customer(name, phone));
                                return;
                        }
                    }
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    orderService.watchAllOrders();
                    break;
                case 6:
                    return;
            }
        }
    }
}
