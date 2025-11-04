/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author Aspire5
 */

import model.util.HibernateUtil;
import org.hibernate.Session;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardDao {

    // Utility: normalisasi nama wilayah
    private String normalizeWilayah(String wilayah) {
        if (wilayah == null) return "";
        return wilayah.replace("Kabupaten ", "")
                      .replace("Kota ", "")
                      .trim()
                      .toLowerCase();
    }

public Object[] getTotalPieData(String wilayah) {
    wilayah = normalizeWilayah(wilayah);
    final String finalWilayah = wilayah;
    Object[] result = new Object[]{0L, 0L}; // pakai Long default

    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        session.doWork(connection -> {
            boolean semuaData = finalWilayah.equalsIgnoreCase("kalimantan timur");

            String sql = "SELECT " +
                    " (SELECT COUNT(*) FROM pengaduan_faskes pf " +
                    " JOIN ketua_rt rt ON pf.id_users = rt.id_users " +
                    (semuaData ? "" : " WHERE LOWER(rt.alamat) LIKE CONCAT('%', ?, '%') ") +
                    ") AS totalFaskes, " +
                    " (SELECT COUNT(*) FROM pengaduan_masyarakat pm " +
                    " JOIN ketua_rt rt ON pm.id_users = rt.id_users " +
                    (semuaData ? "" : " WHERE LOWER(rt.alamat) LIKE CONCAT('%', ?, '%') ") +
                    ") AS totalMasyarakat";

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                if (!semuaData) {
                    stmt.setString(1, finalWilayah);
                    stmt.setString(2, finalWilayah);
                }
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        result[0] = rs.getLong("totalFaskes");
                        result[1] = rs.getLong("totalMasyarakat");
                    }
                }
            }
        });
    } catch (Exception e) {
        e.printStackTrace();
    }
    return result;
}

public Object[][] getDataStacked(String wilayah) {
    wilayah = normalizeWilayah(wilayah);
    final String finalWilayah = wilayah;
    List<Object[]> list = new ArrayList<>();

    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        session.doWork(connection -> {
            boolean semuaData = finalWilayah.equalsIgnoreCase("kalimantan timur");

            String sql =
                    "SELECT 'Fasilitas Kesehatan' AS sumber, " +
                    " SUM(CASE WHEN LOWER(pf.status_pengaduan) = 'belum diproses' THEN 1 ELSE 0 END) AS belum, " +
                    " SUM(CASE WHEN LOWER(pf.status_pengaduan) = 'sedang diproses' THEN 1 ELSE 0 END) AS proses, " +
                    " SUM(CASE WHEN LOWER(pf.status_pengaduan) = 'selesai' THEN 1 ELSE 0 END) AS selesai " +
                    "FROM pengaduan_faskes pf " +
                    "JOIN ketua_rt rt ON pf.id_users = rt.id_users " +
                    (semuaData ? "" : " WHERE LOWER(rt.alamat) LIKE CONCAT('%', ?, '%') ") +

                    " UNION ALL " +

                    "SELECT 'Kesehatan Masyarakat', " +
                    " SUM(CASE WHEN LOWER(pm.status) = 'belum diperiksa' THEN 1 ELSE 0 END) AS belum, " +
                    " 0 AS proses, " +
                    " SUM(CASE WHEN LOWER(pm.status) = 'telah diperiksa' THEN 1 ELSE 0 END) AS selesai " +

                    "FROM pengaduan_masyarakat pm " +
                    "JOIN ketua_rt rt ON pm.id_users = rt.id_users " +
                    (semuaData ? "" : " WHERE LOWER(rt.alamat) LIKE CONCAT('%', ?, '%') ");

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                if (!semuaData) {
                    stmt.setString(1, finalWilayah);
                    stmt.setString(2, finalWilayah);
                }

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Object[] row = new Object[]{
                            rs.getString("sumber"),
                            rs.getLong("belum"),
                            rs.getLong("proses"),
                            rs.getLong("selesai")
                        };
                        list.add(row);
                        System.out.println("DEBUG STACKED -> " + Arrays.toString(row));
                    }
                }
            }
        });
    }
    return list.toArray(new Object[0][]);
}



    // ========================================================================
    //  TOTAL MASYARAKAT
    // ========================================================================
    public Object[] getTotalMasyarakat(String wilayah) {
        wilayah = normalizeWilayah(wilayah);
        final String finalWilayah = wilayah;
        final boolean semuaData = finalWilayah.equalsIgnoreCase("kalimantan timur");

        Object[] result = new Object[3];

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.doWork(connection -> {

                String sql = """
                    SELECT COUNT(*) AS total,
                           SUM(CASE WHEN LOWER(pm.status) = 'telah diperiksa' THEN 1 ELSE 0 END) AS ditangani,
                           SUM(CASE WHEN LOWER(pm.status) = 'belum diperiksa' THEN 1 ELSE 0 END) AS belum
                    FROM pengaduan_masyarakat pm
                    JOIN ketua_rt rt ON pm.id_users = rt.id_users
                """ + (semuaData ? "" : " WHERE LOWER(rt.alamat) LIKE CONCAT('%', ?, '%')");

                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    if (!semuaData) stmt.setString(1, finalWilayah);

                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            result[0] = rs.getInt("total");
                            result[1] = rs.getInt("ditangani");
                            result[2] = rs.getInt("belum");
                        }
                    }
                }
            });
        }

        return result;
    }

    
    // ========================================================================
    //  TOTAL FASKES
    // ========================================================================
    public Object[] getTotalFaskes(String wilayah) {
        wilayah = normalizeWilayah(wilayah);
        final String finalWilayah = wilayah;
        final boolean semuaData = finalWilayah.equalsIgnoreCase("kalimantan timur");

        Object[] result = new Object[4];

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.doWork(connection -> {

                String sql = """
                    SELECT COUNT(*) AS total,
                           SUM(CASE WHEN LOWER(pf.status_pengaduan) = 'belum diproses' THEN 1 ELSE 0 END) AS belum,
                           SUM(CASE WHEN LOWER(pf.status_pengaduan) = 'sedang diproses' THEN 1 ELSE 0 END) AS proses,
                           SUM(CASE WHEN LOWER(pf.status_pengaduan) = 'selesai' THEN 1 ELSE 0 END) AS selesai
                    FROM pengaduan_faskes pf
                    JOIN ketua_rt rt ON pf.id_users = rt.id_users
                """ + (semuaData ? "" : " WHERE LOWER(rt.alamat) LIKE CONCAT('%', ?, '%')");

                try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                    if (!semuaData) stmt.setString(1, finalWilayah);

                    try (ResultSet rs = stmt.executeQuery()) {
                        if (rs.next()) {
                            result[0] = rs.getInt("total");
                            result[1] = rs.getInt("belum");
                            result[2] = rs.getInt("proses");
                            result[3] = rs.getInt("selesai");
                        }
                    }
                }
            });
        }

        return result;
    }
}


