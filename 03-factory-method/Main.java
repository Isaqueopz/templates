interface Produto {
    void usar();
}

class ProdutoA implements Produto {
    @Override
    public void usar() {
        System.out.println("Usando produto A");
    }
}

class ProdutoB implements Produto {
    @Override
    public void usar() {
        System.out.println("Usando produto B");
    }
}

abstract class Criador {
    public abstract Produto criar();

    public void executar() {
        Produto produto = criar();
        produto.usar();
    }
}

class CriadorA extends Criador {
    @Override
    public Produto criar() {
        return new ProdutoA();
    }
}

class CriadorB extends Criador {
    @Override
    public Produto criar() {
        return new ProdutoB();
    }
}

public class Main {
    public static void main(String[] args) {
        Criador criador = new CriadorA();
        criador.executar();

        criador = new CriadorB();
        criador.executar();
    }
}
