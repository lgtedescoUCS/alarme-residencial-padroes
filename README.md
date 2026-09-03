# Alarme e Segurança Residencial — Singleton, Observer e Façade

Núcleo de um sistema de automação residencial em Java. Sensores disparam reações em cadeia, todas as ocorrências vão para um log central único, e a complexidade toda fica atrás de um painel de dois botões.

---

## O problema

Um sistema de segurança tem três exigências que puxam em direções diferentes:

1. **Um único log.** Todas as ocorrências — alarme ativado, sensor disparado, dispositivo acionado — precisam ir para o mesmo lugar. Várias instâncias de logger produziriam auditoria fragmentada.
2. **Reação em cadeia.** Quando a central dispara, sirene, SMS e o que mais estiver conectado precisam reagir. A central não pode ter uma lista fixa de dispositivos no código: isso a obrigaria a mudar toda vez que um dispositivo novo entrasse.
3. **Operação simples.** O usuário final aperta um botão. Ele não configura sensores nem registra observadores.

Cada exigência mapeia para um padrão.

---

## Os três padrões

### Singleton — `LoggerCentral`

Garante instância única do registro de eventos. Implementado com Holder Idiom, que resolve a inicialização tardia e a segurança em ambiente concorrente sem custo de sincronização a cada acesso.

```java
LoggerCentral.getInstancia().registrarEvento("Sensor de fumaça disparado");
```

### Observer — `CentralDeAlarme` e dispositivos

`CentralDeAlarme` é o Sujeito. Mantém a lista de observadores e os notifica quando o estado muda para DISPARADO.

```java
interface ObservadorDeSeguranca {
    void reagirAoDisparo();
}
```

Observadores concretos implementam `reagirAoDisparo()`: `Sirene` toca, `DispositivoSMS` notifica o proprietário.

**O ponto do padrão:** a central conhece apenas a interface. Acrescentar um observador novo — acionamento dos bombeiros, câmera, luzes — é criar uma classe e registrá-la. `CentralDeAlarme` não muda.

### Façade — `SegurancaFacade`

Instancia a central e os dispositivos, registra os observadores no construtor, e expõe ao código cliente apenas dois métodos:

```java
sistema.ativarModoNoite();
sistema.acionarBotaoPanico();
```

O cliente não conhece `CentralDeAlarme`, nem `Sirene`, nem a interface de observador. Conhece a fachada.

---

## Fluxo de um disparo

```
Cliente
  └─► SegurancaFacade.acionarBotaoPanico()
        └─► CentralDeAlarme.disparar()
              ├─► LoggerCentral.registrarEvento("...")
              └─► notifica todos os observadores
                    ├─► Sirene.reagirAoDisparo()      → "SIRENE tocando!"
                    └─► DispositivoSMS.reagirAoDisparo() → "SMS enviado!"
```

---

## Como executar

```bash
javac -d bin src/*.java
java -cp bin Main
```

A `Main` conhece exclusivamente a fachada:

```java
SegurancaFacade sistema = new SegurancaFacade();
sistema.acionarBotaoPanico();
```

Duas linhas disparam a cadeia inteira. É essa a medida do Façade.

---

Trabalho de implementação — Projeto e Arquitetura de Software, Universidade de Caxias do Sul (UCS).

---

> ⚠️ **Confirmar antes de publicar:** o enunciado sugeria implementar observadores além de sirene e SMS. Se você fez — acionamento dos bombeiros, por exemplo — acrescente à lista, porque é exatamente o argumento que prova o Observer. Confirme também se você usou Holder Idiom ou Singleton clássico e ajuste o texto.
