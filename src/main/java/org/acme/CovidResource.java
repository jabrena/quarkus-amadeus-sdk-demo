package org.acme;

import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Objects;

@Path("/api/v1/covid-restrictions")
public class CovidResource {

    @Inject
    private AmadeusService amadeusService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(@QueryParam("country-code") String stateCode) throws ResponseException {

        var countryCode = (!Objects.isNull(stateCode)) ? stateCode : "ES";
        var params = Params.with("countryCode", countryCode);

        return amadeusService.getAmadeus().dutyOfCare.diseases.covid19AreaReport.get(params).toString();
    }
}