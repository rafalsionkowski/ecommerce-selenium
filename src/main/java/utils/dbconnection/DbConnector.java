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

    public Connection connectToDb() throws SQLException {

        try {
            connection = DriverManager.getConnection(url, user, password);
            Log.info("Connected to DB");
        } catch (SQLException e) {
            Log.error("Cannot connect to DB" + e);
        }
        return connection;

    }

    public void closeConnection() throws SQLException {

        try {
            connection.close();
            Log.info("Disconnected from DB");
        } catch (SQLException e) {
            Log.error("Cannot disconect to DB" + e);
        }
    }

    }
