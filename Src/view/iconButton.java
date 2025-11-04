package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class iconButton extends JButton {
    private float scale = 1.0f; // ukuran awal
    private float targetScale = 1.0f;
    private Timer animationTimer;

    public iconButton(String text) {
        super(text);

        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFont(new Font("Poppins", Font.BOLD, 14));
        setForeground(new Color(0, 85, 255));
        setHorizontalTextPosition(CENTER);
        setVerticalTextPosition(BOTTOM);

        // Timer animasi hover
        animationTimer = new Timer(10, e -> animateHover());

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                targetScale = 1.03f; // sedikit membesar
                animationTimer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                targetScale = 1.0f; // kembali normal
                animationTimer.start();
            }
        });
    }

    private void animateHover() {
        float speed = 0.1f;
        if (Math.abs(scale - targetScale) < 0.01f) {
            scale = targetScale;
            animationTimer.stop();
        } else {
            scale += (targetScale - scale) * speed;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // transformasi scale (efek zoom halus)
        g2.translate(w / 2, h / 2);
        g2.scale(scale, scale);
        g2.translate(-w / 2, -h / 2);

        super.paintComponent(g2);
        g2.dispose();
    }
}
