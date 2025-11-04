/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author Aspire5
 */

import model.entity.admin;
import model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class adminDao {

public admin getAdminByUsername(String username) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.createQuery("SELECT a FROM admin a WHERE a.username = :u", admin.class)
                .setParameter("u", username)
                .uniqueResult();
    }
}


}
