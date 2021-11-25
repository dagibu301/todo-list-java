
package org.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/** Example resource class hosted at the URI path "/myresource"
 */
@Path("/myresource")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @Path("/plain")
    @GET
    @Produces("text/plain")
    public String getIt() {
        return "Hi there!";
    }

    @Path("/html")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHTMLHello() {
        //
        return "<html><title>Hello World!</title><body>"
                + "<h1>Hello world! </h1></body></html>";
    }

    @Path("/json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Student sayJsonHello() {
        return new Student(123, "David", "COL");
    }
}
