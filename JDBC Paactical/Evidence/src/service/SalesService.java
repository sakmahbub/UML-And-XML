package service;

import connection.mySqlDbConnection;
import domain.Purchase;
import domain.Sales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static service.PurchaseService.conn;

public class SalesService {

    static Connection conn = mySqlDbConnection.getConnection();

    public static void createTable() {
        String sql = "create table sales(id int auto_increment primary key, productName varchar(30) not null, productCode varchar(30) not null, qty int(11) not null, unitPrice double not null, unitprice double not null,  salesDate Date not null, product_id int(11) not null, foreign key (product_id) references purchase(id))";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Createed");

        } catch (SQLException ex) {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insertSales(Sales sal) {
        String sql = "insert into sales(productName, productCode, qty, unitPrice, totalPrice, salesDate) values(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sal.getProductName());
            ps.setString(2, sal.getProductCode());
            ps.setInt(3, sal.getQty());
            ps.setDouble(4, sal.getUnitPrice());
            ps.setDouble(5, sal.getTotalPrice());
            ps.setDate(6, new java.sql.Date(sal.getSalesDate().getTime()));
            ps.executeUpdate();
            System.out.println("Data Insert Successfully");

        } catch (SQLException ex) {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Sales getSalesByProductId(String productCode) {
        Sales sal = new Sales();
        String sql = "select * from sales where productCode=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, productCode);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                sal.setId(rs.getInt(1));
                sal.setProductName(rs.getString(2));
                sal.setProductCode(rs.getString(3));
                sal.setQty(rs.getInt(4));
                sal.setUnitPrice(rs.getDouble(5));
                sal.setTotalPrice(rs.getDouble(6));
                sal.setSalesDate(rs.getDate(7));

            }

        } catch (SQLException ex) {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sal;
    }
    
    
    
    public static List<Sales> getSalesList() {
        List<Sales> list = new ArrayList<>();
        String sql = "select * from sales";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sales sal = new Sales();
                sal.setId(rs.getInt(1));
                sal.setProductName(rs.getString(2));
                sal.setProductCode(rs.getString(3));
                sal.setQty(rs.getInt(4));
                sal.setUnitPrice(rs.getDouble(5));
                sal.setTotalPrice(rs.getDouble(6));
                sal.setSalesDate(rs.getDate(7));
                list.add(sal);

            }

        } catch (SQLException ex) {
            Logger.getLogger(SalesService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
