package DBAccess;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;


public class DatabaseConnector {

    private DataSource dataSource;
    private Connection connection;
    private Statement statement;
    private ResultSet rs;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


}
