package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Overview extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {



        List<Order_User> linjer = new ArrayList<Order_User>();
        linjer = UserMapper.getOrder_Users();




        HttpSession session = request.getSession();
        session.setAttribute("linjer", linjer);




        return "overview";
    }

}
