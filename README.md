<div align="center">

# 🩺 **Selamat Datang di Panduan**

### 🧠 **APLIKASI SISTEM INFORMASI PENGADUAN LAYANAN KESEHATAN**

*Meningkatkan Efektivitas dan Transparansi Pelayanan Publik*

</div>

---

## 📚 **Daftar Isi**

- [👥 Profil Anggota](#-profil-anggota)
- [📌 Deskripsi Project](#-deskripsi-project)
- [🎯 Tujuan Pengembangan](#-tujuan-pengembangan)
- [⚙️ Fitur Program](#️-fitur-program)
- [🧱 Penerapan OOP](#-penerapan-oop-object-oriented-programming)
- [📊 Flowchart](#-flowchart)
- [🗂️ ERD](#️-erd)
- [📁 Struktur Project](#-struktur-project)
- [💻 Cara Penggunaan Program](#-cara-penggunaan-program)
- [📅 Informasi Tambahan](#-informasi-tambahan)


---

## 👥 **Profil Anggota**

**Kelompok 22**

| **Nama** | **NIM** | **Kelas** | **GitHub Username** |
|-----------|----------|------------|----------------------|
| Taufik Ramadhani | 2409116001 | Sistem Informasi A '24 | [![GitHub](https://img.shields.io/badge/-Rofiif-black?logo=github&style=flat-square)](https://github.com/Rofiif) |
| Moch. Farris Alfiansyah | 2409116079 | Sistem Informasi B '24 | [![GitHub](https://img.shields.io/badge/-Lintang-black?logo=github&style=flat-square)](https://github.com/Lintang) |
| Ghifari Al Azhar | 2409116059 | Sistem Informasi B '24 | [![GitHub](https://img.shields.io/badge/-Rizky-black?logo=github&style=flat-square)](https://github.com/Rizky) |
| Yulius Pune | 2409116110 | Sistem Informasi C '24 | [![GitHub](https://img.shields.io/badge/-Amir-black?logo=github&style=flat-square)](https://github.com/Amir) |

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

## ⚙️ FITUR PROGRAM
### 👤 Pengguna (Masyarakat)
- Registrasi dan login akun.
- Mengirimkan laporan pengaduan terkait fasilitas kesehatan.
- Melihat status tindak lanjut laporan secara real time.
- Mendapatkan tips otomatis sesuai jenis pengaduan.

### 🧑‍💼 Admin
- Melihat seluruh laporan yang masuk dari masyarakat.
- Memverifikasi dan memperbarui status laporan (*Menunggu, Diproses, Selesai*).
- Mengelola data pengguna dan wilayah kerja.
- Menyediakan riwayat dan statistik pengaduan.

### 👥 Ketua RT
- Mengelola laporan dari wilayahnya.
- Menjadi penghubung antara masyarakat dan admin.
- Memantau perkembangan tindak lanjut laporan.

---

## 🧱 PENERAPAN OOP (Object-Oriented Programming)
Program ini menerapkan **5 Pilar OOP**:
1. **Encapsulation** → Setiap entitas seperti *Admin*, *Pengaduan*, *RT*, dan *Tips* dibuat dalam class terpisah dengan atribut privat dan method publik.  
2. **Inheritance** → Class `Pengaduan_Faskes` dan `Pengaduan_Masyarakat` mewarisi atribut umum dari class `Pengaduan`.  
3. **Abstraction** → Fungsi-fungsi pengelolaan data (CRUD) disembunyikan di balik antarmuka database.  
4. **Polymorphism** → Method `tampilkanInfo()` digunakan secara berbeda pada setiap subclass pengaduan.  
5. **Interface** → Interface `DatabaseOperation` diterapkan untuk mengatur method standar (insert, update, delete, select).

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
