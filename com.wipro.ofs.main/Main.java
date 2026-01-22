package com.wipro.ofs.main;
import java.util.ArrayList;
import com.wipro.ofs.entity.*;
import com.wipro.ofs.service.FoodOrderService;
import com.wipro.ofs.util.*;
public class Main {
    public static void main(String args[]) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("U0001", "Rajesh", "7879090035"));
        users.add(new User("U0002", "Lalitha", "9876543786"));
        users.add(new User("U0003", "Vimal", "8654543245"));
        users.add(new User("U0004", "Kirthi", "6876539835"));
        ArrayList<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("M0001", "SandWich", 120.0, 20));
        menu.add(new MenuItem("M0002", "Nuggets", 110.5, 15));
        menu.add(new MenuItem("M0003", "FruitSalad", 158.5, 55));
        menu.add(new MenuItem("M0004", "Boba Tea", 150.5, 65));
        menu.add(new MenuItem("M0005", "Sushi",100.5, 44));
        menu.add(new MenuItem("M0006", "ColdCoffee", 120.5, 14)); 
        menu.add(new MenuItem("M0007", "VegSalad", 100.5, 20));
        menu.add(new MenuItem("M0008", "IceBubbleTea", 150.5, 50));
        ArrayList<Order> orders = new ArrayList<>();
        FoodOrderService service = new FoodOrderService(users, menu, orders);
        try {
            ArrayList<CartItem> cart = new ArrayList<>();
            cart.add(new CartItem("M0001", 2));
            cart.add(new CartItem("M0002", 1));
            Order o1 = service.placeOrder("U0001", cart);
            System.out.println("Order Placed Successfully: " + o1.getOrderId());
            System.out.println("\nUser Orders:");
            service.printUserOrders("U0001");
            System.out.println("\nCancelling Order...");
            service.cancelOrder(o1.getOrderId());
            System.out.println("Order Cancelled!");
            System.out.println("\nUser Orders After Cancellation:");
            service.printUserOrders("U0001");
        } catch (InvalidUserException | ItemNotFoundException | OutOfStockException| OrderNotFoundException | OrderOperationException ex) {
            System.out.println("Error: " + ex);
        } catch (Exception ex) {
            System.out.println("Unexpected Error: " + ex);  } }}

