package FunctionLayer;

import DBAccess.UserMapper;

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

}
