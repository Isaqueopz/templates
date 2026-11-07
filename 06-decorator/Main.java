interface Componente {
    void executar();
}

class ComponenteBase implements Componente {
    @Override
    public void executar() {
        System.out.println("Comportamento original");
    }
}

abstract class Decorador implements Componente {
    protected Componente componente;

    public Decorador(Componente componente) {
        this.componente = componente;
    }

    @Override
    public void executar() {
        componente.executar();
    }
}

class DecoradorA extends Decorador {
    public DecoradorA(Componente componente) {
        super(componente);
    }

    @Override
    public void executar() {
        System.out.println("Extra A antes");
        super.executar();
    }
}

class DecoradorB extends Decorador {
    public DecoradorB(Componente componente) {
        super(componente);
    }

    @Override
    public void executar() {
        super.executar();
        System.out.println("Extra B depois");
    }
}

public class Main {
    public static void main(String[] args) {
        Componente componente = new ComponenteBase();
        componente = new DecoradorA(componente);
        componente = new DecoradorB(componente);
        componente.executar();
    }
}
