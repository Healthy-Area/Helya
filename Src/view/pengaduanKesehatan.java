/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.PengaduanKesehatanController;
import raven.datetime.DatePicker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Aspire5
 */
public class pengaduanKesehatan extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(pengaduanKesehatan.class.getName());
    private DatePicker datePicker;
    private int originalY_TextField5;
    private int originalY_Label2;

    /**
     * Creates new form pengaduanKesehatan
     */
    public pengaduanKesehatan() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
javax.swing.ButtonGroup group = new javax.swing.ButtonGroup();
    group.add(jRadioButton1); // Sakit
    group.add(jRadioButton2); // Sehat

    // default: Sehat terpilih
    jRadioButton2.setSelected(true);

    // ====== KONDISI AWAL (Sehat) ======
    panelAtas.setVisible(true);       // tombol bawah sembunyi
    panelBawah.setVisible(false);         // tombol atas tetap tampil
    jLabelNamaPenyakit.setVisible(false);
    jTextFieldNamaPenyakit.setVisible(false);
    jLabelTanggalSakit.setVisible(false);
    datePickerSakit.setVisible(false);
    tanggal_riwayat_penyakit.setVisible(false);

    // ====== RADIO "SAKIT" DIPILIH ======
    jRadioButton1.addActionListener(e -> {
        panelBawah.setVisible(true);    // tombol atas sembunyi
        panelAtas.setVisible(false);    // tombol bawah tampil

        jLabelNamaPenyakit.setVisible(true);
        jTextFieldNamaPenyakit.setVisible(true);
        jLabelTanggalSakit.setVisible(true);
        datePickerSakit.setVisible(true);
        tanggal_riwayat_penyakit.setVisible(true);
jPanel1.setPreferredSize(new java.awt.Dimension(802, 1200));

        jPanel1.revalidate();
        jPanel1.repaint();
    });

    // ====== RADIO "SEHAT" DIPILIH ======
    jRadioButton2.addActionListener(e -> {
        panelBawah.setVisible(false);     // tombol atas tampil
        panelAtas.setVisible(true);   // tombol bawah sembunyi

        jLabelNamaPenyakit.setVisible(false);
        jTextFieldNamaPenyakit.setVisible(false);
        jLabelTanggalSakit.setVisible(false);
        datePickerSakit.setVisible(false);
        tanggal_riwayat_penyakit.setVisible(false);

        jPanel1.revalidate();
        jPanel1.repaint();
    });

    // tombol atas memanggil aksi kirim yang sama dengan tombol bawah
    jButton3Atas.addActionListener(evt -> jButton3BawahActionPerformed(evt));
    

// Jika mau, sambungkan kedua tombol ke handler yang sama:

        
jPanel1.setComponentZOrder(jLabel1, jPanel1.getComponentCount() - 1);

// Radio button & input di depan background
jPanel1.setComponentZOrder(jRadioButton1, 0);
jPanel1.setComponentZOrder(jRadioButton2, 0);
jPanel1.setComponentZOrder(jTextFieldNamaPenyakit, 0);
jPanel1.setComponentZOrder(jLabelNamaPenyakit, 0);

    jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.getVerticalScrollBar().setUnitIncrement(16); // smooth scroll
    
    jScrollPane1.setBorder(null); // hilangkan garis border scrollpane
    jScrollPane1.getViewport().setBackground(java.awt.Color.WHITE); 
    jPanel1.setBackground(java.awt.Color.WHITE); // warna dasar putih bersih

    datePicker = new DatePicker();
    datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.SINGLE_DATE_SELECTED);
    datePicker.setUsePanelOption(false);

    datePicker.addDateSelectionListener(event -> {
        LocalDate selected = datePicker.getSelectedDate();
        if (selected != null) {
            tanggal_riwayat_penyakit.setText(selected.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
    });

    tanggal_riwayat_penyakit.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            datePicker.showPopup(tanggal_riwayat_penyakit);
        }
    });

// listener saat klik textfield
tanggal_riwayat_penyakit.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        datePicker.showPopup(tanggal_riwayat_penyakit);
    }
}); 
    }
    
