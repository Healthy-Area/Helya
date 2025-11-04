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
@Table(name = "tips_otomatis")
public class tipsOtomatis implements Serializable {

    @Id
    @Column(name = "id_tips", length = 50)
    private String idTips;

    @Column(name = "isi_tips", length = 200, nullable = false)
    private String isiTips;

    public tipsOtomatis() {}

    public String getIdTips() { return idTips; }
    public void setIdTips(String idTips) { this.idTips = idTips; }

    public String getIsiTips() { return isiTips; }
    public void setIsiTips(String isiTips) { this.isiTips = isiTips; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof tipsOtomatis)) return false;
        return Objects.equals(idTips, ((tipsOtomatis) o).idTips);
    }

    @Override
    public int hashCode() { return Objects.hashCode(idTips); }

    @Override
    public String toString() {
        return "tipsOtomatis{" + "idTips='" + idTips + '\'' + '}';
    }
}

