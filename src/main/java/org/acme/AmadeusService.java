package org.acme;

import com.amadeus.Amadeus;
import io.quarkus.runtime.Startup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.Objects;

@Startup //The same effect as Spring does
@ApplicationScoped
public class AmadeusService {

    public static Logger logger = LoggerFactory.getLogger(AmadeusService.class);

    final String AMADEUS_CLIENT_ID;
    final String AMADEUS_CLIENT_SECRET;
    final Amadeus amadeus;

    public AmadeusService() {
        this.AMADEUS_CLIENT_ID = (Objects.isNull(System.getenv("AMADEUS_CLIENT_ID")))
                ? "PENDING_AMADEUS_CLIENT_ID" : System.getenv("AMADEUS_CLIENT_ID");
        this.AMADEUS_CLIENT_SECRET = (Objects.isNull(System.getenv("AMADEUS_CLIENT_SECRET")))
                ? "PENDING_AMADEUS_CLIENT_ID" : System.getenv("AMADEUS_CLIENT_SECRET");
        this.amadeus = Amadeus
                .builder(AMADEUS_CLIENT_ID, AMADEUS_CLIENT_SECRET)
                .setLogLevel("debug")
                .build();
    }

    @PostConstruct
    void init() {
        logger.info("Loading environment variables:");
        logger.info("AMADEUS_CLIENT_ID: {}", AMADEUS_CLIENT_ID);
        logger.info("AMADEUS_CLIENT_SECRET: {}", AMADEUS_CLIENT_SECRET);
    }

    public Amadeus getAmadeus() {
        return amadeus;
    }
}