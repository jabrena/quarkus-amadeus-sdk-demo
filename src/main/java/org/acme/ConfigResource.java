package org.acme;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/config-demo")
public class ConfigResource {

    @ConfigProperty(name = "greeting.suffix", defaultValue="DEFAULT")
    String fieldValue1;

    @ConfigProperty(name = "greeting.suffix2", defaultValue="DEFAULT")
    String fieldValue2;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return fieldValue1 + " " + fieldValue2;
    }

}
