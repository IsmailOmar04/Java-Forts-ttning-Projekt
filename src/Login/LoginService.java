package Login;

import Admin.AdminRepo;
import Kunder.*;

import java.sql.SQLException;

public class LoginService {

    KunderRepo customerRepository;
    KunderRepo adminRepository;
    //LoginController loginController;

    public LoginService() {
        this.customerRepository = new KunderRepo();
        this.adminRepository = new AdminRepo();
        //this.loginController = new LoginController();
    }

    public Kunder loginAsCustomer(String email, String password) throws SQLException {

        Kunder customer = customerRepository.getCustomerByEmail(email);

        if(customer == null){
            System.out.println("No customer found");
        }
        else if(customer.getPassword().equals(password)){
            System.out.println("Congrats you've logged in");
            return customer;
        }
        else{
            System.out.println("Wrong password");
        }
        return null;
    }

    public void loginAsAdmin(String name, String password){

    }

}