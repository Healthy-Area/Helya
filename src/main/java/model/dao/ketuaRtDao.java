/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author Aspire5
 */

import java.util.List;
import model.entity.ketuaRt;
import model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ketuaRtDao extends genericDAO<ketuaRt, String> {

    public ketuaRtDao() {
        super(ketuaRt.class);
    }

    public ketuaRt getKetuaRTByUsername(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM ketuaRt WHERE username = :u",
                    ketuaRt.class)
                    .setParameter("u", username)
                    .uniqueResult();
        }
    }
    
    public List<ketuaRt> findAll() {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.createQuery("FROM ketuaRt", ketuaRt.class).list();
    }
}

    public List<ketuaRt> getKetuaRtByWilayah(String wilayah) {
        wilayah = wilayah.replace("Kabupaten", "")
                         .replace("Kab.", "")
                         .trim();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM ketuaRt k WHERE k.alamat LIKE :wilayah",
                    ketuaRt.class)
                    .setParameter("wilayah", "%" + wilayah + "%")
                    .list();
        }
    }

        public boolean deleteAkun(String id) {
            Transaction tx = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                tx = session.beginTransaction();

                ketuaRt data = session.get(ketuaRt.class, id);
                if (data != null) {
                    session.remove(data); // ✅ mengaktifkan cascading delete
                }

                tx.commit();
                return true;
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                System.err.println("Gagal menghapus akun: " + e.getMessage());
                return false;
            }
        }


    public ketuaRt getById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(ketuaRt.class, id);
        } catch (Exception e) {
            System.err.println("Gagal mengambil data: " + e.getMessage());
            return null;
        }
    }
}


