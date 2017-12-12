/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.pbo.model;

/**
 *
 * @author Dizzay
 */
public class TransaksiModel {
    
    private String id;
    private UserRegistModel userRegistModel;
    private BarangModel barangModel;
    private String qty;
    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    public UserRegistModel getUserRegistModel() {
        return userRegistModel;
    }

    public void setUserRegistModel(UserRegistModel userRegistModel) {
        this.userRegistModel = userRegistModel;
    }

    public BarangModel getBarangModel() {
        return barangModel;
    }

    public void setBarangModel(BarangModel barangModel) {
        this.barangModel = barangModel;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
