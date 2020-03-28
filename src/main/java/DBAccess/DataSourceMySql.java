package DBAccess;


import com.mysql.cj.jdbc.MysqlDataSource;


public class DataSourceMySql {

    private MysqlDataSource dataSource = new MysqlDataSource();
    private MysqlDataSource localDataSource = new MysqlDataSource();

    public DataSourceMySql() {
        {
            try {
                dataSource.setServerName("127.0.0.1");

                dataSource.setPort(3306);
                dataSource.setDatabaseName("olskercupcake");
                dataSource.setUser("root");
                dataSource.setPassword("klon3903202");


                dataSource.setUseSSL(false);

                localDataSource.setServerName("localhost");
                localDataSource.setPort(3306);
                localDataSource.setDatabaseName("olskercupcake");
                localDataSource.setUser("root");

                localDataSource.setPassword("klon3903202");

                localDataSource.setUseSSL(false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public MysqlDataSource getDataSource() {
        return dataSource;
    }
}
