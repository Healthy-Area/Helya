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
import javax.swing.JOptionPane;
import model.dao.pengaduanMasyarakatDao;
import model.dao.ketuaRtDao;
import model.entity.LoginSession;
import model.entity.ketuaRt;
import model.entity.pengaduanMasyarakat;
import view.kirim_berhasil;

public class PengaduanKesehatanController {

    private final pengaduanMasyarakatDao dao = new pengaduanMasyarakatDao();
    private final ketuaRtDao rtDao = new ketuaRtDao();

    public boolean insertPengaduanKesehatan(String nama,
                                            String nik,
                                            String alamat,
                                            String statusKesehatan,
                                            String namaPenyakit,
                                            LocalDate tanggalSakit) {

        // ✅ Validasi kolom kosong
        if (isEmpty(nama) || isEmpty(nik) || isEmpty(alamat)) {
            showWarning("Nama, NIK, dan Alamat wajib diisi!");
            return false;
        }

        // ✅ Validasi format NIK
        if (!nik.matches("\\d+")) {
            showWarning("NIK hanya boleh berisi angka!");
            return false;
        }

        if (nik.length() != 16) {
            showWarning("NIK harus terdiri dari 16 digit!");
            return false;
        }

        // ✅ Validasi panjang alamat
        if (alamat.trim().length() < 5) {
            showWarning("Alamat terlalu pendek, harap masukkan alamat lengkap!");
            return false;
        }

        // ✅ Jika status sakit, validasi penyakit & tanggal
        if ("Sakit".equalsIgnoreCase(statusKesehatan)) {
            if (isEmpty(namaPenyakit)) {
                showWarning("Nama penyakit wajib diisi jika status 'Sakit'!");
                return false;
            }
            if (tanggalSakit == null) {
                showWarning("Tanggal sakit wajib diisi jika status 'Sakit'!");
                return false;
            }
            if (tanggalSakit.isAfter(LocalDate.now())) {
                showWarning("Tanggal sakit tidak boleh melebihi tanggal hari ini!");
                return false;
            }
        }

        // ✅ Ambil ID RT dari sesi login
        String idRt = LoginSession.getIdUsers();
        if (idRt == null) {
            showError("ID Ketua RT tidak ditemukan! Silakan login ulang.");
            return false;
        }

        // ✅ Pastikan Ketua RT ada di database
        ketuaRt rt = rtDao.findById(idRt);
        if (rt == null) {
            showError("Data Ketua RT tidak ditemukan di database!");
            return false;
        }

        // ✅ Buat entitas baru
        pengaduanMasyarakat data = new pengaduanMasyarakat();
        data.setIdPengaduan(java.util.UUID.randomUUID().toString());
        data.setNama(nama);
        data.setNik(nik);
        data.setAlamat(alamat);
        data.setStatusKesehatan(statusKesehatan);
        data.setRiwayatPenyakit("Sakit".equalsIgnoreCase(statusKesehatan) ? namaPenyakit : "-");
        data.setTanggalRiwayatPenyakit("Sakit".equalsIgnoreCase(statusKesehatan) ? tanggalSakit : null);
        data.setStatus("Belum Diperiksa");
        data.setKetuaRt(rt);

        // ✅ Simpan ke database
        try {
            dao.save(data);
            new kirim_berhasil(null, true).setVisible(true);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            showError("Terjadi kesalahan saat menyimpan data: " + e.getMessage());
            return false;
        }
    }

    // 🔹 Fungsi bantu
    private boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    private void showWarning(String message) {
        JOptionPane.showMessageDialog(null, message, "Validasi", JOptionPane.WARNING_MESSAGE);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}


