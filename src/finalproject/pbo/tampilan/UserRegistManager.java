/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.pbo.tampilan;

import finalproject.pbo.dao.impl.BarangDaoImpl;
import finalproject.pbo.dao.impl.UserRegistDaoImpl;
import finalproject.pbo.model.BarangModel;
import finalproject.pbo.model.UserRegistModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dizzay
 */
public class UserRegistManager extends javax.swing.JFrame {

    /**
     * Creates new form UserRegistManager
     */
    
    UserRegistDaoImpl daoImpl;
    DefaultTableModel dtm;
    UserRegistModel modelGlobal = null;
    
    public UserRegistManager() {
        initComponents();
        daoImpl = new UserRegistDaoImpl();
        tampilData();
    }
    
    private void tampilData() {
        String[] kolom = {"ID", "KTP", "Nama", "NIK", "Bagian"};
        dtm = new DefaultTableModel(null, kolom);
        for (UserRegistModel model : daoImpl.getList()) {
            String[] row = new String[kolom.length];
            row[0] = String.valueOf(model.getId());
            row[1] = model.getKtp();
            row[2] = model.getNama();
            row[3] = model.getNik();
            row[4] = model.getBagian();
            dtm.addRow(row);
        }
        tbl_main.setModel(dtm);
        tbl_main.clearSelection();
    }

    private void clearData() {
        modelGlobal = null;
        tf_ktp.setText("");
        tf_nama.setText("");
        tf_nik.setText("");
        tf_bagian.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tf_ktp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_nik = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_bagian = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_main = new javax.swing.JTable();
        bt_simpan = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        bt_clear = new javax.swing.JButton();
        bt_tutup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("User Register");

        jButton1.setText("Refresh");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel2.setText("KTP");

        jLabel3.setText("Nama");

        jLabel4.setText("NIK");

        tf_nik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nikActionPerformed(evt);
            }
        });

        jLabel5.setText("Bagian");

        tbl_main.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_mainMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_main);

        bt_simpan.setText("Simpan");
        bt_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_simpanMouseClicked(evt);
            }
        });

        bt_delete.setText("Delete");
        bt_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_deleteMouseClicked(evt);
            }
        });
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        bt_clear.setText("Clear");
        bt_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_clearMouseClicked(evt);
            }
        });

        bt_tutup.setText("Tutup");
        bt_tutup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_tutupMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(tf_nama)
                    .addComponent(tf_nik)
                    .addComponent(tf_bagian)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_clear))
                    .addComponent(tf_ktp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_tutup)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_tutup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_nik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_bagian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_simpan)
                            .addComponent(bt_delete)
                            .addComponent(bt_clear))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nikActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        // TODO add your handling code here:
        if(modelGlobal != null){
            daoImpl.delete(String.valueOf(modelGlobal.getId()));
            tampilData();
            clearData();
        }
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void tbl_mainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_mainMouseClicked
        // TODO add your handling code here:
        String id = (String) tbl_main.getValueAt(tbl_main.getSelectedRow(), 0);
        UserRegistModel model = daoImpl.byId(Integer.valueOf(id));
        modelGlobal = model;
        tf_ktp.setText(model.getKtp());
        tf_nama.setText(model.getNama());
        tf_nik.setText(model.getNik());
        tf_bagian.setText(model.getBagian());
    }//GEN-LAST:event_tbl_mainMouseClicked

    private void bt_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_simpanMouseClicked
        // TODO add your handling code here:
        String ktp = tf_ktp.getText();
        String nama = tf_nama.getText();
        String nik = tf_nik.getText();
        String bagian = tf_bagian.getText();
        
        if(!ktp.isEmpty() && !nama.isEmpty() && !nik.isEmpty() && !bagian.isEmpty()){
            if(modelGlobal != null){
                daoImpl.update(ktp, nama, nik, bagian, modelGlobal.getId());
            }else{
                daoImpl.insert(ktp, nama, nik, bagian);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tidak Boleh Ada Yang Kosong !");
        }
        tampilData();
        clearData();
    }//GEN-LAST:event_bt_simpanMouseClicked

    private void bt_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_deleteMouseClicked
        // TODO add your handling code here:
        if(modelGlobal != null){
            daoImpl.delete(String.valueOf(modelGlobal.getId()));
            tampilData();
            clearData();
        }
    }//GEN-LAST:event_bt_deleteMouseClicked

    private void bt_clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_clearMouseClicked
        // TODO add your handling code here:
        clearData();
    }//GEN-LAST:event_bt_clearMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        tampilData();
        clearData();
    }//GEN-LAST:event_jButton1MouseClicked

    private void bt_tutupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_tutupMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_bt_tutupMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserRegistManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserRegistManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserRegistManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserRegistManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRegistManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_clear;
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JButton bt_tutup;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_main;
    private javax.swing.JTextField tf_bagian;
    private javax.swing.JTextField tf_ktp;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_nik;
    // End of variables declaration//GEN-END:variables
}