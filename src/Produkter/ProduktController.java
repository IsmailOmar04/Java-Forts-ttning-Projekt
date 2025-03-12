package Produkter;

import Kunder.KunderService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProduktController {

    ProduktRepo productRepository;

    Scanner scanner;

    public ProduktController() {
        // Konstruktor som startar ProduktRepo och Scanner

        this.productRepository = new ProduktRepo();
        this.scanner = new Scanner(System.in);
    }

    // Metod för att starta och köra menyalternativen för produkthantering

    public void run() {
        while (true) {
            try {

                System.out.println("\n=== Produkthantering ===");
                System.out.println("1. Visa alla produkter");
                System.out.println("2. Visa en produkt");
                System.out.println("3. Filtrera Produkter Från Kategorier");
                System.out.println("0. Avsluta");
                System.out.print("Välj ett alternativ: ");

                // Läsa användarens val från menyn
                int select = scanner.nextInt();


                switch (select) {
                    case 1:
                        // Visa alla produkter
                        productRepository.getAll();
                        break;
                    case 2:
                        // Sök efter en specifik produkt genom namn
                        System.out.println("Ange Produktnamn att söka efter:");
                        scanner.nextLine();
                        String sökord = scanner.nextLine();
                        ArrayList<Produkt> produkter = productRepository.SökaProdukt(sökord);

                        if(produkter.isEmpty()) {
                            System.out.println("Inga produkter hittades");

                        } else {
                            // Skriv ut alla produkter som matchade sökordet
                            for (Produkt p : produkter) {
                                System.out.println(p.toString());
                            }
                        }
                        break;
                    case 3:
                        // Filtrera produkter efter kategori
                        System.out.println("Ange kategori att filtrera efter:");
                        String filtrer = scanner.nextLine();
                        scanner.nextLine();
                        productRepository.filtreraProdukterFrånKategorier(filtrer);
                        break;
                    case 0:
                        System.out.println("Avslutar Orderhantering...");
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