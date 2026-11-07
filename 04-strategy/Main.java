interface Estrategia {
    void executar();
}

class EstrategiaA implements Estrategia {
    @Override
    public void executar() {
        System.out.println("Algoritmo A");
    }
}

class EstrategiaB implements Estrategia {
    @Override
    public void executar() {
        System.out.println("Algoritmo B");
    }
}

class Contexto {
    private Estrategia estrategia;

    public Contexto(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public void executar() {
        estrategia.executar();
    }
}

public class Main {
    public static void main(String[] args) {
        Contexto contexto = new Contexto(new EstrategiaA());
        contexto.executar();
        contexto.setEstrategia(new EstrategiaB());
        contexto.executar();
    }
}
