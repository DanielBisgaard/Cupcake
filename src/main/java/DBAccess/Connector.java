package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            setDBCredentials();
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }
    public static void setDBCredentials(){
        String deployed = System.getenv("DEPLOYED");

        if(deployed != null){
            //henter variabler fr setenv.sh
            URL = System.getenv("JDBC_CONNECTION_STRING");
            USERNAME = System.getenv("JDBC_USER");
            PASSWORD = System.getenv("JDBC_PASSWORD");

        }else{
            //Localhost
            URL = "jdbc:mysql://127.0.0.1:3306/olskercupcakes?serverTimezone=CET&useSSL=false";
            USERNAME = "root";
            PASSWORD = "1234fem";
        }
    }
}
