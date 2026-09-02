/**
 * CÓDIGO CLIENTE.
 * Repare que o cliente só conhece a Façade — nada de central,
 * sirene, observadores ou logger diretamente.
 */
public class Main {
    public static void main(String[] args) {
        // O cliente só conhece a Fachada!
        SegurancaFacade sistema = new SegurancaFacade();

        System.out.println("\n--- Simulando o uso do Painel pelo Usuário ---");

        // Arma o sistema
        sistema.ativarModoNoite();

        // Aciona o botão de pânico
        sistema.acionarBotaoPanico();
    }
}
