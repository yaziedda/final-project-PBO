/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.pbo.dao.impl;

import finalproject.pbo.dao.LoginDao;
import finalproject.pbo.konfigurasi.KoneksiDatabase;
import finalproject.pbo.model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dizzay
 */
public class LoginDaoImpl implements LoginDao {
    
    private final Connection koneksiDatabase;

    public LoginDaoImpl() {
        this.koneksiDatabase = KoneksiDatabase.koneksiDB();
    }

    @Override
    public UserModel login(String username, String password) {
        String query = "SELECT nama, username, latest_login FROM app_user_data WHERE username = ? and password = ?";
        UserModel userModel = null;
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            ResultSet hasilQuery = preparedStatement.executeQuery();
            
            while(hasilQuery.next()){
                userModel = new UserModel();
                userModel.setNama(hasilQuery.getString("nama"));
                userModel.setUsername(hasilQuery.getString("username"));
                userModel.setLatestLogin(hasilQuery.getString("latest_login"));
            }
            return userModel;
        } catch (SQLException ex) {
            Logger.getLogger(LoginDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
