package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.example.DataBase.*;

public interface IDBConnection {

    default Connection getConnection () {

        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL + DB,USER,PASSWORD);
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
