/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
import controller.PengaduanController;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader; // ✅ Tambahkan baris ini
import model.entity.LoginSession;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import model.entity.pengaduanMasyarakat;
import model.util.HibernateUtil;
import org.hibernate.Session;


/**
 *
 * @author Aspire5
 */
public class manajemenPengaduan extends javax.swing.JPanel {
    private String wilayahAdmin;
    /**
     * Creates new form manajemenAkun
     */
public manajemenPengaduan() {
    this(LoginSession.getWilayah()); // baris pertama & aman
}

public manajemenPengaduan(String wilayahAdmin) {
    this.wilayahAdmin = wilayahAdmin;
    initComponents();
    setupTableUI();
    loadData();
    setOpaque(false);
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    sorter = new TableRowSorter<>(model);
    table.setRowSorter(sorter);

setBackground(Color.WHITE);




add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 580, 350));

 

table.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = table.rowAtPoint(evt.getPoint());
        int col = table.columnAtPoint(evt.getPoint());

        if (col == 5) { // klik tombol perbarui
            int modelRow = table.convertRowIndexToModel(row);

            String id = table.getModel().getValueAt(modelRow, 0).toString();
            String tipe = table.getModel().getValueAt(modelRow, 3).toString(); // ✅ kolom tipe benar

            System.out.println("Klik ID: " + id + " | Tipe: " + tipe);

            if (tipe.equalsIgnoreCase("Faskes")) {
                RUpdateFasKes popup = new RUpdateFasKes(null, true);
                popup.loadDetail(id);
                popup.setVisible(true);
            } else if (tipe.equalsIgnoreCase("Kesehatan Masyarakat")) {
                RUpdateKesmas popup = new RUpdateKesmas(null, true);
                popup.loadDetail(id);
                popup.setVisible(true);
            } else {
                System.out.println("⚠️ Tipe tidak dikenali -> " + tipe);
            }

        }

    }
});

}

    
private void setupTableUI() {
    table.setRowHeight(42);
    table.setShowGrid(false);
    table.setIntercellSpacing(new Dimension(0, 0));
    table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    table.setForeground(new Color(50, 50, 50));
    table.setSelectionBackground(new Color(230, 240, 255));
    table.setSelectionForeground(Color.BLACK);
    jScrollPane1.setBorder(BorderFactory.createEmptyBorder());

    JTableHeader header = table.getTableHeader();
    header.setPreferredSize(new Dimension(0, 45));
    header.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
    header.setBackground(new Color(245, 245, 245));
    header.setForeground(new Color(60, 60, 60));

    // LEFT renderer (dipakai untuk kolom-kolom selain status & tombol)
    DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
    leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
    leftRenderer.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 0));

    // Renderer untuk kolom status (kolom index 4 di layoutmu)
 // Renderer untuk kolom status (kolom index 4)
DefaultTableCellRenderer statusRenderer = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String status = value != null ? value.toString().toLowerCase() : "";

        // Reset style setiap render
        c.setOpaque(true);
        c.setFont(c.getFont().deriveFont(Font.BOLD)); // tulisannya bold
        c.setHorizontalAlignment(SwingConstants.CENTER);

        // Background tetap default (putih atau warna seleksi)
        if (!isSelected) {
            c.setBackground(Color.WHITE);

            if (status.contains("belum")) {
                c.setForeground(new Color(220, 20, 60)); // merah
            } else if (status.contains("sedang")) {
                c.setForeground(new Color(255, 193, 7)); // kuning
            } else if (status.contains("selesai") || status.contains("telah")) {
                c.setForeground(new Color(46, 204, 113)); // hijau
            } else {
                c.setForeground(Color.GRAY);
            }
        } else {
            // jika baris terseleksi, tetap ikuti warna seleksi, tapi text tetap sesuai status
            c.setBackground(table.getSelectionBackground());
        }

        return c;
    }
};


    // pastikan table kolom cukup (safety)
    int colCount = table.getColumnModel().getColumnCount();
    if (colCount > 4) {
        table.getColumnModel().getColumn(4).setCellRenderer(statusRenderer);
    }

    // set leftRenderer ke semua kolom KECUALI kolom status(4) dan tombol(5)
    for (int i = 0; i < colCount; i++) {
        if (i == 4 || i == 5) continue; // jangan timpa kolom status & tombol
        table.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
    }

    // Setelah setupTableUI selesai
    table.setOpaque(true);
    table.setBackground(Color.WHITE); // pastikan table punya background
    jScrollPane1.getViewport().setOpaque(true);
    jScrollPane1.getViewport().setBackground(Color.WHITE);
}

        
        
