import builder.OrderBuilder;
import model.Category;
import model.Customer;
import model.Order;
import service.MenuService;
import service.OrderService;
import ui.ConsoleMenu;

public class RestaurantOrderingSystemMain {
    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu();
        MenuService menuService = new MenuService();
        menuService.createMenuForDay();

        menu.start(menuService);
    }
}
