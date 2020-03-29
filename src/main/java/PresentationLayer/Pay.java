package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Pay extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int pris = Integer.parseInt(request.getParameter("pris"));
        String email = request.getParameter("email");

        LogicFacade.pay(pris,email);
        return "thankyou";
    }
}
