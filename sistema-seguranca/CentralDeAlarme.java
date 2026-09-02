import java.util.ArrayList;
import java.util.List;

/**
 * SUJEITO (Subject) do padrão OBSERVER.
 *
 * Mantém a lista de observadores e, ao mudar seu estado para "DISPARADO",
 * notifica todos eles automaticamente. Usa o LoggerCentral (Singleton)
 * para registrar cada ocorrência no arquivo central de auditoria.
 */
public class CentralDeAlarme {

    private final List<ObservadorDeSeguranca> observadores = new ArrayList<>();
    private final LoggerCentral logger = LoggerCentral.getInstancia();
    private String estado = "DESARMADO";

    public void adicionarObservador(ObservadorDeSeguranca o) {
        observadores.add(o);
        logger.registrarEvento("Observador conectado: " + o.getClass().getSimpleName());
    }

    public void removerObservador(ObservadorDeSeguranca o) {
        observadores.remove(o);
        logger.registrarEvento("Observador removido: " + o.getClass().getSimpleName());
    }

    /**
     * Muda o estado para DISPARADO e avisa todos os observadores.
     */
    public void disparar() {
        this.estado = "DISPARADO";
        logger.registrarEvento("Central mudou de estado para: " + estado);

        for (ObservadorDeSeguranca o : observadores) {
            o.reagirAoDisparo();
        }

        logger.registrarEvento("Todos os dispositivos foram notificados.");
    }

    public String getEstado() {
        return estado;
    }
}
