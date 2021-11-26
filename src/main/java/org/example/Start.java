package org.example;

import java.sql.Connection;

public class Start {
    public static void main(String[] args) {
        ConnectionDB connectionDB = new ConnectionDB();

        try {
            Connection cnx = connectionDB.get_connection();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
