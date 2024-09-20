package DAO;

import controller.db.DBConnectionMySql;
import model.User;

import java.sql.*;

public class UserDaoImpl implements IUserDao {

    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public User getUser(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            conn = DBConnectionMySql.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setPassWord(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
                user.setCreatedDate(rs.getDate("createdDate"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return null;
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO users (username, password, email, phone, avatar, roleid, createdDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = DBConnectionMySql.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassWord());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAvatar());
            ps.setInt(6, user.getRoleid());
            ps.setDate(7, new Date(System.currentTimeMillis()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }

    @Override
    public boolean checkExistEmail(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        try {
            conn = DBConnectionMySql.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Trả về true nếu tồn tại
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean checkExistUsername(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        try {
            conn = DBConnectionMySql.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Trả về true nếu tồn tại
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        String sql = "SELECT COUNT(*) FROM users WHERE phone = ?";
        try {
            conn = DBConnectionMySql.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, phone);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Trả về true nếu tồn tại
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return false;
    }

    @Override
    public String updatePassword(String email, String newPassword) {
        String resultMessage = "Cập nhật mật khẩu không thành công.";
        String sql = "UPDATE users SET password = ? WHERE email = ?";

        try {
            conn = DBConnectionMySql.getConnection();
            ps = conn.prepareStatement(sql);

            // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
            String hashedPassword = hashPassword(newPassword); // Phương thức mã hóa mật khẩu

            ps.setString(1, hashedPassword);
            ps.setString(2, email);

            int rowsAffected = ps.executeUpdate(); // Thực hiện cập nhật

            if (rowsAffected > 0) {
                resultMessage = "Mật khẩu đã được cập nhật thành công.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultMessage = "Đã xảy ra lỗi trong quá trình cập nhật mật khẩu.";
        } finally {
            closeResources();
        }

        return resultMessage;
    }

    private String hashPassword(String password) {
        // Sử dụng bcrypt hoặc một phương thức mã hóa an toàn khác
        // Ví dụ: return BCrypt.hashpw(password, BCrypt.gensalt());
        return password; // Thay thế bằng mã hóa thực tế
    }


    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
