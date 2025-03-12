package Main;
import Ekonomi.EkonomiController;
import Lager.LagerController;
import Login.LoginController;
import Kunder.KunderController;
import Order.OrderController;
import Produkter.ProduktController;

public class Main {
    public static void main(String[] args) {

        LoginController loginController = new LoginController();
        OrderController orderController = new OrderController();
        KunderController kunderController = new KunderController();
       ProduktController produktController = new ProduktController();
        LagerController lagerController = new LagerController();
        EkonomiController ekonomiController = new EkonomiController();


        //ekonomiController.run();
       //lagerController.run();
      // orderController.run();
      //produktController.run();
     //loginController.run();
     //kunderController.run();


    }


}