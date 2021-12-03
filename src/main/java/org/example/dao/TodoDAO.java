package org.example.dao;

import org.example.ConnectionDB;
import org.example.model.ImmutableTask;
import org.example.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TodoDAO {
    public static void createTaskDB(ImmutableTask task) {

        ConnectionDB connectionDB = new ConnectionDB();

        try{
            Connection cnx = connectionDB.getConnection();
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO tasks (title, description, isfinished) VALUES (?,?,?)";
                ps = cnx.prepareStatement(query);
                ps.setString(1,  task.title());
                ps.setString(2,  task.description());
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

    public static ArrayList<ImmutableTask> getAllTasksDB() {

        ConnectionDB connectionDB = new ConnectionDB();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ImmutableTask> results = new ArrayList<ImmutableTask>();

        try {
            Connection cnx = connectionDB.getConnection();

            try {
                String query = "SELECT * FROM tasks";
                ps = cnx.prepareStatement(query);
                rs = ps.executeQuery();

                while( rs.next()){
                    ImmutableTask newTask = ImmutableTask.builder()
                            .id(rs.getInt("id"))
                            .title(rs.getString("title"))
                            .description(rs.getString("description"))
                            .isFinished(rs.getBoolean("isfinished"))
                            .build();

                    results.add(newTask);
                }
                System.out.println("List Tasks");

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return results;

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

    public static void updateTaskDB(ImmutableTask task){

        ConnectionDB connectionDB = new ConnectionDB();
        PreparedStatement ps = null;

        try {
            Connection cnx = connectionDB.getConnection();

            try {
                String query = "UPDATE tasks SET title = ?, description = ? WHERE id = ?";
                ps = cnx.prepareStatement(query);
                ps.setString(1,  task.title());
                ps.setString(2,  task.description());
                ps.setInt(3,  task.id());
                ps.executeUpdate();
                System.out.println("Task updated");

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
