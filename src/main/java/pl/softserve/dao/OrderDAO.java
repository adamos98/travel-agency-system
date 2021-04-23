package pl.softserve.dao;

import pl.softserve.Models.Order;

import java.util.List;

public interface OrderDAO {

    public void addOrder(Order o);
    public void updateOrder(Order o);
    public List<Order> listOrder();
    public Order getOrderById(int id);
    public void removeOrder(int id);

}
