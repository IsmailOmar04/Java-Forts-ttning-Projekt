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
                System.out.println( "1. Visa alla kunder");
                System.out.println(" 2. Avsluta");
                System.out.print(" Välj ett alternativ: ");

                String select = scanner.nextLine();

                switch (select) {
                    case "1":
                        System.out.println( "alla kunder");
                        customerService.showAllUsers();

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