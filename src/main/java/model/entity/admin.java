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
import java.util.Objects;

@Entity
@Table(name = "admin")
public class admin implements Serializable, userBehavior {

    @Id
    @Column(name = "id_users", length = 50)
    private String idUsers;

    @Column(name = "nama_users", length = 100, nullable = false)
    private String namaUsers;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "wilayah", length = 150)
    private String wilayah;

    @Column(name = "total_aduan")
    private Integer totalAduan;

    public admin() {}

    // Encapsulation: getters / setters
    @Override
    public String getIdUsers() { return idUsers; }
    public void setIdUsers(String idUsers) { this.idUsers = idUsers; }

    @Override
    public String getNamaUsers() { return namaUsers; }
    public void setNamaUsers(String namaUsers) { this.namaUsers = namaUsers; }

    @Override
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getWilayah() { return wilayah; }
    public void setWilayah(String wilayah) { this.wilayah = wilayah; }

    public Integer getTotalAduan() { return totalAduan; }
    public void setTotalAduan(Integer totalAduan) { this.totalAduan = totalAduan; }

    // Polymorphism: different roles provide description
    @Override
    public String getRoleDescription() {
        return "Admin wilayah: " + (wilayah == null ? "-" : wilayah);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof admin)) return false;
        return Objects.equals(idUsers, ((admin) o).idUsers);
    }

    @Override
    public int hashCode() { return Objects.hashCode(idUsers); }

    @Override
    public String toString() {
        return "admin{" + "idUsers='" + idUsers + '\'' + ", namaUsers='" + namaUsers + '\'' + '}';
    }
}