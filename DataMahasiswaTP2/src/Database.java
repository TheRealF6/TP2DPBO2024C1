import java.sql.*;

public class Database {
    private Connection connection;
    private Statement statement;

    // Constructor
    public Database() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mahasiswa_tp2", "root", "");
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method digunakan untuk SELECT
    public ResultSet selectQuery(String sql) {
        try {
            statement.executeQuery(sql);
            return statement.getResultSet();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method ini digunakan untuk INSERT, UPDATE, dan DELETE
    public int insertUpdateDeleteQuery(String sql) {
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method ini digunakan untuk memeriksa apakah NIM sudah ada di database
    public boolean isNimExists(String nim) {
        String sql = "SELECT nim FROM mahasiswa WHERE nim = '" + nim + "'";
        try {
            ResultSet rs = this.selectQuery(sql);
            return rs.next(); // Jika rs.next() bernilai true, maka NIM sudah ada
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Getter
    public Statement getStatement() {
        return statement;
    }
}
