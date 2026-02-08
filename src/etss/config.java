package etss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;

public class config {

    public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:etss.db");
            System.out.println("Connection Successful");

           String createUsers = "CREATE TABLE IF NOT EXISTS tbl_users ("
        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
        + "first_name TEXT NOT NULL,"
        + "last_name TEXT NOT NULL,"
        + "email TEXT NOT NULL UNIQUE,"
        + "password TEXT NOT NULL,"
        + "type TEXT NOT NULL,"
        + "status TEXT NOT NULL"
        + ")";
con.createStatement().execute(createUsers);


          
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Failed: " + e);
        }

        return con;
    }

    public static Connection Connection() {
        return connectDB();
    }

    public static config getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void addRecord(String sql, Object... values) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }

        pstmt.executeUpdate();
        System.out.println("Record added successfully!");
    } catch (SQLException e) {
        System.out.println("Error adding record: " + e.getMessage());
    }
}
    public boolean authenticate(String sql, Object... values) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return true;
            }
        }
    } catch (SQLException e) {
        System.out.println("Login Error: " + e.getMessage());
    }
    return false;
}

   
public void displayData(String sql, javax.swing.JTable table) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
        
        
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
    } catch (SQLException e) {
        System.out.println("Error displaying data: " + e.getMessage());
    }
}
    public ResultSet getUser(String sql, Object... values) {
    try {
       
        Connection conn = connectDB(); 
        PreparedStatement pstmt = conn.prepareStatement(sql);

        for (int i = 0; i < values.length; i++) {
            if (values[i] instanceof String) {
                pstmt.setString(i + 1, ((String) values[i]).trim());
            } else {
                pstmt.setObject(i + 1, values[i]);
            }
        }
        return pstmt.executeQuery(); 
    } catch (SQLException e) {
        System.out.println("Error fetching user: " + e.getMessage());
    }
    return null;
}
private void loadUserProfile(String username) {
    try {
        config conf = new config();
        String sql = "SELECT first_name, last_name, email, type, status FROM tbl_users WHERE LOWER(TRIM(username))=?";
        ResultSet rs = conf.getUser(sql, username.toLowerCase());

        if (rs != null && rs.next()) {
           
            String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
           
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void loadUserTasks(String username) {
    try {
        config conf = new config();
        String email = null;
        String sql = "SELECT id, task_name, due_date, status FROM tbl_tasks WHERE LOWER(TRIM(email))=?";
        ResultSet rs = conf.getUser(sql, email.toLowerCase());

        

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public PreparedStatement prepareStatement(String select__from_tbl_users_WHERE_username) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}

    