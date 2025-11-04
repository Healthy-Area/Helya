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
import javax.swing.table.TableCellRenderer;

public class ButtonRenderer extends JButton implements TableCellRenderer {

    private final String actionType;

    public ButtonRenderer(String actionType) {
        this.actionType = actionType;
        setOpaque(true);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setHorizontalAlignment(SwingConstants.CENTER);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {

        // ✅ Jika untuk edit
        if ("edit".equals(actionType)) {
            setIcon(new ImageIcon(getClass().getResource("/img/icon_edit.png")));
        }

        // ✅ Jika untuk delete (hanya dipakai di manajemenAkun)
        else if ("delete".equals(actionType)) {
            setIcon(new ImageIcon(getClass().getResource("/img/hapus-btn.png")));
        }
        
        else if ("detail".equals(actionType)) {
            setIcon(new ImageIcon(getClass().getResource("/img/weui_eyes-on-outlined.png")));
}


        setText(null);
        return this;
    }
}


