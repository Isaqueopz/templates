// PARA ESTUDAR: comece pelo main no final e acompanhe as chamadas.
// As classes acima do main definem os tipos; declarar uma classe nao executa seus metodos.

// Base comum. Nao pode fazer new Processo(); crie uma subclasse concreta.
abstract class Processo {
    // Este e o Template Method. final impede as subclasses de sobrescrever esta sequencia.
    public final void executar() {
        // Primeiro passo: igual para todas as subclasses.
        System.out.println("Inicio comum");
        // Segundo passo: Java chama a implementacao do objeto real (ProcessoA ou ProcessoB).
        etapaEspecifica();
        // Terceiro passo: so acontece depois que a etapa especifica termina.
        System.out.println("Fim comum");
    }

    // Sem corpo: cada subclasse concreta deve implementar. protected permite acesso pelas subclasses.
    protected abstract void etapaEspecifica();
}

// Herda executar() e fornece a etapa da variacao A.
class ProcessoA extends Processo {
    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    protected void etapaEspecifica() {
        System.out.println("Etapa A");
    }
}

// Herda a mesma sequencia, mas fornece outra etapa.
class ProcessoB extends Processo {
    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    protected void etapaEspecifica() {
        System.out.println("Etapa B");
    }
}

public class Main {
    // Ponto de entrada: a execucao do programa comeca aqui.
    public static void main(String[] args) {
        // 1. Variavel do tipo geral Processo aponta para um objeto ProcessoA.
        Processo processo = new ProcessoA();
        // Executa a sequencia herdada: inicio -> etapa do objeto real -> fim.
        processo.executar();

        // 3. A variavel passa a apontar para um novo ProcessoB; o objeto A nao e transformado.
        processo = new ProcessoB();
        // Executa a sequencia herdada: inicio -> etapa do objeto real -> fim.
        processo.executar();
    }
}
