/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Aspire5
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellEditor;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

    private final JButton button;
    private JTable table;
    private final String actionType;
    
    private manajemenAkun panelAkun;
    private manajemenPengaduan panelPengaduan;
    private homePage panelHome;

    public ButtonEditor(Object panel, String actionType) {
        this.actionType = actionType;

        if (panel instanceof manajemenAkun) {
            this.panelAkun = (manajemenAkun) panel;
        } else if (panel instanceof manajemenPengaduan) {
            this.panelPengaduan = (manajemenPengaduan) panel;
        } else if (panel instanceof homePage) {
            this.panelHome = (homePage) panel;
        }

        button = new JButton();
        button.setBorder(null);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setHorizontalAlignment(SwingConstants.CENTER);

        button.addActionListener(e -> handleAction());
    }

    private void handleAction() {
        int row = table.getEditingRow();
        if (row == -1) return;

        int modelRow = table.convertRowIndexToModel(row);
        String id = table.getModel().getValueAt(modelRow, 0).toString();

        if (panelAkun != null) {
            if ("edit".equals(actionType)) {
                panelAkun.editAction(id);
            } else if ("delete".equals(actionType)) {
                panelAkun.deleteAction(id);
            }
        }

        if (panelPengaduan != null && "edit".equals(actionType)) {
            panelPengaduan.editAction(id);
        }

if (panelHome != null && "detail".equals(actionType)) {

    String tipe = table.getModel().getValueAt(modelRow, 3).toString().toLowerCase();
    System.out.println("Klik Detail! ID = " + id + ", Tipe = " + tipe);

    if (tipe.contains("faskes")) {
        panelHome.showDetailFaskes(id);
    } else {
        panelHome.showDetailKesmas(id);
    }
}


        fireEditingStopped();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {

        this.table = table;

        if ("edit".equals(actionType)) {
            button.setIcon(new ImageIcon(getClass().getResource("/img/icon_edit.png")));
        } else if ("delete".equals(actionType)) {
            button.setIcon(new ImageIcon(getClass().getResource("/img/hapus-btn.png")));
        } else if ("detail".equals(actionType)) {
            button.setIcon(new ImageIcon(getClass().getResource("/img/weui_eyes-on-outlined.png")));
        }

        button.setText(null);
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return actionType;
    }
}


