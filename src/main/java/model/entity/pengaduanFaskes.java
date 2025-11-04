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
import org.hibernate.annotations.GenericGenerator;




@Entity
@Table(name = "pengaduan_faskes")
public class pengaduanFaskes {

@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid2")
@Column(name = "id_pengaduan", length = 50, nullable = false)
private String idPengaduan;


    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "tanggal_pengaduan")
    private LocalDate tanggalPengaduan;

    @Column(name = "jenis_faskes", length = 50)
    private String jenisFaskes;

    @Column(name = "keluhan", length = 255)
    private String keluhan;

    @Column(name = "membutuhkan_tenaga_medis", length = 10)
    private String membutuhkanTenagaMedis;

    @Column(name = "status_pengaduan", length = 50)
    private String statusPengaduan;

    @Column(name = "bulan", length = 20)
    private String bulan;

    @Column(name = "tahun", length = 20)
    private String tahun;

    public pengaduanFaskes() {
    this.statusPengaduan = "Belum di Proses";
    this.tanggalPengaduan = LocalDate.now();
}

    public String getIdPengaduan() { return idPengaduan; }
    public void setIdPengaduan(String idPengaduan) { this.idPengaduan = idPengaduan; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getTanggalPengaduan() { return tanggalPengaduan; }
    public void setTanggalPengaduan(LocalDate tanggalPengaduan) {
        this.tanggalPengaduan = tanggalPengaduan;
        if (tanggalPengaduan != null) {
            this.bulan = String.valueOf(tanggalPengaduan.getMonthValue());
            this.tahun = String.valueOf(tanggalPengaduan.getYear());
        }
    }

    public String getJenisFaskes() { return jenisFaskes; }
    public void setJenisFaskes(String jenisFaskes) { this.jenisFaskes = jenisFaskes; }

    public String getKeluhan() { return keluhan; }
    public void setKeluhan(String keluhan) { this.keluhan = keluhan; }

    public String getMembutuhkanTenagaMedis() { return membutuhkanTenagaMedis; }
    public void setMembutuhkanTenagaMedis(String membutuhkanTenagaMedis) { this.membutuhkanTenagaMedis = membutuhkanTenagaMedis; }

    public String getStatusPengaduan() { return statusPengaduan; }
    public void setStatusPengaduan(String statusPengaduan) { this.statusPengaduan = statusPengaduan; }

    public String getBulan() { return bulan; }
    public void setBulan(String bulan) { this.bulan = bulan; }

    public String getTahun() { return tahun; }
    public void setTahun(String tahun) { this.tahun = tahun; }

    public String getDetailSummary() {
        return "Faskes: " + (jenisFaskes == null ? "-" : jenisFaskes)
                + " | Status: " + (statusPengaduan == null ? "-" : statusPengaduan)
                + " | Bulan: " + (bulan == null ? "-" : bulan);
    }
    
    
@ManyToOne
@JoinColumn(name = "id_users", referencedColumnName = "id_users")
private ketuaRt ketuaRt;

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof pengaduanFaskes)) return false;
        pengaduanFaskes other = (pengaduanFaskes) o;
        return Objects.equals(idPengaduan, other.idPengaduan);
    }


public ketuaRt getKetuaRt() {
    return ketuaRt;
}

public void setKetuaRt(ketuaRt ketuaRt) {
    this.ketuaRt = ketuaRt;
}
}


