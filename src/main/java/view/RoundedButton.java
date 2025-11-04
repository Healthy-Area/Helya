package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButton extends JButton {

    private boolean hover;
    private boolean pressed;

    public RoundedButton(String text) {
        super(text);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setBackground(new Color(51, 153, 255)); // Warna default (biru muda)
        setFont(new Font("SansSerif", Font.BOLD, 14));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Event hover dan klik
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pressed = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        int arc = 8; // Besarnya lengkungan

        // Warna tombol saat kondisi berbeda
        Color base = getBackground();
        if (pressed) {
            base = base.darker();
        } else if (hover) {
            base = base.brighter();
        }

        g2.setColor(base);
        g2.fillRoundRect(0, 0, width, height, arc, arc);

        // Teks di tengah
        FontMetrics fm = g2.getFontMetrics();
        int textX = (width - fm.stringWidth(getText())) / 2;
        int textY = (height + fm.getAscent() - fm.getDescent()) / 2;

        g2.setColor(getForeground());
        g2.drawString(getText(), textX, textY);

        g2.dispose();
    }
}
