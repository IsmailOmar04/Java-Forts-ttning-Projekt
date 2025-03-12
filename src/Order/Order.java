package Order;

import Super.User;

import java.util.Date;

public class Order {
    private int OrderID;
    private int customerID;

    private Date orderDate;


    public Order(int orderID, int customerID, Date orderDate ) {
        this.OrderID = orderID;
        this.customerID = customerID;

        this.orderDate = orderDate;

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

public Date getOrderDate() {
        return orderDate;
}
public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
}
@Override
    public String toString() {
        return "Order{" +
                "orderId=" + OrderID +
                ", customerId ="+ customerID +
                ", orderDate = " + orderDate +
                '}';

}


}
