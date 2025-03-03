package Main;
import Login.LoginController;
import Kunder.KunderController;

public class Main {
    public static void main(String[] args) {

        LoginController loginController = new LoginController();

        KunderController kunderController = new KunderController();

       // loginController.run();
        kunderController.run();

    }


}