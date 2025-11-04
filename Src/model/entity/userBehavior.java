/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import jakarta.persistence.MappedSuperclass;

/**
 *
 * @author Aspire5
 */
@MappedSuperclass
public interface userBehavior {
    String getIdUsers();
    String getNamaUsers();
    String getUsername();
    String getRoleDescription();
}
