package org.acme;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Objects;

@Path("/api/v1/covid-restrictions")
public class CovidResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(@QueryParam("country-code") String stateCode) throws ResponseException {

        var AMADEUS_CLIENT_ID = System.getenv("AMADEUS_CLIENT_ID");
        var AMADEUS_CLIENT_SECRET = System.getenv("AMADEUS_CLIENT_SECRET");

        var amadeus = Amadeus.builder(AMADEUS_CLIENT_ID, AMADEUS_CLIENT_SECRET).build();
        var countryCode = (!Objects.isNull(stateCode)) ? stateCode : "ES";

        var params = Params.with("countryCode", countryCode);

        return amadeus.dutyOfCare.diseases.covid19AreaReport.get(params).toString();
    }
}