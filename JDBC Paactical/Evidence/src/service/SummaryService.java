package service;

import connection.mySqlDbConnection;
import domain.Purchase;
import domain.Summary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SummaryService {

    static Connection conn = mySqlDbConnection.getConnection();

//     private int id;
//    private String productName;
//    private String productCode;
//    private int totalQty;
//    private int soldQty;
//    private int availableQty;
//    private Date lastUpdate;
    public static void createTable() {
        String sql = "create table sammary(id int auto_increment primary key, productName varchar(30) not null, productCode varchar(30) not null, totalQty int(11) not null, soldQty double not null, availableQty double not null,  lastUpdate Date not null, product_id int(11) not null, foreign key (product_id) references purchase(id))";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            System.out.println("Table Createed");

        } catch (SQLException ex) {
            Logger.getLogger(SummaryService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insertSummary(Summary pur) {
        String sql = "insert into summary(productName, productCode, totalQty, soldQty, availableQty, lastUpdate, product_id) values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pur.getProductName());
            ps.setString(2, pur.getProductCode());
            ps.setInt(3, pur.getTotalQty());
            ps.setInt(4, pur.getSoldQty());
            ps.setInt(5, pur.getAvailableQty());
            ps.setDate(6, new java.sql.Date(pur.getLastUpdate().getTime()));
            ps.setInt(7, pur.getPurchase().getId());
            ps.executeUpdate();
            System.out.println("Data Insert Summary");

        } catch (SQLException ex) {
            Logger.getLogger(SummaryService.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SummaryService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pc;
    }

    public static List<Purchase> getSummaryList() {
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
            Logger.getLogger(SummaryService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
