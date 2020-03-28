package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import com.mysql.cj.protocol.Resultset;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {
    private DatabaseConnector connector = new DatabaseConnector();

    public UserMapper(DataSource ds) {
        connector.setDataSource(ds);
    }
    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO OlskerCupCakes.Users (email, password, role, credit) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.setInt(4, user.getCredit());
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int userid = ids.getInt(1);
            user.setId(userid);



        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT userid, role, credit FROM OlskerCupCakes.Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int credit = rs.getInt("credit");
                int userid = rs.getInt("userid");
                User user = new User(email, password, role, credit);
                user.setId(userid);

                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static List<User> getUsers() {
       List<User> users = new ArrayList<User>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM OlskerCupCakes.Users WHERE role='Customer'";


            PreparedStatement ps = con.prepareStatement(SQL);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String role = rs.getString("role");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int credit = rs.getInt("credit");
                int userid = rs.getInt("userid");
                User user = new User(email, password, role, credit);
                user.setId(userid);

                users.add(user);

            }


        } catch (ClassNotFoundException | SQLException ex) {

        }
        return users;
    }
    public static User getUser(String email) {
        User user = new User();
        try {

            Connection con = Connector.connection();
            String SQL = "SELECT * FROM OlskerCupCakes.Users WHERE Email=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String role = rs.getString("role");
                String emailen = rs.getString("email");
                String password = rs.getString("password");
                int credit = rs.getInt("credit");
                int userid = rs.getInt("userid");
                user = new User(emailen, password, role, credit);
                user.setId(userid);


            }


        } catch (ClassNotFoundException | SQLException ex) {

        }
        return user;
    }

}