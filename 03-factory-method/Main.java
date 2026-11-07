// PARA ESTUDAR: comece pelo main no final e acompanhe as chamadas.
// As classes acima do main definem os tipos; declarar uma classe nao executa seus metodos.

// Contrato de tudo que os criadores podem fabricar.
interface Produto {
    void usar();
}

// Primeiro tipo concreto de produto.
class ProdutoA implements Produto {
    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public void usar() {
        System.out.println("Usando produto A");
    }
}

// Segundo tipo concreto de produto.
class ProdutoB implements Produto {
    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public void usar() {
        System.out.println("Usando produto B");
    }
}

// Classe base que sabe usar um produto, mas deixa a criacao para as subclasses.
abstract class Criador {
    // Factory Method: promete retornar um Produto. A subclasse decide qual.
    public abstract Produto criar();

    public void executar() {
        // Chama criar() do criador real (A ou B) e guarda o produto retornado.
        Produto produto = criar();
        // Usa o produto recebido. Nao precisa testar se e ProdutoA ou ProdutoB.
        produto.usar();
    }
}

// Herda executar() e escolhe fabricar ProdutoA.
class CriadorA extends Criador {
    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public Produto criar() {
        // Cria o objeto A e o devolve para quem chamou criar().
        return new ProdutoA();
    }
}

// Herda executar() e escolhe fabricar ProdutoB.
class CriadorB extends Criador {
    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public Produto criar() {
        // Cria o objeto B e o devolve pela interface Produto.
        return new ProdutoB();
    }
}

public class Main {
    // Ponto de entrada: a execucao do programa comeca aqui.
    public static void main(String[] args) {
        // 1. Escolhe a fabrica A. Ainda nao criou o produto.
        Criador criador = new CriadorA();
        // Executar herdado -> criar() da fabrica real -> usar() do produto retornado.
        criador.executar();

        // 3. Troca a referencia para uma fabrica B. A proxima execucao cria e usa ProdutoB.
        criador = new CriadorB();
        // Executar herdado -> criar() da fabrica real -> usar() do produto retornado.
        criador.executar();
    }
}
