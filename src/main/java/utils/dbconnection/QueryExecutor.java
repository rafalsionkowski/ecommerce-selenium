package utils.dbconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryExecutor {

//    public static ResultSet executeSelect(String query) throws SQLException {
//        DbConnector dbConnector = new DbConnector();
//        Connection connection = dbConnector.connectToDb();
//        Statement statement = connection.createStatement();
//        return statement.executeQuery(query);
//    }

    public static boolean executeQuery(String query) throws SQLException {
        DbConnector dbConnector = new DbConnector();
        Connection connection = dbConnector.connectToDb();
        boolean statement = connection.createStatement().execute(query);
        dbConnector.closeConnection();
        return statement;

    }

    }


