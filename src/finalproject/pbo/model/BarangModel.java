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
public class BarangModel {
    
    private int id;
    private String nama;
    private String qty;
    private String diPinjam;
    private String sisa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getDiPinjam() {
        return diPinjam;
    }

    public void setDiPinjam(String diPinjam) {
        this.diPinjam = diPinjam;
    }

    public String getSisa() {
        return sisa;
    }

    public void setSisa(String sisa) {
        this.sisa = sisa;
    }
    
    
    
}
