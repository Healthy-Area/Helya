/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author Aspire5
 */

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "pengaduan_masyarakat")
public class pengaduanMasyarakat {

    @Id
    @Column(name = "id_pengaduan", length = 50, nullable = false)
    private String idPengaduan;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "nik", length = 20, nullable = false)
    private String nik;

    @Column(name = "nama", length = 100, nullable = false)
    private String nama;

    @Column(name = "alamat", length = 150)
    private String alamat;

    @Column(name = "status_kesehatan", length = 50)
    private String statusKesehatan;

    @Column(name = "riwayat_penyakit", length = 100)
    private String riwayatPenyakit;

    @Column(name = "tanggal_riwayat_penyakit")
    private LocalDate tanggalRiwayatPenyakit;

    @Column(name = "tips_otomatis_id_tips", length = 50)
    private String tipsOtomatisIdTips;
    
    public String getNama() {
    return nama;
}

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setStatusKesehatan(String statusKesehatan) {
        this.statusKesehatan = statusKesehatan;
    }

    public String getStatusKesehatan() {
    return statusKesehatan;
}


    // ✅ Relasi ke ketuaRt
    @ManyToOne
    @JoinColumn(name = "id_users")
    private ketuaRt ketuaRt;

    public pengaduanMasyarakat() {}

    // ✅ Getter & Setter baru untuk relasi
    public ketuaRt getKetuaRt() { return ketuaRt; }
    public void setKetuaRt(ketuaRt ketuaRt) { this.ketuaRt = ketuaRt; }

    // ... semua getter setter yang sudah kamu punya ...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof pengaduanMasyarakat)) return false;
        pengaduanMasyarakat other = (pengaduanMasyarakat) o;
        return Objects.equals(idPengaduan, other.idPengaduan);
    }

    public String getIdPengaduan() {
        return idPengaduan;
    }

    public void setIdPengaduan(String idPengaduan) {
        this.idPengaduan = idPengaduan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRiwayatPenyakit() {
        return riwayatPenyakit;
    }

    public void setRiwayatPenyakit(String riwayatPenyakit) {
        this.riwayatPenyakit = riwayatPenyakit;
    }

    public LocalDate getTanggalRiwayatPenyakit() {
        return tanggalRiwayatPenyakit;
    }

    public void setTanggalRiwayatPenyakit(LocalDate tanggalRiwayatPenyakit) {
        this.tanggalRiwayatPenyakit = tanggalRiwayatPenyakit;
    }

    public String getTipsOtomatisIdTips() {
        return tipsOtomatisIdTips;
    }

    public void setTipsOtomatisIdTips(String tipsOtomatisIdTips) {
        this.tipsOtomatisIdTips = tipsOtomatisIdTips;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPengaduan);
    }
}

