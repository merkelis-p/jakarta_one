package lt.vu;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;

@Named
@RequestScoped
public class AntrasKomponentas implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(AntrasKomponentas.class.getName());

    @Inject
    public AntrasKomponentas() {
        LOGGER.info("AntrasKomponentas created with PirmasKomponentas.");
    }

    public String sakykLabas() {
        return "Antras.Labas " + new Date() + " " + toString();
    }

    @PostConstruct
    public void init() {
        LOGGER.info(toString() + " constructed.");
    }

    @PreDestroy
    public void preDestroy() {
        LOGGER.info(toString() + " will be destroyed.");
    }
}
