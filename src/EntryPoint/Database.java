package EntryPoint;

import java.sql.*;

public class Database {
    private static Connection dbConnection = null;
    final static String URLConnectionString = "jdbc:sqlite:User.db";
    public static Connection getDbConnection() {
        connectToDb();
        return dbConnection;
    }

    public static void setDbConnection(Connection dbConnection) {
        Database.dbConnection = dbConnection;
    }

    public static void connectToDb() {
        try {
            Connection connectionUrl = DriverManager.getConnection(URLConnectionString);
            System.out.println("Connection to SQLite has been established.");
            setDbConnection(connectionUrl);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void closeConnection() {
        try {
            dbConnection.close();
        }
        catch (SQLException e) {
        }
    }

    public static void main(String[] args) {
        /*try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        try {
            Connection connectionUrl = DriverManager.getConnection(URLConnectionString);
            System.out.println("Connection to SQLite has been established.");
            setDbConnection(connectionUrl);

            Statement statement = connectionUrl.createStatement();
            statement.execute("CREATE TABLE if not exists users(ID varchar(50) NOT NULL PRIMARY KEY, PWD varchar(50) NOT NULL)");

//            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
//
//            while (resultSet.next()){
//                System.out.println(resultSet.getString("ID"));
//            }


            statement.close();
            //connectionUrl.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

