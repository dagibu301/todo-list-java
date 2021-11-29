
package org.example;

import org.example.model.Task;
import org.example.service.TodoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/tasks")
public class TaskResource {

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Task createNewTask(Task newTask) {
        //we can make use of UserProfile now
        String title = newTask.getTitle();
        String description = newTask.getDescription();
        try {
            TodoService.createTask(newTask);
        } catch (Exception e) {
            System.out.println("Not able to create record");
        }

        System.out.println("Title = " + title);
        System.out.println("Description = " + description);
        // And when we are done we can return user profile back
        return newTask;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getAllTasks() {
        TodoService.getAllTasks();
        /*Task[] currentTasks = TodoService.getAllTasks();*/
    }

    @Path("/update/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Task task) {

        return Response.noContent().build();
    }

    @Path("/delete/{id}")
    @DELETE
    public Response deleteTask(@PathParam("id") int id) {
        TodoService.deleteTask(id);
        return Response.status(202).entity("Task deleted successfully !!").build();
    }
}
