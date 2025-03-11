package Produkter;

import Kunder.KunderService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProduktController {

    ProduktRepo productRepository;

    Scanner scanner;

    public ProduktController() {

        this.productRepository = new ProduktRepo();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            try {

                System.out.println("\n=== Produkthantering ===");
                System.out.println("1. Visa alla produkter");
                System.out.println("2. Visa en produkt");
                System.out.println("3. Filtrera Produkter Från Kategorier");
                System.out.println("0. Avsluta");
                System.out.print("Välj ett alternativ: ");


                int select = scanner.nextInt();


                switch (select) {
                    case 1:

                        productRepository.getAll();
                        break;
                    case 2:
                        System.out.println("Ange Produktnamn att söka efter:");
                        scanner.nextLine();
                        String sökord = scanner.nextLine();
                        ArrayList<Produkt> produkter = productRepository.SökaProdukt(sökord);

                        if(produkter.isEmpty()) {
                            System.out.println("Inga produkter hittades");

                        } else {
                            for (Produkt p : produkter) {
                                System.out.println(p.toString());
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Ange kategori att filtrera efter:");
                        String filtrer = scanner.nextLine();
                        productRepository.filtreraProdukterFrånKategorier(filtrer);
                        break;
                    case 0:
                        System.out.println("Avslutar kundhantering...");
                        return;
                    default:
                        System.out.println("Ogiltigt val, försök igen");
                }
            } catch (SQLException e) {

                System.out.println("Ett fel uppstod vid databasanrop: " + e.getMessage());
            } catch (Exception e) {

                System.out.println("Ett oväntat fel uppstod: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
}