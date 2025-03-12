package Lager;
import java.sql.SQLException;

public class LagerService {
    LagerRepo lagerRepo;

    public LagerService() {
        this.lagerRepo = new LagerRepo();
    }

    public void produktStock(int productId, int Rquantity) throws SQLException {
        int stock = lagerRepo.Stockquantity(productId);

        // Kontrollerar om det finns tillräckligt i lager
        if (stock >= Rquantity) {
            System.out.println("Finns i lager");
        }   else   {
            System.out.println("Produkten finns inte tillräckligt i lagret");
        }

    }
public void uppdateradStockEfterOrder(int productId, int Oquantity) throws SQLException {
        int Stock = lagerRepo.Stockquantity(productId);

    // Om tillräckligt i lager, uppdatera saldo
    if (Stock >= Oquantity) {
            lagerRepo.uppdateradStockQuantity(productId, Stock - Oquantity);
            System.out.println("LagerSaldo uppdaterad");

        } else {
            System.out.println("inte tillräckligt produkter i Lagret");
        }
    }
}

