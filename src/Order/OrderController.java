package Order;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class OrderController {
    OrderService orderService;
    Scanner scanner;

   // Skapar en ny OrderController och startar OrderService och Scanner.

    public OrderController() {
        this.orderService = new OrderService();
        this.scanner = new Scanner(System.in);

    }
       //  Startar huvudmenyn för orderhantering.

    public void run() {
        while (true) {
            try {
                System.out.println("\n=== ORDRAR ===");
                System.out.println("1. Skapa nya  Order");
                System.out.println("2. vissa  Order");
                System.out.println("0. Avsluta");
                System.out.println("Välj ett alternative: ");

                String select = scanner.nextLine();


                switch (select) {
                    case "1":

                        // Skapa en ny order
                        System.out.println(" Ange Kundens ID: ");
                        int customerId = scanner.nextInt();
                        scanner.nextLine();
                        orderService.SkapaOrder(customerId);
                        break;

                    case "2":
                        // Visa orderhistorik för en kund
                        System.out.println(" Ange Kundens ID: ");
                        int CustomerId = scanner.nextInt();
                        scanner.nextLine();
                        orderService.OrderHistorik(CustomerId);
                        break;
                        case "0":
                            System.out.println( "Avslutar Orderhantering... ");
                            break;
                    default:
                            System.out.println(" Ogiltigt val, försök igen");


                }
            } catch (SQLException e) {
                System.out.println(" Databasfel: " + e.getMessage());

            } catch (Exception a) {
                System.out.println(" Ett fel uppstod: " + a.getMessage());
                scanner.nextLine();
            }
        }
    }
}

