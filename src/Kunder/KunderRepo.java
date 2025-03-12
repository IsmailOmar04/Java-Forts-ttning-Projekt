package Kunder;
import Super.*;

import java.sql.*;
import java.util.ArrayList;

public class KunderRepo  {

    // Hämtar alla kunder från databasen
    public ArrayList<Kunder> getAll() throws SQLException {
        ArrayList<Kunder> customers = new ArrayList<>();

        String sql = "SELECT * FROM customers";

        // Öppnar anslutning till databasen och stänger den automatiskt efteråt
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Skapa en Kunder-instans för varje rad i resultatet
            while (rs.next()) {
                Kunder customer = new Kunder(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("password")
                );
                customers.add(customer); //Lägger till i listan
            }
        }
        return customers; // Retunerara listan

    }

    // Hämtar en kund baserat på deras e-postadress
    public Kunder getCustomerByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM customers WHERE email = ?";

        // Öppnar anslutning till databasen och stänger den automatiskt efteråt
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Sätter in det nya Email i frågan
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            // Om en kund hittas, returnera kundens objekt
            if (rs.next()) {
                return new Kunder(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("password")
                );
            }
        }
        return null; // Om ingen kund hittas, returnera null

    }
    // Lägger till en ny kund i databasen
    public void addCustomers(Kunder customer) throws SQLException{
        String sql = "INSERT INTO customers (name, email, phone, address, password,customer_id) VALUES (?, ?, ?, ?, ?,NULL)";

        // Förbereda och köra SQL-frågan
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhone());
            stmt.setString(4, customer.getAddress());
            stmt.setString(5, customer.getPassword());

            // Utför uppdateringen för att lägga till kunden
            stmt.executeUpdate();
        }
    }
    // Uppdaterar en befintlig kunds information i databasen
    public void updateCustomers(Kunder customer) throws SQLException{
        // Förbereda och köra SQL-frågan
        String sql = "UPDATE customers SET name = ?, email = ?, phone = ?, address = ?, password = ? WHERE customer_id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
        PreparedStatement stmt = conn.prepareStatement(sql)) {


            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhone());
            stmt.setString(4, customer.getAddress());
            stmt.setString(5, customer.getPassword());
            stmt.setInt(6, customer.getId()); // Sätt kundens ID som parameter för att identifiera rätt kund

            stmt.executeUpdate();
            // Utför uppdateringen för att ändra kundens information

        }
    }
}


     