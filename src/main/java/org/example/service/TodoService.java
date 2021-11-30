package org.example.service;

import org.example.dao.TodoDAO;
import org.example.model.Task;

public class TodoService {
    public static void createTask(Task task) {
        TodoDAO.createTaskDB(task);
    }

    public static void getAllTasks() {
        TodoDAO.getAllTasksDB();
    }

    public static void  deleteTask(int id) {
        TodoDAO.deleteTaskDB(id);
    }

    public static void updateTask(Task task){
        TodoDAO.updateTaskDB(task);
    }
}
