-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 18 Mar 2024 pada 18.48
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
-- Database: `db_mahasiswa_tp2`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id` int(11) NOT NULL,
  `nim` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jenis_kelamin` varchar(255) NOT NULL,
  `asal_pulau` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `mahasiswa`
--

INSERT INTO `mahasiswa` (`id`, `nim`, `nama`, `jenis_kelamin`, `asal_pulau`) VALUES
(1, '2100001', 'I Wayan Arya Putra Kencana', 'Laki-laki', 'Bali'),
(2, '2100002', 'Ni Ayu Devi Saraswati', 'Perempuan', 'Bali'),
(3, '2100003', 'Daud Muhammad Agung', 'Laki-laki', 'Bali'),
(4, '2100004', 'Mutiara Sarah Julianti', 'Perempuan', 'Jawa'),
(5, '2100005', 'Darrel Valentino Wijaya', 'Laki-laki', 'Jawa'),
(6, '2100006', 'Annisa Hanifah Jayanti', 'Perempuan', 'Jawa'),
(7, '2100007', 'Michael Thomas Hartono', 'Laki-laki', 'Kalimantan'),
(8, '2100008', 'Alya Khairunnisa', 'Perempuan', 'Kalimantan'),
(9, '2100009', 'Putra Kelana Nusantara', 'Laki-laki', 'Kalimantan'),
(10, '2100010', 'Fatimah Azzahra Rianti', 'Perempuan', 'Nusa Tenggara'),
(11, '2100011', 'Abdullah Karim Nursalman', 'Laki-laki', 'Nusa Tenggara'),
(12, '2100012', 'Siti Nur Farida', 'Perempuan', 'Nusa Tenggara'),
(13, '2100013', 'Muhammad Arifin Husain', 'Laki-laki', 'Papua'),
(14, '2100014', 'Rania Salma Julianti', 'Perempuan', 'Papua'),
(15, '2100015', 'Haryanto Zulfikar Abdurrahman', 'Laki-laki', 'Papua'),
(16, '2100016', 'Devina Putri Artamevia', 'Perempuan', 'Sulawesi'),
(17, '2100017', 'Haris Hidayatullah', 'Laki-laki', 'Sulawesi'),
(18, '2100018', 'Jasmine Ratu Jayawardhana', 'Perempuan', 'Sulawesi'),
(19, '2100019', 'Muhammad Ryan Ardhitama', 'Laki-laki', 'Sumatera'),
(20, '2100020', 'Fransiska Josephine Panjaitan', 'Perempuan', 'Sumatera'),
(21, '2100021', 'Adam Thoriq Khairullah', 'Laki-laki', 'Sumatera');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
