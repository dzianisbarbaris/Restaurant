package by.dzianisbarbaris.model;

import java.util.Objects;

public class MenuItem {
    private final int itemId;
    private final String itemName;
    private final double itemPrice;
    private final Category category;
    private final boolean availability;

    public MenuItem(int itemId, String itemName, double itemPrice, Category category, boolean availability) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.category = category;
        this.availability = availability;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isAvailability() {
        return availability;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MenuItem menuItem)) return false;
        return Objects.equals(itemName, menuItem.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(itemName);
    }

    @Override
    public String toString() {
        return itemName + ": Стоимость " + itemPrice + " руб.";
    }
}
