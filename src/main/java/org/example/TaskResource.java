
package org.example;

import org.example.dao.ITodoDAO;
import org.example.model.ImmutableTask;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/** Example resource class hosted at the URI path "/tasks"
 */
@Path("/tasks")
public class TaskResource implements ITodoDAO {

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ImmutableTask createNewTask(ImmutableTask newTask) {

        return createTaskDB(newTask);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ImmutableTask> getAllTasks() {
        return getAllTasksDB();
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(ImmutableTask task) {
        updateTaskDB(task);
        return Response.status(202).entity("Task updated successfully!").build();
    }

    @Path("/delete/{id}")
    @DELETE
    public Response deleteTask(@PathParam("id") int id) {
        deleteTaskDB(id);
        return Response.status(202).entity("Task deleted successfully!").build();
    }
}
