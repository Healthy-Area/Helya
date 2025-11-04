/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Aspire5
 */

import model.entity.LoginSession;
import model.entity.admin;
import model.entity.ketuaRt;
import model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class LoginController {

    public enum LoginRole { ADMIN, KETUA_RT, INVALID }

    public LoginRole autentikasi(String username, String password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            // 🔹 Cek admin
            Query<admin> adminQuery = session.createQuery("FROM admin WHERE username = :u AND password = :p", admin.class);
            adminQuery.setParameter("u", username);
            adminQuery.setParameter("p", password);
            admin adminUser = adminQuery.uniqueResult();

            if (adminUser != null) {
                LoginSession.setUsername(adminUser.getUsername());
                LoginSession.setIdUsers(adminUser.getIdUsers());
                LoginSession.setWilayah(adminUser.getWilayah());
                return LoginRole.ADMIN;
                
            }

             Query<ketuaRt> rtQuery = session.createQuery(
                    "FROM ketuaRt WHERE username = :u AND password = :p", ketuaRt.class);
            rtQuery.setParameter("u", username);
            rtQuery.setParameter("p", password);
            ketuaRt rtUser = rtQuery.uniqueResult();

            if (rtUser != null) {
                // ✅ Simpan session ketua RT
                LoginSession.setIdUsers(rtUser.getIdUsers());
                return LoginRole.KETUA_RT;
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return LoginRole.INVALID;
    }
}
