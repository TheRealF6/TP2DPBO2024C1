import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Menu extends JFrame{
    public static void main(String[] args) {
        // Buat object window
        Menu window = new Menu();

        // Atur ukuran window
        window.setSize(480, 560);
        // Letakkan window di tengah layar
        window.setLocationRelativeTo(null);
        // Isi window
        window.setContentPane(window.mainPanel);
        // Ubah warna background
        window.getContentPane().setBackground(Color.white);
        // Tampilkan window
        window.setVisible(true);
        // Agar program ikut berhenti saat window diclose
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Index baris yang diklik
    private int selectedIndex = -1;
    private Database database;

    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox jenisKelaminComboBox;
    private JComboBox asalPulauComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;
    private JLabel asalPulauLabel;

    // Constructor
    public Menu() {
        // Buat objek database
        database = new Database();

        // Isi tabel mahasiswa
        mahasiswaTable.setModel(setTable());

        // Ubah styling title
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        // Atur isi combo box
        String[] jenisKelaminData = {"", "Laki-laki", "Perempuan"};
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel(jenisKelaminData));
        String[] asalPulauData = {"", "Bali", "Jawa", "Kalimantan", "Nusa Tenggara", "Papua", "Sulawesi", "Sumatera"};
        asalPulauComboBox.setModel(new DefaultComboBoxModel(asalPulauData));

        // Sembunyikan button delete
        deleteButton.setVisible(false);

        // Saat tombol add/update ditekan
        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex == -1) {
                    insertData();
                } else {
                    updateData();
                }
            }
        });
        // Saat tombol delete ditekan
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex >= 0) {
                    deleteData();
                }
            }
        });
        // Saat tombol cancel ditekan
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
        // Saat salah satu baris tabel ditekan
        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Ubah selectedIndex menjadi baris tabel yang diklik
                selectedIndex = mahasiswaTable.getSelectedRow();

                // Simpan value textField dan comboBox
                String selectedNim = mahasiswaTable.getModel().getValueAt(selectedIndex, 1).toString();
                String selectedNama = mahasiswaTable.getModel().getValueAt(selectedIndex, 2).toString();
                String selectedJenisKelamin = mahasiswaTable.getModel().getValueAt(selectedIndex, 3).toString();
                String selectedAsalPulau = mahasiswaTable.getModel().getValueAt(selectedIndex, 4).toString();

                // Ubah isi textField dan comboBox
                nimField.setText(selectedNim);
                namaField.setText(selectedNama);
                jenisKelaminComboBox.setSelectedItem(selectedJenisKelamin);
                asalPulauComboBox.setSelectedItem(selectedAsalPulau);

                // Ubah button "Add" menjadi "Update"
                addUpdateButton.setText("Update");
                // Tampilkan button delete
                deleteButton.setVisible(true);
                // Membuat field NIM tidak bisa diedit
                nimField.setEditable(false);
            }
        });
    }

    public final DefaultTableModel setTable() {
        // Tentukan kolom tabel
        Object[] column = {"No", "NIM", "Nama", "Jenis Kelamin", "Asal Pulau"};

        // Buat objek tabel dengan kolom yang sudah dibuat
        DefaultTableModel temp = new DefaultTableModel(null, column);

        try {
            ResultSet resultSet = database.selectQuery("SELECT * FROM mahasiswa");

            int i = 0;
            while (resultSet.next()) {
                Object[] row = new Object[5];

                row[0] = i + 1;
                row[1] = resultSet.getString("nim");
                row[2] = resultSet.getString("nama");
                row[3] = resultSet.getString("jenis_kelamin");
                row[4] = resultSet.getString("asal_pulau");

                temp.addRow(row);
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return temp;
    }

    public void insertData() {
        // Ambil value dari textfield dan combobox
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String asalPulau = asalPulauComboBox.getSelectedItem().toString();

        // Cek apakah NIM sudah ada di database
        if (database.isNimExists(nim)) {
            JOptionPane.showMessageDialog(null, "NIM sudah terdaftar!");
            return;
        }

        // Cek apakah ada field yang kosong
        if (nim.isEmpty() || nama.isEmpty() || jenisKelamin.isEmpty() || asalPulau.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
            return;
        }

        // Tambahkan data ke dalam database
        String sql = "INSERT INTO mahasiswa VALUES (null, '" + nim + "', '" + nama + "', '" + jenisKelamin + "', '" + asalPulau + "');";
        database.insertUpdateDeleteQuery(sql);

        // Update tabel
        mahasiswaTable.setModel(setTable());

        // Bersihkan form
        clearForm();

        // Feedback
        System.out.println("Insert berhasil!");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
    }

    public void updateData() {
        // Ambil data dari form
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String asalPulau = asalPulauComboBox.getSelectedItem().toString();

        // Cek apakah ada field yang kosong
        if (nim.isEmpty() || nama.isEmpty() || jenisKelamin.isEmpty() || asalPulau.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
            return;
        }

        // Ubah data mahasiswa di database
        String sql = "UPDATE mahasiswa SET nama = '" + nama + "', jenis_kelamin = '" + jenisKelamin + "', asal_pulau = '" + asalPulau + "' WHERE nim = '" + nim + "';";
        database.insertUpdateDeleteQuery(sql);

        // Update tabel
        mahasiswaTable.setModel(setTable());

        // Bersihkan form
        clearForm();

        // Feedback
        System.out.println("Update Berhasil!");
        JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
    }


    public void deleteData() {
        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

        // Jika pengguna memilih 'YES', lanjutkan penghapusan
        if (confirm == JOptionPane.YES_OPTION) {
            // Ambil data dari form
            String nim = nimField.getText();

            // Hapus data dari database
            String sql = "DELETE FROM mahasiswa WHERE nim = '" + nim + "';";
            database.insertUpdateDeleteQuery(sql);

            // Update tabel
            mahasiswaTable.setModel(setTable());

            // Bersihkan form
            clearForm();

            // Feedback
            System.out.println("Delete berhasil!");
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        } else {
            // Jika pengguna memilih 'NO', batalkan penghapusan
            System.out.println("Delete dibatalkan.");
        }
    }

    public void clearForm() {
        // Kosongkan semua texfield dan combo box
        nimField.setText("");
        namaField.setText("");
        jenisKelaminComboBox.setSelectedItem("");
        asalPulauComboBox.setSelectedItem("");

        // Ubah button "Update" menjadi "Add"
        addUpdateButton.setText("Add");
        // Sembunyikan button delete
        deleteButton.setVisible(false);
        // Membuat field NIM bisa diedit (untuk insertData)
        nimField.setEditable(true);

        // Ubah selectedIndex menjadi -1 (tidak ada baris yang dipilih)
        selectedIndex = -1;
    }
}
