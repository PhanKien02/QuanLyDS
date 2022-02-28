package quanlydanhsach.ConnetionJDBC;

import java.util.List;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import quanlydanhsach.User;

public class UseJDBC {

    static Connection conn;

    public List<User> getAlLUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try {
            conn = JDBCConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();

                user.setID(rs.getInt("ID"));
                user.setName(rs.getString("ten"));
                user.setPhone(rs.getString("phone"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Passwords"));
                user.setRole(rs.getString("roles"));
                users.add(user);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Loi get"+e.toString());
        }

        return users;
    }

    public void addUser(User user) {
        String sql = "Insert into users(ID,ten,phone,UserName,Passwords,roles)"+
                "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, user.getID());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getUserName());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getRole());
            int rs = preparedStatement.executeUpdate();
            System.out.println("da add "+rs+" dong du lieu");
        } catch (SQLException e) {
            // TODO: handle exception
            System.out.println("Loi add"+e.toString());
        }
    }
    public  void DeleteUser(int ID){
        String sql = "Delete From users where ID=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, ID);
            int ps = preparedStatement.executeUpdate();
            System.out.println("da xoa "+ps+" dong");
        } catch (Exception e) {
        }
    }
}
