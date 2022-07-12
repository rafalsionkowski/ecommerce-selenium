package utils.dbconnection;

import utils.log.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.IllegalFormatException;

public class DbConnector {

    private final String url = "jdbc:mysql://localhost:3306/movielibrary";
    private final String user = "root";
    private final String password = "qwerty";

    public void connecttoDb() throws SQLException {

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Log.info("Database connected!");
            } catch (SQLException e) { Log.error("Cannot connect the database" + e);
            throw new IllegalStateException();
        }

    }

}