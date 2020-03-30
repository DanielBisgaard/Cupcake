package PresentationLayer;

import DBAccess.Connector;
import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

public class AddCredit extends Command {
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter("amail");
        int credit = Integer.parseInt(request.getParameter("credit"));
        User user = new User(email);
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE OlskerCupCakes.Users set Credit=? where Email =?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, credit);
            ps.setString(2, email);

            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            while (ids.next()){

                int kredit = ids.getInt(5);
                user.setCredit(kredit);
            }





        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }


        return "Employee" + "page";
    }
}
