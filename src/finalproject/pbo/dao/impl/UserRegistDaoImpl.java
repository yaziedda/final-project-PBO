/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.pbo.dao.impl;

import finalproject.pbo.konfigurasi.KoneksiDatabase;
import finalproject.pbo.model.BarangModel;
import finalproject.pbo.model.UserRegistModel;
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
public class UserRegistDaoImpl {
    
    private final Connection koneksiDatabase;

    public UserRegistDaoImpl() {
        this.koneksiDatabase = KoneksiDatabase.koneksiDB();
    }

    public List<UserRegistModel> getList() {
        String namaTable = "app_user_regist";
        String query = "SELECT * FROM "+namaTable;
        UserRegistModel model;
        List<UserRegistModel> list = new ArrayList<>();
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new UserRegistModel();
                model.setId(hasilQuery.getInt("id"));
                model.setNama(hasilQuery.getString("nama"));
                model.setKtp(hasilQuery.getString("ktp"));
                model.setNik(hasilQuery.getString("nik"));
                model.setBagian(hasilQuery.getString("bagian"));
                list.add(model);
            }            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public UserRegistModel byId(int id){
        String namaTable = "app_user_regist";
        String query = "SELECT * FROM "+namaTable+" WHERE id = "+id;
        UserRegistModel model = null;
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new UserRegistModel();
                model.setId(hasilQuery.getInt("id"));
                model.setNama(hasilQuery.getString("nama"));
                model.setKtp(hasilQuery.getString("ktp"));
                model.setNik(hasilQuery.getString("nik"));
                model.setBagian(hasilQuery.getString("bagian"));
            }            
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public UserRegistModel searchKtp(String ktp){
        String namaTable = "app_user_regist";
        String query = "SELECT * FROM "+namaTable+" WHERE ktp = '"+ktp+"'";
        UserRegistModel model = null;
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new UserRegistModel();
                model.setId(hasilQuery.getInt("id"));
                model.setNama(hasilQuery.getString("nama"));
                model.setKtp(hasilQuery.getString("ktp"));
                model.setNik(hasilQuery.getString("nik"));
                model.setBagian(hasilQuery.getString("bagian"));
            }            
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    public boolean update(String ktp, String nama, String nik, String bagian, int id) {
        String namaTable = "app_user_regist";
        String query = "UPDATE "+namaTable+" SET `ktp`='"+nama+"', `nama`='"+nama+"', `nik`='"+nik+"', `bagian`='"+bagian+"' WHERE  `id`="+id+";";
        
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.execute();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean insert(String ktp, String nama, String nik, String bagian) {
        String namaTable = "app_user_regist";
        String query = "INSERT INTO "+namaTable+" (`ktp`, `nama`, `nik`, `bagian`) VALUES ('"+ktp+"', '"+nama+"','"+nik+"', '"+bagian+"');";
        
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
        String namaTable = "app_user_regist";
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
