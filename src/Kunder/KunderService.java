package Kunder;
import java.sql.SQLException;
import java.util.ArrayList;

public class KunderService {

    // Repository som hanterar alla databasanrop
    KunderRepo customerRepository;


    public KunderService() {
        this.customerRepository = new KunderRepo();

    }


    public void showAllUsers() throws SQLException {
        // Hämta alla kunder från repository-lagret
        ArrayList<Kunder> customers = customerRepository.getAll();

        // Kontrollera om vi har några kunder att visa
        if (customers.isEmpty()) {
            System.out.println("Inga kunder hittades.");
            return;
        }

        // Skriv ut alla kunder med tydlig formatering
        System.out.println("\n=== Kundlista ===");
        for (Kunder customer : customers) {
            System.out.println("ID: " + customer.getId());
            System.out.println("Namn: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Telefonnummer" + customer.getPhone());
            System.out.println("Adress" + customer.getAddress());
            System.out.println("-----------------");
        }
    } }

