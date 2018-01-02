package simple_version;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCConnection{

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            ResourceBundle resource = ResourceBundle.getBundle("database");
            String url = resource.getString("url");
            String user = resource.getString("user");
            String pass = resource.getString("password");
            connection =  DriverManager.getConnection(url, user, pass);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
