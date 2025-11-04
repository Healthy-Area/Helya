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
- [🧩 Use Case Diagram](#-use-case-diagram)
- [📁 Struktur Project](#-struktur-project)
- [💻 Cara Penggunaan Program](#-cara-penggunaan-program)
- [📅 Informasi Tambahan](#-informasi-tambahan)

---

## 👥 **Profil Anggota**

**Kelompok 22**

| **Nama** | **NIM** | **Kelas** | **GitHub Username** |
|-----------|----------|------------|----------------------|
| Taufik Ramadhani | 2409116001 | Sistem Informasi A '24 | [![GitHub]([https://img.shields.io/badge/-Oxcyy-black?logo=github&style=flat-square)](https://github.com/Oxcyy](https://github.com/superamarr)) |
| Moch. Farris Alfiansyah | 2409116079 | Sistem Informasi B '24 | [![GitHub](https://img.shields.io/badge/-Farris636-black?logo=github&style=flat-square)](https://github.com/Farris636) |
| Ghifari Al Azhar | 2409116059 | Sistem Informasi B '24 | [![GitHub](https://img.shields.io/badge/-gfarlz-black?logo=github&style=flat-square)](https://github.com/gfarlz) |
| Yulius Pune | 2409116110 | Sistem Informasi C '24 | [![GitHub](https://img.shields.io/badge/-Oxcyy-black?logo=github&style=flat-square)](https://github.com/Oxcyy) |

---

## 📌 **Deskripsi Project**

Pelayanan publik yang **efektif, cepat tanggap, dan transparan** merupakan hal penting dalam meningkatkan kesejahteraan masyarakat. Namun, di banyak daerah terutama wilayah perbatasan proses pengaduan masyarakat masih dilakukan secara manual melalui surat, kotak saran, atau penyampaian langsung.  
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
### 1. Login
<img width="416" height="603" alt="image" src="https://github.com/user-attachments/assets/30f25f36-bedf-4eee-b2aa-cc21ef1899b4" />

### 2. Menu User
<img width="826" height="726" alt="image" src="https://github.com/user-attachments/assets/3e2d73fb-531f-47e5-b67c-19859f59aabb" />

### 3. Menu Admin
<img width="990" height="732" alt="image" src="https://github.com/user-attachments/assets/a633ac51-4339-4735-863d-81825682d2b4" />

### 4. Kelola User
<img width="579" height="676" alt="image" src="https://github.com/user-attachments/assets/009f6c74-2333-4e31-8d80-d47289766b5a" />

📎 [Klik di sini untuk melihat Flowchart Lengkap](https://app.diagrams.net/?src=about#G1l_0vRv375RYu1bvGWVfsu-FzTx-2HyA5#%7B%22pageId%22%3A%22YSO67Ypj2ylAbOuhdHeY%22%7D)

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
  

📌 **ERD LOGICAL**

<img width="491" height="772" alt="image" src="https://github.com/user-attachments/assets/563eefd2-d33a-4f38-864b-2d4c26030152" />


📌 **ERD RELATIONAL**

<img width="569" height="785" alt="image" src="https://github.com/user-attachments/assets/07dae1e0-0166-4830-a278-d5d173b74e04" />

📎 [Klik di sini untuk melihat ERD Logical dan Relasional](https://app.diagrams.net/)

---

## 🧩 **Use Case Diagram**
> Berikut merupakan ilustrasi hubungan antara aktor (Admin, Ketua RT, dan Pengguna) dengan fungsionalitas utama dalam sistem pengaduan layanan kesehatan.

<img width="1002" height="636" alt="image" src="https://github.com/user-attachments/assets/e5f203c9-59b0-4439-a096-949e50e1d6f8" />

## 📁 **Struktur Project**

<img width="452" height="812" alt="image" src="https://github.com/user-attachments/assets/50310517-14de-4d33-85bd-47991befb19b" />


## 💻 **Cara Penggunaan Program**

###🔐LOGIN
<img width="798" height="565" alt="Screenshot 2025-11-04 221337" src="https://github.com/user-attachments/assets/3f6383ba-36dd-4aa0-b8f2-f989676b41da" />

Panduan awal penggunaan aplikasi HELYA dimulai dengan proses login melalui halaman utama. Pengguna diminta untuk mengisi kolom Username dan Password sesuai data yang telah terdaftar, kemudian menekan tombol Login untuk mengakses sistem. Setelah berhasil masuk, pengguna dapat melanjutkan ke fitur utama seperti pelaporan kondisi kesehatan pribadi maupun fasilitas kesehatan di lingkungan sekitar. Tampilan yang sederhana dan terpusat memudahkan proses autentikasi awal serta memastikan pengalaman penggunaan yang cepat dan efisien.

**👨🏻‍💻 Admin**

Pengguna Admin HELYA bertugas memantau, mengelola, dan memperbarui data pengaduan kesehatan masyarakat serta fasilitas kesehatan. Melalui akun admin, proses pengawasan dan tindak lanjut laporan dapat dilakukan secara cepat dan terkoordinasi.
<details>
  <summary>1️⃣ Dashboard</summary>
  <img width="783" height="529" alt="Screenshot 2025-11-04 221508" src="https://github.com/user-attachments/assets/8d532833-8e7b-4035-bab8-e66a51964ebc" />

  Halaman Dashboard Admin HELYA berfungsi sebagai pusat pemantauan seluruh aktivitas pengaduan kesehatan di wilayah kerja. Tampilan ini menampilkan informasi statistik berupa jumlah pengaduan dari masyarakat dan fasilitas kesehatan, status penanganan laporan, serta grafik perbandingan jenis pengaduan dan jumlah pengaduan berdasarkan sumbernya. Desain dashboard menggunakan warna yang kontras untuk membedakan kategori dan status, seperti hijau untuk laporan selesai, kuning untuk sedang diproses, dan merah untuk belum diperiksa. Melalui tampilan ini, admin dapat dengan mudah memantau, menganalisis, dan mengevaluasi perkembangan penanganan pengaduan secara cepat dan efisien.
</details>

<details>
  <summary>2️⃣ Manajemen Akun</summary>
  <img width="783" height="528" alt="Screenshot 2025-11-04 221542" src="https://github.com/user-attachments/assets/56d2e229-eb86-418c-bed7-6e65bbd1a5d9" />

  Halaman Manajemen Akun berfungsi untuk mengelola data pengguna dalam sistem HELYA, khususnya akun ketua RT yang bertugas memantau dan menindaklanjuti laporan kesehatan di wilayahnya. Tampilan ini menyediakan fitur pencarian berdasarkan nama, serta tombol untuk menambah, memperbarui, dan menghapus akun pengguna. Setiap data ditampilkan dalam tabel berisi nomor, nama, nomor RT, serta opsi tindakan. Desain halaman dibuat sederhana dan terstruktur agar admin dapat melakukan pengelolaan akun dengan cepat, akurat, dan efisien.

  <img width="986" height="701" alt="Screenshot 2025-11-04 224825" src="https://github.com/user-attachments/assets/5ed07616-38a8-45e3-8ef9-1a72b09ba6ab" />
  
  admin dapat mencari Akun dengan menginput nama akun.

  <img width="994" height="697" alt="Screenshot 2025-11-04 224927" src="https://github.com/user-attachments/assets/1d92fc7a-7286-4830-b2d1-b1cc749c4d4b" />

  Admin dapat menambahkan akun pengguna baru.

  <img width="988" height="703" alt="Screenshot 2025-11-04 225113" src="https://github.com/user-attachments/assets/25f9f1ff-779e-44c7-b374-512dea5b3ff9" />

  Admin dapat mengubah data akun pengguna.

  <img width="989" height="700" alt="Screenshot 2025-11-04 225211" src="https://github.com/user-attachments/assets/5da54832-ef1e-4f73-881f-c54aeaf8c6dc" />
  Admin dapat menghapus akun pengguna yang telah dibuat.


  


  
</details>

<details>
  <summary>3️⃣ Manajemen Pengaduan</summary>

  Penjelasan atau isi proyek admin di sini.
  
</details>

<details>
  <summary>4️⃣ Keluar</summary>

  Penjelasan atau isi proyek admin di sini.
  
</details>


<img width="999" height="750" alt="Screenshot 2025-11-04 223014" src="https://github.com/user-attachments/assets/f2ca3667-eae0-4fdb-9b36-ada631b9dfef" />



















## 📅 **Informasi Tambahan**
🧩 **Kebutuhan Sistem**

Sebelum menjalankan program **Sistem Informasi Pengaduan Layanan Kesehatan**, pastinya kami menggunakan beberapa perangkat yang sudah memenuhi beberapa kebutuhan sistem berikut:

- **🧱 JDK 23**  
  Java Development Kit (JDK) berisi kompiler *javac*, pustaka standar Java, serta alat bantu lain yang diperlukan untuk menulis, menjalankan, dan menguji program berbasis Java.

- **🖥️ NetBeans IDE 22**  
  NetBeans merupakan lingkungan pengembangan terintegrasi (IDE) yang mendukung berbagai bahasa pemrograman seperti Java, PHP, dan C++.  
  Versi terbaru memiliki fitur untuk *debugging*, integrasi Git, dan pengembangan aplikasi berbasis web maupun desktop.

- **⚙️ XAMPP**  
  Diperlukan untuk menjalankan aplikasi yang membutuhkan server web, basis data, serta bahasa pemrograman *server-side*.  
  XAMPP mempermudah proses konfigurasi dan pengelolaan lingkungan pengembangan.

- **💾 MySQL**  
  Merupakan sistem manajemen basis data relasional (RDBMS) yang menggunakan bahasa SQL.  
  MySQL berfungsi untuk menyimpan, mengatur, dan mengelola data agar tetap akurat, aman, serta mudah diakses kapan pun dibutuhkan.

- **🔗 MySQL Connector (JDBC)**  
  Pustaka tambahan yang digunakan untuk menghubungkan aplikasi Java dengan basis data MySQL.  
  Dengan konektor ini, aplikasi dapat melakukan proses komunikasi dan pertukaran data dengan database secara langsung.

---

[⬆️ Kembali ke Awal](#-selamat-datang-di-panduan)
