package utils;

import java.sql.*;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class DatabaseUtil {

    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private Connection connection;

    public DatabaseUtil(String dbUrl, String dbUser, String dbPassword){
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public void openConnection(){
        try {
            this.connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String executeQuery(String query){

        String result = "";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                result = resultSet.getString(1);
            }

            statement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

    public void updateQuery(String query){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