private void kirimDataPengaduan() {
    PengaduanKesehatanController controller = new PengaduanKesehatanController();

    String namaInput = nama.getText().trim();
    String nikInput = nik.getText().trim();
    String alamatInput = alamat.getText().trim();
    String statusKesehatan = jRadioButton2.isSelected() ? "Sehat" : "Sakit";
    String namaPenyakit = jTextFieldNamaPenyakit.getText().trim();

    LocalDate tanggalSakit = null;
    if (!tanggal_riwayat_penyakit.getText().isEmpty()) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        tanggalSakit = LocalDate.parse(tanggal_riwayat_penyakit.getText(), formatter);
    }

    boolean success = controller.insertPengaduanKesehatan(
        namaInput,
        nikInput,
        alamatInput,
        statusKesehatan,
        namaPenyakit,
        tanggalSakit
    );

    if (success) {

        if (statusKesehatan.equals("Sakit")) {
            tips popup = new tips(null, true);
            popup.setLocationRelativeTo(null); // Biar di tengah layar
            popup.setVisible(true);


        } else {
            JOptionPane.showMessageDialog(this,
                "Pengaduan berhasil dikirim!",
                "Informasi",
                JOptionPane.INFORMATION_MESSAGE);
        }

        clearForm();
    }
}


        // Tambahkan method untuk mereset form setelah berhasil dikirim
        private void clearForm() {
            nama.setText("");
            nik.setText("");
            alamat.setText("");
            jTextFieldNamaPenyakit.setText("");
            tanggal_riwayat_penyakit.setText("");
            jRadioButton2.setSelected(true); // default kembali ke "Sehat"

            // Sembunyikan kembali field penyakit & tanggal
            panelBawah.setVisible(false);
            panelAtas.setVisible(true);
            jLabelNamaPenyakit.setVisible(false);
            jTextFieldNamaPenyakit.setVisible(false);
            jLabelTanggalSakit.setVisible(false);
            datePickerSakit.setVisible(false);
            tanggal_riwayat_penyakit.setVisible(false);
        }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panelBawah = new javax.swing.JPanel();
        jButton3Bawah =  new view.RoundedButton("Kirim");
        panelAtas = new javax.swing.JPanel();
        jButton3Atas =  new view.RoundedButton("Kirim");
        nama = new javax.swing.JTextField();
        nik = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabelNamaPenyakit = new javax.swing.JLabel();
        datePickerSakit = new javax.swing.JLabel();
        jTextFieldNamaPenyakit = new javax.swing.JTextField();
        jLabelTanggalSakit = new javax.swing.JLabel();
        tanggal_riwayat_penyakit = new javax.swing.JTextField();
        jButton1 = new view.iconButton("")
        ;
        jButton2 = new view.iconButton("")
        ;
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(802, 570));
        setPreferredSize(new java.awt.Dimension(802, 570));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3Bawah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kirim-sumit.png"))); // NOI18N
        jButton3Bawah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3BawahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBawahLayout = new javax.swing.GroupLayout(panelBawah);
        panelBawah.setLayout(panelBawahLayout);
        panelBawahLayout.setHorizontalGroup(
            panelBawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBawahLayout.createSequentialGroup()
                .addComponent(jButton3Bawah, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelBawahLayout.setVerticalGroup(
            panelBawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBawahLayout.createSequentialGroup()
                .addComponent(jButton3Bawah, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(panelBawah, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 744, 592, 47));

        jButton3Atas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kirim-sumit.png"))); // NOI18N
        jButton3Atas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3AtasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAtasLayout = new javax.swing.GroupLayout(panelAtas);
        panelAtas.setLayout(panelAtasLayout);
        panelAtasLayout.setHorizontalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAtasLayout.createSequentialGroup()
                .addComponent(jButton3Atas, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelAtasLayout.setVerticalGroup(
            panelAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3Atas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(panelAtas, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 600, 592, 50));

        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        jPanel1.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 375, 592, 40));

        nik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nikActionPerformed(evt);
            }
        });
        jPanel1.add(nik, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 300, 592, 40));
        jPanel1.add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 452, 592, 40));

        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, 290, 40));
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 530, 270, 40));

        jLabelNamaPenyakit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Nama Penyakit.png"))); // NOI18N
        jPanel1.add(jLabelNamaPenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 590, -1, -1));

        datePickerSakit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bxs_calendar.png"))); // NOI18N
        jPanel1.add(datePickerSakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 692, -1, -1));

        jTextFieldNamaPenyakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNamaPenyakitActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNamaPenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 610, 592, 40));

        jLabelTanggalSakit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tanggal Sakit.png"))); // NOI18N
        jPanel1.add(jLabelTanggalSakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 664, -1, -1));
        jPanel1.add(tanggal_riwayat_penyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 685, 110, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sehat-submit.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 530, 291, 40));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sakit-submit.png"))); // NOI18N
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, 291, 40));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Batal.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 50, -1));
        jButton3.setBorderPainted(false);
        jButton3.setFocusPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Desktop - 6 (2).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 802, 882));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nikActionPerformed

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton3BawahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3BawahActionPerformed
            kirimDataPengaduan();
    }//GEN-LAST:event_jButton3BawahActionPerformed

    private void jTextFieldNamaPenyakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNamaPenyakitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNamaPenyakitActionPerformed

    private void jButton3AtasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3AtasActionPerformed
         kirimDataPengaduan();
    }//GEN-LAST:event_jButton3AtasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        homePage home = new homePage();
        home.show();
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
try {
    // Terapkan tema modern sebelum GUI dibuat
    UIManager.setLookAndFeel(new com.formdev.flatlaf.themes.FlatMacLightLaf());

    // Opsi tambahan (rounded, smooth, warna halus)
    UIManager.put("TextComponent.arc", 12);
    UIManager.put("Button.arc", 12);
    UIManager.put("Component.focusWidth", 1);
    UIManager.put("Component.focusColor", new java.awt.Color(0, 120, 215));
    UIManager.put("ScrollBar.thumbArc", 999);
    UIManager.put("ScrollBar.track", java.awt.Color.WHITE);
    UIManager.put("ScrollBar.thumb", new java.awt.Color(210, 210, 210));

    // 🔧 PATCH agar DatePicker tidak hilang
    UIManager.put("Panel.background", Color.WHITE);
    UIManager.put("Button.background", Color.WHITE);
    UIManager.put("Label.foreground", Color.BLACK);
    UIManager.put("DatePicker.background", Color.WHITE);
    UIManager.put("DatePicker.foreground", Color.BLACK);
    UIManager.put("Table.background", Color.WHITE);
    UIManager.put("Table.foreground", Color.BLACK);

} catch (Exception ex) {
    System.err.println("Gagal menerapkan tema FlatLaf: " + ex.getMessage());
}

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new pengaduanKesehatan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JLabel datePickerSakit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton3Atas;
    private javax.swing.JButton jButton3Bawah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNamaPenyakit;
    private javax.swing.JLabel jLabelTanggalSakit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldNamaPenyakit;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nik;
    private javax.swing.JPanel panelAtas;
    private javax.swing.JPanel panelBawah;
    private javax.swing.JTextField tanggal_riwayat_penyakit;
    // End of variables declaration//GEN-END:variables
}
