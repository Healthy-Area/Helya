/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Aspire5
 */


public class TestConnection {
    public static void main(String[] args) {
        try {
            // ✅ Paksa load driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // ✅ Konfigurasi Hibernate
            Configuration configuration = new Configuration().configure("/hibernate.cfg.xml");
            try (SessionFactory sessionFactory = configuration.buildSessionFactory();
                 Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                System.out.println("✅ Koneksi ke database BERHASIL!");
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            System.err.println("❌ Gagal koneksi ke database:");
            e.printStackTrace();
        }
    }
}
