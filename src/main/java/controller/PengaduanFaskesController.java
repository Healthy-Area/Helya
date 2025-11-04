/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Aspire5
 */
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import model.dao.pengaduanFaskesDao;
import model.dao.ketuaRtDao;
import model.entity.LoginSession;
import model.entity.ketuaRt;
import model.entity.pengaduanFaskes;


public class PengaduanFaskesController {

    private final pengaduanFaskesDao dao = new pengaduanFaskesDao();
    private final ketuaRtDao rtDao = new ketuaRtDao();

public boolean insertPengaduanFaskes(String jenisFaskes,
                                     String keluhan,
                                     String tenagaMedis,
                                     LocalDate tanggalPengaduan) {

    // ✅ Validasi tanggal
    if (tanggalPengaduan == null) {
        javax.swing.JOptionPane.showMessageDialog(null,
                "Tanggal pengaduan belum dipilih!",
                "Validasi", javax.swing.JOptionPane.WARNING_MESSAGE);
        return false;
    }

    String idRt = LoginSession.getIdUsers();
    if (idRt == null) {
        javax.swing.JOptionPane.showMessageDialog(null,
                "ID Ketua RT tidak ditemukan! Harus login ulang.",
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // ✅ Ambil data ketua RT
    ketuaRt rt = rtDao.findById(idRt);
    if (rt == null) {
        javax.swing.JOptionPane.showMessageDialog(null,
                "Data Ketua RT tidak ditemukan di database!",
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // ✅ Set data pengaduan
    pengaduanFaskes data = new pengaduanFaskes();
    data.setJenisFaskes(jenisFaskes);
    data.setKeluhan(keluhan);
    data.setMembutuhkanTenagaMedis(tenagaMedis);
    data.setTanggalPengaduan(tanggalPengaduan);
    data.setStatusPengaduan("Belum Diproses");
    data.setKetuaRt(rt);

    try {
        dao.save(data);  
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

}
