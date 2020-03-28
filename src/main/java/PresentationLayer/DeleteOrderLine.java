package PresentationLayer;

import DBAccess.CartMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderLine;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteOrderLine extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        try {
            int OrderLineID = Integer.parseInt(request.getParameter( "OrderLineID" ));
            CartMapper.DeleteOrderLine(OrderLineID);

            String email = request.getParameter("email");
            ArrayList<OrderLine> array = LogicFacade.getOrderLines(email);


            HttpSession session = request.getSession();
            session.setAttribute("xy", array);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "cart";
    }
}
