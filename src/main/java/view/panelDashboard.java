/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;
import controller.DashboardController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import model.entity.LoginSession;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.CategoryDataset;



/**
 *
 * @author Aspire5
 */
public class panelDashboard extends javax.swing.JPanel {
private final DashboardController controller = new DashboardController();
private final String wilayah = LoginSession.getWilayah();

    /**
     * Creates new form panelDashboard
     */
public panelDashboard() {
    initComponents();
    setOpaque(false);

    loadCharts();
    loadDashboardData();
}

private void loadDashboardData() {

    // 🔹 Kesehatan Masyarakat (tidak ada "ditangani")
// Kesehatan Masyarakat
    Object[] dataMasyarakat = controller.getDataMasyarakat(wilayah);
    if (dataMasyarakat != null) {
        int total = (int) dataMasyarakat[0];
        int ditangani = (int) dataMasyarakat[1];
        int belumDitangani = (int) dataMasyarakat[2];

        jLabel6.setText(total + " Laporan");
        jLabel5.setText("✔ " + ditangani + " Ditangani");
        jLabel4.setText("❌ " + belumDitangani + " Belum ditangani");
    }


    // 🔹 Pengaduan Fasilitas Kesehatan (yang punya Selesai)
    Object[] dataFaskes = controller.getDataFaskes(wilayah);
    if (dataFaskes != null) {
        int total = (int) dataFaskes[0];
        int belum = (int) dataFaskes[1];     // belum diproses
        int selesai = (int) dataFaskes[3];   // selesai → ini yang ditangani

        jLabel9.setText(total + " Laporan");
        jLabel8.setText("✔ " + selesai + " Selesai");
        jLabel7.setText("❌ " + belum + " Belum diproses");
    }
}




