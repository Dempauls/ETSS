package etss;

import static java.nio.file.StandardOpenOption.CREATE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.text.Collator.PRIMARY;
import net.proteanit.sql.DbUtils;

public class config {

    private static final String DB_URL = "jdbc:sqlite:etss.db";

    public static Connection connectDB() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // CREATE TABLE (call once at app startup)
    public static void initDatabase() {
        String createUsers =
        "CREATE TABLE IF NOT EXISTS tbl_users ("
      + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
      + "first_name TEXT NOT NULL, "
      + "last_name TEXT NOT NULL, "
      + "email TEXT NOT NULL UNIQUE, "
      + "password TEXT NOT NULL, "
      + "type TEXT NOT NULL, "
      + "status TEXT NOT NULL, "
      + "idpicture BLOB"
      + ")";

        try (Connection con = connectDB()) {
            con.createStatement().execute(createUsers);
            System.out.println("Database ready");
        } catch (SQLException e) {
            throw new RuntimeException("DB INIT FAILED", e);
        }
    }

    // INSERT / UPDATE
    public void executeUpdate(String sql, Object... values) {
        try (Connection conn = connectDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < values.length; i++) {
                ps.setObject(i + 1, values[i]);
            }

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // AUTH
    public boolean authenticate(String sql, Object... values) {
        try (Connection conn = connectDB();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < values.length; i++) {
                ps.setObject(i + 1, values[i]);
            }

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            return false;
        }
    }

    // TABLE DISPLAY
    public void displayData(String sql, javax.swing.JTable table) {
        try (Connection conn = connectDB();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
