package Main;
import Login.LoginController;
import Kunder.KunderController;
import Produkter.ProduktController;

public class Main {
    public static void main(String[] args) {

        LoginController loginController = new LoginController();

        KunderController kunderController = new KunderController();
       ProduktController produktController = new ProduktController();

       //produktController.run();
     loginController.run();
     kunderController.run();

    }


}