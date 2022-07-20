package pages.user;


import utils.dbconnection.QueryExecutor;

import java.sql.SQLException;

public class UserDbManager extends QueryExecutor {

    public void addNewUserToDb(String userName, String userPassword) throws SQLException {
        executeQuery("INSERT user (user_name, user_password) VALUES ('" + userName + "', '"+ userPassword +"')");
    }
}
