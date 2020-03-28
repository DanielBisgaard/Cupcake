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

public class AddToCart extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String toppen = request.getParameter( "toppen" );
        String bunden = request.getParameter( "bunden" );
        String count = request.getParameter("count");
        String email = request.getParameter("email");
        LogicFacade.createOrderLine(Integer.parseInt(toppen), bunden, Integer.parseInt(count), email);
        Product cupcake = LogicFacade.createProduct(Integer.parseInt(toppen), bunden);

        List<OrderLine> ordrelinjer = new ArrayList<OrderLine>();
        ordrelinjer=LogicFacade.getOrderLines(email);




        HttpSession session = request.getSession();
        session.setAttribute("xy", ordrelinjer);


        return "cart";
    }

}

