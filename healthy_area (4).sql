-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 04 Nov 2025 pada 15.53
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `healthy_area`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_users` varchar(50) NOT NULL,
  `nama_users` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `wilayah` varchar(150) DEFAULT NULL,
  `total_aduan` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_users`, `nama_users`, `username`, `password`, `wilayah`, `total_aduan`) VALUES
('U001', 'Admin Kutai Kartanegara', 'admin_kukar', '12345', 'Kabupaten Kutai Kartanegara', 27),
('U002', 'Admin Kutai Timur', 'admin_kutim', '12345', 'Kabupaten Kutai Timur', 18),
('U003', 'Admin Berau', 'admin_berau', '12345', 'Kabupaten Berau', 12),
('U004', 'Admin Paser', 'admin_paser', '12345', 'Kabupaten Paser', 15),
('U005', 'Admin Penajam Paser Utara', 'admin_ppu', '12345', 'Kabupaten Penajam Paser Utara', 9),
('U006', 'Admin Kutai Barat', 'admin_kubar', '12345', 'Kabupaten Kutai Barat', 8),
('U007', 'Admin Mahakam Ulu', 'admin_mahakamulu', '12345', 'Kabupaten Mahakam Ulu', 6),
('U008', 'Admin Balikpapan', 'admin_balikpapan', '12345', 'Kota Balikpapan', 10),
('U009', 'Admin Bontang', 'admin_bontang', '12345', 'Kota Bontang', 11),
('U010', 'Admin Mahulu', 'admin_mahulu', '12345', 'Kabupaten Mahulu', 5),
('U011', 'Admin Kalimantan Timur', 'admin_kaltim', '12345', 'Kalimantan Timur', 40),
('U012', 'Admin Kota Samarinda', 'admin_samarinda', '12345', 'Kota Samarinda', 32);

-- --------------------------------------------------------

--
-- Struktur dari tabel `ketua_rt`
--

