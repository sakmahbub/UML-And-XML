/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcCrudCoonection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class InsertIntoTable {

    private static Connection con = JdbcConnection.getConnection();

    public static void insertData(Student s) {
        String indata = "insert into studen(id, name, email) values(?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(indata);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getEmail());
            ps.executeUpdate();

            System.out.println("Insert Data Success");

        } catch (SQLException ex) {
            Logger.getLogger(InsertIntoTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ///////////////////////Update////////////////////////////////
    public static void updateData(Student s) {
        String updata = "update studen set name=?, email=? where id=? ";

        try {
            PreparedStatement ps = con.prepareStatement(updata);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setInt(3, s.getId());

            ps.executeUpdate();

            System.out.println("Update Data suceses");

        } catch (SQLException ex) {
            Logger.getLogger(InsertIntoTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //////////////Delete /////////////////////
    public static void deleteData(Student s) {
        String dedata = "delete from studen where id=? ";

        try {
            PreparedStatement ps = con.prepareStatement(dedata);

            ps.setInt(1, s.getId());

            ps.executeUpdate();

            System.out.println("Delete Data suceses");

        } catch (SQLException ex) {
            Logger.getLogger(InsertIntoTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
