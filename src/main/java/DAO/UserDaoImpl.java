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
            String query = "SELECT * FROM users WHERE userName = ?";
            User user = null;
            try {
                conn =  DBConnectionMySql.getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, username);
                rs = ps.executeQuery();
                ps.setString(1, username);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // Assuming the User table has columns: id, email, userName, fullName, passWord, avatar, roleid, phone, createdDate
                        int id = rs.getInt("id");
                        String email = rs.getString("email");
                        String userName = rs.getString("userName");
//
                        String password = rs.getString("password");
                        String avatar = rs.getString("avatar");
                        String roleid = rs.getString("roleid");
                        String phone = rs.getString("phone");
                        Date createdDate = rs.getDate("createdDate");

//                         user = new User(id, email, userName, password, avatar, roleid,phone, createdDate);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(); // You may want to use a logger instead of printStackTrace in a production environment
            }
            return user;


        }


    }
