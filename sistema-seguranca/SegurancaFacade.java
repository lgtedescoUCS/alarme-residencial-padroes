/**
 * FAÇADE.
 *
 * Esconde toda a complexidade (criar central, instanciar dispositivos,
 * registrar observadores) do código Cliente. O cliente só conhece dois
 * métodos: ativarModoNoite() e acionarBotaoPanico().
 */
public class SegurancaFacade {

    private final CentralDeAlarme central;
    private final Sirene sirene;
    private final DispositivoSMS sms;
    private final ServicoBombeiros bombeiros;
    private final LuzesDeEmergencia luzes;
    private final LoggerCentral logger = LoggerCentral.getInstancia();

    public SegurancaFacade() {
        // A Façade monta o subsistema internamente...
        this.central   = new CentralDeAlarme();
        this.sirene    = new Sirene();
        this.sms       = new DispositivoSMS();
        this.bombeiros = new ServicoBombeiros();
        this.luzes     = new LuzesDeEmergencia();

        // ...e já conecta todos os observadores na central.
        central.adicionarObservador(sirene);
        central.adicionarObservador(sms);
        central.adicionarObservador(bombeiros);
        central.adicionarObservador(luzes);

        logger.registrarEvento("Fachada de segurança inicializada e dispositivos conectados.");
    }

    /** Configura e "arma" o sistema. */
    public void ativarModoNoite() {
        System.out.println("== MODO NOITE ATIVADO: sistema armado e monitorando. ==");
        logger.registrarEvento("Modo Noite ativado: sistema armado.");
    }

    /** Dispara o alarme — delega para a central, que notifica todos. */
    public void acionarBotaoPanico() {
        System.out.println("== BOTÃO DE PÂNICO PRESSIONADO ==");
        logger.registrarEvento("Botão de pânico acionado pelo usuário!");
        central.disparar();
    }
}
