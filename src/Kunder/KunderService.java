package Kunder;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class KunderService {


    KunderRepo customerRepository;


    public KunderService() {
        this.customerRepository = new KunderRepo();

    }


    public void showAllUsers() throws SQLException {

        ArrayList<Kunder> customers = customerRepository.getAll();


        if (customers.isEmpty()) {
            System.out.println("Inga kunder hittades.");
            return;
        }


        System.out.println("\n=== Kundlista ===");
        for (Kunder customer : customers) {
            System.out.println("ID: " + customer.getId());
            System.out.println("Namn: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Telefonnummer" + customer.getPhone());
            System.out.println("Adress" + customer.getAddress());
            System.out.println("-----------------");
        }
    }

    public void updateCustomerInfo(int customerId, String Name, String Email, String Phone, String Address, String Password) throws SQLException {
    Kunder customer = new Kunder(customerId, Name, Email, Phone, Address, Password);
    customerRepository.updateCustomers(customer);
        System.out.println("Kundinformation updaterad!!");
}}

