/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author Aspire5
 */

public class LoginSession {
    private static String wilayah;

    private static String idUsers;
    private static String username;

    public static void setUsername(String user) {
        username = user;
    }

    public static String getUsername() {
        return username;
    }

    public static void setIdUsers(String id) {
        idUsers = id;
    }

    public static String getIdUsers() {
        return idUsers;
    }
    
    public static void setWilayah(String w) {
        wilayah = w;
    }

    public static String getWilayah() {
        return wilayah;
    }
    
}

