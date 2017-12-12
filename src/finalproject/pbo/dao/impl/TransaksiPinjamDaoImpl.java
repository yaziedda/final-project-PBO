/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.pbo.dao.impl;

import finalproject.pbo.konfigurasi.KoneksiDatabase;
import finalproject.pbo.model.BarangModel;
import finalproject.pbo.model.TransaksiModel;
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
public class TransaksiPinjamDaoImpl {

    private final Connection koneksiDatabase;

    public TransaksiPinjamDaoImpl() {
        this.koneksiDatabase = KoneksiDatabase.koneksiDB();
    }

    public boolean insert(String idUser, String idBarang, String jumlah) {
        String query = "INSERT INTO `fp_pbo`.`trx_pinjam` (`id_user`, `id_barang`, `qty`) VALUES ('" + idUser + "', '" + idBarang + "', '" + jumlah + "');";
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<TransaksiModel> search(String nama) {
        String query = "select a.id, b.nama as nama_user, c.nama as nama_barang, a.qty, a.created_at from trx_pinjam a\n"
                + "inner join app_user_regist b\n"
                + "on a.id_user = b.id\n"
                + "inner join master_barang c\n"
                + "on a.id_barang = c.id\n"
                + "where b.ktp = '" + nama + "'\n"
                + "and a.status = 0";
        System.out.println(query);
        TransaksiModel model;
        List<TransaksiModel> list = new ArrayList<>();
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);

            while (hasilQuery.next()) {
                model = new TransaksiModel();
                model.setId(hasilQuery.getString("id"));

                UserRegistModel userRegistModel = new UserRegistModel();
                userRegistModel.setNama(hasilQuery.getString("nama_user"));

                BarangModel barangModel = new BarangModel();
                barangModel.setNama(hasilQuery.getString("nama_barang"));

                model.setUserRegistModel(userRegistModel);
                model.setBarangModel(barangModel);
                model.setQty(hasilQuery.getString("qty"));
                model.setDate(hasilQuery.getString("created_at"));
                list.add(model);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public TransaksiModel searchById(String id) {
        String query = "select a.id, b.nama as nama_user, c.nama as nama_barang, a.qty, a.created_at,\n"
                + "b.nik, b.ktp\n"
                + "from trx_pinjam a\n"
                + "inner join app_user_regist b\n"
                + "on a.id_user = b.id\n"
                + "inner join master_barang c\n"
                + "on a.id_barang = c.id\n"
                + "where a.id = '" + id + "'";
        System.out.println(query);
        TransaksiModel model = null;
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);

            while (hasilQuery.next()) {
                model = new TransaksiModel();
                model.setId(hasilQuery.getString("id"));

                UserRegistModel userRegistModel = new UserRegistModel();
                userRegistModel.setNama(hasilQuery.getString("nama_user"));
                userRegistModel.setKtp(hasilQuery.getString("ktp"));
                userRegistModel.setNik(hasilQuery.getString("nik"));

                BarangModel barangModel = new BarangModel();
                barangModel.setNama(hasilQuery.getString("nama_barang"));

                model.setUserRegistModel(userRegistModel);
                model.setBarangModel(barangModel);
                model.setQty(hasilQuery.getString("qty"));
                model.setDate(hasilQuery.getString("created_at"));
            }
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean kembalikan(String id) {
        String query = "UPDATE trx_pinjam SET status = 1 WHERE id = "+id;
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
