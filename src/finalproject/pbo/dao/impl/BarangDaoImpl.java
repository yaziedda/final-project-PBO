/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.pbo.dao.impl;

import finalproject.pbo.konfigurasi.KoneksiDatabase;
import finalproject.pbo.model.BarangModel;
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
public class BarangDaoImpl {

    private final Connection koneksiDatabase;

    public BarangDaoImpl() {
        this.koneksiDatabase = KoneksiDatabase.koneksiDB();
    }

    public List<BarangModel> getList() {
        String namaTable = "master_barang";
        String query = "select a.*, coalesce(sum(b.qty), 0) as dipinjam, (a.qty - coalesce(sum(b.qty), 0)) as sisa\n"
                + "from master_barang a\n"
                + "left join trx_pinjam b\n"
                + "on a.id = b.id_barang\n"
                + "group by a.id";
        BarangModel model;
        List<BarangModel> list = new ArrayList<>();
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);

            while (hasilQuery.next()) {
                model = new BarangModel();
                model.setId(hasilQuery.getInt("id"));
                model.setNama(hasilQuery.getString("nama"));
                model.setQty(hasilQuery.getString("qty"));
                model.setDiPinjam(hasilQuery.getString("dipinjam"));
                model.setSisa(hasilQuery.getString("sisa"));
                list.add(model);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<BarangModel> searchBarang(String nama) {
        String namaTable = "master_barang";
        String query = "select a.*, coalesce(sum(b.qty), 0) as dipinjam, (a.qty - coalesce(sum(b.qty), 0)) as sisa\n"
                + "from master_barang a\n"
                + "left join trx_pinjam b\n"
                + "on a.id = b.id_barang\n"
                + "WHERE a.nama LIKE '%" + nama + "%'\n"
                + "group by a.id";
        System.out.println(query);
        BarangModel model;
        List<BarangModel> list = new ArrayList<>();
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);

            while (hasilQuery.next()) {
                model = new BarangModel();
                model.setId(hasilQuery.getInt("id"));
                model.setNama(hasilQuery.getString("nama"));
                model.setQty(hasilQuery.getString("qty"));
                model.setDiPinjam(hasilQuery.getString("dipinjam"));
                model.setSisa(hasilQuery.getString("sisa"));
                list.add(model);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public BarangModel byId(int id) {
        String namaTable = "master_barang";
        String query = "SELECT * FROM " + namaTable + " WHERE id = " + id;
        BarangModel model = null;
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);

            while (hasilQuery.next()) {
                model = new BarangModel();
                model.setId(hasilQuery.getInt("id"));
                model.setNama(hasilQuery.getString("nama"));
                model.setQty(hasilQuery.getString("qty"));
            }
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean update(String nama, String qty, int id) {
        String namaTable = "master_barang";
        String query = "UPDATE " + namaTable + " SET `nama`='" + nama + "', `qty`=" + qty + " WHERE  `id`=" + id + ";";

        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean insert(String nama, String qty) {
        String namaTable = "master_barang";
        String query = "INSERT INTO " + namaTable + " (`nama`, `qty`) VALUES ('" + nama + "', '" + qty + "');";

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
        String namaTable = "master_barang";
        String query = "DELETE FROM " + namaTable + " WHERE id = " + id;

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
