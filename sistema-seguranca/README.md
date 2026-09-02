# Sistema de Automação e Segurança Residencial

Trabalho em Java demonstrando três padrões de projeto:
- **Singleton** — `LoggerCentral` (Holder Idiom)
- **Observer** — `CentralDeAlarme` (Sujeito) + dispositivos (Sirene, DispositivoSMS, ServicoBombeiros, LuzesDeEmergencia)
- **Façade** — `SegurancaFacade`

## Como rodar no VS Code

1. Instale o **Extension Pack for Java** (da Microsoft) no VS Code.
2. Tenha um **JDK 17+** instalado (`java -version` e `javac -version` devem funcionar no terminal).
3. Abra esta pasta no VS Code (`File > Open Folder...`).
4. Abra o arquivo `Main.java` e clique em **Run** (▶) acima do método `main`.

### Alternativa pelo terminal
Dentro da pasta:
```
javac *.java
java Main
```

## Saída esperada (resumida)
```
[LOG CENTRAL - ...] Observador conectado: Sirene
...
== MODO NOITE ATIVADO: sistema armado e monitorando. ==
== BOTÃO DE PÂNICO PRESSIONADO ==
>> SIRENE tocando! WIUU WIUU WIUU
>> SMS enviado para o proprietário!
>> BOMBEIROS acionados! Chamada automática para o 193.
>> LUZES DE EMERGÊNCIA acesas! Iluminando rotas de fuga.
```
