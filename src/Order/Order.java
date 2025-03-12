package Order;




public class Order {
    private int OrderID;
    private int customerID;




    public Order(int orderID, int customerID ) {
        this.OrderID = orderID;
        this.customerID = customerID;

    }
public int getOrderID() {
        return OrderID;
}
public void setOrderID(int orderID) {
        OrderID = orderID;

}
public int getCustomerID() {
        return customerID;

}
public void setCustomerID(int customerID) {
        this.customerID = customerID;
}

}



