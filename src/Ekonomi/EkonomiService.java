package Ekonomi;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class EkonomiService {
        EkonomiController ekonomiController;


        public EkonomiService() {

        }
        public void uppdateraproduktpris(int produktID, double pris) throws SQLException {
            String sql = "UPDATE products SET price = ? WHERE product_id = ?";
            try(Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDouble(1, pris);
                stmt.setInt(2, produktID);

                int rowsUpdated = stmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Produkt uppdaterad " + pris + " Sek");
                } else {
                    System.out. println("Produkt inte hittad");
                }
            }
        }

    public void totalpris(int orderID) {
        String sql = """
        SELECT o.order_id, o.order_date, SUM(op.unit_price * op.quantity) AS price
        FROM orders o
        JOIN orders_products op ON o.order_id = op.order_id
        WHERE o.order_id = ?
    """;

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
        PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1,orderID);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                double totalpris = rs.getDouble("Price");
                System.out.println("Totalpris för order ID " + orderID + " är: " + totalpris + " SEK");

            } else {
                System.out.println("Ingen order hittades");
            }

        } catch (SQLException e) {
            System.out.println(" Ett fel uppstod:" + e.getMessage());
        }   catch (Exception e) {
        System.out.println(" Ett fel uppstod: " + e.getMessage());

    }
    }
}
