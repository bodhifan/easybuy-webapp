package com.easybuy.services.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.easybuy.application.Main;

import static org.junit.Assert.assertEquals;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }
    
    @Test
    public void testGetHeaders(){
        String resonse = target.path("myresource/my").request().header("hi", "test").get(String.class);
        System.out.println(resonse);
    }
    
    @Test
    public void getProduct(){
        String resonse = target.path("product/351").request().header("content-type", "application/json").get(String.class);
        System.out.println(resonse);
    }
    
    @Test
    public void getLinks(){
        Response resonse = target.path("myresource/mylinks").request().header("content-type", "application/json").get();
        System.out.println(resonse.getLinks().toString());
    }
    @Test
    public void getWidgets(){
        Response resonse = target.path("widgets").request().header("content-type", "application/json").get();
        System.out.println(resonse.toString());
        System.out.println(resonse.getLinks());
    }
}
