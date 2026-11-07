# Aplicacoes concretas ao lado de cada template

Em cada pasta de 01 a 07:

- Main.java: estrutura generica comentada para memorizar.
- Aplicacao.java: caso concreto comentado para entender o uso.

Os comentarios iniciais de Aplicacao.java mostram quais nomes do template
foram substituidos. Comece pelo main e acompanhe as chamadas.

| Pasta | Caso | Resultado principal |
| --- | --- | --- |
| 01-composite | Compra com produtos e caixas dentro de caixas | 50 + (10 + 20) = 80 |
| 02-template-method | Preparo de cafe e cha | Mesma receita, etapas especificas diferentes |
| 03-factory-method | Criacao de monstros e robos | Cada criador fabrica um inimigo diferente |
| 04-strategy | Calculo de frete normal e expresso | Peso 2: normal 10, expresso 20 |
| 05-observer | Atualizacoes de pedido | Interessados cadastrados recebem os avisos |
| 06-decorator | Sorvete com cobertura e granulado | 5 + 2 + 1 = 8 |
| 07-mvc | Depositos em conta | Depositar 100 e 50 mostra saldos 100 e 150 |

Dentro da pasta escolhida, execute:

```text
javac -encoding UTF-8 Aplicacao.java
java Aplicacao
```

Para executar o template generico, use Main.java e java Main.
Os dois arquivos de uma mesma pasta podem ser compilados juntos, pois os tipos
da aplicacao possuem nomes diferentes dos tipos do template.
Mantenha cada pasta como um programa independente: outras pastas repetem Main
e Aplicacao. No IntelliJ, abra somente a pasta do padrao que deseja estudar,
como na imagem, e execute o main de Aplicacao.java.

A pasta 08-caso-pratico-missoes continua sendo um exemplo adicional que combina
Template Method e Factory Method.

Precos e saldos usam double apenas para simplificar o estudo dos padroes.
