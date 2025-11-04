/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.DashboardDao;
import org.hibernate.Session;

/**
 *
 * @author Aspire5
 */

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.dao.DashboardDao;
import model.util.HibernateUtil;
import org.hibernate.Session;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.category.DefaultCategoryDataset;
import model.entity.LoginSession;

public class DashboardController {
    
    private final String wilayah;
    private final DashboardDao dao;

    public DashboardController() {
        dao = new DashboardDao();
            this.wilayah = LoginSession.getWilayah();
    }

    // ---------------------- PIE CHART DATA ----------------------
    public Object[] ambilDataPie(String wilayah) {
        return dao.getTotalPieData(wilayah);
    }

    // ---------------------- STACKED BAR DATA ----------------------
public Object[][] ambilDataStacked(String wilayah   ) {
    return dao.getDataStacked(wilayah);
}



    // ---------------------- STACKED BAR PANEL ----------------------
// ---------------------- STACKED BAR PANEL ----------------------
public JPanel buatPanelStackedChart(Object[][] dataStacked) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    for (Object[] row : dataStacked) {
        String sumber = (String) row[0];
        long belum = (long) row[1];
        long sedang = (long) row[2];
        long selesai = (long) row[3];

        dataset.addValue(belum, "Belum Diproses", sumber);
        if (sedang > 0) { // hanya tampilkan jika faskes
            dataset.addValue(sedang, "Sedang Diproses", sumber);
        }
        dataset.addValue(selesai, "Selesai", sumber);
    }

    JFreeChart chart = ChartFactory.createStackedBarChart(
        "Perbandingan Status Pengaduan",
        "Sumber Pengaduan",
        "Jumlah Laporan",
        dataset,
        PlotOrientation.HORIZONTAL,
        true, true, false
    );

    CategoryPlot plot = chart.getCategoryPlot();
    plot.setBackgroundPaint(Color.WHITE);
    plot.setOutlineVisible(false);
    plot.setRangeGridlinePaint(new Color(230, 230, 230));
    plot.setDomainGridlinesVisible(false);

    // Renderer untuk tampilan batang
    StackedBarRenderer renderer = new StackedBarRenderer();
    renderer.setBarPainter(new StandardBarPainter());
    renderer.setShadowVisible(false);
    renderer.setDrawBarOutline(false);

    // Warna untuk tiap kategori
    renderer.setSeriesPaint(0, new Color(118, 136, 255)); // Belum
    renderer.setSeriesPaint(1, new Color(255, 187, 92));  // Sedang
    renderer.setSeriesPaint(2, new Color(78, 186, 111));  // Selesai

    // Tampilkan nilai di atas batang
    renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
    renderer.setDefaultItemLabelsVisible(true);
    renderer.setDefaultItemLabelFont(new Font("Segoe UI", Font.BOLD, 12));
    renderer.setDefaultItemLabelPaint(Color.DARK_GRAY);

    plot.setRenderer(renderer);
    plot.setOrientation(PlotOrientation.HORIZONTAL);

    // Font modern
    Font modernFont = new Font("Segoe UI", Font.PLAIN, 12);
    chart.getTitle().setFont(new Font("Segoe UI", Font.BOLD, 14));
    chart.getLegend().setItemFont(modernFont);
    chart.getLegend().setBackgroundPaint(Color.WHITE);
    chart.getLegend().setPosition(RectangleEdge.BOTTOM);

    plot.getDomainAxis().setLabelFont(modernFont);
    plot.getRangeAxis().setLabelFont(modernFont);
    plot.getRangeAxis().setAxisLineVisible(false);
    plot.getRangeAxis().setTickLabelFont(modernFont);

    // Panel utama untuk chart
    ChartPanel chartPanel = new ChartPanel(chart);
    chartPanel.setOpaque(false);
    chartPanel.setBackground(Color.WHITE);

    // Tambahkan legenda warna manual agar lebih jelas dan modern
    JPanel legendPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
    legendPanel.setBackground(Color.WHITE);

    legendPanel.add(buatLegendaItem("Belum Diproses", new Color(118, 136, 255)));
    legendPanel.add(buatLegendaItem("Sedang Diproses", new Color(255, 187, 92)));
    legendPanel.add(buatLegendaItem("Selesai", new Color(78, 186, 111)));

    // Gabungkan chart + legenda
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(chartPanel, BorderLayout.CENTER);
    panel.add(legendPanel, BorderLayout.SOUTH);
    panel.setBackground(Color.WHITE);

    return panel;
}

// ========================
// Helper untuk legenda
// ========================
private JPanel buatLegendaItem(String label, Color warna) {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
    panel.setBackground(Color.WHITE);

    JPanel kotak = new JPanel();
    kotak.setPreferredSize(new Dimension(15, 15));
    kotak.setBackground(warna);
    kotak.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY, 1));

    JLabel teks = new JLabel(label);
    teks.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    teks.setForeground(new Color(60, 60, 60));

    panel.add(kotak);
    panel.add(teks);
    return panel;
}

    public Object[] getDataMasyarakat(String wilayah) {
        return dao.getTotalMasyarakat(wilayah);
    }

    public Object[] getDataFaskes(String wilayah) {
    return dao.getTotalFaskes(wilayah);
}



    }
