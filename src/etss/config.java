package etss;

import static java.nio.file.StandardOpenOption.CREATE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.text.Collator.PRIMARY;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class config {

    private static final String DB_URL = "jdbc:sqlite:etss.db";
    private Connection connect;
    
    public config() {
        try {
            
            this.connect = DriverManager.getConnection(DB_URL);
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex.getMessage());
        }
    }

    public static Connection connectDB() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
  

    
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

    
    public void displayData(String sql, javax.swing.JTable table) {
        try (Connection conn = connectDB();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int insertData(String sql){
        try (Connection conn = connectDB(); 
         PreparedStatement pst = conn.prepareStatement(sql)) {
        
        pst.executeUpdate();
        System.out.println("Inserted Successfully");
        return 1; 
    } catch(SQLException ex) {
        System.out.println("Connection Error: " + ex);
        return 0;
    }
}
    public int duplicateCheck(String sql){
    int dups = 0;
    try {
        java.sql.ResultSet rs = getData(sql);
        if(rs.next()){
            dups = 1;
        }
    } catch(java.sql.SQLException ex) {
        System.out.println("Error: " + ex);
    }
    return dups;
}


        public java.sql.ResultSet getData(String sql) throws java.sql.SQLException {
    java.sql.Connection con = connectDB(); 
    java.sql.Statement stmt = con.createStatement();
    java.sql.ResultSet rs = stmt.executeQuery(sql);
    return rs;
    }
        public void displayMyTasks(String userId) {
  config conf = new config();
       
        String sql = "SELECT t_id AS 'ID', t_title AS 'Task Title', t_deadline AS 'Deadline', t_status AS 'Status' "
                   + "FROM tbl_tasks WHERE assigned_to = '" + userId + "' AND t_status != 'Completed'";
        JTable myTasksTable = null;
        
        
        conf.displayData(sql, myTasksTable);
}

    public int insertDataWithID(String sqlTask) { 
   int id = -1;
    
    try (Connection conn = connectDB();
         PreparedStatement pst = conn.prepareStatement(sqlTask, Statement.RETURN_GENERATED_KEYS)) {
        
        pst.executeUpdate();
        try (ResultSet rs = pst.getGeneratedKeys()) {
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }
        System.out.println("Inserted with ID: " + id);
    } catch (SQLException ex) {
        System.out.println("SQL Error in insertDataWithID: " + ex.getMessage());
    }
    return id;
}
    public void logEvent(String userId, String action, String details) {
    try {
        java.sql.Connection conn = connectDB();
       
        String sql = "INSERT INTO tbl_logs (l_user_id, l_action, l_details) VALUES (?, ?, ?)";
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, userId);  
        pst.setString(2, action);   
        pst.setString(3, details); 
        
        pst.executeUpdate();
        pst.close();
        conn.close();
    } catch (java.sql.SQLException e) {
        System.out.println("Logging Error: " + e.getMessage());
    }
}
}
        
   

