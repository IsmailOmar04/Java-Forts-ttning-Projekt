package Produkter;

import java.sql.SQLException;
import java.util.Scanner;


public class ProduktController {

    // Service-lager för kundhantering, hanterar affärslogik
    ProduktRepo productRepository;

    // Scanner för användarinput
    Scanner scanner;

    public ProduktController() {
        // Skapa instanser av nödvändiga objekt
        this.productRepository = new ProduktRepo();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Huvudloop för kundhantering
     * Visar meny och hanterar användarval
     */
    public void run() {
        while (true) {
            try {
                // Skriv ut menyalternativ direkt i run-metoden för tydlighet
                System.out.println("\n=== Produkthantering ===");
                System.out.println("1. Visa alla produkter");
                System.out.println("2. Visa en produkt");
                System.out.println("3. Lägg till en produkt");
                System.out.println("0. Avsluta");
                System.out.print("Välj ett alternativ: ");

                // Läs användarens val
                int select = scanner.nextInt();

                // Hantera användarens val
                switch (select) {
                    case 1:
                        // Anropa service-lagret för att visa alla kunder
                        productRepository.getAll();
                        break;
                    case 2:
                        // Anropa service-lagret för att visa en kund baserat på id
                        System.out.println("Ange ID");
                        int id = scanner.nextInt();
                        //customerService.showUserById(id);
                        break;
                    case 3:
                        // Anropa service-lagret för att visa en kund baserat på id
                        System.out.println("Ange namn");
                        String name = scanner.next();
                        System.out.println("Ange email");
                        String email = scanner.next();
                        System.out.println("Ange telefon");
                        String phone = scanner.next();
                        System.out.println("Ange adress");
                        String address = scanner.next();
                        System.out.println("Ange lösenord");
                        String password = scanner.next();
                        //customerService.addCustomer(name, email, phone, address, password);
                        break;
                    case 0:
                        System.out.println("Avslutar kundhantering...");
                        return;
                    default:
                        System.out.println("Ogiltigt val, försök igen");
                }
            } catch (SQLException e) {
                // Hantera databasfel
                System.out.println("Ett fel uppstod vid databasanrop: " + e.getMessage());
            } catch (Exception e) {
                // Hantera övriga fel (t.ex. felaktig input)
                System.out.println("Ett oväntat fel uppstod: " + e.getMessage());
                scanner.nextLine(); // Rensa scanner-bufferten vid felinmatning
            }
        }
    }
}