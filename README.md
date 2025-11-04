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
| Taufik Ramadhani | 2409116001 | Sistem Informasi A '24 | [![GitHub](https://img.shields.io/badge/-superamarr-black?logo=github&style=flat-square)](https://github.com/superamarr) |
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
   
    <img width="775" height="70" alt="image" src="https://github.com/user-attachments/assets/a1649291-ccfb-4ae8-9f25-a58c3250c488" />

2. **Inheritance** → Class `Pengaduan_Faskes` dan `Pengaduan_Masyarakat` mewarisi atribut umum dari class `Pengaduan`.
   <img width="790" height="97" alt="image" src="https://github.com/user-attachments/assets/3f64c0c7-99dd-464d-8a0d-cae23039c164" />

3. **Abstraction** → Fungsi-fungsi pengelolaan data (CRUD) disembunyikan di balik antarmuka database.
   <img width="698" height="256" alt="image" src="https://github.com/user-attachments/assets/dd1b8307-c133-46c2-80c9-d4ff2e312b98" />

4. **Polymorphism** → Method `tampilkanInfo()` digunakan secara berbeda pada setiap subclass pengaduan.
   <img width="634" height="63" alt="image" src="https://github.com/user-attachments/assets/eb85c5c4-044d-4718-b772-c3427d1dde5f" />

   
5. **Interface** → Interface `DatabaseOperation` diterapkan untuk mengatur method standar (insert, update, delete, select).
   <img width="372" height="171" alt="image" src="https://github.com/user-attachments/assets/25830025-fa69-4a6d-80c0-4d76b36e95ee" />
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

<img width="319" height="924" alt="image" src="https://github.com/user-attachments/assets/c4215c3d-5664-45c7-b8c7-2ace7e0e3449" />

<img width="321" height="914" alt="image" src="https://github.com/user-attachments/assets/2fb331d9-1e22-4464-bfda-2b4836114a09" />

<img width="315" height="952" alt="image" src="https://github.com/user-attachments/assets/f0afb42b-ec14-44ba-9544-6e7dceeb8fb3" />

<img width="316" height="166" alt="image" src="https://github.com/user-attachments/assets/31f7ad32-7007-491a-a8db-931af3162701" />






## 💻 **Cara Penggunaan Program**

---

### 👤 **USER (Pengguna Aplikasi)**

#### 🔐 Login  

<p align="center">
  <img width="798" height="565" alt="Login Page" src="https://github.com/user-attachments/assets/3f6383ba-36dd-4aa0-b8f2-f989676b41da" />
</p>

Langkah pertama sebelum mengakses sistem adalah **login ke aplikasi HELYA**.  
Pengguna wajib mengisi **Username** dan **Password** yang telah terdaftar, kemudian menekan tombol **Login**.

Setelah berhasil masuk, akan muncul notifikasi konfirmasi login seperti berikut:

<p align="center">
  <img width="802" height="559" alt="Screenshot 2025-11-04 221446 1" src="https://github.com/user-attachments/assets/b103e36f-1136-4941-9128-95db7b74ad79" />
</p>

Tampilan ini menunjukkan bahwa pengguna telah berhasil melakukan autentikasi dan siap menggunakan seluruh fitur di dalam sistem.

---

#### 🏠 **Beranda Pengguna**

<p align="center">
  <img width="799" height="667" alt="Screenshot 2025-11-04 231351 1" src="https://github.com/user-attachments/assets/ee69ca2e-41b5-454d-bf37-b780847ab991" />
</p>

Setelah login, pengguna akan diarahkan ke halaman utama aplikasi **HELYA**, di mana mereka dapat:
- Membuat **pengaduan kesehatan pribadi**.  
- Membuat **pengaduan fasilitas kesehatan (puskesmas, rumah sakit, klinik)**.  
- Melihat **riwayat laporan** serta status tindak lanjut pengaduan (*Menunggu, Diproses, Selesai*).  

Tampilan sederhana dan responsif memudahkan pengguna dalam mengakses fitur utama dengan cepat dan efisien.  

---

#### 🩺 **Membuat Pengaduan**  
Pengguna dapat memilih menu **“Pengaduan Kesehatan”** atau **“Pengaduan Fasilitas”**, lalu mengisi formulir berisi:  
- Nama dan alamat pelapor.  
- Jenis keluhan atau permasalahan.  
- Keterangan tambahan atau foto pendukung (opsional).  

Setelah dikirim, laporan otomatis tersimpan di basis data dan dapat dipantau statusnya oleh pengguna dan admin.

---

#### 📊 **Riwayat Laporan**  
Pada bagian bawah halaman utama, terdapat tabel **Riwayat Pengaduan** yang menampilkan:
- Nomor laporan  
- Nama pelapor  
- Jenis pengaduan  
- Status laporan  
- Tombol *Detail* untuk melihat informasi lebih lanjut  

