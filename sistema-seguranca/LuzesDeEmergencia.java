/**
 * OBSERVADOR CONCRETO (extra).
 * Reage ao disparo acendendo as luzes de emergência.
 */
public class LuzesDeEmergencia implements ObservadorDeSeguranca {

    private final LoggerCentral logger = LoggerCentral.getInstancia();

    @Override
    public void reagirAoDisparo() {
        System.out.println(">> LUZES DE EMERGÊNCIA acesas! Iluminando rotas de fuga.");
        logger.registrarEvento("Luzes de emergência acionadas.");
    }
}
