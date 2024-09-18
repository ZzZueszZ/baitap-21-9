    package DAO;

    import controller.db.DBConnectionMySql;
    import model.User;

    import java.sql.*;

    public class UserDaoImpl implements IUserDao{

//        private Connection conn = null;
//
//        public UserDaoImpl(Connection conn) {
//            this.conn = conn;
//        }
        public Connection conn = null;
        public PreparedStatement ps = null;
        public ResultSet rs = null;

        @Override
        public User getUser(String username) {
            String sql = "SELECT * FROM users WHERE username = ? ";
            try {
                conn =  DBConnectionMySql.getConnection();
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
                    user.setRoleid(Integer.parseInt(rs.getString("roleid")));
                    user.setPhone(rs.getString("phone"));
                    user.setCreatedDate(rs.getDate("createdDate"));
                    return user;
                }
            } catch (Exception e) {e.printStackTrace(); }
            return null;
        }


    }
