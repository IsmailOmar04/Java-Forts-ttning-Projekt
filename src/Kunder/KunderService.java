package Kunder;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Service-klass för kundhantering
 * Innehåller affärslogik mellan controller och repository
 */
public class KunderService {

    // Repository som hanterar alla databasanrop
    KunderRepo customerRepository;

    /**
     * Konstruktor för Customer.CustomerService
     * Initierar repository-lagret
     */
    public KunderService() {
        this.customerRepository = new KunderRepo();
    }

    /**
     * Hämtar och visar alla kunder från databasen
     * Service-lagret kan här:
     * - Formatera utskriften
     * - Lägga till affärslogik (t.ex. filtrera bort inaktiva kunder)
     * - Hantera specialfall (t.ex. om listan är tom)
     *
     * @throws SQLException vid problem med databasanrop
     */
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
            System.out.println("Customer.Customer{" +
                    "customerId=" + customer.getId() +
                    ", name='" + customer.getName() + '\'' +
                    ", email='" + customer.getEmail() + '\'' +
                    ", phone='" + customer.getPhone() + '\'' +
                    ", address='" + customer.getAddress() + '\'' +
                    ", password='" + customer.getPassword() + '\'' +
                    '}');
        }
    }

    public void showUserById(int customerId) throws SQLException {
        // Hämta alla kunder från repository-lagret
        Kunder customer = customerRepository.getCustomerById(customerId);


        // Skriv ut alla kunder med tydlig formatering
        System.out.println(customer.toString());
    }

    public void addCustomer(String name, String email, String phone, String address, String password) throws SQLException {

        customerRepository.addCustomer(name, email, phone, address, password);

    }

    /**
     * Här kan man lägga till fler metoder som t.ex:
     * - getCustomerById
     * - addNewCustomer
     * - updateCustomer
     * - deleteCustomer
     * - findCustomerByEmail
     */
}