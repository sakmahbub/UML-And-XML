/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author User
 */
public class CreateTableUsingMysql {

    private static final Connection con = MySqlDbConnection.getConnection();

    private static void createTable() {

        String tbl = "create table student(id int(15) primary key, name varchar(25))";
        try {
            PreparedStatement ps = con.prepareStatement(tbl);
            ps.execute();
            
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {

        createTable();
    }

}
