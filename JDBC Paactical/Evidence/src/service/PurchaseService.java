package service;

import connection.mySqlDbConnection;
import domain.Purchase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseService {

    static Connection conn = mySqlDbConnection.getConnection();

//    private int id;
//    private String productName;
//    private String productCode;
//    private int qty;
//    private double unitPrice;
//    private double totalPrice;
//    private Date purchaseDate;
    public static void createTable() {
        String sql = "create table purchase(id int auto_increment primary key, productName varchar(30) not null, productCode varchar(30) not null, qty int(11) not null, unitPrice double not null, unitprice double not null,  purchaseDate Date not null)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Createed");

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insertPurchase(Purchase pur) {
        String sql = "insert into purchase(productName, productCode, qty, unitPrice, totalPrice, purchaseDate) values(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pur.getProductName());
            ps.setString(2, pur.getProductCode());
            ps.setInt(3, pur.getQty());
            ps.setDouble(4, pur.getUnitPrice());
            ps.setDouble(5, pur.getTotalPrice());
            ps.setDate(6, new java.sql.Date(pur.getPurchaseDate().getTime()));
            ps.executeUpdate();
            System.out.println("Data Insert Successfully");

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Purchase getPurchaseByProductId(String productCode) {
        Purchase pc = new Purchase();
        String sql = "select * from purchase where productCode=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productCode);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                pc.setId(rs.getInt(1));
                pc.setProductName(rs.getString(2));
                pc.setProductCode(rs.getString(3));
                pc.setQty(rs.getInt(4));
                pc.setUnitPrice(rs.getDouble(5));
                pc.setTotalPrice(rs.getDouble(6));
                pc.setPurchaseDate(rs.getDate(7));

            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pc;
    }
    
    
    
    

    public static List<Purchase> getPurchaseList() {
        List<Purchase> list = new ArrayList<>();
        String sql = "select * from purchase";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Purchase pc = new Purchase();
                pc.setId(rs.getInt(1));
                pc.setProductName(rs.getString(2));
                pc.setProductCode(rs.getString(3));
                pc.setQty(rs.getInt(4));
                pc.setUnitPrice(rs.getDouble(5));
                pc.setTotalPrice(rs.getDouble(6));
                pc.setPurchaseDate(rs.getDate(7));
                list.add(pc);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
