/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject.pbo.tampilan;

import finalproject.pbo.dao.impl.BarangDaoImpl;
import finalproject.pbo.dao.impl.TransaksiPinjamDaoImpl;
import finalproject.pbo.dao.impl.UserRegistDaoImpl;
import finalproject.pbo.model.BarangModel;
import finalproject.pbo.model.TransaksiModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dizzay
 */
public class KembaliBarangTrx extends javax.swing.JFrame {

    /**
     * Creates new form KembaliBarangTrx
     */
    BarangDaoImpl barangDaoImpl;
    UserRegistDaoImpl userRegistDaoImpl;
    TransaksiPinjamDaoImpl transaksiPinjamDaoImpl;
    DefaultTableModel dtm;
    BarangModel barangModelGlobal = null;

    public KembaliBarangTrx() {
        initComponents();
        barangDaoImpl = new BarangDaoImpl();
        userRegistDaoImpl = new UserRegistDaoImpl();
        transaksiPinjamDaoImpl = new TransaksiPinjamDaoImpl();
        setTableAndView();
    }
    
    private void setTableAndView(){
        String[] kolom = {"ID", "Nama Peminjam", "Nama Barang", "Jumlah", "Tanggal Pinjam"};
        dtm = new DefaultTableModel(null, kolom);
        tbl_main.setModel(dtm);
        lb_nik.setText("");
        lb_ktp.setText("");
        lb_nama.setText("");
        lb_nama_barang.setText("");
        lb_jumlah.setText("");
        lb_tanggal.setText("");
        tf_cari.setText("");
    }

    private void tampilData(String nama) {
        String[] kolom = {"ID", "Nama Peminjam", "Nama Barang", "Jumlah", "Tanggal Pinjam"};
        dtm = new DefaultTableModel(null, kolom);
        for (TransaksiModel model : transaksiPinjamDaoImpl.search(nama)) {
            String[] row = new String[kolom.length];
            row[0] = String.valueOf(model.getId());
            row[1] = model.getUserRegistModel().getNama();
            row[2] = model.getBarangModel().getNama();
            row[3] = model.getQty();
            row[4] = model.getDate();
            dtm.addRow(row);
        }
        tbl_main.setModel(dtm);
        tbl_main.clearSelection();
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
        bt_tutup = new javax.swing.JButton();
        tf_cari = new javax.swing.JTextField();
        bt_cari = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_main = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lb_nama = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lb_ktp = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb_nik = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lb_nama_barang = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lb_jumlah = new javax.swing.JLabel();
        bt_kembalikan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lb_tanggal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kembali Barang");

        bt_tutup.setText("Tutup");
        bt_tutup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_tutupMouseClicked(evt);
            }
        });
        bt_tutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tutupActionPerformed(evt);
            }
        });

        bt_cari.setText("Cari");
        bt_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_cariMouseClicked(evt);
            }
        });
        bt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cariActionPerformed(evt);
            }
        });

        jLabel2.setText("Masukan No KTP");

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
        tbl_main.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl_mainKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_main);

        jLabel3.setText("Nama");

        lb_nama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_nama.setText("Yazied DA");

        jLabel4.setText("KTP");

        lb_ktp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_ktp.setText("123");

        jLabel6.setText("NIK");

        lb_nik.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_nik.setText("321");

        jLabel8.setText("Nama Barang");

        lb_nama_barang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_nama_barang.setText("Lenovo");

        jLabel10.setText("Jumlah");

        lb_jumlah.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_jumlah.setText("1");

        bt_kembalikan.setText("Kembalikan");
        bt_kembalikan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_kembalikanMouseClicked(evt);
            }
        });
        bt_kembalikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_kembalikanActionPerformed(evt);
            }
        });

        jLabel5.setText("Tanggal");

        lb_tanggal.setText("123-123-12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_kembalikan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_cari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cari))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_tutup))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lb_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(lb_nama_barang)
                            .addComponent(jLabel10)
                            .addComponent(lb_jumlah))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 182, Short.MAX_VALUE))
                                    .addComponent(lb_ktp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(lb_nik, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(lb_tanggal))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_tutup)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_cari)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nama))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_ktp))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nik)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nama_barang)
                    .addComponent(lb_tanggal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_jumlah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_kembalikan)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_kembalikanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_kembalikanMouseClicked
        // TODO add your handling code here:
        String id = (String) tbl_main.getValueAt(tbl_main.getSelectedRow(), 0);
        transaksiPinjamDaoImpl.kembalikan(id);
        setTableAndView();
    }//GEN-LAST:event_bt_kembalikanMouseClicked

    private void bt_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_cariMouseClicked
        // TODO add your handling code here:
        String ktp = tf_cari.getText();
        if (!ktp.isEmpty()) {
            tampilData(ktp);
        } else {
            JOptionPane.showMessageDialog(null, "KTP Tidak boleh kosong !");
        }
    }//GEN-LAST:event_bt_cariMouseClicked

    private void bt_tutupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_tutupMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_tutupMouseClicked

    private void tbl_mainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_mainMouseClicked
        // TODO add your handling code here:
        String id = (String) tbl_main.getValueAt(tbl_main.getSelectedRow(), 0);
        TransaksiModel model = transaksiPinjamDaoImpl.searchById(id);
        if (model != null) {
            lb_nik.setText(model.getUserRegistModel().getNik());
            lb_ktp.setText(model.getUserRegistModel().getKtp());
            lb_nama.setText(model.getUserRegistModel().getNama());
            lb_nama_barang.setText(model.getBarangModel().getNama());
            lb_jumlah.setText(model.getQty());
            lb_tanggal.setText(model.getDate());
        }
    }//GEN-LAST:event_tbl_mainMouseClicked

    private void bt_kembalikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_kembalikanActionPerformed
        // TODO add your handling code here:
        String id = (String) tbl_main.getValueAt(tbl_main.getSelectedRow(), 0);
        TransaksiModel model = transaksiPinjamDaoImpl.searchById(id);
        if (model != null) {
            lb_nik.setText(model.getUserRegistModel().getNik());
            lb_ktp.setText(model.getUserRegistModel().getKtp());
            lb_nama.setText(model.getUserRegistModel().getNama());
            lb_nama_barang.setText(model.getBarangModel().getNama());
            lb_jumlah.setText(model.getQty());
            lb_tanggal.setText(model.getDate());
        }
    }//GEN-LAST:event_bt_kembalikanActionPerformed

    private void bt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cariActionPerformed
        // TODO add your handling code here:
        String ktp = tf_cari.getText();
        if (!ktp.isEmpty()) {
            tampilData(ktp);
        } else {
            JOptionPane.showMessageDialog(null, "KTP Tidak boleh kosong !");
        }
    }//GEN-LAST:event_bt_cariActionPerformed

    private void tbl_mainKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_mainKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_mainKeyPressed

    private void bt_tutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tutupActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_bt_tutupActionPerformed

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
            java.util.logging.Logger.getLogger(KembaliBarangTrx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KembaliBarangTrx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KembaliBarangTrx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KembaliBarangTrx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KembaliBarangTrx().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cari;
    private javax.swing.JButton bt_kembalikan;
    private javax.swing.JButton bt_tutup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_jumlah;
    private javax.swing.JLabel lb_ktp;
    private javax.swing.JLabel lb_nama;
    private javax.swing.JLabel lb_nama_barang;
    private javax.swing.JLabel lb_nik;
    private javax.swing.JLabel lb_tanggal;
    private javax.swing.JTable tbl_main;
    private javax.swing.JTextField tf_cari;
    // End of variables declaration//GEN-END:variables
}
