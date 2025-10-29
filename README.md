# 🩺 SISTEM INFORMASI PENGADUAN LAYANAN KESEHATAN  
### *Meningkatkan Efektivitas dan Transparansi Pelayanan Publik*

---

## 📚 **Daftar Isi**
- [👥 Profil Anggota](#-profil-anggota)
- [📌 Deskripsi Project](#-deskripsi-project)
- [🎯 Tujuan Pengembangan](#-tujuan-pengembangan)
- [📊 Flowchart](#-flowchart)
- [🗂️ ERD](#️-erd)
- [💾 Struktur Basis Data](#-struktur-basis-data)
- [💻 Penerapan dan Fitur Utama](#-penerapan-dan-fitur-utama)
- [📈 Kesimpulan](#-kesimpulan)

---

## 👥 **Profil Anggota**

**Kelompok:  Sistem Informasi Pengaduan Layanan Kesehatan**  
**Praktikum Sistem Basis Data – Universitas Mulawarman (2025)**  

| Nama | NIM | Kelas |
|------|-----|--------|
| Taufik Ramadhani | 2409116001 | Sistem Informasi A ‘23 |
| Moch. Farris Alfiansyah | 2409116079 | Sistem Informasi A ‘23 |
| Ghifari Al Azhar | 2409116059 | Sistem Informasi A ‘23 |
| Yulius Pune | 2409116110 | Sistem Informasi A ‘23 |

---

## 📌 **Deskripsi Project**

Pelayanan publik yang **efektif, cepat tanggap, dan transparan** merupakan elemen penting dalam meningkatkan kesejahteraan masyarakat. Namun, di banyak daerah — terutama wilayah perbatasan — proses pengaduan masyarakat masih dilakukan secara manual melalui surat, kotak saran, atau penyampaian langsung.  
Kondisi ini menyebabkan proses pengelolaan keluhan menjadi lambat, data rentan hilang, dan menghambat tindak lanjut oleh pihak berwenang.

Sebagai solusi, dikembangkanlah **Sistem Informasi Pengaduan Layanan Kesehatan** berbasis online untuk mendigitalisasi proses pelaporan masyarakat terhadap masalah pelayanan kesehatan. Sistem ini memungkinkan masyarakat untuk:
- Menyampaikan pengaduan secara **online** kapan saja dan di mana saja.  
- Melihat **status dan tindak lanjut** laporan secara *real time*.  
- Mendapatkan **tips otomatis kesehatan** sesuai keluhan yang dilaporkan.  

Pihak **admin** dan **ketua RT** dapat memantau pengaduan masyarakat, memverifikasi laporan, serta menindaklanjuti masalah berdasarkan wilayahnya.  
Seluruh data tersimpan dalam **basis data terpusat (DB_HELIA)**, sehingga proses pengelolaan lebih aman, efisien, dan transparan.

---

## 🎯 **Tujuan Pengembangan**
a. Meningkatkan efektivitas pelayanan publik dalam penanganan pengaduan sektor kesehatan.  
b. Meningkatkan transparansi dan akuntabilitas data melalui sistem database terintegrasi.  
c. Mendukung partisipasi aktif masyarakat dalam evaluasi dan pemantauan pelayanan kesehatan di lingkungannya.  

---

## 📊 **Flowchart**
1. Flowchart Umum Sistem  
2. Flowchart Menu Login dan Register  
3. Flowchart Pengaduan (User)  
4. Flowchart Verifikasi dan Laporan (Admin/RT)  
5. Flowchart Tips Otomatis  

📎 [Klik di sini untuk melihat Flowchart Lengkap](https://app.diagrams.net/)

---

## 🗂️ **ERD**
Entitas utama dalam sistem:
- **Admin**  
- **Ketua_RT**  
- **Pengaduan_Faskes**  
- **Pengaduan_Masyarakat**  
- **Log_Status**  
- **Tips_Otomatis**

Relasi utama antar entitas:
- `Users` → `Admin` (1:1)  
- `Users` → `Ketua_RT` (1:1)  
- `Users` → `Pengaduan` (1:N)  
- `Pengaduan` → `Log_Status` (1:N)  
- `Pengaduan_Masyarakat` ↔ `Tips_Otomatis` (N:M)

📎 [Lihat ERD Logical & Relasional di Draw.io](https://app.diagrams.net/)

---

## 💾 **Struktur Basis Data**

### 🔹 Tabel Utama
1. **Admin** — Menyimpan data pengelola wilayah.  
2. **Ketua_RT** — Menyimpan data pengurus lingkungan (wilayah pelapor).  
3. **Pengaduan_Faskes** — Menyimpan laporan terkait fasilitas kesehatan.  
4. **Pengaduan_Masyarakat** — Menyimpan data pelapor & kondisi kesehatan.  
5. **Log_Status** — Mencatat perubahan status pengaduan secara kronologis.  
6. **Tips_Otomatis** — Berisi saran kesehatan otomatis berdasarkan keluhan.

### 🔹 Contoh Database
