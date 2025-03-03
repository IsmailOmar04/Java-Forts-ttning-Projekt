package Login;


import Kunder.*;

import java.sql.SQLException;

public class LoginService {

    KunderRepo customerRepository;
    //LoginController loginController;

    public LoginService() {
        this.customerRepository = new KunderRepo();
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

    public void RegistreraKunder(String name,String email, String phone,String adress,String password) throws SQLException{

        Kunder nykund = new Kunder(0, name, email, phone, adress, password);
        customerRepository.addCustomers(nykund);
        System.out.println("Kunden har registrerats");
    }


}





