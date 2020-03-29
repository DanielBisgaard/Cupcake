package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put("addCredit", new AddCredit());
        commands.put("registerEmployee", new RegisterEmployee());
        commands.put( "overview", new Overview() );
        commands.put( "home", new Home() );
        commands.put( "about", new About() );
        commands.put( "shop", new Shop() );
        commands.put( "cart", new Cart() );
        commands.put( "addtocart", new AddToCart() );
        commands.put( "deleteorderline", new DeleteOrderLine() );
        commands.put( "pay", new Pay() );
        commands.put( "kurv", new Kurv() );
        commands.put( "logud", new LogOut() );
        commands.put( "Customerpage", new Customerpage() );
        commands.put( "Employeepage", new Employeepage() );
        commands.put( "userlist", new UserList() );
        commands.put( "deleteorder", new DeleteOrder() );
        commands.put( "getusers", new GetUsers() );
        commands.put( "activeoverview", new ActiveOverview() );

    }

    static Command from( HttpServletRequest request ) {
        String TagetName = request.getParameter( "taget" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(TagetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException;

}
