package controller.db;

//import com.mysql.cj.xdevapi.Statement;

import java.sql.*;

public class DBConnectionMySql {

    private static final String URL = "jdbc:mysql://localhost:3306/servlet"; // Thay thế 'servlet' bằng tên cơ sở dữ liệu của bạn
    private static final String USER = "root"; // Thay thế bằng tên người dùng của bạn
    private static final String PASSWORD = "D0ga00g123@"; // Thay thế bằng mật khẩu của bạn
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Driver class not found", e);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) throws SQLException {
        Connection conn =  DBConnectionMySql.getConnection();
        Date date = new Date(2004);
        String insertSQL = "INSERT INTO users (email, userName, password, avatar, roleid, phone, createdDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, "admin@example.com");
            pstmt.setString(2, "admin");
//            pstmt.setString(3, "Example User");
            pstmt.setString(3, "admin");
            pstmt.setString(4, "default_avatar.png");
            pstmt.setInt(5, 2);
            pstmt.setString(6, "1234567890");
            pstmt.setDate(7, date); // Sử dụng ngày hiện tại

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (conn!= null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
