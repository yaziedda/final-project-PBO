/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.pbo.dao.impl;

import finalproject.pbo.konfigurasi.KoneksiDatabase;
import finalproject.pbo.model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class UserDaoImpl {
    
    private final Connection koneksiDatabase;

    public UserDaoImpl() {
        this.koneksiDatabase = KoneksiDatabase.koneksiDB();
    }

    public List<UserModel> getList() {
        String namaTable = "app_user_data";
        String query = "SELECT * FROM "+namaTable;
        UserModel model;
        List<UserModel> list = new ArrayList<>();
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new UserModel();
                model.setId(hasilQuery.getInt("id"));
                model.setNama(hasilQuery.getString("nama"));
                model.setUsername(hasilQuery.getString("username"));
                model.setRole(hasilQuery.getString("role"));
                list.add(model);
            }            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public UserModel byId(int id){
        String namaTable = "app_user_data";
        String query = "SELECT * FROM "+namaTable+" WHERE id = "+id;
        UserModel model = null;
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new UserModel();
                model.setId(hasilQuery.getInt("id"));
                model.setNama(hasilQuery.getString("nama"));
                model.setUsername(hasilQuery.getString("username"));
                model.setRole(hasilQuery.getString("role"));
            }            
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    public boolean update(String nama, String username, String password, String role, int id) {
        String namaTable = "app_user_data";
        String query;
        if(password.isEmpty()){
            query = "UPDATE `app_user_data` SET `nama`='"+nama+"', `username`='"+username+"', `role`="+role+" WHERE  `id`="+id+";";
        } else {
            query = "UPDATE `app_user_data` SET `nama`='"+nama+"', `username`='"+username+"', `password`='"+password+"', `role`="+role+" WHERE  `id`="+id+";";
        }
        
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.execute();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean insert(String nama, String username, String password, String role) {
        String namaTable = "app_user_data";
        String query = "INSERT INTO `app_user_data` (`nama`, `username`, `password`, `role`) VALUES ('"+nama+"', '"+username+"','"+password+"', '"+role+"');";
        
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.execute();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean delete(String id) {
        String namaTable = "app_user_data";
        String query = "DELETE FROM "+namaTable+" WHERE id = "+id;
        
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.execute();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
