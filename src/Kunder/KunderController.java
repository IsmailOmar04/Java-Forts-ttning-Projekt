package Kunder;

import java.sql.SQLException;
import java.util.Scanner;

public class KunderController {

    KunderService customerService;

    Scanner scanner;

    public KunderController() {
        this.customerService = new KunderService();
        this.scanner = new Scanner(System.in);
    }

    public void run() {


        while (true) {
            try {

                System.out.println("Kundhantering");
                System.out.println( "Visa alla kunder");
                System.out.println( "Visa en kund");
                System.out.println( "Lägg till en kund ");
                System.out.println("Avsluta");
                System.out.print(" Välj ett alternativ: ");

                String select = scanner.nextLine();

                switch (select) {
                    case "1":
                        System.out.println( "\n=== Visar alla kunder ");
                        customerService.showAllUsers();
                        System.out.println(" Alla kunder listade framgångsrikt!");
                        break;
                    case "2":
                        System.out.println("\n=== Sök kund ");
                        System.out.print(" Ange ID: ");
                        String idInput = scanner.nextLine();
                        int id = Integer.parseInt(idInput);
                        customerService.showUserById(id);
                        System.out.println(" Kund hittad!");
                        break;
                    case "3":
                        System.out.println( "\n=== Lägg till ny kund " + " ===");
                        System.out.print(" Namn: ");
                        String name = scanner.nextLine();
                        System.out.print(" Email: ");
                        String email = scanner.nextLine();
                        System.out.print(" Telefon: ");
                        String phone = scanner.nextLine();
                        System.out.print(" Adress: ");
                        String address = scanner.nextLine();
                        System.out.print(" Lösenord: ");
                        String password = scanner.nextLine();
                        customerService.addCustomer(name, email, phone, address, password);
                        System.out.println(" Ny kund tillagd framgångsrikt!");
                        break;
                    case "0":
                        System.out.println( "Avslutar kundhantering... ");
                        return;
                    default:
                        System.out.println(" Ogiltigt val, försök igen");
                }
            } catch (SQLException e) {
                System.out.println(" Databasfel: " + e.getMessage());
            } catch (Exception e) {
                System.out.println(" Ett fel uppstod: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}