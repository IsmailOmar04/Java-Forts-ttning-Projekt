package Order;

import java.sql.SQLException;
import java.util.ArrayList;


public class OrderService {
    OrderRepo orderRepository;

public OrderService() {
    this.orderRepository = new OrderRepo();

}
    // Metod för att hämta och skriva ut orderhistorik för en kund
public void OrderHistorik(int customerid) throws SQLException {

    // Hämta alla ordrar för en given kund från databasen
    ArrayList<Order> orders = orderRepository.OrderHistorik(customerid);

    // Om ingen orderhistorik hittas, skriv ut ett meddelande
    if (orders.isEmpty()) {
        System.out.println("Ingen orderhistorik hittades för kund med ID: " + customerid);
        return; // Avsluta metoden om inga ordrar finns

    }
    // Om orderhistorik hittas, skriv ut information om varje order
    System.out.println("\n=== Orderhistorik för kund ID: " + customerid + " ===");
    for (Order order : orders) {
        System.out.println("Order ID" +order.getOrderID());
        System.out.println("Kund ID: " + order.getCustomerID());
        System.out.println("----------------------------");

    }
}
    // Metod för att skapa en ny order för en kund
public void SkapaOrder(int customerID) throws SQLException {

    // Skapa ett nytt Order-objekt med kundens ID (order_id sätts till 0, för en ny order)
    Order order = new Order(0, customerID);

    // Anropa metoden från OrderRepo för att spara ordern i databasen
    orderRepository.SkapaOrder(order);
    System.out.println("Ny Order skapad för kund ID " + customerID);

}

}