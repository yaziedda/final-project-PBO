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
public class UserModel {
    private int id;
    private String nama;
    private String username;
    private String role;
    private String latestLogin;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    

    public String getLatestLogin() {
        return latestLogin;
    }

    public void setLatestLogin(String latestLogin) {
        this.latestLogin = latestLogin;
    }
    
    
}
