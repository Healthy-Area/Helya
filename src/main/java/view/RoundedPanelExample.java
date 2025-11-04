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

public class RoundedPanelExample extends JPanel {
    private int cornerRadius;

    public RoundedPanelExample(int radius) {
        this.cornerRadius = radius;
        setOpaque(false); // penting agar sudut transparan tidak ditimpa warna background
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        // 🔹 Warna putih solid
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);

        // 🔹 Border lembut (opsional)
        g2.setColor(new Color(220, 220, 220));
        g2.drawRoundRect(0, 0, width - 1, height - 1, cornerRadius, cornerRadius);

        g2.dispose();
    }
}


