/**
 * OBSERVADOR CONCRETO.
 * Reage ao disparo da central tocando a sirene.
 */
public class Sirene implements ObservadorDeSeguranca {

    private final LoggerCentral logger = LoggerCentral.getInstancia();

    @Override
    public void reagirAoDisparo() {
        System.out.println(">> SIRENE tocando! WIUU WIUU WIUU");
        logger.registrarEvento("Sirene acionada.");
    }
}
