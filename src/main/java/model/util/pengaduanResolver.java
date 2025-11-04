/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.util;

/**
 *
 * @author Aspire5
 */

import model.entity.pengaduanFaskes;
import model.entity.pengaduanMasyarakat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class pengaduanResolver {

    private final SessionFactory sessionFactory;

    public pengaduanResolver(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // ✅ Resolve berdasarkan ID pengaduan
    public Object resolveById(String idPengaduan) {
        try (Session session = sessionFactory.openSession()) {

            // ✅ Cari pengaduan masyarakat terlebih dahulu dengan JOIN FETCH ke ketuaRt
            Query<pengaduanMasyarakat> q1 = session.createQuery(
                    "SELECT p FROM pengaduanMasyarakat p LEFT JOIN FETCH p.ketuaRt "
                    + "WHERE p.idPengaduan = :id",
                    pengaduanMasyarakat.class
            );
            q1.setParameter("id", idPengaduan);
            pengaduanMasyarakat masyarakat = q1.uniqueResult();

            if (masyarakat != null) {
                return masyarakat;
            }

            // ✅ Jika tidak ditemukan cek pengaduan faskes
            Query<pengaduanFaskes> q2 = session.createQuery(
                    "FROM pengaduanFaskes WHERE idPengaduan = :id",
                    pengaduanFaskes.class
            );
            q2.setParameter("id", idPengaduan);

            return q2.uniqueResult();

        } catch (Exception e) {
            System.err.println("❌ Gagal resolve pengaduan ID: " + idPengaduan);
            e.printStackTrace();
            return null;
        }
    }

    // ✅ Ringkas data untuk UI
    public String getSummary(String idPengaduan) {
        Object pengaduan = resolveById(idPengaduan);
        if (pengaduan == null) {
            return "Pengaduan dengan ID " + idPengaduan + " tidak ditemukan.";
        }

        if (pengaduan instanceof pengaduanMasyarakat m) {
            return "[MASYARAKAT] " + m.getNama()
                    + " | Kesehatan: " + (m.getStatusKesehatan() == null ? "-" : m.getStatusKesehatan())
                    + " | Ketua RT: " + (m.getKetuaRt() == null ? "-" : m.getKetuaRt().getNamaUsers());
        } else if (pengaduan instanceof pengaduanFaskes f) {
            return "[FASKES] " + f.getJenisFaskes()
                    + " - Status: " + f.getStatusPengaduan();
        }

        return "Tipe pengaduan tidak dikenal.";
    }
}

