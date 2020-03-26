package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Product;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Cart extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String toppen = request.getParameter( "toppen" );
        String bunden = request.getParameter( "bunden" );
        String count = request.getParameter("count");
        //User user = LogicFacade.( toppen, bunden, count );
            //eksisterer cupcake allerede? Hvis ikke, så sæt den ind som product i DB'en
        Product cupcake = LogicFacade.createProduct(Integer.parseInt(toppen), bunden);
        //Se om brugeren har en eksisterende ordre som ikke er betalt, hvis nej lav ordre
        //lav ordrelinje
        //hent ordre

        //regn samlet pris på ordre
        //send ordre til jsp
        HttpSession session = request.getSession();


        //session.setAttribute( "user", user );
        //session.setAttribute( "role", user.getRole() );
        //session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke


        return "cart";
    }

}