CREATE TABLE `ketua_rt` (
  `id_users` varchar(50) NOT NULL,
  `nama_users` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `no_rt` varchar(10) NOT NULL,
  `rw` varchar(10) DEFAULT NULL,
  `alamat` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `ketua_rt`
--

INSERT INTO `ketua_rt` (`id_users`, `nama_users`, `username`, `password`, `no_rt`, `rw`, `alamat`) VALUES
('9b373a1e-4254-4e76-b94d-cf0ecaa9e757', 'topik', 'topik1', '12345', '3', NULL, 'Paser'),
('U001', 'Ketua RT 01', 'rt01', '12345', '01', '03', 'Jl. Merdeka No. 10, Tenggarong, Kutai Kartanegara'),
('U002', 'Ketua RT 02', 'rt02', '12345', '02', '01', 'Jl. Kenanga No. 5, Sangatta, Kutai Timur'),
('U003', 'Ketua RT 03', 'rt03', '12345', '03', '02', 'Jl. Mangga No. 2, Tanjung Redeb, Berau'),
('U004', 'Ketua RT 04', 'rt04', '12345', '04', '02', 'Jl. Melati No. 8, Tanah Grogot, Paser'),
('U005', 'Ketua RT 05', 'rt05', '12345', '05', '02', 'Jl. Bunga No. 7, Penajam, Penajam Paser Utara'),
('U006', 'Ketua RT 06', 'rt06', '12345', '06', '02', 'Jl. Durian No. 4, Sendawar, Kutai Barat'),
('U007', 'Ketua RT 07', 'rt07', '12345', '07', '02', 'Jl. Flamboyan No.12, Ujoh Bilang, Mahakam Ulu'),
('U008', 'Ketua RT 08', 'rt08', '12345', '08', '03', 'Jl. Hutan No.3, Balikpapan, Kota Balikpapan'),
('U009', 'Ketua RT 09', 'rt09', '12345', '09', '03', 'Jl. Sultan Iskandar Muda No.1, Samarinda, Kota Samarinda'),
('U010', 'Ketua RT 10', 'rt10', '12345', '10', '03', 'Jl. Laut No.6, Bontang, Kota Bontang');

-- --------------------------------------------------------

--
-- Struktur dari tabel `log_status`
--

CREATE TABLE `log_status` (
  `id_log` varchar(50) NOT NULL,
  `status_baru` varchar(50) NOT NULL,
  `keterangan` varchar(100) DEFAULT NULL,
  `waktu_update` timestamp NOT NULL DEFAULT current_timestamp(),
  `id_pengaduan` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `log_status`
--

INSERT INTO `log_status` (`id_log`, `status_baru`, `keterangan`, `waktu_update`, `id_pengaduan`) VALUES
('193104eb-7e32-4df4-a7ec-92907dc53f1b', 'Belum Diperiksa', NULL, '2025-11-02 19:37:16', 'M017'),
('36375dc9-1efd-482a-9cbc-db4a27ca20f8', 'Sedang Diproses', NULL, '2025-11-02 23:16:01', 'F034'),
('928e261b-beb4-40b6-9fd3-bc9a082e3298', 'Telah Diperiksa', NULL, '2025-11-02 19:36:17', 'M040'),
('ad8b580e-a04e-472b-9e31-f537fbb18550', 'Sedang Diproses', NULL, '2025-11-04 06:29:07', '3ccab5c4-2a2d-4024-8972-4ed3a1fe873e'),
('ce984353-4727-43f5-91d6-c30ee286380c', 'Selesai', NULL, '2025-11-03 21:39:17', '5db3cb84-1c5f-48e1-80d5-ecdba3770490'),
('f46ded13-c376-4cd1-b3e4-550c05c4c98d', 'Sedang Diproses', NULL, '2025-11-03 04:42:13', 'F002'),
('L001', 'Belum Diproses', 'Laporan baru diterima', '2025-10-20 14:41:37', 'P001'),
('L002', 'Dalam Proses', 'Sedang ditinjau oleh ketua RT', '2025-10-20 14:41:37', 'P002'),
('L003', 'Selesai', 'Masalah selesai ditangani', '2025-10-20 14:41:37', 'P003'),
('L004', 'Dalam Proses', 'Pengaduan sedang diverifikasi', '2025-10-20 14:41:37', 'P004'),
('L005', 'Selesai', 'Perbaikan sudah dilakukan', '2025-10-20 14:41:37', 'P005'),
('L006', 'Belum Diproses', 'Menunggu verifikasi data pelapor', '2025-10-20 14:41:37', 'P006'),
('L007', 'Dalam Proses', 'Tim kesehatan sedang menuju lokasi', '2025-10-20 14:41:37', 'P007'),
('L008', 'Selesai', 'Laporan tuntas diproses', '2025-10-20 14:41:37', 'P008'),
('L009', 'Belum Diproses', 'Pengaduan baru masuk sistem', '2025-10-20 14:41:37', 'P009'),
('L010', 'Dalam Proses', 'Sedang dikonfirmasi oleh petugas RT', '2025-10-20 14:41:37', 'P010'),
('L011', 'Selesai', 'Laporan diselesaikan dengan baik', '2025-10-20 14:41:37', 'P011'),
('L012', 'Dalam Proses', 'Menunggu tindak lanjut', '2025-10-20 14:41:37', 'P012'),
('L013', 'Selesai', 'Sudah diverifikasi dan ditangani', '2025-10-20 14:41:37', 'P013'),
('L014', 'Belum Diproses', 'Belum ada tindakan', '2025-10-20 14:41:37', 'P014'),
('L015', 'Dalam Proses', 'Tim sedang melakukan pengecekan', '2025-10-20 14:41:37', 'P015'),
('L016', 'Selesai', 'Masalah selesai dengan cepat', '2025-10-20 14:41:37', 'P016'),
('L017', 'Belum Diproses', 'Menunggu validasi laporan', '2025-10-20 14:41:37', 'P017'),
('L018', 'Dalam Proses', 'RT sedang berkoordinasi', '2025-10-20 14:41:37', 'P018'),
('L019', 'Selesai', 'Laporan sudah tuntas', '2025-10-20 14:41:37', 'P019'),
('L020', 'Belum Diproses', 'Data pengadu baru dimasukkan', '2025-10-20 14:41:37', 'P020'),
('L021', 'Dalam Proses', 'Masih dalam tahap investigasi', '2025-10-20 14:41:37', 'P021'),
('L022', 'Selesai', 'Sudah ditangani pihak terkait', '2025-10-20 14:41:37', 'P022'),
('L023', 'Dalam Proses', 'Tim RT sedang memverifikasi', '2025-10-20 14:41:37', 'P023'),
('L024', 'Belum Diproses', 'Menunggu petugas', '2025-10-20 14:41:37', 'P024'),
('L025', 'Dalam Proses', 'Sudah diteruskan ke puskesmas', '2025-10-20 14:41:37', 'P025'),
('L026', 'Selesai', 'Kasus diselesaikan oleh RT', '2025-10-20 14:41:37', 'P026'),
('L027', 'Belum Diproses', 'Belum diverifikasi', '2025-10-20 14:41:37', 'P027'),
('L028', 'Dalam Proses', 'Pemeriksaan sedang berjalan', '2025-10-20 14:41:37', 'P028'),
('L029', 'Selesai', 'Sudah tuntas diproses', '2025-10-20 14:41:37', 'P029'),
('L030', 'Belum Diproses', 'Menunggu tindak lanjut RT', '2025-10-20 14:41:37', 'P030'),
('L031', 'Dalam Proses', 'Proses sedang dilakukan', '2025-10-20 14:41:37', 'P031'),
('L032', 'Selesai', 'Permasalahan sudah ditutup', '2025-10-20 14:41:37', 'P032'),
('L033', 'Belum Diproses', 'Laporan masuk hari ini', '2025-10-20 14:41:37', 'P033'),
('L034', 'Dalam Proses', 'Tim meninjau lokasi', '2025-10-20 14:41:37', 'P034'),
('L035', 'Selesai', 'Sudah selesai diproses', '2025-10-20 14:41:37', 'P035'),
('L036', 'Belum Diproses', 'Data masih dicek', '2025-10-20 14:41:37', 'P036'),
('L037', 'Dalam Proses', 'Verifikasi oleh ketua RT', '2025-10-20 14:41:37', 'P037'),
('L038', 'Selesai', 'Sudah selesai dan didokumentasikan', '2025-10-20 14:41:37', 'P038'),
('L039', 'Dalam Proses', 'Pengecekan di lapangan', '2025-10-20 14:41:37', 'P039'),
('L040', 'Selesai', 'Laporan ditutup', '2025-10-20 14:41:37', 'P040');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengaduan_faskes`
--

CREATE TABLE `pengaduan_faskes` (
  `id_pengaduan` varchar(50) NOT NULL,
  `id_users` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `tanggal_pengaduan` date DEFAULT current_timestamp(),
  `jenis_faskes` varchar(50) DEFAULT NULL,
  `keluhan` varchar(255) DEFAULT NULL,
  `membutuhkan_tenaga_medis` varchar(10) DEFAULT NULL,
  `status_pengaduan` varchar(50) DEFAULT 'Belum diperiksa',
  `bulan` varchar(20) DEFAULT NULL,
  `tahun` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pengaduan_faskes`
--

INSERT INTO `pengaduan_faskes` (`id_pengaduan`, `id_users`, `status`, `tanggal_pengaduan`, `jenis_faskes`, `keluhan`, `membutuhkan_tenaga_medis`, `status_pengaduan`, `bulan`, `tahun`) VALUES
('3ccab5c4-2a2d-4024-8972-4ed3a1fe873e', 'U001', NULL, '2025-11-04', 'Rumah Sakit', 'vfvfffffcdc', 'Dokter', 'Sedang Diproses', '11', '2025'),
('5db3cb84-1c5f-48e1-80d5-ecdba3770490', 'U001', NULL, '2025-11-05', 'Puskesmas', 'kurang terawat', 'Perawat', 'Selesai', '11', '2025'),
('d8545f1e-53ca-4f56-9cb4-3f2fd32f022f', 'U001', NULL, '2025-11-04', 'Rumah Sakit', 'bau', 'Dokter', 'Belum Diproses', '11', '2025'),
('F002', 'U003', 'Aktif', '2025-01-10', 'Puskesmas', 'Pelayanan lambat', 'Ya', 'Sedang Diproses', 'Januari', '2025'),
('F003', 'U004', 'Aktif', '2025-01-12', 'Klinik', 'Kurangnya tenaga medis', 'Tidak', 'Sedang Diproses', 'Januari', '2025'),
('F004', 'U006', 'Aktif', '2025-01-15', 'Rumah Sakit', 'Obat sering habis', 'Ya', 'Selesai', 'Januari', '2025'),
('F005', 'U004', 'Aktif', '2025-01-22', 'Puskesmas', 'Ruang tunggu sempit', 'Tidak', 'Sedang Diproses', 'Februari', '2025'),
('F006', 'U005', 'Aktif', '2025-01-27', 'Klinik', 'Administrasi lambat', 'Tidak', 'Sedang Diproses', 'Februari', '2025'),
('F007', 'U004', 'Aktif', '2025-02-05', 'Puskesmas', 'Tenaga medis kurang', 'Ya', 'Selesai', 'Februari', '2025'),
('F008', 'U006', 'Aktif', '2025-02-09', 'Rumah Sakit', 'Dokter sering terlambat', 'Tidak', 'Sedang Diproses', 'Februari', '2025'),
('F009', 'U002', 'Aktif', '2025-02-14', 'Klinik', 'Klinik sering tutup tanpa pemberitahuan', 'Ya', 'Belum Diproses', 'Februari', '2025'),
('F010', 'U007', 'Aktif', '2025-02-21', 'Puskesmas', 'Alat laboratorium rusak', 'Ya', 'Sedang Diproses', 'Maret', '2025'),
('F011', 'U006', 'Aktif', '2025-02-28', 'Klinik', 'Parkiran tidak memadai', 'Tidak', 'Selesai', 'Maret', '2025'),
('F012', 'U007', 'Aktif', '2025-03-03', 'Rumah Sakit', 'Kamar rawat inap penuh', 'Ya', 'Belum Diproses', 'Maret', '2025'),
('F013', 'U004', 'Aktif', '2025-03-10', 'Puskesmas', 'Petugas administrasi tidak ramah', 'Tidak', 'Sedang Diproses', 'Maret', '2025'),
('F014', 'U010', 'Aktif', '2025-03-15', 'Klinik', 'Biaya pemeriksaan tidak transparan', 'Tidak', 'Selesai', 'April', '2025'),
('F015', 'U002', 'Aktif', '2025-03-20', 'Puskesmas', 'Ruangan perawatan panas', 'Tidak', 'Belum Diproses', 'April', '2025'),
('F016', 'U004', 'Aktif', '2025-03-25', 'Rumah Sakit', 'Kurangnya fasilitas IGD', 'Ya', 'Sedang Diproses', 'April', '2025'),
('F017', 'U003', 'Aktif', '2025-04-01', 'Klinik', 'Layanan BPJS lambat', 'Tidak', 'Selesai', 'April', '2025'),
('F018', 'U008', 'Aktif', '2025-04-06', 'Puskesmas', 'Dokter tidak hadir sesuai jadwal', 'Ya', 'Sedang Diproses', 'Mei', '2025'),
('F019', 'U007', 'Aktif', '2025-04-09', 'Klinik', 'Kebersihan ruang tunggu kurang', 'Tidak', 'Belum Diproses', 'Mei', '2025'),
('F020', 'U007', 'Aktif', '2025-04-12', 'Rumah Sakit', 'Waktu tunggu lama di apotek', 'Ya', 'Selesai', 'Mei', '2025'),
('F021', 'U006', 'Aktif', '2025-04-17', 'Puskesmas', 'Petugas administrasi tidak membantu', 'Tidak', 'Sedang Diproses', 'Mei', '2025'),
('F022', 'U004', 'Aktif', '2025-05-01', 'Klinik', 'Kurangnya tenaga kebersihan', 'Tidak', 'Belum Diproses', 'Juni', '2025'),
('F023', 'U002', 'Aktif', '2025-05-05', 'Puskesmas', 'Sarana cuci tangan rusak', 'Ya', 'Sedang Diproses', 'Juni', '2025'),
('F024', 'U002', 'Aktif', '2025-05-10', 'Rumah Sakit', 'Kamar mandi kotor', 'Tidak', 'Selesai', 'Juni', '2025'),
('F025', 'U010', 'Aktif', '2025-05-15', 'Klinik', 'Air di ruang periksa mati', 'Ya', 'Sedang Diproses', 'Juni', '2025'),
('F026', 'U009', 'Aktif', '2025-05-22', 'Puskesmas', 'Alat suntik tidak tersedia', 'Ya', 'Selesai', 'Juni', '2025'),
('F027', 'U010', 'Aktif', '2025-05-28', 'Rumah Sakit', 'Layanan IGD terlalu lambat', 'Ya', 'Belum Diproses', 'Juli', '2025'),
('F028', 'U003', 'Aktif', '2025-06-01', 'Puskesmas', 'Obat tidak lengkap', 'Tidak', 'Sedang Diproses', 'Juli', '2025'),
('F029', 'U009', 'Aktif', '2025-06-07', 'Klinik', 'Alat pengukur tekanan darah rusak', 'Ya', 'Selesai', 'Juli', '2025'),
('F030', 'U009', 'Aktif', '2025-06-11', 'Puskesmas', 'Petugas jaga malam kurang', 'Ya', 'Belum Diproses', 'Juli', '2025'),
('F031', 'U004', 'Aktif', '2025-06-15', 'Rumah Sakit', 'Klinik rawat inap overkapasitas', 'Tidak', 'Sedang Diproses', 'Agustus', '2025'),
('F032', 'U005', 'Aktif', '2025-06-21', 'Klinik', 'Petugas tidak profesional', 'Ya', 'Selesai', 'Agustus', '2025'),
('F033', 'U010', 'Aktif', '2025-06-28', 'Puskesmas', 'Ruang tunggu bocor saat hujan', 'Tidak', 'Belum Diproses', 'Agustus', '2025'),
('F034', 'U001', 'Aktif', '2025-07-02', 'Puskesmas', 'Keterlambatan pelayanan vaksin', 'Tidak', 'Sedang Diproses', 'Juli', '2025'),
('F035', 'U009', 'Aktif', '2025-07-09', 'Klinik', 'Obat resep tidak tersedia', 'Ya', 'Selesai', 'Juli', '2025'),
('F036', 'U003', 'Aktif', '2025-07-15', 'Rumah Sakit', 'Kurangnya dokter jaga malam', 'Ya', 'Belum Diproses', 'Agustus', '2025'),
('F037', 'U007', 'Aktif', '2025-07-21', 'Puskesmas', 'Fasilitas laboratorium rusak', 'Tidak', 'Sedang Diproses', 'Agustus', '2025'),
('F038', 'U002', 'Aktif', '2025-07-27', 'Klinik', 'Proses administrasi lambat', 'Tidak', 'Selesai', 'Agustus', '2025'),
('F039', 'U010', 'Aktif', '2025-08-01', 'Puskesmas', 'Kurangnya tenaga kebersihan', 'Ya', 'Belum Diproses', 'September', '2025'),
('F040', 'U006', 'Aktif', '2025-08-06', 'Rumah Sakit', 'Sistem pendaftaran bermasalah', 'Ya', 'Sedang Diproses', 'September', '2025'),
('F041', 'U006', 'Aktif', '2025-08-10', 'Klinik', 'Pasien menunggu terlalu lama', 'Tidak', 'Selesai', 'September', '2025'),
('F042', 'U010', 'Aktif', '2025-01-10', 'Puskesmas', 'Pelayanan lambat', 'Ya', 'Belum Diproses', 'Januari', '2025'),
('f23067e3-d64b-4ce3-8ba4-16301803ca1c', 'U001', NULL, '2025-11-04', 'Klinik', 'kotor halaman depan', 'Dokter', 'Belum Diproses', '11', '2025');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengaduan_masyarakat`
--

CREATE TABLE `pengaduan_masyarakat` (
  `id_pengaduan` varchar(50) NOT NULL,
  `id_users` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `nik` varchar(20) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` varchar(150) DEFAULT NULL,
  `status_kesehatan` varchar(50) DEFAULT NULL,
  `riwayat_penyakit` varchar(100) DEFAULT NULL,
  `tanggal_riwayat_penyakit` date DEFAULT NULL,
  `tips_otomatis_id_tips` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pengaduan_masyarakat`
--

INSERT INTO `pengaduan_masyarakat` (`id_pengaduan`, `id_users`, `status`, `nik`, `nama`, `alamat`, `status_kesehatan`, `riwayat_penyakit`, `tanggal_riwayat_penyakit`, `tips_otomatis_id_tips`) VALUES
('5854185a-2199-4abd-8775-1d43305eb6cb', 'U001', 'Belum Diperiksa', '1234567899876543', 'naruto', 'gang sirad', 'Sakit', 'coba', '2025-11-04', NULL),
('e5341404-f4a1-47e5-a18b-dd2be0675fc9', 'U001', 'Belum Diperiksa', '1234567899876543', 'yhyh', 'tfcdcd', 'Sakit', 'gv c', '2025-11-04', NULL),
('M002', 'U009', 'Belum Diperiksa', '6472123001000001', 'Agus Santoso', 'Jl. Mawar No. 12, Samarinda', 'Sehat', 'Hipertensi', '2025-01-12', 'T061'),
('M003', 'U008', 'Telah Diperiksa', '6472123002000002', 'Anindya Putri', 'Jl. Diponegoro No. 15, Balikpapan', 'Kurang Sehat', 'Tidak Ada', '2025-01-06', 'T062'),
('M004', 'U010', 'Telah Diperiksa', '6472123003000003', 'Ahmad Yusuf', 'Jl. Gatot Subroto No. 8, Bontang', 'Kurang Sehat', 'Diabetes', '2025-01-28', 'T063'),
('M005', 'U009', 'Telah Diperiksa', '6472123004000004', 'Dwi Hartono', 'Jl. Gunung Lingga No. 9, Samarinda', 'Kurang Sehat', 'Hipertensi', '2025-01-19', 'T064'),
('M006', 'U009', 'Telah Diperiksa', '6472123005000005', 'Budi Hartami', 'Jl. Gunung Lingga No. 9, Samarinda', 'Kurang Sehat', 'Hipertensi', '2025-01-17', 'T065'),
('M007', 'U001', 'Belum Diperiksa', '6472123006000006', 'Sinta Wulan', 'Jl. Pramuka No. 10, Tenggarong', 'Sehat', 'Tidak Ada', '2025-03-14', 'T066'),
('M008', 'U001', 'Telah Diperiksa', '6472123007000007', 'Rina Sari', 'Jl. Pramuka No. 10, Tenggarong', 'Sehat', 'Tidak Ada', '2025-03-20', 'T067'),
('M009', 'U002', 'Telah Diperiksa', '6472123008000008', 'Rudi Haryanto', 'Jl. Kenanga No. 5, Sangatta', 'Tidak Sehat', 'Darah Tinggi', '2025-03-26', 'T068'),
('M010', 'U010', 'Telah Diperiksa', '6472123009000009', 'Mia Kusuma', 'Jl. Kejayaan No. 8, Bontang', 'Kurang Sehat', 'Kolesterol', '2025-03-31', 'T069'),
('M011', 'U008', 'Belum Diperiksa', '6472123010000010', 'Eko Wahyudi', 'Jl. Perjuangan No. 20, Balikpapan', 'Sehat', 'Tidak Ada', '2025-04-02', 'T070'),
('M012', 'U008', 'Telah Diperiksa', '6472123011000011', 'Rendi Saputra', 'Jl. Adinegoro No. 21, Balikpapan', 'Kurang Sehat', 'Hipertensi', '2025-04-04', 'T071'),
('M013', 'U002', 'Telah Diperiksa', '6472123012000012', 'Lina Hidayati', 'Jl. Mawar No. 6, Kutai Timur', 'Kurang Sehat', 'Diabetes', '2025-04-09', 'T072'),
('M014', 'U009', 'Belum Diperiksa', '6472123013000013', 'Putra Adi', 'Jl. Mayor Jendral Sutoyo No.18, Samarinda', 'Sehat', 'Tidak Ada', '2025-04-13', 'T073'),
('M015', 'U008', 'Telah Diperiksa', '6472123014000014', 'Hana Hidayah', 'Jl. Nusa Indah No. 10, Balikpapan', 'Kurang Sehat', 'Diabetes', '2025-04-15', 'T074'),
('M016', 'U009', 'Telah Diperiksa', '6472123015000015', 'Dimas Pratama', 'Jl. Mawar No. 6, Samarinda', 'Sehat', 'Tidak Ada', '2025-04-20', 'T075'),
('M017', 'U001', 'Belum Diperiksa', '6472123016000016', 'Rani Hartati', 'Jl. Gunung Sari No. 10, Tenggarong', 'Sehat', 'Tidak Ada', '2025-04-25', 'T076'),
('M018', 'U010', 'Telah Diperiksa', '6472123017000017', 'Asep Setiawan', 'Jl. Nusa Indah No. 7, Bontang', 'Kurang Sehat', 'Hipertensi', '2025-05-02', 'T077'),
('M019', 'U004', 'Belum Diperiksa', '6472123018000018', 'Andi Wijaya', 'Jl. Melati No. 8, Paser', 'Sehat', 'Tidak Ada', '2025-05-05', 'T078'),
('M020', 'U008', 'Telah Diperiksa', '6472123019000019', 'Dewi Anggraini', 'Jl. Ahmad Yani No. 18, Balikpapan', 'Kurang Sehat', 'Hipertensi', '2025-05-10', 'T079'),
('M021', 'U010', 'Telah Diperiksa', '6472123020000020', 'Teguh Prasetyo', 'Jl. Basuki Rahmat No. 8, Bontang', 'Kurang Sehat', 'Hipertensi', '2025-05-14', 'T080'),
('M022', 'U008', 'Telah Diperiksa', '6472123021000021', 'Ratna Dewi', 'Jl. Basuki Rahmat No. 10, Balikpapan', 'Kurang Sehat', 'Hipertensi', '2025-05-18', 'T081'),
('M023', 'U008', 'Telah Diperiksa', '6472123022000022', 'Samsul Hadi', 'Jl. Diponegoro No. 14, Balikpapan', 'Kurang Sehat', 'Hipertensi', '2025-05-22', 'T082'),
('M024', 'U009', 'Belum Diperiksa', '6472123023000023', 'Rachmat Hidayat', 'Jl. Diponegoro No. 18, Samarinda', 'Sehat', 'Tidak Ada', '2025-05-25', 'T083'),
('M025', 'U010', 'Telah Diperiksa', '6472123024000024', 'Siti Asmawati', 'Jl. Slamet Riyadi No. 8, Bontang', 'Kurang Sehat', 'Hipertensi', '2025-05-29', 'T084'),
('M026', 'U008', 'Telah Diperiksa', '6472123025000025', 'Nur Asnaini', 'Jl. KH Ahmad Dahlan No. 14, Balikpapan', 'Kurang Sehat', 'Hipertensi', '2025-05-31', 'T085'),
('M027', 'U010', 'Belum Diperiksa', '6472123026000026', 'Fajar Gunawan', 'Jl. Anggrek No. 11, Bontang', 'Sehat', 'Tidak Ada', '2025-06-01', 'T086'),
('M028', 'U008', 'Telah Diperiksa', '6472123027000027', 'Tina Duweni', 'Jl. Anggrek No. 20, Balikpapan', 'Kurang Sehat', 'Hipertensi', '2025-06-03', 'T087'),
('M029', 'U009', 'Telah Diperiksa', '6472123028000028', 'Rahmawati', 'Jl. Sekolahan No. 14, Samarinda', 'Sehat', 'Tidak Ada', '2025-06-07', 'T088'),
('M030', 'U009', 'Telah Diperiksa', '6472123029000029', 'Rohmanul', 'Jl. Juanda No. 25, Samarinda', 'Sehat', 'Tidak Ada', '2025-06-09', 'T089'),
('M031', 'U008', 'Belum Diperiksa', '6472123030000030', 'Rina Kusuma', 'Jl. Juanda No. 20, Balikpapan', 'Kurang Sehat', 'Asma', '2025-06-02', 'T090'),
('M032', 'U008', 'Telah Diperiksa', '6472123031000031', 'Rahmat Hidayat', 'Jl. Basuki Rahmat No. 20, Balikpapan', 'Kurang Sehat', 'Hipertensi', '2025-06-06', 'T091'),
('M033', 'U009', 'Telah Diperiksa', '6472123032000032', 'Eko Putra', 'Jl. Pahlawan No. 10, Samarinda', 'Sehat', 'Tidak Ada', '2025-06-09', 'T092'),
('M034', 'U008', 'Belum Diperiksa', '647212303000033', 'Dina Lestari', 'Jl. Anggrek No. 5, Balikpapan', 'Sehat', 'Tidak Ada', '2025-06-10', 'T093'),
('M035', 'U009', 'Telah Diperiksa', '647212303000034', 'Hendra Wijaya', 'Jl. Mawar No. 7, Samarinda', 'Kurang Sehat', 'Hipertensi', '2025-06-11', 'T094'),
('M036', 'U001', 'Telah Diperiksa', '647212303000035', 'Indah Pratiwi', 'Jl. Melati No. 4, Tenggarong', 'Sehat', 'Tidak Ada', '2025-06-12', 'T095'),
('M037', 'U010', 'Telah Diperiksa', '647212303000036', 'Bayu Saputra', 'Jl. Sudirman No. 10, Bontang', 'Kurang Sehat', 'Asma', '2025-06-13', 'T096'),
('M038', 'U002', 'Telah Diperiksa', '647212303000037', 'Ratna Dewi', 'Jl. Diponegoro No. 8, Sangatta', 'Sehat', 'Tidak Ada', '2025-06-14', 'T097'),
('M039', 'U004', 'Telah Diperiksa', '647212303000038', 'Eko Nugroho', 'Jl. Kenanga No. 9, Paser', 'Kurang Sehat', 'Diabetes', '2025-06-15', 'T098'),
('M040', 'U002', 'Telah Diperiksa', '647212303000039', 'Citra Amelia', 'Jl. Mawar No. 3, Kutai Timur', 'Sehat', 'Tidak Ada', '2025-06-16', 'T099'),
('M041', 'U009', 'Telah Diperiksa', '647212303000040', 'Yoga Prasetyo', 'Jl. Ahmad Yani No. 5, Samarinda', 'Kurang Sehat', 'Hipertensi', '2025-06-17', 'T100');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tips_otomatis`
--

CREATE TABLE `tips_otomatis` (
  `id_tips` varchar(50) NOT NULL,
  `isi_tips` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tips_otomatis`
--

INSERT INTO `tips_otomatis` (`id_tips`, `isi_tips`) VALUES
('T001', 'Kurangi konsumsi garam dan perbanyak sayuran untuk menjaga tekanan darah.'),
('T002', 'Rutin berolahraga minimal 30 menit setiap hari agar tubuh tetap bugar.'),
('T003', 'Kurangi konsumsi gula untuk mencegah risiko diabetes.'),
('T004', 'Gunakan masker di tempat umum untuk mencegah penyebaran penyakit.'),
('T005', 'Perbanyak minum air putih agar tidak dehidrasi.'),
('T006', 'Hindari stres berlebihan dengan melakukan kegiatan positif.'),
('T007', 'Konsumsi buah dan sayur setiap hari untuk menjaga sistem imun.'),
('T008', 'Cuci tangan sebelum makan dan setelah beraktivitas di luar rumah.'),
('T009', 'Istirahat cukup setiap malam untuk menjaga kesehatan mental.'),
('T010', 'Kurangi makanan berminyak untuk menjaga kadar kolesterol.'),
('T011', 'Segera periksa ke dokter jika batuk lebih dari dua minggu.'),
('T012', 'Hindari merokok dan asap rokok agar paru-paru tetap sehat.'),
('T013', 'Lakukan cek kesehatan rutin setiap 6 bulan sekali.'),
('T014', 'Jaga kebersihan lingkungan untuk mencegah penyakit menular.'),
('T015', 'Gunakan helm dan alat pelindung saat berkendara.'),
('T016', 'Konsumsi makanan tinggi protein untuk memperkuat daya tahan tubuh.'),
('T017', 'Gunakan air bersih untuk memasak dan mencuci bahan makanan.'),
('T018', 'Konsumsi vitamin C secara rutin untuk meningkatkan imunitas.'),
('T019', 'Hindari begadang berlebihan agar metabolisme tubuh tetap stabil.'),
('T020', 'Gunakan pakaian hangat saat musim hujan agar tidak mudah terserang flu.');

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vw_pengaduan_all`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vw_pengaduan_all` (
`id_pengaduan` varchar(50)
,`sumber` varchar(10)
,`info` varchar(100)
,`isi` varchar(255)
,`status` varchar(50)
,`tgl` date
);

-- --------------------------------------------------------

--
-- Struktur untuk view `vw_pengaduan_all`
--
DROP TABLE IF EXISTS `vw_pengaduan_all`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_pengaduan_all`  AS SELECT `pf`.`id_pengaduan` AS `id_pengaduan`, 'Faskes' AS `sumber`, `pf`.`jenis_faskes` AS `info`, `pf`.`keluhan` AS `isi`, `pf`.`status_pengaduan` AS `status`, `pf`.`tanggal_pengaduan` AS `tgl` FROM `pengaduan_faskes` AS `pf`union all select `pm`.`id_pengaduan` AS `id_pengaduan`,'Masyarakat' AS `Masyarakat`,`pm`.`nama` AS `nama`,`pm`.`riwayat_penyakit` AS `riwayat_penyakit`,`pm`.`status` AS `status`,`pm`.`tanggal_riwayat_penyakit` AS `tanggal_riwayat_penyakit` from `pengaduan_masyarakat` `pm`  ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_users`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indeks untuk tabel `ketua_rt`
--
ALTER TABLE `ketua_rt`
  ADD PRIMARY KEY (`id_users`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indeks untuk tabel `log_status`
--
ALTER TABLE `log_status`
  ADD PRIMARY KEY (`id_log`),
  ADD KEY `id_pengaduan` (`id_pengaduan`);

--
-- Indeks untuk tabel `pengaduan_faskes`
--
ALTER TABLE `pengaduan_faskes`
  ADD PRIMARY KEY (`id_pengaduan`),
  ADD KEY `fk_faskes_rt` (`id_users`);

--
-- Indeks untuk tabel `pengaduan_masyarakat`
--
ALTER TABLE `pengaduan_masyarakat`
  ADD PRIMARY KEY (`id_pengaduan`),
  ADD KEY `fk_pm_ketua_rt` (`id_users`);

--
-- Indeks untuk tabel `tips_otomatis`
--
ALTER TABLE `tips_otomatis`
  ADD PRIMARY KEY (`id_tips`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `pengaduan_faskes`
--
ALTER TABLE `pengaduan_faskes`
  ADD CONSTRAINT `fk_faskes_rt` FOREIGN KEY (`id_users`) REFERENCES `ketua_rt` (`id_users`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pf_ketua_rt` FOREIGN KEY (`id_users`) REFERENCES `ketua_rt` (`id_users`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengaduan_masyarakat`
--
ALTER TABLE `pengaduan_masyarakat`
  ADD CONSTRAINT `fk_pm_ketua_rt` FOREIGN KEY (`id_users`) REFERENCES `ketua_rt` (`id_users`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
