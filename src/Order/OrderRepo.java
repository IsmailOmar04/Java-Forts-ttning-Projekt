package Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
public class OrderRepo  {

    // Metod för att skapa en ny order i databasen
    public void SkapaOrder(Order order) throws SQLException {

        // SQL-fråga för att lägga till en ny order
        String sql = "INSERT INTO orders (customer_id, order_date) VALUES (?,?)";

        // Öppnar anslutning till databasen och stänger den automatiskt efteråt
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Sätt kundens ID i den förberedda frågan
            stmt.setInt(1,order.getCustomerID());

            // Utför SQL-frågan för att lägga till ordern
            stmt.executeUpdate();

            System.out.println(order.getCustomerID());

        } }
    // Metod för att hämta orderhistorik för en specifik kund
    public ArrayList<Order> OrderHistorik(int customerId) throws SQLException{

        // SQL-fråga för att välja alla ordrar för en given kund

            String SQL = "SELECT * FROM orders WHERE customer_id = ?";

        ArrayList<Order> orders = new ArrayList<Order>();// Lista för att lagra ordrarna

        // Öppnar anslutning till databasen och stänger den automatiskt efteråt
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
            PreparedStatement stmt = conn.prepareStatement(SQL)) {

            // Sätt kundens ID i den förberedda frågan
            stmt.setInt(1, customerId);

            // Utför frågan och få resultatet
            ResultSet rs = stmt.executeQuery();

            //Skapar Order-objekt
            while (rs.next()) {
                    Order order = new Order(
                            rs.getInt("order_id"),
                            rs.getInt("customer_id"));
                    orders.add(order);  // Lägg till ordern i listan
                }

                }
            return orders;  // Returnera listan med ordrar
            }
        }






