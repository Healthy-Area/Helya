# 🩺 Selamat Datang di Panduan **APLIKASI SISTEM INFORMASI PENGADUAN LAYANAN KESEHATAN!**
### *Meningkatkan Efektivitas dan Transparansi Pelayanan Publik*

---

## 📚 **Daftar Isi**
- [👥 Profil Anggota](#-profil-anggota)
- [📌 Deskripsi Project](#-deskripsi-project)
- [🎯 Tujuan Pengembangan](#-tujuan-pengembangan)
- [📊 Flowchart](#-flowchart)
- [🗂️ ERD](#️-erd)
- [📁 Struktur Project](#-struktur-project)
- [💻 Penjelasan dan Penggunaan Aplikasi](#-penjelasan-dan-penggunaan-aplikasi)

---

## 👥 **Profil Anggota**

**Kelompok 22**

| **Nama** | **NIM** | **Kelas** | **GitHub Username** |
|-----------|----------|------------|----------------------|
| Taufik Ramadhani | 2409116001 | Sistem Informasi A '24 | [![GitHub](https://img.shields.io/badge/-Rofiif-black?logo=github&style=flat-square)](https://github.com/Rofiif) |
| Moch. Farris Alfiansyah | 2409116079 | Sistem Informasi B '24 | [![GitHub](https://img.shields.io/badge/-Lintang-black?logo=github&style=flat-square)](https://github.com/Lintang) |
| Ghifari Al Azhar | 2409116059 | Sistem Informasi B '24 | [![GitHub](https://img.shields.io/badge/-Rizky-black?logo=github&style=flat-square)](https://github.com/Rizky) |
| Yulius Pune | 2409116111 | Sistem Informasi C '24 | [![GitHub](https://img.shields.io/badge/-Amir-black?logo=github&style=flat-square)](https://github.com/Amir) |

---

## 📌 **Deskripsi Project**

Pelayanan publik yang **efektif, cepat tanggap, dan transparan** merupakan hal penting dalam meningkatkan kesejahteraan masyarakat. Namun, di banyak daerah — terutama wilayah perbatasan — proses pengaduan masyarakat masih dilakukan secara manual melalui surat, kotak saran, atau penyampaian langsung.  
Kondisi ini menyebabkan proses penanganan keluhan menjadi lambat, data mudah hilang, dan menyulitkan pihak berwenang dalam melakukan tindak lanjut laporan.

Sebagai solusi, dikembangkanlah **Sistem Informasi Pengaduan Layanan Kesehatan** berbasis online yang memungkinkan masyarakat menyampaikan pengaduan kapan saja dan di mana saja tanpa batas waktu dan jarak. Sistem ini menyimpan seluruh data secara **terpusat** menggunakan **basis data relasional (DB_HELIA)** sehingga setiap laporan dapat ditangani dengan lebih cepat, transparan, dan terukur.

Sistem ini dilengkapi dengan:
- Fitur pengaduan masyarakat dan pengaduan fasilitas kesehatan.  
- Fitur log status untuk memantau perkembangan laporan.  
- Fitur tips otomatis yang memberikan saran kesehatan sesuai keluhan.  
- Fitur admin dan ketua RT untuk mengelola dan memverifikasi pengaduan masyarakat.  

---

## 🎯 **Tujuan Pengembangan**
a. Meningkatkan efektivitas pelayanan publik dalam proses penanganan dan tindak lanjut pengaduan masyarakat di sektor kesehatan.  
b. Meningkatkan transparansi dan akuntabilitas dalam pengelolaan data pengaduan melalui sistem basis data terintegrasi.  
c. Mendukung partisipasi aktif masyarakat dalam pemantauan dan evaluasi pelayanan kesehatan di lingkungannya.

---

## 📊 **Flowchart**
1. Flowchart Sistem Utama  
2. Flowchart Menu Login & Register  
3. Flowchart Menu Pengaduan (User)  
4. Flowchart Verifikasi Pengaduan (Admin)  
5. Flowchart Tips Otomatis  

📎 [Klik di sini untuk melihat Flowchart Lengkap](https://app.diagrams.net/)

---

## 🗂️ **ERD**
Entitas utama sistem:
- **Admin**
- **Ketua_RT**
- **Pengaduan_Faskes**
- **Pengaduan_Masyarakat**
- **Log_Status**
- **Tips_Otomatis**

Relasi utama:
- `Users` ↔ `Admin` (1:1)  
- `Users` ↔ `Ketua_RT` (1:1)  
- `Users` ↔ `Pengaduan` (1:N)  
- `Pengaduan` ↔ `Log_Status` (1:N)  
- `Pengaduan_Masyarakat` ↔ `Tips_Otomatis` (N:M)

📎 [Klik di sini untuk melihat ERD Logical dan Relasional](https://app.diagrams.net/)

---

## 📁 **Struktur Project**
