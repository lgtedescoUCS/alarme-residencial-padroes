/**
 * OBSERVADOR CONCRETO (extra).
 * Reage ao disparo acionando o Corpo de Bombeiros.
 */
public class ServicoBombeiros implements ObservadorDeSeguranca {

    private final LoggerCentral logger = LoggerCentral.getInstancia();

    @Override
    public void reagirAoDisparo() {
        System.out.println(">> BOMBEIROS acionados! Chamada automática para o 193.");
        logger.registrarEvento("Corpo de Bombeiros notificado.");
    }
}
