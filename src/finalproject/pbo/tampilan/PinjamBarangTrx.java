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
import finalproject.pbo.model.UserRegistModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dizzay
 */
public class PinjamBarangTrx extends javax.swing.JFrame {

    /**
     * Creates new form PinjamBarangTrx
     */
    BarangDaoImpl barangDaoImpl;
    UserRegistDaoImpl userRegistDaoImpl;
    TransaksiPinjamDaoImpl transaksiPinjamDaoImpl;
    DefaultTableModel dtm;
    BarangModel barangModelGlobal = null;

    public PinjamBarangTrx() {
        initComponents();
        barangDaoImpl = new BarangDaoImpl();
        userRegistDaoImpl = new UserRegistDaoImpl();
        transaksiPinjamDaoImpl = new TransaksiPinjamDaoImpl();
        String[] kolom = {"ID", "Nama", "Qty", "Di Pinjam", "Sisa"};
        dtm = new DefaultTableModel(null, kolom);
        tbl_main.setModel(dtm);
    }

    private void tampilData(String nama) {
        String[] kolom = {"ID", "Nama", "Qty", "Di Pinjam", "Sisa"};
        dtm = new DefaultTableModel(null, kolom);
        for (BarangModel model : barangDaoImpl.searchBarang(nama)) {
            String[] row = new String[kolom.length];
            row[0] = String.valueOf(model.getId());
            row[1] = model.getNama();
            row[2] = String.valueOf(model.getQty());
            row[3] = model.getDiPinjam();
            row[4] = model.getSisa();
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
        tf_cari = new javax.swing.JTextField();
        bt_cari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_main = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tf_ktp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lb_nama_barang = new javax.swing.JLabel();
        bt_pinjam = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tf_jumlah = new javax.swing.JTextField();
        bt_tutup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pinjam Barang");

        tf_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_cariKeyPressed(evt);
            }
        });

        bt_cari.setText("Cari");
        bt_cari.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bt_cariMouseDragged(evt);
            }
        });
        bt_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_cariMouseClicked(evt);
            }
        });
        bt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_cariKeyPressed(evt);
            }
        });

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

        jLabel2.setText("KTP");

        jLabel3.setText("Nama Barang");

        lb_nama_barang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        bt_pinjam.setText("Pinjam");
        bt_pinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_pinjamMouseClicked(evt);
            }
        });
        bt_pinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_pinjamActionPerformed(evt);
            }
        });

        jLabel4.setText("Jumlah");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tf_cari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cari))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(tf_ktp)
                            .addComponent(jLabel3)
                            .addComponent(lb_nama_barang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_pinjam)
                            .addComponent(jLabel4)
                            .addComponent(tf_jumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_tutup)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bt_tutup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_cari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_ktp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_nama_barang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tf_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_pinjam)
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cariMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_cariMouseDragged
        // TODO add your handling code here:

    }//GEN-LAST:event_bt_cariMouseDragged

    private void tbl_mainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_mainMouseClicked
        // TODO add your handling code here:
        String id = (String) tbl_main.getValueAt(tbl_main.getSelectedRow(), 0);
        BarangModel model = barangDaoImpl.byId(Integer.valueOf(id));
        lb_nama_barang.setText(model.getNama());
        String sisa = (String) tbl_main.getValueAt(tbl_main.getSelectedRow(), 4);
        String diPinjam = (String) tbl_main.getValueAt(tbl_main.getSelectedRow(), 3);
        model.setDiPinjam(diPinjam);
        model.setSisa(sisa);
        barangModelGlobal = model;
    }//GEN-LAST:event_tbl_mainMouseClicked

    private void bt_cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_cariMouseClicked
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_bt_cariMouseClicked

    private void bt_cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_cariKeyPressed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_bt_cariKeyPressed

    private void tf_cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cariKeyPressed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_tf_cariKeyPressed

    private void bt_pinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_pinjamMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bt_pinjamMouseClicked

    private void bt_tutupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_tutupMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_bt_tutupMouseClicked

    private void bt_tutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tutupActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_bt_tutupActionPerformed

    private void bt_pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_pinjamActionPerformed
        // TODO add your handling code here:
        String ktp = tf_ktp.getText();
        String qty = tf_jumlah.getText();
        UserRegistModel userRegistModel = userRegistDaoImpl.searchKtp(ktp);
        if (barangModelGlobal != null) {
            if (userRegistModel != null) {
                if (!qty.isEmpty() && Integer.valueOf(qty) <= Integer.valueOf(barangModelGlobal.getSisa())) {
                    String rincian = "Nama Peminjam : "+userRegistModel.getNama()
                            +"\nKTP : "+userRegistModel.getKtp()
                            +"\nNIK : "+userRegistModel.getNik()
                            +"\nNama Barang : "+barangModelGlobal.getNama()
                            +"\nJumlah : "+qty
                            +"\n\nApakah benar ?";
                    String[] options = new String[]{"Ya", "Tidak"};
                    int response = JOptionPane.showOptionDialog(null, rincian,
                            "Konfirmasi", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                    if (response == 0) {
                        if (transaksiPinjamDaoImpl.insert(String.valueOf(userRegistModel.getId()), String.valueOf(barangModelGlobal.getId()), qty)) {
                            JOptionPane.showMessageDialog(null, "Transaksi berhasil !");
                            options = new String[]{"Ya", "Tidak"};
                            response = JOptionPane.showOptionDialog(null, "Ada transaksi lagi?",
                                    "Konfirmasi", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                            if (response == 0) {
                                tf_jumlah.setText("");
                                lb_nama_barang.setText("");
                                barangModelGlobal = null;
                            } else if (response == 1) {
                                this.setVisible(false);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Transaksi gagal coba beberapa saat lagi");
                        }
                    } else {

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Jumlah minimal 1 dan tidak lebih dari "+barangModelGlobal.getSisa());
                }
            } else {
                JOptionPane.showMessageDialog(null, "User tidak terdaftar, silahkan daftar terlebih dahulu !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih terlebih dahulu !");
        }
    }//GEN-LAST:event_bt_pinjamActionPerformed

    private void cari() {
        String nama = tf_cari.getText();
        tampilData(nama);
    }

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
            java.util.logging.Logger.getLogger(PinjamBarangTrx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PinjamBarangTrx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PinjamBarangTrx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PinjamBarangTrx.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PinjamBarangTrx().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cari;
    private javax.swing.JButton bt_pinjam;
    private javax.swing.JButton bt_tutup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_nama_barang;
    private javax.swing.JTable tbl_main;
    private javax.swing.JTextField tf_cari;
    private javax.swing.JTextField tf_jumlah;
    private javax.swing.JTextField tf_ktp;
    // End of variables declaration//GEN-END:variables
}
