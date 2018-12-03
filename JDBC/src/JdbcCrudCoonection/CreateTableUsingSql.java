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
public class CreateTableUsingSql {
    
    private static Connection con= JdbcConnection.getConnection();
    
    
    private static void createTable(){
    String tbl="create table studen(id int(10) primary key, name varchar(30), email varchar(20))";
    
        try {
            PreparedStatement ps=con.prepareStatement(tbl);
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(CreateTableUsingSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void main(String[] args) {
        createTable();
    }
    
}
