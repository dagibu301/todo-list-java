package org.example.dao;

import org.example.ConnectionDB;
import org.example.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoDAO {
    public static void createTaskDB(Task task) {

        ConnectionDB connectionDB = new ConnectionDB();

        try{
            Connection cnx = connectionDB.getConnection();
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO tasks (title, description, isfinished) VALUES (?,?,?)";
                ps = cnx.prepareStatement(query);
                ps.setString(1,  task.getTitle());
                ps.setString(2,  task.getDescription());
                ps.setBoolean(3,  task.isFinished());
                ps.executeUpdate();
                System.out.println("Task created");

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void getAllTasksDB() {

        ConnectionDB connectionDB = new ConnectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection cnx = connectionDB.getConnection();

            try {
                String query = "SELECT * FROM tasks";
                ps = cnx.prepareStatement(query);
                rs = ps.executeQuery();

                while( rs.next()){
                    System.out.println("---------------------------------");
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Title: " + rs.getString("title"));
                    System.out.println("Description: " + rs.getString("description"));
                    System.out.println("Is Finished: " + rs.getBoolean("isfinished"));
                    System.out.println("---------------------------------");
                }
                System.out.println("List Tasks");

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void  deleteTaskDB(int id) {

        ConnectionDB connectionDB = new ConnectionDB();
        PreparedStatement ps = null;

        try {
            Connection cnx = connectionDB.getConnection();

            try {
                String query = "DELETE FROM tasks WHERE id = ?";
                ps = cnx.prepareStatement(query);
                ps.setInt(1,  id);
                ps.executeUpdate();
                System.out.println("Task deleted");

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void updateTaskDB(Task task){

    }
}
