/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.pbo.dao.impl;

import finalproject.pbo.dao.UserDataDao;
import finalproject.pbo.konfigurasi.KoneksiDatabase;
import finalproject.pbo.model.UserModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dizzay
 */
public class UserDataDaoImpl implements UserDataDao {
    
    private final Connection koneksiDatabase;

    public UserDataDaoImpl() {
        this.koneksiDatabase = KoneksiDatabase.koneksiDB();
    }    

    @Override
    public List<UserModel> getUser() {
        List<UserModel> list = new ArrayList<>();
        try {
            Statement statement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = statement.executeQuery("SELECT * FROM app_user_data");
            
            while(hasilQuery.next()){
                UserModel model = new UserModel();
                model.setNama(hasilQuery.getString("nama"));
                model.setUsername(hasilQuery.getString("username"));
                model.setLatestLogin(hasilQuery.getString("latest_login"));
                list.add(model);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserDataDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        }
    }
    
}
