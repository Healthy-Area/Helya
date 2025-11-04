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
import model.entity.pengaduanFaskes;
import model.util.HibernateUtil;
import org.hibernate.Session;

public class pengaduanFaskesDao extends genericDAO<pengaduanFaskes, String> {
    public pengaduanFaskesDao() {
        super(pengaduanFaskes.class);
    }

    // Tambahan query khusus (jika nanti kamu perlu filter tertentu)
    // Misalnya ambil data berdasarkan status
    public java.util.List<pengaduanFaskes> findByStatus(String status) {
        try (org.hibernate.Session session = model.util.HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from PengaduanFaskes where statusPengaduan = :status", pengaduanFaskes.class)
                    .setParameter("status", status)
                    .list();
        }
    }
    
    public List<pengaduanFaskes> findByRt(String idRt) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.createQuery(
            "FROM pengaduanFaskes WHERE ketuaRt.idUsers = :idRt",
            pengaduanFaskes.class
        )
        .setParameter("idRt", idRt)
        .list();
    }
}

}
