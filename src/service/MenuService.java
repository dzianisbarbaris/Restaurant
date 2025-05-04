package service;

import exception.MenuItemNotFoundException;
import factory.MenuItemFactory;
import model.Category;
import model.MenuItem;

import java.util.*;
import java.util.stream.Collectors;

public class MenuService {
    private final Set<MenuItem> menuItems = new HashSet<>();
    private final MenuItemFactory itemFactory = new MenuItemFactory();

    public void createMenuForDay(){
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

    public void watchMenuItems(){
        System.out.println(menuItems);
    }

    public void addItem(Category category) {
        menuItems.add(itemFactory.next(category));
    }

    public void removeItem(MenuItem item) {
        menuItems.remove(item);
    }

    public MenuItem findItem(String menuItemName) throws MenuItemNotFoundException {
        Optional<MenuItem> optionalItem = menuItems.stream().filter(menuItem -> menuItem.getItemName().equals(menuItemName)).findFirst();
        if (optionalItem.isEmpty()){
            throw new MenuItemNotFoundException("Блюдо " + menuItemName + " не найдено");
        }
        return optionalItem.get();
    }

}
