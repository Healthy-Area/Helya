/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Aspire5
 */
import java.util.List;
import model.dao.ketuaRtDao;
import model.entity.ketuaRt;

public class KetuaRtController {

    private static final ketuaRtDao dao = new ketuaRtDao();

    // CREATE
    public static boolean tambah(ketuaRt rt) {
        try {
            dao.save(rt);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // READ ALL
    public static List<ketuaRt> getAll() {
        return dao.findAll();
    }

    // READ BY ID
    public static ketuaRt getById(String id) {
        return dao.findById(id);
    }

    // UPDATE
    public static boolean update(ketuaRt rt) {
        try {
            dao.update(rt);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE
    public static boolean delete(ketuaRt rt) {
        try {
            dao.delete(rt);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // LOGIN VALIDATION (opsional)
    public static ketuaRt login(String username, String password) {
        ketuaRt data = dao.getKetuaRTByUsername(username);
        if (data != null && data.getPassword().equals(password)) {
            return data;
        }
        return null;
    }
}
