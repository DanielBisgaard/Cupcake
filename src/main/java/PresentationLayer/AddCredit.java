package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCredit extends Command {
    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter("Email");
        String credit = request.getParameter("Credit");
        User user = LogicFacade.addCredit(email, 0);
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("credit", credit);

    return user.getRole()+"page";
    }
}
