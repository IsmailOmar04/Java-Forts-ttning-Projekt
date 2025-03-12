package Lager;

public class Lager{
    private int productID;
    private int stock_quantity;


    public Lager(int productID, int stock_quantity) {
        this.productID = productID;
        this.stock_quantity = stock_quantity;
    }
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }
}
