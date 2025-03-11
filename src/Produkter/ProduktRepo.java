package Produkter;

import Super.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduktRepo {

    public ArrayList<Produkt> getAll() throws SQLException {
        ArrayList<Produkt> produkt = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {


            while (rs.next()) {
                Produkt product = new Produkt(
                        rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("stock_quantity")
                );
                produkt.add(product);
                System.out.println(product.toString());
            }
        }
        return produkt;
    }

        public ArrayList<Produkt> SökaProdukt(String sök) throws SQLException{
            ArrayList<Produkt> produkt = new ArrayList<>();

            String query = "SELECT * FROM products WHERE name LIKE ?";
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
                 PreparedStatement stmt = conn.prepareStatement(query)) {

                stmt.setString(1, sök);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Produkt product = new Produkt(
                            rs.getInt("product_id"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getDouble("price"),
                            rs.getInt("stock_quantity")
                    );
                    produkt.add(product);

                }
                return produkt;

            }

    }
    public ArrayList<Produkt> filtreraProdukterFrånKategorier(String kategori)  throws SQLException{
        ArrayList<Produkt> produkt = new ArrayList<>();

        String query = "SELECT * FROM products WHERE categories = ?" ;
      try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
           PreparedStatement stmt = conn.prepareStatement(query)){

          stmt.setString(1,kategori);
          ResultSet rs = stmt.executeQuery();

          while (rs.next()){
              Produkt product = new Produkt(
                      rs.getInt("product_id"),
                      rs.getString("name"),
                      rs.getString("description"),
                      rs.getDouble("price"),
                      rs.getInt("stock_quantity")

              );
              produkt.add(product);
          }
          return produkt;

      }



    }
}




