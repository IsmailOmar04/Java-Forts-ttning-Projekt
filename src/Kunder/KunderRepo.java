package Kunder;
import Super.*;

import java.sql.*;
import java.util.ArrayList;

public class KunderRepo extends Repo {

    public ArrayList<Kunder> getAll() throws SQLException {
        ArrayList<Kunder> customers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM customers")) {

            while (rs.next()) {
                Kunder customer = new Kunder(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("password")
                );
                customers.add(customer);
            }
        }
        return customers;

    }

    public Kunder getCustomerByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM customers WHERE email = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

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
        return null;
    }

    public void addCustomers(Kunder customer) throws SQLException{
        String sql = "INSERT INTO customers (name, email, phone, address, password) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:webbutiken.db");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhone());
            stmt.setString(4, customer.getAddress());
            stmt.setString(5, customer.getPassword());

            stmt.executeUpdate();
        }
    }
}






    /**
     * Här kan fler metoder läggas till som t.ex:
     * - addCustomer
     * - getCustomerById
     * - updateCustomer
     * - deleteCustomer
     * - findCustomerByEmail
     *
     * Varje metod kommer följa samma mönster:
     * 1. Skapa Connection med DriverManager.getConnection(URL)
     * 2. Skapa Statement eller PreparedStatement
     * 3. Utför databasoperationen
     * 4. Hantera resultatet
     * 5. Låt try-with-resources stänga alla resurser
     */
