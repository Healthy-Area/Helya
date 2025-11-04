/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author Aspire5
 */
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.util.HibernateUtil;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

public class genericDAO<T, ID extends Serializable> {

    private final Class<T> clazz;

    public genericDAO(Class<T> clazz) { this.clazz = clazz; }

    public T save(T entity) {
        return execute(session -> {
            session.persist(entity);
            return entity;
        });
    }

    public T update(T entity) {
        return execute(session -> (T) session.merge(entity));
    }

    public void delete(T entity) {
        execute(session -> { session.remove(entity); return null; });
    }

    public T findById(ID id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(clazz, id);
        }
    }

    public List<T> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from " + clazz.getSimpleName(), clazz).list();
        }
    }

    private <R> R execute(Function<Session, R> callback) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            R result = callback.apply(session);
            tx.commit();
            return result;
        } catch (RuntimeException ex) {
            if (tx != null) tx.rollback();
            throw ex;
        }
    }
}
