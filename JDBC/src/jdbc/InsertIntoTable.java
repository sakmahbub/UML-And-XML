/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class InsertIntoTable {

    public static Connection conn = MySqlDbConnection.getConnection();

    public static void insertData() {
        String sql = "insert into student(id, name) values(1 , 'Mahbub')";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Insert Data");
        } catch (SQLException ex) {
            Logger.getLogger(InsertIntoTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insertData2(int id, String name) {
        String sql = "insert into student(id, name) values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
            System.out.println("Insert Data Success");
        } catch (SQLException ex) {
            Logger.getLogger(InsertIntoTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //////////////////Update//////////////////////////////////
    public static void updateData(int id, String name) {
        String sql = "update student set name=? where id=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Update Data suceses");
        } catch (SQLException ex) {
            Logger.getLogger(InsertIntoTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //////////////////Delete//////////////////////
    public static void deleteData(int id) {
        String sql = "delete from student where id=? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Delete Data suceses");
        } catch (SQLException ex) {
            Logger.getLogger(InsertIntoTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //////////////////Query//////////////////////
    public static ResultSet getDataById(int id) {
        ResultSet rs = null;
        String sql = "select * from student where id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
           rs= ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(InsertIntoTable.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }

    public static void main(String[] args) {
        // InsertIntoTable.insertData();

        //InsertIntoTable.insertData2(4, "Kotha");
        // updateData(4, "asha");
        //deleteData(3);
        getDataById(1);
    }

}
