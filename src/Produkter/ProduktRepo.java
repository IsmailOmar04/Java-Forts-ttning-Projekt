package Produkter;

import Super.*;

import java.sql.*;
import java.util.ArrayList;

public class ProduktRepository extends Repo{

    public ArrayList<Produkt> getAll() throws SQLException {
        ArrayList<Produkt> products = new ArrayList<>();

        // try-with-resources stänger automatiskt Connection, Statement och ResultSet
        try (Connection conn = DriverManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {

            // Loopa igenom alla rader från databasen
            while (rs.next()) {
                Produkt product = new Produkt(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("stock_quantity")
                );
                products.add(product);
                System.out.println(product.toString());
            }
        }
        return products;
    }

}