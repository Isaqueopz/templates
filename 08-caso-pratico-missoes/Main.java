// CASO PRATICO: Template Method + Factory Method juntos.
// Comece a leitura pelo main no final deste arquivo.

// PRODUTO do Factory Method e classe base do Template Method.
abstract class Missao {
    // TEMPLATE METHOD: todas as missoes seguem esta mesma ordem.
    // final impede que uma subclasse sobrescreva a sequencia inteira.
    public final void executar() {
        System.out.println("Preparando missao...");
        System.out.println("Verificando equipamentos...");

        // Java chama os metodos da missao concreta criada pela fabrica.
        realizarObjetivo();
        int recompensa = calcularRecompensa();

        System.out.println("Recompensa: " + recompensa);
        System.out.println("Missao finalizada!");
    }

    // Cada missao concreta e obrigada a fornecer estas duas etapas.
    protected abstract void realizarObjetivo();
    protected abstract int calcularRecompensa();
}

// PRODUTO CONCRETO: herda a sequencia e implementa somente o que muda.
class MissaoCombate extends Missao {
    @Override
    protected void realizarObjetivo() {
        System.out.println("Enfrentando inimigo!");
    }

    @Override
    protected int calcularRecompensa() {
        return 100;
    }
}

class MissaoExploracao extends Missao {
    @Override
    protected void realizarObjetivo() {
        System.out.println("Explorando regiao desconhecida!");
    }

    @Override
    protected int calcularRecompensa() {
        return 50;
    }
}

// Nova modalidade: nao exige mudar o algoritmo de Missao.executar().
class MissaoResgate extends Missao {
    @Override
    protected void realizarObjetivo() {
        System.out.println("Resgatando personagem!");
    }

    @Override
    protected int calcularRecompensa() {
        return 150;
    }
}

// CRIADOR: sabe iniciar uma missao, mas delega a escolha do tipo a subclasse.
abstract class CriadorMissao {
    // FACTORY METHOD: retorna a abstracao Missao.
    public abstract Missao criarMissao();

    public void iniciarMissao() {
        // 3. Chama criarMissao() do criador concreto escolhido no main.
        Missao missao = criarMissao();
        // 5. Recebe a missao criada e chama o Template Method.
        // A sequencia e comum; objetivo e recompensa dependem da missao real.
        missao.executar();
    }
}

// CRIADORES CONCRETOS: cada um sabe instanciar uma modalidade.
class CriadorCombate extends CriadorMissao {
    @Override
    public Missao criarMissao() {
        // 4. Cria o produto concreto e retorna para iniciarMissao().
        return new MissaoCombate();
    }
}

class CriadorExploracao extends CriadorMissao {
    @Override
    public Missao criarMissao() {
        return new MissaoExploracao();
    }
}

class CriadorResgate extends CriadorMissao {
    @Override
    public Missao criarMissao() {
        return new MissaoResgate();
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. Escolhe o criador. Neste ponto ainda nao existe uma MissaoCombate.
        CriadorMissao criador = new CriadorCombate();
        // 2. Entra em iniciarMissao(), herdado de CriadorMissao.
        criador.iniciarMissao();

        System.out.println();

        // 6. Repete o fluxo, agora criando uma missao de exploracao.
        criador = new CriadorExploracao();
        criador.iniciarMissao();

        System.out.println();

        // 7. A modalidade nova utiliza exatamente o mesmo fluxo.
        criador = new CriadorResgate();
        criador.iniciarMissao();
    }
}
