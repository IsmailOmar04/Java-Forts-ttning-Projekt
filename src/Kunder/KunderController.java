package Kunder;
import java.sql.SQLException;
import java.util.Scanner;

public class KunderController {

    KunderService customerService;

    Scanner scanner;

    // Konstruktor som startar KunderService och Scanner
    public KunderController() {
        this.customerService = new KunderService();
        this.scanner = new Scanner(System.in);
    }

    // Metod som kör menyalternativen för kundhantering
    public void run() {

        while (true) {
            try {

                System.out.println("Kundhantering");
                System.out.println( "1. Visa alla kunder");
                System.out.println("2. Updatera kundinformation");
                System.out.println(" 2. Avsluta");
                System.out.print(" Välj ett alternativ: ");

                // Läs användarens val
                String select = scanner.nextLine();

                switch (select) {
                    case "1":
                        // Visa alla kunder genom att anropa showAllUsers-metoden i KunderService
                        System.out.println( "alla kunder");
                        customerService.showAllUsers();

                        break;
                    case "2":
                        // Uppdatera kundinformation genom att fråga om kundens ID
                        System.out.println("Ange kundens ID för att uppdatera");
                        int customerId = scanner.nextInt();
                        scanner.nextLine();
                        // Fråga efter ny kundinformation

                        System.out.println("Nytt Namn: ");
                        String Name  = scanner.nextLine();

                        System.out.println("Nytt Email: ");
                        String Email = scanner.nextLine();

                        System.out.println("Nytt Phone: ");
                        String Phone = scanner.nextLine();

                        System.out.println("Nytt Address");
                        String Address = scanner.nextLine();

                        System.out.println("Nytt Lösenord: ");
                        String Password = scanner.nextLine();

                        // Uppdatera kundens information genom att anropa updateCustomerInfo-metoden i KunderService
                        customerService.updateCustomerInfo(customerId, Name, Email, Phone, Address, Password);
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