private void loadData() {
    try {
        List<Object[]> data;
        if ("Kalimantan Timur".equalsIgnoreCase(wilayahAdmin)) {
            data = PengaduanController.getSemuaPengaduan(); // admin provinsi
        } else {
            data = PengaduanController.getPengaduanByWilayah(wilayahAdmin); // admin daerah
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        int no = 1;
        for (Object[] row : data) {

            String id = row[0].toString();     // ID
            String nama = row[1].toString();   // Nama Pelapor
            String tipe = row[2].toString();   // Tipe Aduan
            String status = (row[3] == null) ? "Belum Diproses" : row[3].toString();

            model.addRow(new Object[]{
                id,       // hidden column
                no++,     // nomor urut
                nama,
                tipe,
                status,
                "Detail"  // tombol
            });
        }


        // Hide column ID
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setWidth(0);

//        table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer("Detail"));
//        table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(this, "Detail"));

        int colAksi = 5;
        table.getColumnModel().getColumn(colAksi).setCellRenderer(new ButtonRenderer("edit"));
        table.getColumnModel().getColumn(colAksi).setCellEditor(new ButtonEditor(this, "edit"));

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,
                "Gagal memuat data: " + e.getMessage(),
                "Kesalahan", JOptionPane.ERROR_MESSAGE);
    }

    table.revalidate();
    table.repaint();
}


  
        public void openPopup(String id, String tipe) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

            try {
                if (tipe.toLowerCase().contains("Fasilitas Kesehatan")) {
                    System.out.println("Membuka popup FASKES");
                    RUpdateFasKes popup = new RUpdateFasKes(frame, true);
                    popup.loadDetail(id);
                    popup.setVisible(true);
                } else if (tipe.toLowerCase().contains("Kesehatan Masyarakat")) {
                    System.out.println("Membuka popup KESMAS");
                    RUpdateKesmas popup = new RUpdateKesmas(frame, true);
                    popup.loadDetail(id);
                    popup.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this,
                        "Tipe aduan tidak dikenali: " + tipe,
                        "Kesalahan",
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Gagal membuka detail: " + e.getMessage(),
                        "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }



public void editAction(String idPengaduan) {
    try {
        int row = table.getSelectedRow();
        if (row < 0) return;

        int modelRow = table.convertRowIndexToModel(row);
        String tipe = table.getModel().getValueAt(modelRow, 3).toString();

        System.out.println("Klik ID: " + idPengaduan + " | Tipe: " + tipe);

        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);

        if (tipe.equalsIgnoreCase("Kesehatan")) {
            RUpdateFasKes popup = new RUpdateFasKes(parent, true);
            popup.loadDetail(idPengaduan);
            popup.setVisible(true);

        } else if (tipe.equalsIgnoreCase("Masyarakat")) {
            RUpdateKesmas popup = new RUpdateKesmas(parent, true);
            popup.loadDetail(idPengaduan);
            popup.setVisible(true);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
            "Gagal membuka data:\n" + e.getMessage(),
            "Kesalahan", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(610, 480));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pengmas.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/filter.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(562, 50, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ikon-search.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 16, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ikon-cari.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 15, -1, -1));

        jTextField1.setForeground(new java.awt.Color(150, 150, 150));
        jTextField1.setText("Cari pengaduan...");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 7, 575, 34));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, -1));

        table.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        table.setForeground(new java.awt.Color(255, 255, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"ID", "Nomor", "Nama", "Tipe Aduan", "Status", "Perbarui"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // hanya kolom "Pengaturan" (index 5) yang editable (button)
                return column == 5;
            }
        });
        // Misal tabelmu bernama jTable1
        table.getColumnModel().getColumn(0).setPreferredWidth(5);   // Nomor
        table.getColumnModel().getColumn(1).setPreferredWidth(150);  // Nama
        table.getColumnModel().getColumn(2).setPreferredWidth(120);  // Tipe Aduan
        table.getColumnModel().getColumn(3).setPreferredWidth(100);  // Status
        table.getColumnModel().getColumn(4).setPreferredWidth(80);   // Pengaturan

        table.getTableHeader().setResizingAllowed(false);
        jScrollPane1.setViewportView(table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 580, 350));
    }// </editor-fold>//GEN-END:initComponents


    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        if (jTextField1.getText().equals("Cari pengaduan...")) {
        jTextField1.setText("");
        jTextField1.setForeground(new Color(50, 50, 50));
    }
        jLabel2.setVisible(false); // sembunyikan ikon saat klik
          
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        if (jTextField1.getText().isEmpty()) {
        jTextField1.setText("Cari pengaduan...");
        jTextField1.setForeground(new Color(150, 150, 150));
        jLabel2.setVisible(true); // tampilkan kembali ikon jika kosong
    }

    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
            String text = jTextField1.getText().trim();
    if (text.equals("") || text.equalsIgnoreCase("Cari pengaduan...")) {
        sorter.setRowFilter(null); // tampilkan semua
    } else {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text)); // filter tidak case-sensitive
    }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadData();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
    private TableRowSorter<DefaultTableModel> sorter;

}
