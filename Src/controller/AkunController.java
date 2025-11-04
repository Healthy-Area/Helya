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

public class AkunController {

    private static ketuaRtDao dao = new ketuaRtDao();

    public static List<ketuaRt> getAkunKetuaRtByWilayah(String wilayah) {
        return dao.getKetuaRtByWilayah(wilayah);
    }

    public static List<ketuaRt> getSemuaAkunKetuaRt() {
    return new ketuaRtDao().findAll();
}
    public static boolean deleteAkun(String id) {
        return dao.deleteAkun(id);
    }

    public static ketuaRt getById(String id) {
        return dao.getById(id);
    }
}

