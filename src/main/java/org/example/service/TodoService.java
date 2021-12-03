package org.example.service;

import org.example.dao.TodoDAO;
import org.example.model.ImmutableTask;
import org.example.model.Task;

import java.util.ArrayList;

public class TodoService {
    public static void createTask(ImmutableTask task) {
        TodoDAO.createTaskDB(task);
    }

    public static ArrayList<ImmutableTask> getAllTasks() {
        ArrayList<ImmutableTask> allTasks = TodoDAO.getAllTasksDB();
        return allTasks;
    }

    public static void  deleteTask(int id) {
        TodoDAO.deleteTaskDB(id);
    }

    public static void updateTask(ImmutableTask task){
        TodoDAO.updateTaskDB(task);
    }
}
