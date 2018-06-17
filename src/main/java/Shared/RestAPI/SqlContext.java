package Shared.RestAPI;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import java.sql.*;

public class SqlContext implements SqlContextable {
    String url =  "jdbc:sqlserver://;database=ConnectFour;integratedSecurity=true;";


    //region general
    public void register(String username, String password) throws SQLException {

        Connection connection = DriverManager.getConnection(url);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Account (username, password) VALUES (?, ?)");
        statement.setString(1, username);
        statement.setString(2, password);
        statement.execute();

    }

    public int loginPlayer(String username, String password) throws SQLException{
        Connection connection = DriverManager.getConnection(url);
        PreparedStatement statement = connection.prepareStatement("SELECT id FROM Account WHERE username = ? AND password = ?");
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet set = statement.executeQuery();
        set.next();
        return set.getInt("id");
    }
}
