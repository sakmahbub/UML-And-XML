package domain;

import java.util.Date;

public class Sales {

    private int id;
    private String productName;
    private String productCode;
    private int qty;
    private double unitprice;
    private double totalPrice;

    Purchase purchase;

    public Sales() {
    }

    public Sales(String productName, String productCode, int qty, double unitprice, double totalPrice, Purchase purchase) {
        this.productName = productName;
        this.productCode = productCode;
        this.qty = qty;
        this.unitprice = unitprice;
        this.totalPrice = totalPrice;
        this.purchase = purchase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "Sales{" + "id=" + id + ", productName=" + productName + ", productCode=" + productCode + ", qty=" + qty + ", unitprice=" + unitprice + ", totalPrice=" + totalPrice + ", purchase=" + purchase + '}';
    }

    
    
    
}
