package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order_User;
import FunctionLayer.Product;
import FunctionLayer.User;
import com.mysql.cj.protocol.Resultset;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
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
            String SQL = "INSERT INTO OlskerCupCakes.users (Email, Password, Role, Credit) VALUES (?, ?, ?, ?)";
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
            String SQL = "SELECT UserID, Role, Credit FROM OlskerCupCakes.users "
                    + "WHERE Email=? AND Password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("Role");
                int credit = rs.getInt("Credit");
                int userid = rs.getInt("UserID");
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

    public static List<Order_User> getOrder_Users() {
        List<Order_User> OUL = new ArrayList<Order_User>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT users.*, orders.* FROM OlskerCupCakes.users join orders on users.UserID=orders.UserID WHERE Role='Customer';";


            PreparedStatement ps = con.prepareStatement(SQL);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String role = rs.getString("Role");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                int credit = rs.getInt("Credit");
                int userid = rs.getInt("UserID");
                int orderid = rs.getInt("OrderID");

                java.util.Date date;
                Date dato = rs.getDate("PaidTime");


                Order_User OU = new Order_User(orderid, userid, email, password, role, credit);
                OU.setPaidTime(dato);

                OUL.add(OU);

            }


        } catch (ClassNotFoundException | SQLException ex) {

        }
        return OUL;
    }

    public static User getUser(String email) {
        User user = new User();
        try {

            Connection con = Connector.connection();
            String SQL = "SELECT * FROM OlskerCupCakes.users WHERE Email=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String role = rs.getString("Role");
                String emailen = rs.getString("Email");
                String password = rs.getString("Password");
                int credit = rs.getInt("Credit");
                int userid = rs.getInt("UserID");
                user = new User(emailen, password, role, credit);
                user.setId(userid);


            }


        } catch (ClassNotFoundException | SQLException ex) {

        }
        return user;
    }

    public static void pay(int money, String email, int ordreid) throws LoginSampleException {
        User user = new User(email);
        try {
            //Nu checker vi hvor mange penge kunden har på sin konto
            Connection con = Connector.connection();
            String query = "Select Credit from OlskerCupCakes.users where Email = ?";
            PreparedStatement pstatement = con.prepareStatement(query);
            pstatement.setString(1, email);


            pstatement.executeQuery();

            ResultSet res = pstatement.executeQuery();


            int userCredit = 0;
            while (res.next()) {
                userCredit = res.getInt("Credit");

            }

            //Her trækker vi beløbet kunden skal betale fra kundens konto, for at se om kunden har råd
            int Credit = userCredit - money;

            //Hvis kunden så har råd trækker vi rent faktisk beløbet fra kontoen her
            if (Credit > 0) {
                String SQL = "UPDATE users SET Credit = ? WHERE Email = ?;";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, userCredit);
                ps.setString(2, email);
                ps.executeUpdate();


                user.setCredit(userCredit);
                CartMapper.setPayTime(ordreid);

            } else {
                throw new LoginSampleException("Penge på konto: " + userCredit + " kr. er ikke nok til at købe den ønskede ordre.. Bed en nede i Olskers Cupcakes om at sætte flere penge ind på din konto hvis du vil have kage. Ja det er sku ret dumt, men vi designer jo bare det system vi bliver bedt om. " + " " + " - vh Albert, Artem og Daniel");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
    public static List<User> getUsers() {
        List<User> UL = new ArrayList<User>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT users.* FROM OlskerCupCakes.users;";


            PreparedStatement ps = con.prepareStatement(SQL);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String role = rs.getString("Role");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                int credit = rs.getInt("Credit");
                int userid = rs.getInt("UserID");

                User U = new User(email, password, role, credit);


                UL.add(U);

            }


        } catch (ClassNotFoundException | SQLException ex) {

        }
        return UL;
    }
}

