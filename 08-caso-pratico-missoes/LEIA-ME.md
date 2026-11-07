# Caso pratico resolvido: sistema de missoes

Implementacao baseada na atividade de refatoracao fornecida pela professora.
Nao e uma previsao do enunciado da prova. O exemplo usa saida de console e
mantem todas as classes no mesmo arquivo para facilitar o estudo.

## O problema

Um jogo oferece missoes de Combate, Exploracao e Resgate. Todas precisam:

1. Preparar a missao.
2. Verificar equipamentos.
3. Realizar o objetivo especifico.
4. Calcular e mostrar a recompensa.
5. Finalizar a missao.

Combate enfrenta um inimigo e recebe 100 pontos. Exploracao explora uma regiao
e recebe 50 pontos. Resgate resgata um personagem e recebe 150 pontos.

A sequencia deve ser compartilhada, e a criacao deve usar criadores concretos,
sem um if/switch central que instancie todas as modalidades.

## Onde estao os padroes

**Template Method:** Missao.executar() define a sequencia. MissaoCombate,
MissaoExploracao e MissaoResgate implementam realizarObjetivo() e
calcularRecompensa(). Assim, o fluxo comum nao fica duplicado.

**Factory Method:** CriadorMissao declara criarMissao(), que retorna Missao.
CriadorCombate, CriadorExploracao e CriadorResgate sobrescrevem esse metodo
para instanciar seus produtos. iniciarMissao() trabalha com a abstracao Missao.

Missao tem dois papeis: classe base do Template Method e produto do Factory
Method. O produto pode ser uma classe abstrata; nao precisa ser uma interface.

## Fluxo de uma execucao

```text
main escolhe new CriadorCombate()
  -> chama iniciarMissao() de CriadorMissao
     -> chama criarMissao() de CriadorCombate
        -> cria e retorna new MissaoCombate()
     -> chama executar() de Missao no objeto recebido
        -> imprime a preparacao comum
        -> imprime a verificacao comum
        -> chama realizarObjetivo() de MissaoCombate
        -> chama calcularRecompensa() de MissaoCombate, que retorna 100
        -> imprime a recompensa e a finalizacao comuns
```

O mesmo acontece com os outros criadores. O tipo real do objeto determina qual
implementacao dos metodos sobrescritos sera executada.

## Relacoes entre as classes

```text
Missao (abstrata)
  <- MissaoCombate
  <- MissaoExploracao
  <- MissaoResgate

CriadorMissao (abstrato; usa e retorna Missao)
  <- CriadorCombate      -> cria MissaoCombate
  <- CriadorExploracao   -> cria MissaoExploracao
  <- CriadorResgate      -> cria MissaoResgate

<- significa: a classe abaixo herda da classe acima.
```

## Como executar

Abra o terminal nesta pasta:

```text
javac -encoding UTF-8 Main.java
java Main
```

Compile esta pasta separadamente dos outros templates: todos possuem Main.

## Saida esperada

```text
Preparando missao...
Verificando equipamentos...
Enfrentando inimigo!
Recompensa: 100
Missao finalizada!

Preparando missao...
Verificando equipamentos...
Explorando regiao desconhecida!
Recompensa: 50
Missao finalizada!

Preparando missao...
Verificando equipamentos...
Resgatando personagem!
Recompensa: 150
Missao finalizada!
```

## Como adaptar na prova

Para uma nova modalidade, crie uma subclasse de Missao e um criador concreto.
Depois escolha o novo criador no main. Missao.executar() e
CriadorMissao.iniciarMissao() continuam servindo para a nova modalidade.

Justificativa curta: Template Method centraliza a sequencia comum e permite
variar etapas por heranca. Factory Method delega a escolha do tipo concreto
para os criadores, mantendo a logica de inicio dependente da abstracao Missao.
