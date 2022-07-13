package utils.dbconnection;

import utils.log.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    private final String url = "jdbc:mysql://localhost:3306/movielibrary";
    private final String user = "root";
    private final String password = "qwerty";
    Connection connection;

    public Connection connecttoDb() throws SQLException {

        connection = DriverManager.getConnection(url, user, password);
        Log.info("połoczone");

        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
        Log.info("rozłączono");
    }

}