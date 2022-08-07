package com.himynameisilnano;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/name")
public class BankResource {

    @ConfigProperty(name = "bank.name", defaultValue = "Bank of nothing")
    String name;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getName() {
        return name;
    }
}