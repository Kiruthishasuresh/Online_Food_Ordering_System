package com.wipro.ofs.service;
import java.util.ArrayList;
import com.wipro.ofs.entity.CartItem;
import com.wipro.ofs.entity.MenuItem;
import com.wipro.ofs.entity.Order;
import com.wipro.ofs.entity.User;
import com.wipro.ofs.util.InvalidUserException;
import com.wipro.ofs.util.ItemNotFoundException;
import com.wipro.ofs.util.OrderNotFoundException;
import com.wipro.ofs.util.OrderOperationException;
import com.wipro.ofs.util.OutOfStockException;
public class FoodOrderingService {
	private ArrayList<User> users;
	private ArrayList<MenuItem> menu;
	private ArrayList<Order> orders;
	public FoodOrderService(ArrayList<User> users, ArrayList<MenuItem> menu, ArrayList<Order> orders) {
		this.users=users;
		this.menu=menu;
		this.orders=orders;}
	public boolean validateUser(String userId) throws InvalidUserException {
		for(User user:users) {
			if(user.getUserId().equals(userId)) {
				return true;}}
		throw new InvalidUserException("Invalid userId"+userId);
	}
	public MenuItem findMenuItem(String itemId) throws ItemNotFoundException{
		for(MenuItem menuitem:menu) {
			if(menuitem.getItemid().equals(itemId)) {
				return menuitem;
			}}
		throw new ItemNotFoundException("Invalid menu item"+itemId);
	}
	public void checkStock(String itemId, int quantity) throws OutOfStockException, ItemNotFoundException {
		MenuItem menuitem=findMenuItem(itemId);
		if(quantity<=0) {
			throw new OutOfStockException("InvalidQuantity");
		}
		if(menuitem.getStock()<quantity) {
			throw new OutOfStockException("out of stock"+itemId);
		}}
	public Order placeOrder(String userId, ArrayList<CartItem> cart)throws  InvalidUserException, ItemNotFoundException,
    OutOfStockException, OrderNotFoundException,OrderOperationException {
		if(cart==null||cart.isEmpty()) {
			throw new OrderNotFoundException("Cart is Empty");
		}
		validateUser(userId);
		for(CartItem cartim:cart) {
			checkStock(cartim.getItemId(),cartim.getQuantity());
		}
		 for (CartItem c : cart) {
		        MenuItem item = findMenuItem(c.getItemId());
		        item.setStock(item.getStock() - c.getQuantity());
		    }
		    double total = calculateTotal(cart);
		    Order order = new Order("ORD" + (orders.size() + 1), userId, total);
		    orders.add(order);
		    return order;}
	private double calculateTotal(ArrayList<CartItem> cart) throws ItemNotFoundException {
		double total=0;
		for(CartItem cartim:cart) {
			MenuItem menuitem=findMenuItem(cartim.getItemId());
			total+=menuitem.getPrice()*cartim.getQuantity();
		}
		return total;}
	public void cancelOrder(String orderId) throws OrderNotFoundException {
		Order cancelling=null;
		for(Order order:orders) {
			if(order.getOrderId().equals(orderId)) {
			  cancelling = order;
				break;}}
		if(cancelling==null)
		{
			throw new OrderNotFoundException("Order not found"+orderId);
		}
		orders.remove(cancelling);}
	public void printUserOrders(String userId) {
		for(Order order:orders) {
			if(order.getUserId().equals(userId)) {
				System.out.println("Your order:"+order);}}}}
