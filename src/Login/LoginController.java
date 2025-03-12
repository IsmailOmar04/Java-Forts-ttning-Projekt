package Login;

import java.sql.SQLException;
import java.util.Scanner;

import Kunder.KunderService;


public class LoginController {

    LoginService loginService;
    KunderService kunderService;


    Scanner scanner;

    public LoginController() {

        this.loginService = new LoginService();
        this.scanner = new Scanner(System.in);
        this.kunderService = new KunderService();
    }

    public void run() {
        while (true) {
            try {
                System.out.println("\n=== Login ===");
                System.out.println("1. Logga in som kund");
                System.out.println("2. Registrera kund");
                System.out.println("0. Avsluta");
                System.out.print("Välj ett alternativ: ");

                String select = scanner.nextLine();

                switch (select) {
                    case "1":
                        System.out.println("Skriv Mailadress");
                        String email = scanner.nextLine();

                        System.out.println("Skriv lösenord");
                        String password = scanner.nextLine();

                        loginService.loginAsCustomer(email, password);
                        break;

                    case "2":
                        System.out.println("\n Registrera Ny Kund");
                        System.out.println("Namn: ");
                        String Name  = scanner.nextLine();

                        System.out.println("Email: ");
                        String Email = scanner.nextLine();

                        System.out.println("Phone: ");
                        String Phone = scanner.nextLine();

                        System.out.println("Address");
                        String Address = scanner.nextLine();

                        System.out.println("Lösenord:  ");
                        String Password = scanner.nextLine();

                        loginService.RegistreraKunder(Name, Email, Phone, Address, Password);

                        break;

                    case "0":
                        System.out.println("Avslutar Loginhantering...");
                        return;
                    default:
                        System.out.println("Ogiltigt val, försök igen");
                }
            } catch (SQLException e) {

                System.out.println("Ett fel uppstod vid databasanrop: " + e.getMessage());
            } catch (Exception e) {

                System.out.println("Ett oväntat fel uppstod: " + e.getMessage());
                scanner.nextLine(); // Rensa scanner-bufferten vid felinmatning
            }
        }
    }
}