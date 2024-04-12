package edu.upc.dsa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameManagerTest {
    GameManager manager;

    //private HttpServer server;
    //private WebTarget target;

    @Before
    public void addUserTest() {
        manager.addUser("1","Carla","Abascal",0);
        manager.addUser("2","Ines","Mas",0);
        Assert.assertEquals(2,manager.numUsers());
    }
    public void addProductTest(){
        manager.addProduct("1","Pócima",15);
        manager.addProduct("2","Escudo",70);
        Assert.assertEquals(2,manager.numProducts());
    }
    @Test
    public void consultStatusTest(){
        manager.consultStatus("1");
        Assert.assertEquals("INICIADO_EN_FUNCIONAMIENTO",manager.consultStatus("1"));

    }
}
