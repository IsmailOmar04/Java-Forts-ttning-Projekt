package Produkter;

import Super.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduktRepo {

    // Metod för att hämta alla produkter från databasen
    public ArrayList<Produkt> getAll() throws SQLException {
        ArrayList<Produkt> produkt = new ArrayList<>(); // Lista för att lagra alla produkter

        String sql = "SELECT * FROM Products";
        // Öppnar anslutning till databasen och stänger den automatiskt efteråt
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // skapar Produkt-objekt för varje rad
            while (rs.next()) {
                Produkt product = new Produkt(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("stock_quantity")
                );
                produkt.add(product); // Lägg till produkt i listan
                System.out.println(product.toString());  // Skriv ut produktens information
            }
        }
        return produkt; // Returnera listan med produkter
    }
    // Metod för att söka efter en produkt baserat på produktens namn
        public ArrayList<Produkt> SökaProdukt(String sök) throws SQLException{
            ArrayList<Produkt> produkt = new ArrayList<>(); // Lista för att lagra sökta produkter

            // SQL-fråga för att söka produkter med namn som matchar sökordet
            String query = "SELECT * FROM products WHERE name LIKE ?";
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                // Sätt sökordet i SQL-frågan
                stmt.setString(1, sök);
                ResultSet rs = stmt.executeQuery(); // Utför frågan

                // Skapar Produkt-objekt för varje rad
                while (rs.next()) {
                    Produkt product = new Produkt(
                            rs.getInt("product_id"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getDouble("price"),
                            rs.getInt("stock_quantity")
                    );
                    produkt.add(product); // Lägg till produkt i listan

                }
                return produkt; // Returnera listan med produkter

            }

    }
    // Metod för att filtrera produkter baserat på kategori
    public ArrayList<Produkt> filtreraProdukterFrånKategorier(String kategori)  throws SQLException{
        ArrayList<Produkt> produkt = new ArrayList<>(); // Lista för att lagra filtrerade produkter

        // SQL-fråga för att filtrera produkter från en specifik kategori
        String query = "SELECT p.product_id, p.name, p.description, p.price, p.stock_quantity " +
                "FROM products p " +
                "JOIN products_categories pc ON p.product_id = pc.product_id " +
                "JOIN categories c ON pc.category_id = c.category_id " +
                "WHERE c.name = ?";

        // Öppnar anslutning till databasen och stänger den automatiskt efteråt
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
           PreparedStatement stmt = conn.prepareStatement(query)){

            // Sätt kategorin i SQL-frågan
            stmt.setString(1,kategori);
          ResultSet rs = stmt.executeQuery();  // Utför frågan

            // skapar Produkt-objekt för varje rad

            while (rs.next()){
              Produkt product = new Produkt(
                      rs.getInt("product_id"),
                      rs.getString("name"),
                      rs.getString("description"),
                      rs.getDouble("price"),
                      rs.getInt("stock_quantity")

              );
              produkt.add(product); // Lägg till produkt i listan
          }
          return produkt; // Returnera listan

      }



    }
}




