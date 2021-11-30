package org.example.service;

import org.example.dao.TodoDAO;
import org.example.model.Task;

import java.util.ArrayList;

public class TodoService {
    public static void createTask(Task task) {
        TodoDAO.createTaskDB(task);
    }

    public static ArrayList<Task> getAllTasks() {
        ArrayList<Task> allTasks = TodoDAO.getAllTasksDB();
        return allTasks;
    }

    public static void  deleteTask(int id) {
        TodoDAO.deleteTaskDB(id);
    }

    public static void updateTask(Task task){
        TodoDAO.updateTaskDB(task);
    }
}
