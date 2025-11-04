/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.net.URL;

/**
 *
 * @author Aspire5
 */
public class main {
       public static void main(String[] args) {
        // 🔍 Daftar semua path gambar yang digunakan di dashboard & manajemenAkun
        String[] imagePaths = {
            "/img/dashboard-menu.png",
            "/img/dashboard-manajemen-akun.png",
            "/img/dashboard-manajemen-pengaduan.png",
            "/img/keluar-db.png",
            "/img/welcome-db.png",
            "/img/navbar-db.png",
            "/img/sidebar-db.png",
            "/img/bg-db.png",
            "/img/pengmas.png",
            "/img/filter.png",
            "/img/icon_edit.png"
        };

        System.out.println("🔎 Memeriksa ketersediaan semua gambar di /img/");
        System.out.println("===============================================");

        int missingCount = 0;
        for (String path : imagePaths) {
            URL url = main.class.getResource(path);
            if (url == null) {
                System.out.println("❌ Gambar tidak ditemukan: " + path);
                missingCount++;
            } else {
                System.out.println("✅ Gambar ditemukan: " + path);
            }
        }

        System.out.println("===============================================");
        if (missingCount == 0) {
            System.out.println("🎉 Semua gambar tersedia dengan benar!");
        } else {
            System.out.println("⚠️ Total gambar yang hilang: " + missingCount);
            System.out.println("Pastikan semua file berada di folder: src/main/resources/img/");
        }
    }
}
