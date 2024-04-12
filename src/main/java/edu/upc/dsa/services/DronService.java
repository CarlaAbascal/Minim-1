package edu.upc.dsa.services;


import edu.upc.dsa.DronManager;
import edu.upc.dsa.DronManagerImpl;
import edu.upc.dsa.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Api(value = "/Game", description = "Endpoint to Game Service")
@Path("Game")
public class GamesService {

    private final DronManager manager;
    //final static Logger logger = Logger.getLogger(GameManagerImpl.class);

    public GamesService() {
        this.manager = DronManagerImpl.getInstance();
        if (manager.size() == 0) {
            this.manager.addUser("1", "Carla", "Abascal", 25);
            this.manager.addUser("2", "Ines", "Mas", 25);
            this.manager.addUser("3", "Luis", "Angel", 25);

            this.manager.addProduct("1", "Pócima", 15);
            this.manager.addProduct("2", "Escudo", 75);
        }
    }
    @POST
    @ApiOperation(value = "Add new user", notes = "Add new user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Dron.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(Dron user){

        if (user.getId()==null || user.getName()==null || user.getSurname()==null)  return Response.status(500).entity(user).build();
        this.manager.addUser(user.getId(), user.getName(), user.getSurname(), user.getDsaCoins());
        return Response.status(201).entity(user).build();
    }

}
