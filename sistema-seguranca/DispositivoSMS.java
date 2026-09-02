/**
 * OBSERVADOR CONCRETO.
 * Reage ao disparo enviando um SMS ao proprietário.
 */
public class DispositivoSMS implements ObservadorDeSeguranca {

    private final LoggerCentral logger = LoggerCentral.getInstancia();

    @Override
    public void reagirAoDisparo() {
        System.out.println(">> SMS enviado para o proprietário!");
        logger.registrarEvento("SMS de alerta enviado ao proprietário.");
    }
}