    private void loadCharts() {
        // Hapus chart lama dulu kalau ada
        for (java.awt.Component c : getComponents()) {
            if (c instanceof ChartPanel) remove(c);
        }

        SwingUtilities.invokeLater(() -> {
            loadPieChart();
            Object[][] data = controller.ambilDataStacked(wilayah);
            JPanel chartPanel = controller.buatPanelStackedChart(data);
            jPanel2.removeAll();
            jPanel2.setLayout(new BorderLayout());
            jPanel2.add(chartPanel, BorderLayout.CENTER);
            jPanel2.revalidate();
            jPanel2.repaint();
            
            loadStackedBarChart(wilayah);

        });
    }

private void loadPieChart() {
    if (jPanel1.getWidth() <= 0 || jPanel1.getHeight() <= 0) {
        SwingUtilities.invokeLater(() -> loadPieChart());
        return;
    }

    try {
        Object[] data = controller.ambilDataPie(wilayah);
        long totalFaskes = (long) data[0];
        long totalMasyarakat = (long) data[1];
        long totalSemua = totalFaskes + totalMasyarakat;

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Fasilitas Kesehatan", totalFaskes);
        dataset.setValue("Kesehatan Masyarakat", totalMasyarakat);

        JFreeChart chart = ChartFactory.createRingChart(
                "Perbandingan Jenis Pengaduan",
                dataset,
                true,
                true,
                false
        );

        RingPlot plot = (RingPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(0, 0, 0, 0));
        plot.setOutlineVisible(false);
        plot.setSectionDepth(0.35);
        plot.setShadowGenerator(null);

        plot.setSectionPaint("Fasilitas Kesehatan", new Color(118, 136, 255));
        plot.setSectionPaint("Kesehatan Masyarakat", new Color(78, 186, 111));

        plot.setSimpleLabels(false);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}",
                new java.text.DecimalFormat("0"), new java.text.DecimalFormat("0%")));
        plot.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
        plot.setLabelPaint(Color.BLACK);
        plot.setLabelBackgroundPaint(new Color(255, 255, 255, 220));
        plot.setLabelOutlinePaint(Color.GRAY);
        plot.setLabelShadowPaint(null);

        chart.getTitle().setFont(new Font("SansSerif", Font.BOLD, 14));
        chart.getLegend().setItemFont(new Font("SansSerif", Font.PLAIN, 12));

        JLabel totalLabel = new JLabel("Total: " + totalSemua, JLabel.CENTER);
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        totalLabel.setForeground(new Color(60, 60, 60));

        ChartPanel cp = new ChartPanel(chart);
        cp.setOpaque(false);
        cp.setBackground(new Color(0, 0, 0, 0));
        cp.setLayout(new BorderLayout());
        cp.add(totalLabel, BorderLayout.CENTER);

        cp.addChartMouseListener(new org.jfree.chart.ChartMouseListener() {
            @Override
            public void chartMouseClicked(org.jfree.chart.ChartMouseEvent e) {
                org.jfree.chart.entity.ChartEntity entity = e.getEntity();
                if (entity instanceof org.jfree.chart.entity.PieSectionEntity) {
                    org.jfree.chart.entity.PieSectionEntity pie = (org.jfree.chart.entity.PieSectionEntity) entity;
                    String key = pie.getSectionKey().toString();
                    Number val = dataset.getValue(key);
                    JOptionPane.showMessageDialog(panelDashboard.this,
                            key + " : " + val + " laporan",
                            "Detail Pengaduan",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }

            @Override
            public void chartMouseMoved(org.jfree.chart.ChartMouseEvent e) {}
        });

        // Tempatkan chart di atas jPanel1
        jPanel1.removeAll();
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(cp, BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();

    } catch (Exception e) {
        System.err.println("Error loading pie chart: " + e.getMessage());
        e.printStackTrace();
    }
}

private void loadStackedBarChart(String wilayah) {
    try {
        Object[][] data = controller.ambilDataStacked(wilayah);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        double maxValue = 0.0;

        for (Object[] row : data) {
            String sumber = (String) row[0];
            int belum = ((Number) row[1]).intValue();
            int proses = ((Number) row[2]).intValue();
            int selesai = ((Number) row[3]).intValue();

            dataset.addValue(belum, "Belum Diperiksa", sumber);
            dataset.addValue(proses, "Sedang Diproses", sumber);
            dataset.addValue(selesai, "Selesai / Telah Diperiksa", sumber);

            double total = belum + proses + selesai;
            if (total > maxValue) maxValue = total;
        }

        JFreeChart chart = ChartFactory.createStackedBarChart(
                null,
                "Sumber Pengaduan",
                "Jumlah Pengaduan",
                dataset,
                PlotOrientation.HORIZONTAL,
                true,
                true,
                false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineVisible(false);
        plot.setRangeGridlinePaint(new Color(230, 230, 230));

        // ⬅️ ✅ Kembali seperti kode kamu sebelumnya
        plot.setInsets(new RectangleInsets(15, 5, 5, 5));

        StackedBarRenderer renderer = new StackedBarRenderer() {

            @Override
            public Paint getItemPaint(int row, int column) {
                switch (row) {
                    case 0: return new Color(255, 99, 132); 
                    case 1: return new Color(255, 193, 7);  
                    case 2: return new Color(75, 192, 192);
                }
                return super.getItemPaint(row, column);
            }

            @Override
            public void drawItem(Graphics2D g2,
                                 CategoryItemRendererState state,
                                 Rectangle2D dataArea,
                                 CategoryPlot plot,
                                 CategoryAxis domainAxis,
                                 ValueAxis rangeAxis,
                                 CategoryDataset dataset,
                                 int row,
                                 int column,
                                 int pass) {

                super.drawItem(g2, state, dataArea, plot, domainAxis, rangeAxis,
                        dataset, row, column, pass);

                Number valueObj = dataset.getValue(row, column);
                if (valueObj == null || valueObj.intValue() == 0) return;

                double value = valueObj.doubleValue();

                int catCount = dataset.getColumnCount();
                double barHeight = dataArea.getHeight() / catCount;
                double barY = dataArea.getY() + (column * barHeight);

                double offset = 0;
                for (int i = 0; i < row; i++) {
                    Number prev = dataset.getValue(i, column);
                    if (prev != null) offset += prev.doubleValue();
                }

                double midVal = offset + value / 2.0;
                double midX = rangeAxis.valueToJava2D(midVal, dataArea, plot.getRangeAxisEdge());
                double midY = barY + barHeight / 2.0;

                String label = String.valueOf((int) value);
                g2.setFont(new Font("Poppins", Font.BOLD, 11));

                Color fill = (Color) getItemPaint(row, column);
                double lum = (0.299 * fill.getRed() + 0.587 * fill.getGreen() + 0.114 * fill.getBlue()) / 255;

                FontMetrics fm = g2.getFontMetrics();
                int x = (int) (midX - fm.stringWidth(label) / 2);
                int y = (int) (midY + fm.getAscent() / 2 - 2);

                if (value < 1) return;

                g2.setStroke(new BasicStroke(2f));
                g2.setColor(new Color(0, 0, 0, 80));
                g2.drawString(label, x, y);

                g2.setStroke(new BasicStroke(1f));
                g2.setColor(lum < 0.6 ? Color.WHITE : Color.BLACK);
                g2.drawString(label, x, y);
            }
        };

        renderer.setBarPainter(new StandardBarPainter());
        renderer.setDefaultItemLabelsVisible(false);
        plot.setRenderer(renderer);

        // ✅ Legend warna disamakan dengan bar (dipertahankan)
        LegendItemCollection legendItems = new LegendItemCollection();
        legendItems.add(new LegendItem("Belum Diperiksa", null, null, null, 
                new Rectangle(10, 10), new Color(255, 99, 132)));
        legendItems.add(new LegendItem("Sedang Diproses", null, null, null, 
                new Rectangle(10, 10), new Color(255, 193, 7)));
        legendItems.add(new LegendItem("Selesai / Telah Diperiksa", null, null, null, 
                new Rectangle(10, 10), new Color(75, 192, 192)));
        plot.setFixedLegendItems(legendItems);

        // ✅ Legend kembali style kamu
        chart.getLegend().setPosition(RectangleEdge.BOTTOM);
        chart.getLegend().setMargin(6,6,6,6);
        chart.getLegend().setPadding(2, 2, 4, 2);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(0, Math.ceil(maxValue + maxValue * 0.1));
        rangeAxis.setNumberFormatOverride(new java.text.DecimalFormat("0"));

        // ✅ Chart height kamu sebelumnya
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(520, 160));
        chartPanel.setBackground(Color.WHITE);

        jPanel2.removeAll();
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(chartPanel, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();

    } catch (Exception e) {
        e.printStackTrace();
        System.err.println("Error loadStackedBarChart: " + e.getMessage());
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

        jPanel1 = new view.RoundedPanelExample(30);
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(610, 460));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 3, 343, 236));

        jPanel2.setLayout(new java.awt.BorderLayout());
        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 253, 600, 210));

        jLabel9.setText("jLabel9");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));
        jLabel9.setFont(new java.awt.Font("Poppins ExtraBold", Font.BOLD, 24));
        jLabel9.setForeground(new Color(25, 33, 53));
        jLabel9.setText("0 Laporan");

        jLabel8.setText("jLabel8");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 206, -1, -1));
        jLabel8.setFont(new java.awt.Font("Poppins", Font.PLAIN, 8));
        jLabel8.setForeground(new Color(0, 153, 0));
        jLabel8.setText("✔ 0 Ditangani");

        jLabel7.setText("jLabel7");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 206, -1, -1));
        jLabel7.setFont(new java.awt.Font("Poppins", Font.PLAIN, 8));
        jLabel7.setForeground(new Color(204, 0, 0));
        jLabel7.setText("❌ 0 Belum ditangani");

        jLabel6.setText("jLabel6");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 47, -1, -1));
        jLabel6.setFont(new java.awt.Font("Poppins Bold", Font.BOLD, 24));
        jLabel6.setForeground(new java.awt.Color(25, 33, 53));
        jLabel6.setText("0 Laporan");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/komponen-pengfas.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, -1, 110));

        jLabel5.setText("jLabel5");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 86, -1, -1));
        jLabel5.setFont(new java.awt.Font("Poppins", Font.PLAIN, 8));
        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setText("✔ 0 Ditangani");

        jLabel4.setText("jLabel4");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 86, -1, -1));
        jLabel4.setFont(new java.awt.Font("Poppins", Font.PLAIN, 8));
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("❌ 0 Belum ditangani");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/komponen-pengmas.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg-db.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 470));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
