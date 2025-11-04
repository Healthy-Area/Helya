/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;


import controller.*;
import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import model.dao.ketuaRtDao;
import model.entity.ketuaRt;
import model.entity.LoginSession;

/**
 *
 * @author Aspire5
 */
public class manajemenAkun extends javax.swing.JPanel {

    /**
     * Creates new form manajemenPengaduan
     */
     public manajemenAkun() {
        initComponents();
        setOpaque(false);
        setupTableUI();
        refreshData();

        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table2.setRowSorter(sorter);

        // ✅ Gunakan placeholder text yang sudah kamu atur dari GUI Designer
        String placeholder = jTextField1.getText();
        jTextField1.putClientProperty("JTextField.placeholderText", placeholder);

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
    @Override
    public void focusGained(java.awt.event.FocusEvent evt) {
        if (jTextField1.getText().equals(placeholder)) {
            jTextField1.setText("");
            jTextField1.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(java.awt.event.FocusEvent evt) {
        if (jTextField1.getText().isEmpty()) {
            jTextField1.setText(placeholder);
            jTextField1.setForeground(new Color(150, 150, 150));
        }
    }
});

jTextField1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    private void filter() {
        String text = jTextField1.getText().trim();
        if (text.isEmpty() || text.equals("Cari nama ketua RT...")) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 2));
        }
    }

    @Override public void insertUpdate(javax.swing.event.DocumentEvent e) { filter(); }
    @Override public void removeUpdate(javax.swing.event.DocumentEvent e) { filter(); }
    @Override public void changedUpdate(javax.swing.event.DocumentEvent e) { filter(); }
});



    }
     
     private void setupTableUI() {
    table2.setRowHeight(42);
    table2.setShowGrid(false);
    table2.setIntercellSpacing(new Dimension(0, 0));
    table2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    table2.setForeground(new Color(50, 50, 50));
    table2.setSelectionBackground(new Color(230, 240, 255));
    table2.setSelectionForeground(Color.BLACK);
    jScrollPane1.setBorder(BorderFactory.createEmptyBorder());

    JTableHeader header = table2.getTableHeader();
    header.setPreferredSize(new Dimension(0, 45));
    header.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
    header.setBackground(new Color(245, 245, 245));
    header.setForeground(new Color(60, 60, 60));

    DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
    leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
    leftRenderer.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 0));

    jScrollPane1.getViewport().setOpaque(true);
    jScrollPane1.getViewport().setBackground(Color.WHITE);

    for (int i = 0; i < table2.getColumnCount(); i++) {
        if (i != 4 && i != 5) { 
            table2.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
        }
    }

    table2.getColumnModel().getColumn(0).setMinWidth(0);
    table2.getColumnModel().getColumn(0).setMaxWidth(0);
    table2.getColumnModel().getColumn(0).setWidth(0);

    table2.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer("edit"));
    table2.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(this, "edit"));

    table2.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer("delete"));
    table2.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(this, "delete"));


}

     public void refreshData() {
    String wilayahAdmin = LoginSession.getWilayah();
    System.out.println("Wilayah dari session: " + wilayahAdmin);
    loadAkun(wilayahAdmin);
}

    private void loadAkun(String wilayahAdmin) {
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        model.setRowCount(0);

        List<ketuaRt> data = AkunController.getAkunKetuaRtByWilayah(wilayahAdmin);

            // ✅ Jika admin Kalimantan Timur, tampilkan semua RT
    if ("Kalimantan Timur".equalsIgnoreCase(wilayahAdmin)) {
        data = AkunController.getSemuaAkunKetuaRt();
    } else {
        data = AkunController.getAkunKetuaRtByWilayah(wilayahAdmin);
    }
        int no = 1;
        for (ketuaRt k : data) {
            model.addRow(new Object[]{
                k.getIdUsers(),        // ID (hidden)
                no++,             // Nomor urut
                k.getNamaUsers(),      // Nama Ketua RT
                k.getNoRt(),      // RT
                new ImageIcon(getClass().getResource("/img/icon_edit.png")),
                new ImageIcon(getClass().getResource("/img/hapus-btn.png"))
            });
        }

        
        // ✅ Sembunyikan ID
        table2.getColumnModel().getColumn(0).setMinWidth(0);
        table2.getColumnModel().getColumn(0).setMaxWidth(0);
    }
    
    public void editAction(String id) {
        ketuaRt selectedData = AkunController.getById(id); // ✅ Ambil data lengkap dari DB

        if (selectedData == null) {
            JOptionPane.showMessageDialog(this, "Data tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        java.awt.Frame parent = (java.awt.Frame) SwingUtilities.getWindowAncestor(this);
        perbaruiAkunDialog dialog = new perbaruiAkunDialog(parent, true);

        dialog.loadData(selectedData); // ✅ Tampilkan data lama ke dalam textfield
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);

        if (dialog.getReturnStatus() == perbaruiAkunDialog.RET_OK) {
            refreshData(); // ✅ Update tabel setelah simpan
        }
    }


   public void deleteAction(String id) {
       java.awt.Frame parent = (java.awt.Frame) SwingUtilities.getWindowAncestor(this);
       hapusAkunDialog dialog = new hapusAkunDialog(parent, true);
       dialog.setLocationRelativeTo(parent);
       dialog.setVisible(true);
       if (dialog.getReturnStatus() == hapusAkunDialog.RET_OK) {
           AkunController.deleteAkun(id);
           refreshData();
       }
   }
   



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ikon-cari.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 13, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ikon-search.png"))); // NOI18N
        jLabel2.setToolTipText("");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 16, -1, -1));

        jTextField1.setText("Cari nama ketua RT...");
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 6, 575, 34));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Akun Pengguna.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tambah 1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, -1, -1));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nomor", "Nama", "Rt", "Perbarui", "Hapus"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // kolom 4 = Edit, kolom 5 = Hapus
                return column == 4 || column == 5;
            }

        });
        jScrollPane1.setViewportView(table2);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 570, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            java.awt.Frame parent = (java.awt.Frame) SwingUtilities.getWindowAncestor(this);
    tambahAkunDialog dialog = new tambahAkunDialog(parent, true);
    dialog.setLocationRelativeTo(parent);
    dialog.setVisible(true);

    if (dialog.getReturnStatus() == tambahAkunDialog.RET_OK) {
        refreshData(); // ✅ perbarui tabel setelah tambah akun
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
