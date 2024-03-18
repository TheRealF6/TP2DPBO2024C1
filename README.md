# TP2DPBO2024C1

### Janji
Saya Muhammad Fakhri Fadhlurrahman NIM 2105997 mengerjakan soal TP2 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

### Desain Program
Program ini mempunyai 4 variabel data: NIM (String, TextField), Nama (String, TextField), Jenis Kelamin (String, ComboBox), dan Asal Pulau (String, ComboBox). Data yang digunakan di program ini merupakan dari database SQL. Di dalam program ini terdapat proses CRUD. User dapat menambah, mengubah, dan menghapus data. Tampilan program merupakan window berisi form data dan tampilan data mahasiswa. Data akan reset ketika menutup program karena datanya hardcode. Ketika menghapus akan ada prompt konfirmasi penghapusan agar tidak terjadi penghapusan data yang tidak disengaja. Ketika ingin menambah atau mengubah data namun ada field kosong, maka akan keluar prompt yang memberi tahu jika field belum terisi semua. Jika ingin menambah data namun NIMnya sudah ada, maka akan keluar prompt yang memberi tahu user bahwa NIM sudah terdaftar (ada di database)

### Penjelasan Alur
Pertama-tama, run Menu.java untuk menjalankan program. Setelah itu, maka akan muncul tampilan window Data Mahasiswa yang berisi form data dan 20 data mahasiswa di bawahnya. Dalam form ada beberapa opsi yang bisa digunakan: Add (menambah data) dan Cancel (membatalkan pilihan). Jika user mengklik salah satu data maka akan muncul dua opsi tambahan: Update (mengubah data) dan Delete (menghapus data). User bisa melakukan semua query tanpa ada batasan sampai user menutup program. Jika melakukan query apapun, maka database akan terupdate secara otomatis. Catatan: Jika ingin menambah data, pastikan bahwa field sudah terisi semua dan NIM belum ada di database, karena akan keluar prompt yang memberi tahu dan jadinya tidak bisa berhasil melakukan penambahan data. Hal ini berlaku juga untuk insert untuk bagian field.

### Dokumentasi
Video dari proses berjalannya program:<br>
https://github.com/TheRealF6/TP2DPBO2024C1/assets/119662753/3d908cbc-01dc-4aae-9a32-26e4a013ba74
