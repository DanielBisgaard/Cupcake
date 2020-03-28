package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Cart extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String toppen = request.getParameter( "toppen" );
        String bunden = request.getParameter( "bunden" );
        String count = request.getParameter("count");
        String email = request.getParameter("email");

        //User user = LogicFacade.( toppen, bunden, count );
            //eksisterer cupcake allerede? Hvis ikke, så sæt den ind som product i DB'en

        Product cupcake = LogicFacade.createProduct(Integer.parseInt(toppen), bunden);

        //Se om brugeren har en eksisterende ordre som ikke er betalt, hvis nej lav ordre
        //lav ordrelinje
        //hent ordrelinjer

        List<OrderLine> ordrelinjer = new ArrayList<OrderLine>();
        ordrelinjer=LogicFacade.getOrderLines(email);

        //regn samlet pris på ordre
        //send ordre til jsp

        HttpSession session = request.getSession();

        session.setAttribute("orderlines", ordrelinjer);

//        for (int i = 0; i < ordrelinjer.size(); i++) {
//            session.setAttribute("OrderID" + i, ordrelinjer.get(i).getOrderID());
//            session.setAttribute("ProductID" + i, ordrelinjer.get(i).getProductID());
//            session.setAttribute("TopIngredient" + i, ordrelinjer.get(i).getTopIngredient());
//            session.setAttribute("BotIngredient" + i, ordrelinjer.get(i).getBotIngredient());
//            session.setAttribute("Price" + i, ordrelinjer.get(i).getPrice());
//        }


        return "cart";
    }

}
