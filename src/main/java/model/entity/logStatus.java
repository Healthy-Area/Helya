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
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import model.util.HibernateUtil;
import model.util.pengaduanResolver;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "log_status")
public class logStatus implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_log")
    private String idLog;

    @Column(name = "status_baru", length = 50)
    private String statusBaru;

    @Column(name = "keterangan", length = 100)
    private String keterangan;

    @Column(name = "waktu_update")
    private LocalDateTime waktuUpdate;

    // DB stores id_pengaduan (varchar) — kita simpan itu langsung, tanpa FK Hibernate ke entitas parent
    @Column(name = "id_pengaduan", length = 50)
    private String idPengaduan;

    public logStatus() {}
    public String getIdLog() {
        return idLog;
    }

    public void setIdLog(String idLog) {
        this.idLog = idLog;
    }

    public String getStatusBaru() { return statusBaru; }
    public void setStatusBaru(String statusBaru) { this.statusBaru = statusBaru; }

    public String getKeterangan() { return keterangan; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }

    public LocalDateTime getWaktuUpdate() { return waktuUpdate; }
    public void setWaktuUpdate(LocalDateTime waktuUpdate) { this.waktuUpdate = waktuUpdate; }

    public String getIdPengaduan() { return idPengaduan; }
    public void setIdPengaduan(String idPengaduan) { this.idPengaduan = idPengaduan; }

    @Transient
    public pengaduanBase resolvePengaduan() {
        // helper ringan: gunakan pengaduanResolver (DAO) untuk ambil entity aktual
    pengaduanResolver resolver = new pengaduanResolver(HibernateUtil.getSessionFactory());
    return (pengaduanBase) resolver.resolveById(idPengaduan);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof logStatus)) return false;
        return Objects.equals(idLog, ((logStatus) o).idLog);
    }

    @Override
    public int hashCode() { return Objects.hashCode(idLog); }

    @Override
    public String toString() {
        return "logStatus{" + "idLog='" + idLog + '\'' + ", statusBaru='" + statusBaru + '\'' + '}';
    }
}
