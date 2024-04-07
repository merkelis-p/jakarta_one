package lt.vu;
import lt.vu.interceptors.LoggedInvocation;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;


@Named
@LoggedInvocation
@RequestScoped // @SessionScoped
public class PirmasKomponentas implements Serializable{

    private static final Logger LOGGER = Logger.getLogger(PirmasKomponentas.class.getName());

    //@Inject
    private AntrasKomponentas antras;
//    PirmasKomponentas () {
//        LOGGER.info("PirmasKomponentas created.");
//    }
//
    @Inject
    public PirmasKomponentas(AntrasKomponentas antras) {
        this.antras = antras;
        LOGGER.info("PirmasKomponentas created with AntrasKomponentas.");
    }

    public String sakykLabas() {
        return "Labas " + new Date() + " " + toString() + " " + antras.getClass().getName();
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