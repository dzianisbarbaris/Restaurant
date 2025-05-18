package by.dzianisbarbaris.service;

import by.dzianisbarbaris.exception.MenuItemNotFoundException;
import by.dzianisbarbaris.factory.MenuItemFactory;
import by.dzianisbarbaris.model.Category;
import by.dzianisbarbaris.model.MenuItem;

import java.util.*;
import java.util.stream.IntStream;

public class MenuService {
    private final Set<MenuItem> menuItems = new LinkedHashSet<>();

    public void createTodayMenu() {
        Arrays.stream(Category.values()).forEach(category -> IntStream.range(0,3)
                .forEach(i -> menuItems.add(MenuItemFactory.next(category))));
    }

    public void printMenuItems() {
        int j = 1;
        for (MenuItem menuItem : menuItems) {
            System.out.println("Блюдо № " + j + ": " + menuItem);
            j++;
        }
    }

    public void addItem(Category category) {
        menuItems.add(MenuItemFactory.next(category));
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

