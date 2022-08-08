package com.himynameisilnano;

import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;
import java.util.Optional;

@Path("/bank")
public class BankResource {

    @ConfigProperty(name = "bank.name", defaultValue = "Bank of nothing")
    String name;

    @ConfigProperty(name = "bank.mobileBanking")
    Optional<Boolean> mobileBanking;

    @ConfigProperties(prefix = "bank-support")
    BankSupportConfig supportConfig;

    @GET
    @Path("/name")
    @Produces(MediaType.TEXT_PLAIN)
    public String getName() {
        return name;
    }

    @GET
    @Path("/mobilebanking")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean getMobileBanking() {
        return mobileBanking.orElse(false);
    }

    @GET
    @Path("/suport")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getSupport() {
        return Map.of(
                "email", supportConfig.email,
                "phone", supportConfig.getPhone()
        );
    }
}