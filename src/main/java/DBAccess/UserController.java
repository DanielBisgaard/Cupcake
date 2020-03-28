package DBAccess;

import FunctionLayer.User;

import DBAccess.UserMapper;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;


public class UserController {

    private UserMapper um;

    public UserController(DataSource ds) {
        um = new UserMapper(ds);
    }

    public List<User> getUsers() {
        return um.getUsers();
    }


    }