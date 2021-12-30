package org.example.dao;

import org.example.IDBConnection;
import org.example.model.ImmutableTask;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.Record;
import test.generated.tables.Tasks;
import test.generated.tables.records.TasksRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ITodoDAO extends IDBConnection {

    default ImmutableTask createTaskDB(ImmutableTask task) {
        try{
            Connection cnx = getConnection();

            DSLContext context = DSL.using(cnx, SQLDialect.MYSQL);
            TasksRecord newTask = context.newRecord(Tasks.TASKS);
            newTask.setTitle(task.title());
            newTask.setDescription(task.description());
            newTask.setIsfinished((byte) (task.isFinished() ? 1 : 0 ));
            newTask.store();

        } catch (Exception e) {
            System.out.println(e);
        }

        return task;
    }

    default ArrayList<ImmutableTask> getAllTasksDB() {

        ArrayList<ImmutableTask> results = new ArrayList<ImmutableTask>();
        Byte zero = 0;

        try {
            Connection cnx = getConnection();
            DSLContext context = DSL.using(cnx, SQLDialect.MYSQL);
            /*Result<Record> records = context.select().from(Tasks.TASKS).fetch();*/
            Result<Record> records = context.fetch("SELECT * FROM tasks");

            // WIP: Cast Byte value isFinished to boolean coming from DB
            for (Record record : records ) {
                ImmutableTask newTask = ImmutableTask.builder()
                        .id(record.get(Tasks.TASKS.ID))
                        .title(record.get(Tasks.TASKS.TITLE))
                        .description(record.get(Tasks.TASKS.DESCRIPTION))
                        .isFinished(false)
                        .build();

                results.add(newTask);
            }
            System.out.println("List Tasks");

        } catch (Exception e) {
            System.out.println(e);
        }
        return results;

    }

    default void  deleteTaskDB(int id) {

        try {

            Connection cnx = getConnection();

            PreparedStatement ps = null;
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

    default void updateTaskDB(ImmutableTask task){

        try {
            Connection cnx = getConnection();
            /* JOOQ Implementation, WIP
            DSLContext context = DSL.using(cnx, SQLDialect.MYSQL);
            context.update(Tasks.TASKS)
                    .set(Tasks.TASKS.TITLE, task.title())
                    .set(Tasks.TASKS.DESCRIPTION, task.description())
                    .set(Tasks.TASKS.ISFINISHED, (byte) 0)
                    .where(Tasks.TASKS.ID.eq(task.id().orElse(0)))
                    .execute();*/

            PreparedStatement ps = null;
            try {
                String query = "UPDATE tasks SET title = ?, description = ? WHERE id = ?";
                ps = cnx.prepareStatement(query);
                ps.setString(1,  task.title());
                ps.setString(2,  task.description());
                ps.setInt(3,  task.id().orElse(0));
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
