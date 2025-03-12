package Lager;
import java.sql.SQLException;
import java.util.Scanner;



public class LagerController {
    LagerService lagerService;
    Scanner scanner;

     //   Konstruktor som startar LagerService och Scanner.

    public LagerController() {
        this.lagerService = new LagerService();
        this.scanner = new Scanner(System.in);

    }
    // Startar lagerhanteringsmenyn och hanterar användarens val.

    public void run() {
        try {
            System.out.println("===Lagerhantering===");
            System.out.println("1.Kontrollera LagerSaldo");
            System.out.println("2.Uppdatera LagerSaldo");
            System.out.println("0.Avsluta");
            System.out.println(" Välj ett alternativ");

            String Select = scanner.nextLine(); // Läser användarens val

            switch (Select) {
                case "1":
                    // Hantera kontroll av lagersaldo
                    System.out.println("Ange Produkt ID: ");
                    int productId = scanner.nextInt();
                    System.out.println("Ange Produkt Saldo kvantitet: ");
                    int quantity = scanner.nextInt();
                    lagerService.produktStock(productId, quantity);
                    break;

                case "2":
                    // Hantera uppdatering av lagersaldo
                    System.out.println("Ange Produkt ID för uppdatering: ");
                    int uppdateringId = scanner.nextInt();
                    System.out.println("Ange Ny lagersaldo: ");
                    int Quantity = scanner.nextInt();
                    scanner.nextLine();
                    lagerService.uppdateradStockEfterOrder(uppdateringId, Quantity);
                    break;
                case "0":
                    System.out.println("Avslutar kundhantering... ");
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


