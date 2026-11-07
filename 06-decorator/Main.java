// PARA ESTUDAR: comece pelo main no final e acompanhe as chamadas.
// As classes acima do main definem os tipos; declarar uma classe nao executa seus metodos.

// Contrato comum do objeto original e das camadas extras.
interface Componente {
    void executar();
}

// Objeto original: executa a funcionalidade sem adicionais.
class ComponenteBase implements Componente {
    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public void executar() {
        System.out.println("Comportamento original");
    }
}

// Base das camadas. Tambem e Componente, por isso uma camada pode envolver outra.
abstract class Decorador implements Componente {
    // Guarda o objeto envolvido: pode ser o original ou outro decorador.
    protected Componente componente;

    // Construtor que recebe o objeto que esta camada vai envolver.
    public Decorador(Componente componente) {
        // Guarda a referencia recebida; nao executa nada ainda.
        this.componente = componente;
    }

    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public void executar() {
        // 4. Entra em B -> entra em A -> imprime Extra A -> Base imprime original -> volta a B e imprime Extra B.
        componente.executar();
    }
}

// Camada que acrescenta uma mensagem ANTES do objeto envolvido.
class DecoradorA extends Decorador {
    public DecoradorA(Componente componente) {
        // Chama o construtor de Decorador para guardar o objeto envolvido.
        super(componente);
    }

    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public void executar() {
        System.out.println("Extra A antes");
        // Chama Decorador.executar(), que chama executar() no objeto envolvido.
        super.executar();
    }
}

// Camada que acrescenta uma mensagem DEPOIS do objeto envolvido.
class DecoradorB extends Decorador {
    public DecoradorB(Componente componente) {
        // Chama o construtor de Decorador para guardar o objeto envolvido.
        super(componente);
    }

    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public void executar() {
        // Chama Decorador.executar(), que chama executar() no objeto envolvido.
        super.executar();
        System.out.println("Extra B depois");
    }
}

public class Main {
    // Ponto de entrada: a execucao do programa comeca aqui.
    public static void main(String[] args) {
        // 1. Cria o objeto original.
        Componente componente = new ComponenteBase();
        // 2. Cria A envolvendo o objeto original: A -> Base.
        componente = new DecoradorA(componente);
        // 3. Cria B envolvendo A: B -> A -> Base. Os objetos anteriores continuam conectados.
        componente = new DecoradorB(componente);
        // 4. Entra em B -> entra em A -> imprime Extra A -> Base imprime original -> volta a B e imprime Extra B.
        componente.executar();
    }
}
