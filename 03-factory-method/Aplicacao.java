// CASO: criar inimigos de tipos diferentes para um jogo.
// Produto -> Inimigo; Criador -> CriadorInimigo.
interface Inimigo {
    void atacar();
}

class Monstro implements Inimigo {
    @Override
    public void atacar() {
        System.out.println("Monstro ataca com garras!");
    }
}

class Robo implements Inimigo {
    @Override
    public void atacar() {
        System.out.println("Robo dispara laser!");
    }
}

abstract class CriadorInimigo {
    // Factory Method: a subclasse escolhe o inimigo concreto.
    public abstract Inimigo criarInimigo();

    public void iniciarCombate() {
        // 3. Chama o metodo de criacao da fabrica real.
        Inimigo inimigo = criarInimigo();
        // 4. Usa o resultado pela interface, sem testar seu tipo.
        inimigo.atacar();
    }
}

class CriadorMonstro extends CriadorInimigo {
    @Override
    public Inimigo criarInimigo() {
        return new Monstro();
    }
}

class CriadorRobo extends CriadorInimigo {
    @Override
    public Inimigo criarInimigo() {
        return new Robo();
    }
}

public class Aplicacao {
    public static void main(String[] args) {
        // 1. Escolhe quem vai fabricar o inimigo.
        CriadorInimigo criador = new CriadorMonstro();
        // 2. Entra na logica comum: criar -> atacar. Imprime o ataque do monstro.
        criador.iniciarCombate();

        // 5. Outra fabrica, mesmo fluxo: agora cria um robo e dispara laser.
        criador = new CriadorRobo();
        criador.iniciarCombate();
    }
}
