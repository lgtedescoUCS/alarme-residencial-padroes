/**
 * SINGLETON (Initialization-on-demand Holder Idiom).
 *
 * Garante uma única instância do logger em memória. A instância só é
 * criada quando getInstancia() é chamado pela primeira vez, e o
 * carregamento da classe interna Holder pela JVM já é thread-safe,
 * dispensando 'synchronized'.
 */
public class LoggerCentral {

    // Construtor privado: ninguém de fora pode dar "new LoggerCentral()".
    private LoggerCentral() { }

    // A classe interna só é carregada quando referenciada em getInstancia().
    private static class Holder {
        private static final LoggerCentral INSTANCIA = new LoggerCentral();
    }

    public static LoggerCentral getInstancia() {
        return Holder.INSTANCIA;
    }

    public void registrarEvento(String mensagem) {
        System.out.println("[LOG CENTRAL - " + System.currentTimeMillis() + "] " + mensagem);
    }
}
