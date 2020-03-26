package PresentationLayer;

import DBAccess.Connector;
import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddCredit extends Command {
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter("email");
        int credit = Integer.parseInt(request.getParameter("credit"));
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE OlskerCupCakes.Users set Credit=? where Email =?";
            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(2, email);
            ps.setInt(1, credit);
            ps.executeUpdate();


        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("credit", credit);
        return "done";
    }
}
