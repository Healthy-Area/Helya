/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Aspire5
 */
import java.time.LocalDateTime;
import java.util.List;
import model.entity.logStatus;
import model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PengaduanController {

    // ==========================
    // ADMIN - SEMUA PENGADUAN
    // ==========================
    public static List<Object[]> getSemuaPengaduan() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = """
            SELECT 
                p.id_pengaduan, 
                k.nama_users,
                'Faskes' AS tipe,
                COALESCE((
                    SELECT ls.status_baru
                    FROM log_status ls
                    WHERE ls.id_pengaduan = p.id_pengaduan
                    ORDER BY ls.waktu_update DESC LIMIT 1
                ), p.status_pengaduan) AS status_terbaru
            FROM pengaduan_faskes p
            LEFT JOIN ketua_rt k ON k.id_users = p.id_users
            
            UNION ALL
            
            SELECT
                m.id_pengaduan,
                m.nama AS nama_masyarakat,
                'Masyarakat' AS tipe,
                COALESCE((
                    SELECT ls.status_baru
                    FROM log_status ls
                    WHERE ls.id_pengaduan = m.id_pengaduan
                    ORDER BY ls.waktu_update DESC LIMIT 1
                ), m.status) AS status_terbaru
            FROM pengaduan_masyarakat m
            """;

            return session.createNativeQuery(sql).list();
        }
    }

    // =================================
    // ADMIN - PENGADUAN BERDASARKAN WILAYAH ADMIN
    // =================================
    public static List<Object[]> getPengaduanByWilayah(String wilayahAdmin) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            String sql = """
            SELECT 
                p.id_pengaduan,
                k.nama_users,
                'Faskes' AS tipe,
                COALESCE((
                    SELECT ls.status_baru
                    FROM log_status ls
                    WHERE ls.id_pengaduan = p.id_pengaduan
                    ORDER BY ls.waktu_update DESC LIMIT 1
                ), p.status_pengaduan) AS status_terbaru
            FROM pengaduan_faskes p
            JOIN ketua_rt k ON k.id_users = p.id_users
            WHERE LOWER(REPLACE(REPLACE(k.alamat,'Kabupaten',''),'Kota','')) 
                  LIKE CONCAT('%', LOWER(REPLACE(REPLACE(:wilayah,'Kabupaten',''),'Kota','')), '%')
                  
            UNION ALL
            
            SELECT
                m.id_pengaduan,
                m.nama,
                'Masyarakat' AS tipe,
                COALESCE((
                    SELECT ls.status_baru
                    FROM log_status ls
                    WHERE ls.id_pengaduan = m.id_pengaduan
                    ORDER BY ls.waktu_update DESC LIMIT 1
                ), m.status) AS status_terbaru
            FROM pengaduan_masyarakat m
            JOIN ketua_rt k2 ON k2.id_users = m.id_users
            WHERE LOWER(REPLACE(REPLACE(k2.alamat,'Kabupaten',''),'Kota','')) 
                  LIKE CONCAT('%', LOWER(REPLACE(REPLACE(:wilayah,'Kabupaten',''),'Kota','')), '%')
            """;

            return session.createNativeQuery(sql)
                    .setParameter("wilayah", wilayahAdmin)
                    .list();
        }
    }

    // =================================
    // KETUA RT - PENGADUAN PRIBADI (BY id_users)
    // =================================
    public static List<Object[]> getPengaduanByUsers(String idUsers) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = """
            SELECT 
                p.id_pengaduan,
                'Faskes' AS tipe,
                COALESCE((
                    SELECT ls.status_baru FROM log_status ls
                    WHERE ls.id_pengaduan = p.id_pengaduan
                    ORDER BY ls.waktu_update DESC LIMIT 1
                ), p.status_pengaduan) AS status_terbaru
            FROM pengaduan_faskes p
            WHERE p.id_users = :id
             
            UNION ALL
            
            SELECT
                m.id_pengaduan,
                'Masyarakat' AS tipe,
                COALESCE((
                    SELECT ls.status_baru FROM log_status ls
                    WHERE ls.id_pengaduan = m.id_pengaduan
                    ORDER BY ls.waktu_update DESC LIMIT 1
                ), m.status) AS status_terbaru
            FROM pengaduan_masyarakat m
            WHERE m.id_users = :id
            """;

            return session.createNativeQuery(sql)
                    .setParameter("id", idUsers)
                    .list();
        }
    }

    // ===============================
    // DETAIL MASYARAKAT
    // ===============================
    public static Object[] getDetailKesmasById(String idPengaduan) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (Object[]) session.createNativeQuery("""
                SELECT 
                    pm.id_pengaduan,
                    pm.nama,
                    kr.no_rt,
                    pm.riwayat_penyakit,
                    pm.tanggal_riwayat_penyakit,
                    pm.status,
                    pm.status_kesehatan
                FROM pengaduan_masyarakat pm
                LEFT JOIN ketua_rt kr ON pm.id_users = kr.id_users
                WHERE pm.id_pengaduan = :id
            """)
            .setParameter("id", idPengaduan)
            .uniqueResult();
        }
    }



    // ===============================
    // DETAIL FASKES
    // ===============================
public static Object[] getDetailFaskesById(String idPengaduan) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return (Object[]) session.createNativeQuery("""
            SELECT
                pf.id_pengaduan,
                pf.jenis_faskes,
                pf.keluhan,
                pf.status_pengaduan,
                pf.tanggal_pengaduan,
                kr.nama_users,
                kr.no_rt
            FROM pengaduan_faskes pf
            LEFT JOIN ketua_rt kr ON pf.id_users = kr.id_users
            WHERE pf.id_pengaduan = :id
        """)
        .setParameter("id", idPengaduan)
        .uniqueResult();
    }
}





    // ===============================
    // UPDATE STATUS MASYARAKAT
    // ===============================
public static boolean updateStatusKesmas(String idPengaduan, String statusBaru) {
    Transaction tx = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        tx = session.beginTransaction();

        session.createNativeQuery("""
            UPDATE pengaduan_masyarakat
            SET status = :status
            WHERE id_pengaduan = :id
        """)
        .setParameter("status", statusBaru)
        .setParameter("id", idPengaduan)
        .executeUpdate();

        // ✅ Insert log menggunakan entity
        logStatus log = new logStatus();
        log.setIdPengaduan(idPengaduan);
        log.setStatusBaru(statusBaru);
        log.setWaktuUpdate(LocalDateTime.now());
        session.save(log);

        tx.commit();
        return true;
    } catch (Exception e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
        return false;
    }
}


    // ===============================
    // UPDATE STATUS FASKES
    // ===============================
    public static boolean updateStatusFaskes(String idPengaduan, String statusBaru) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            session.createNativeQuery("""
                UPDATE pengaduan_faskes
                SET status_pengaduan = :status
                WHERE id_pengaduan = :id
            """)
            .setParameter("status", statusBaru)
            .setParameter("id", idPengaduan)
            .executeUpdate();

            // ✅ Insert log menggunakan entity
            logStatus log = new logStatus();
            log.setIdPengaduan(idPengaduan);
            log.setStatusBaru(statusBaru);
            log.setWaktuUpdate(LocalDateTime.now());
            session.save(log);

            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

}



