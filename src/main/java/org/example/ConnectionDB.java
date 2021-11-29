package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public Connection getConnection() {

        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist","root","");
            if (connection != null) System.out.println("Connected successfully");
        } catch (SQLException e) {
            System.out.println("Not connected :(");

            System.out.println(e);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
