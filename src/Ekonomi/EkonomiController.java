package Ekonomi;

import java.sql.SQLException;
import java.util.Scanner;


public class EkonomiController {
    EkonomiService ekonomiService;
    Scanner scanner;

    public EkonomiController() {
        this.ekonomiService = new EkonomiService();
        this.scanner = new Scanner(System.in);
    }

    public void run(){

        while(true){

        try {
            System.out.println("===EkonomiHantering");
            System.out.println("1. Uppdatera Produktpris");
            System.out.println("2. Visa totalpris för en order");
            System.out.println("0.Avsluta ");
            System.out.print("Välj ett alternativ: ");

            String select = scanner.nextLine();

            switch(select){
                case "1":
                    System.out.println("ange produktID: ");
                    int productID = scanner.nextInt();
                    System.out.println("ange nytt produkt pris: ");
                    double price = scanner.nextDouble();
                    ekonomiService.uppdateraproduktpris(productID, price);
                    scanner.nextLine();

                        break;
                        case "2":
                            System.out.println("Ange orderID: ");
                            int orderID = scanner.nextInt();
                            scanner.nextLine();
                            ekonomiService.totalpris(orderID);
                            break;
                            case "0":
                                System.out.println("Avslutar ekonomihantering...");
                                return;

                                    default:
                                        System.out.println(" Ogiltigt val, försök igen");
                                        break;
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
