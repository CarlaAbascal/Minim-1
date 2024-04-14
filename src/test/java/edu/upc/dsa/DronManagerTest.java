package edu.upc.dsa;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;

public class DronManagerTest {
    DronManager manager;

    private HttpServer server;
    private WebTarget target;

    @Before
    public void addDronTest() {
        manager.addDron("1","Dron1","fabricante1","modelo1");
        manager.addDron("2","Dron2","fabricante2","modelo1");
        Assert.assertEquals(2,manager.numDrones());
    }
    public void addPilotoTest(){
        manager.addPiloto("1","Carla","Abascal");
        manager.addPiloto("2","Luis","Angel");
        Assert.assertEquals(2,manager.numPrilotos());
    }

}
