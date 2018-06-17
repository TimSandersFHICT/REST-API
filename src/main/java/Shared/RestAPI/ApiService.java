package Shared.RestAPI;

import com.google.gson.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("api")
public class ApiService {

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response register(@FormParam("username") String username, @FormParam("password") String password){
        try {
            Service.context.register(username, password);
        } catch (SQLException e) {
            return Response.status(400).build();
        }
        return Response.status(200).build();
    }

    @GET
    @Path("/loginPlayer/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@PathParam("username") String username,
                        @PathParam("password") String password){

        int result = Integer.MIN_VALUE;
        try {
            result = Service.context.loginPlayer(username, password);
        } catch (SQLException e) {
            //ignore
        }

        JsonObject json = new JsonObject();
        json.addProperty("id", result);

        return json.toString();
    }
}
