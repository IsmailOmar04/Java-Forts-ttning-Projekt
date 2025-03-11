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
                System.out.println("2. Updatera kundinformation");
                System.out.println(" 2. Avsluta");
                System.out.print(" Välj ett alternativ: ");

                String select = scanner.nextLine();

                switch (select) {
                    case "1":
                        System.out.println( "alla kunder");
                        customerService.showAllUsers();

                        break;
                    case "2":
                        System.out.println("Ange kundens ID för att uppdatera");
                        int customerId = scanner.nextInt();
                        scanner.nextLine();

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