Fitur ini membantu pengguna memantau sejauh mana pengaduannya telah ditindaklanjuti oleh pihak berwenang.  

---

### 👨🏻‍💻 **ADMIN (Pengelola Sistem)**

Pengguna **Admin HELYA** memiliki peran penting dalam memantau, mengelola, dan memperbarui data pengaduan masyarakat serta fasilitas kesehatan.  
Melalui akun admin, proses pengawasan dan tindak lanjut laporan dapat dilakukan secara cepat, terkoordinasi, dan transparan.

---

<details>
  <summary>📊 <b>1️⃣ Dashboard</b></summary>

  <p align="center">
    <img width="783" height="529" alt="Dashboard Admin" src="https://github.com/user-attachments/assets/8d532833-8e7b-4035-bab8-e66a51964ebc" />
  </p>

  Halaman **Dashboard Admin HELYA** berfungsi sebagai pusat pemantauan seluruh aktivitas pengaduan di wilayah kerja.  
  Tampilan ini menampilkan informasi statistik seperti jumlah pengaduan masyarakat, status penanganan laporan, serta grafik perbandingan jenis pengaduan.  

  Desain dashboard menggunakan warna kontras untuk membedakan kategori status:
  - 🟢 **Selesai**
  - 🟡 **Sedang Diproses**
  - 🔴 **Belum Diperiksa**

  Melalui tampilan ini, admin dapat dengan mudah memantau, menganalisis, dan mengevaluasi perkembangan laporan secara efisien.
</details>

---

<details>
  <summary>👥 <b>2️⃣ Manajemen Akun</b></summary>

  <p align="center">
    <img width="783" height="528" alt="Manage Account" src="https://github.com/user-attachments/assets/56d2e229-eb86-418c-bed7-6e65bbd1a5d9" />
  </p>

  Halaman **Manajemen Akun** berfungsi untuk mengelola data pengguna dalam sistem HELYA, khususnya akun **Ketua RT** yang memantau dan menindaklanjuti laporan kesehatan di wilayahnya.  
  Tampilan ini menyediakan fitur pencarian berdasarkan nama, serta tombol untuk menambah, memperbarui, dan menghapus akun pengguna.  

  Setiap data ditampilkan dalam tabel berisi:
  - Nomor akun  
  - Nama pengguna  
  - Nomor RT  
  - Opsi tindakan (Edit / Hapus)  

  ---
  <p align="center">
    <img width="986" height="701" alt="Search Account" src="https://github.com/user-attachments/assets/5ed07616-38a8-45e3-8ef9-1a72b09ba6ab" />
  </p>
  Admin dapat mencari akun dengan menginput nama akun.

  ---
  <p align="center">
    <img width="994" height="697" alt="Add Account" src="https://github.com/user-attachments/assets/1d92fc7a-7286-4830-b2d1-b1cc749c4d4b" />
  </p>
  Admin dapat menambahkan akun pengguna baru.

  ---
  <p align="center">
    <img width="988" height="703" alt="Edit Account" src="https://github.com/user-attachments/assets/25f9f1ff-779e-44c7-b374-512dea5b3ff9" />
  </p>
  Admin dapat mengubah data akun pengguna.

  ---
  <p align="center">
    <img width="989" height="700" alt="Delete Account" src="https://github.com/user-attachments/assets/5da54832-ef1e-4f73-881f-c54aeaf8c6dc" />
  </p>
  Admin dapat menghapus akun pengguna yang telah dibuat.
</details>

---

<details>
  <summary>🧾 <b>3️⃣ Manajemen Pengaduan</b></summary>

  <p align="center">
    <img width="999" height="750" alt="Manage Reports" src="https://github.com/user-attachments/assets/f2ca3667-eae0-4fdb-9b36-ada631b9dfef" />
  </p>

  Halaman **Manajemen Pengaduan** memungkinkan admin melihat seluruh laporan pengaduan dari masyarakat dan fasilitas kesehatan.  
  Data ditampilkan dalam bentuk tabel dengan informasi seperti:
  - Nama Pelapor  
  - Jenis Pengaduan  
  - Status Penanganan  
  - Tanggal Laporan  
  - Opsi Aksi (Lihat / Update / Hapus)

  Fitur pencarian dan filter memudahkan admin untuk mengelompokkan laporan berdasarkan status (*Menunggu, Diproses, Selesai*).  
  Desain halaman ini membantu admin memantau perkembangan setiap pengaduan dengan cepat dan akurat.
</details>

---

<details>
  <summary>🚪 <b>4️⃣ Keluar</b></summary>

  Fitur **Keluar (Logout)** berfungsi untuk mengakhiri sesi admin dan memastikan keamanan akun.  
  Setelah logout, sistem akan mengarahkan kembali ke halaman **Login**, menjaga agar akses aplikasi tetap aman dan terbatas hanya untuk pengguna yang berwenang.
</details>



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
