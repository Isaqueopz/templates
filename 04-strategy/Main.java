// PARA ESTUDAR: comece pelo main no final e acompanhe as chamadas.
// As classes acima do main definem os tipos; declarar uma classe nao executa seus metodos.

// Contrato comum das maneiras possiveis de realizar uma tarefa.
interface Estrategia {
    void executar();
}

// Uma maneira de realizar a tarefa.
class EstrategiaA implements Estrategia {
    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public void executar() {
        System.out.println("Algoritmo A");
    }
}

// Outra maneira de realizar a mesma tarefa.
class EstrategiaB implements Estrategia {
    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public void executar() {
        System.out.println("Algoritmo B");
    }
}

// Objeto que precisa da tarefa. Ele delega o trabalho para a estrategia escolhida.
class Contexto {
    // Guarda uma estrategia pela interface; pode receber A ou B.
    private Estrategia estrategia;

    // Construtor: recebe a estrategia inicial ao criar o Contexto.
    public Contexto(Estrategia estrategia) {
        // this.estrategia e o atributo do objeto; estrategia e o parametro recebido.
        this.estrategia = estrategia;
    }

    // Permite substituir a estrategia sem recriar o Contexto.
    public void setEstrategia(Estrategia estrategia) {
        // this.estrategia e o atributo do objeto; estrategia e o parametro recebido.
        this.estrategia = estrategia;
    }

    public void executar() {
        // Delega: quem trabalha e o objeto guardado no atributo estrategia.
        estrategia.executar();
    }
}

public class Main {
    // Ponto de entrada: a execucao do programa comeca aqui.
    public static void main(String[] args) {
        // 1. Cria A; depois cria o Contexto e entrega A ao construtor.
        Contexto contexto = new Contexto(new EstrategiaA());
        // Chama Contexto.executar(), que chama executar() da estrategia atual.
        contexto.executar();
        // 3. O mesmo contexto passa a usar B. A proxima chamada imprime Algoritmo B.
        contexto.setEstrategia(new EstrategiaB());
        // Chama Contexto.executar(), que chama executar() da estrategia atual.
        contexto.executar();
    }
}
