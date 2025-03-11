package Order;

import java.sql.*;
import java.util.ArrayList;

public class OrderRepo  {

    public void SkapaOrder(Order order) throws SQLException {
        String sql = "INSERT INTO orders (customer_id, order_date) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,order.getCustomerID());
            stmt.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));

            stmt.executeUpdate();
            System.out.println(order.getCustomerID() + " " + order.getOrderDate());

        } }
        public ArrayList<Order> OrderHistorik(int CustomerId) throws SQLException{
            String SQL = "SELECT * FROM orders WHERE customer_id = ?";
            ArrayList<Order> orders = new ArrayList<Order>();

            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
            PreparedStatement stmt = conn.prepareStatement(SQL)) {
                stmt.setInt(1, CustomerId);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Order order = new Order(
                            rs.getInt("order_id"),
                            rs.getInt("customer_id"),
                            rs.getDate("order_date")

                    );
                    orders.add(order);
                }

                }
            return orders;
            }
        }






