/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.pbo.konfigurasi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dizzay
 */
public class KoneksiDatabase {
    
    private static Connection mysqlkonek;
    
    public static Connection koneksiDB() {
        if(mysqlkonek==null){
            try {
                String DB="jdbc:mysql://localhost:3306/fp_pbo"; // fp_pbo database
                String user="root"; // user database
                String pass=""; // password database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkonek = (Connection) DriverManager.getConnection(DB,user,pass);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Koneksi Gagal, pastikan MySQL berjalan !");
            }
        }
        return mysqlkonek;
    }
    
}
