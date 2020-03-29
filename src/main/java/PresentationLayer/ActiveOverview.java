package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.OrderLine;
import FunctionLayer.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ActiveOverview extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {





        List<OrderLine> ordrelinjer = new ArrayList<OrderLine>();
        ordrelinjer=LogicFacade.getAllActiveOrderLines();




        HttpSession session = request.getSession();
        session.setAttribute("xy", ordrelinjer);
        return "activeoverview";
    }
}
