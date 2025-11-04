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
import java.util.List;
import java.util.Objects;
import model.entity.pengaduanFaskes;
import model.entity.pengaduanMasyarakat;
import org.hibernate.annotations.GenericGenerator;



    @Entity
    @Table(name = "ketua_rt")
    public class ketuaRt implements Serializable, userBehavior {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_users")
    private String idUsers;

    @Column(name = "nama_users", length = 100, nullable = false)
    private String namaUsers;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "no_rt", length = 10, nullable = false)
    private String noRt;

    @Column(name = "rw", length = 10)
    private String rw;

    @Column(name = "alamat", length = 150)
    private String alamat;

    public ketuaRt() {}

    @Override public String getIdUsers() { return idUsers; }

    @Override public String getNamaUsers() { return namaUsers; }
    public void setNamaUsers(String namaUsers) { this.namaUsers = namaUsers; }

    @Override public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNoRt() { return noRt; }
    public void setNoRt(String noRt) { this.noRt = noRt; }

    public String getRw() { return rw; }
    public void setRw(String rw) { this.rw = rw; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }

    
    @OneToMany(mappedBy = "ketuaRt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<pengaduanFaskes> pengaduanFaskesList;

    @OneToMany(mappedBy = "ketuaRt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<pengaduanMasyarakat> pengaduanMasyarakatList;

    
    @Override
    public String getRoleDescription() {
        return "Ketua RT no " + noRt + (rw != null ? " / RW " + rw : "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ketuaRt)) return false;
        return Objects.equals(idUsers, ((ketuaRt) o).idUsers);
    }

    @Override
    public int hashCode() { return Objects.hashCode(idUsers); }

    @Override
    public String toString() {
        return "ketuaRt{" + "idUsers='" + idUsers + '\'' + ", namaUsers='" + namaUsers + '\'' + '}';
    }
}
