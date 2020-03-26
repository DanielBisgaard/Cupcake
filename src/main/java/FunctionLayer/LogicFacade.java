package FunctionLayer;

import DBAccess.CartMapper;
import DBAccess.UserMapper;

import java.sql.SQLException;

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
    public static Product createProduct(int TopID, String BotID ) throws LoginSampleException {
        Product cupcake = new Product();
        cupcake.setBotID(BotID);
        cupcake.setTopID(TopID);
        CartMapper.createProduct(cupcake);
        return cupcake;
    }
    public static int convertBundToInt(String Bunden) throws LoginSampleException {



        return CartMapper.getBundID(Bunden);
    }


}
