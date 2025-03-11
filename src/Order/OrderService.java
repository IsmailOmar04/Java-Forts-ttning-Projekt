package Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class OrderService {
    OrderRepo orderRepository;

public OrderService() {
    this.orderRepository = new OrderRepo();

}
public void OrderHistorik(int customerid) throws SQLException {
    ArrayList<Order> orders = orderRepository.OrderHistorik(customerid);

    if (orders.isEmpty()) {
        System.out.println("Ingen orderhistorik hittades för kund med ID: " + customerid);
        return;

    }
    System.out.println("\n=== Orderhistorik för kund ID: " + customerid + " ===");
    for (Order order : orders) {
        System.out.println("Order ID" +order.getOrderID());
        System.out.println("Kund ID: " + order.getCustomerID());
        System.out.println("OrderDatum: " + order.getOrderDate());
        System.out.println("----------------------------");

    }
}
public void SkapaOrder(int customerID, Date orderDate) throws SQLException {
Order order = new Order(0, customerID, orderDate);
orderRepository.SkapaOrder(order);
    System.out.println("Ny Order skapad för kund ID" + customerID);

}
    public void uppdateraOrder(int orderId, int customerId, Date orderDate) throws SQLException {
        Order uppdateradOrder = new Order(0, customerId, orderDate);
        orderRepository.uppdateraOrder(uppdateradOrder);
        System.out.println("Order med ID: " + orderId + " har uppdaterats.");
}}
