package Lager;

import java.sql.*;

public class LagerRepo {

    public int Stockquantity(int productID) throws SQLException {
        String sql = "SELECT stock_quantity FROM products WHERE product_id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, productID);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("stock_quantity");
            }
        }
        return 0;
    }

    public void uppdateradStockQuantity(int productID, int quantity) throws SQLException {

        // Öppnar anslutning till databasen och stänger den automatiskt efteråt

        String sql = "UPDATE products SET stock_quantity = ? WHERE product_id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Sätter in det nya lagersaldot och produkt-ID i frågan
            stmt.setInt(1, quantity);
            stmt.setInt(2, productID);

            // Kör uppdateringen
            stmt.executeUpdate();

        }
    }
}
