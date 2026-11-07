abstract class Processo {
    public final void executar() {
        System.out.println("Inicio comum");
        etapaEspecifica();
        System.out.println("Fim comum");
    }

    protected abstract void etapaEspecifica();
}

class ProcessoA extends Processo {
    @Override
    protected void etapaEspecifica() {
        System.out.println("Etapa A");
    }
}

class ProcessoB extends Processo {
    @Override
    protected void etapaEspecifica() {
        System.out.println("Etapa B");
    }
}

public class Main {
    public static void main(String[] args) {
        Processo processo = new ProcessoA();
        processo.executar();

        processo = new ProcessoB();
        processo.executar();
    }
}
