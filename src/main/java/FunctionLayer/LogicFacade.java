package FunctionLayer;

import DBAccess.CartMapper;
import DBAccess.Connector;
import DBAccess.UserMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "Customer", 0);
        UserMapper.createUser( user );
        return user;
    }
    public static User createEmployee(String email, String password) throws LoginSampleException {
        User employee = new User(email,password,"Employee",0);
        UserMapper.createUser(employee);
        return employee;
    }
    public static void createOrderLine(int TopID, String BotID, int count, String email) throws LoginSampleException {
        //Får fat i produkt id
        Product cupcake = new Product();
        cupcake = LogicFacade.createProduct(TopID, BotID);
        int productID = cupcake.getProductID();

        //Får fat i ordre id
        Order o = LogicFacade.createOrder(email);
        int orderID = o.getOrderID();

        //Sæt ordrelinje i databasen
        CartMapper.createOrderLine(count, productID, orderID);

    }

    public static Product createProduct(int TopID, String BotID ) throws LoginSampleException {
        Product cupcake = new Product();
        User user = new User();
        cupcake.setBotID(CartMapper.getBundID(BotID));
        cupcake.setTopID(TopID);
        CartMapper.createProduct(cupcake);
        return cupcake;
    }
    public static Order createOrder(String email ) throws LoginSampleException {

        User user = UserMapper.getUser(email);
        int id = user.getId();
        Order o = new Order(id);
        try {
            CartMapper.createOrder(o);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }
    public static int convertBundToInt(String Bunden) throws LoginSampleException {
        return CartMapper.getBundID(Bunden);
    }
    public static ArrayList<OrderLine> getOrderLines(String email) throws LoginSampleException {
        ArrayList<OrderLine> linjer = new ArrayList<OrderLine>();
        User user = UserMapper.getUser(email);
        int id = user.getId();
        linjer = CartMapper.getOrderLines(id);

        return linjer;
    }



    public static void pay(int pris, String email) throws LoginSampleException {
        User user = UserMapper.getUser(email);
        int id = user.getId();
        int orderid = 0;
        try {
            orderid = CartMapper.getOrderID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        UserMapper.pay(pris, email, orderid);


    }

    public static List<OrderLine> getAllActiveOrderLines() {
        ArrayList<OrderLine> linjer = new ArrayList<OrderLine>();


        linjer = CartMapper.getAllActiveOrderLines();

        return linjer;
    }
}
