package service;

import exception.MenuItemNotFoundException;
import factory.MenuItemFactory;
import model.Category;
import model.MenuItem;

import java.util.*;
import java.util.stream.Collectors;

public class MenuService {
    private static final Set<MenuItem> menuItems = new LinkedHashSet<>();
    private static final MenuItemFactory itemFactory = new MenuItemFactory();

    public void createTodayMenu() {
        addItem(Category.MAIN_DISH);
        addItem(Category.MAIN_DISH);
        addItem(Category.MAIN_DISH);
        addItem(Category.SNACK);
        addItem(Category.SNACK);
        addItem(Category.SNACK);
        addItem(Category.DRINK);
        addItem(Category.DRINK);
        addItem(Category.DRINK);
        addItem(Category.DESSERT);
        addItem(Category.DESSERT);
        addItem(Category.DESSERT);
    }

    public void printMenuItems() {
        int j = 1;
        for (MenuItem menuItem : menuItems) {
            System.out.println("Блюдо № " + j + ": " + menuItem);
            j++;
        }
    }

    public void addItem(Category category) {
        menuItems.add(itemFactory.next(category));
    }

    public void removeItem(MenuItem item) {
        menuItems.remove(item);
    }

    public MenuItem findItem(String itemName) throws MenuItemNotFoundException {
        Optional<MenuItem> orderedMenuItem = menuItems.stream().filter(item -> item.getItemName().equalsIgnoreCase(itemName)).findFirst();
        if (orderedMenuItem.isEmpty()) {
            throw new MenuItemNotFoundException("Блюдо " + itemName + " не найдено в меню!");
        }
        return orderedMenuItem.get();
    }
}

