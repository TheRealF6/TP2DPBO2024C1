public class Mahasiswa {
    private String nim;
    private String nama;
    private String jenisKelamin;
    private String asalPulau;

    public Mahasiswa(String nim, String nama, String jenisKelamin, String asalPulau) {
        this.nim = nim;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.asalPulau = asalPulau;
    }

    // Setter
    public void setNim(String nim) {
        this.nim = nim;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    public void setasalPulau(String asalPulau) {
        this.asalPulau = asalPulau;
    }

    // Getter
    public String getNim() {
        return this.nim;
    }
    public String getNama() {
        return this.nama;
    }
    public String getJenisKelamin() {
        return this.jenisKelamin;
    }
    public String getasalPulau() {
        return asalPulau;
    }
}
