
package org.example;

import org.example.model.Task;
import org.example.service.TodoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/** Example resource class hosted at the URI path "/tasks"
 */
@Path("/tasks")
public class TaskResource {

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Task createNewTask(Task newTask) {
        TodoService.createTask(newTask);
        return newTask;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getAllTasks() {
        TodoService.getAllTasks();
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Task task) {
        TodoService.updateTask(task);
        return Response.status(202).entity("Task updated successfully!").build();
    }

    @Path("/delete/{id}")
    @DELETE
    public Response deleteTask(@PathParam("id") int id) {
        TodoService.deleteTask(id);
        return Response.status(202).entity("Task deleted successfully!").build();
    }
}
