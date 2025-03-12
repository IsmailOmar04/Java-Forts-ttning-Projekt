package Order;
import java.sql.SQLException;
import java.util.Scanner;

public class OrderController {
    OrderService orderService;
    Scanner scanner;

    public OrderController() {
        this.orderService = new OrderService();
        this.scanner = new Scanner(System.in);

    }
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
                        System.out.println(" Ange Kundens ID: ");
                        int customerId = scanner.nextInt();
                        scanner.nextLine();
                        orderService.SkapaOrder(customerId);
                        break;
                    case "2":
                        System.out.println(" Ange Kundens ID: ");
                        int orderId = scanner.nextInt();
                        scanner.nextLine();
                        orderService.OrderHistorik(orderId);
                }

            }
        }
    }}

