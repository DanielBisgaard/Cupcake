package PresentationLayer;

import DBAccess.CartMapper;
import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderLine;
import FunctionLayer.Order_User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeleteOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int OrderID = Integer.parseInt(request.getParameter( "orderID" ));
        try {
            CartMapper.DeleteOrderLines(OrderID);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        CartMapper.DeleteOrder(OrderID);


        List<Order_User> array = new ArrayList<Order_User>();
        array = UserMapper.getOrder_Users();

        HttpSession session = request.getSession();
        session.setAttribute("linjer", array);


        return "overview";
    }
}
