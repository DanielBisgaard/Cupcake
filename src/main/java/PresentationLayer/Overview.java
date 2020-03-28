/*package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Overview extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String html = "overview";

        HttpSession session = request.getSession();
        ArrayList<User> brugere = UserMapper.getUsers();


        session.setAttribute( "xy", brugere );
        return html;
    }

}*/
