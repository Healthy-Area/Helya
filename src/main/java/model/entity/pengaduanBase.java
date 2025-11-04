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
@MappedSuperclass
public abstract class pengaduanBase {
    @Column(name = "status", length = 50)
    protected String status;

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public abstract String getDetailSummary();
}

