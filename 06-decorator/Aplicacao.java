// CASO: calcular a descricao e o preco de um sorvete com adicionais.
// Componente -> Sorvete; ComponenteBase -> SorveteSimples;
// Decorador -> Adicional; DecoradorA/B -> Cobertura/Granulado.
interface Sorvete {
    String descricao();
    double preco();
}

class SorveteSimples implements Sorvete {
    @Override
    public String descricao() {
        return "Sorvete";
    }

    @Override
    public double preco() {
        return 5;
    }
}

abstract class Adicional implements Sorvete {
    protected Sorvete sorvete;

    public Adicional(Sorvete sorvete) {
        this.sorvete = sorvete;
    }

    @Override
    public String descricao() {
        return sorvete.descricao();
    }

    @Override
    public double preco() {
        return sorvete.preco();
    }
}

class Cobertura extends Adicional {
    public Cobertura(Sorvete sorvete) {
        super(sorvete); // Guarda o objeto que esta camada envolve.
    }

    @Override
    public String descricao() {
        return super.descricao() + " + cobertura";
    }

    @Override
    public double preco() {
        return super.preco() + 2;
    }
}

class Granulado extends Adicional {
    public Granulado(Sorvete sorvete) {
        super(sorvete);
    }

    @Override
    public String descricao() {
        return super.descricao() + " + granulado";
    }

    @Override
    public double preco() {
        return super.preco() + 1;
    }
}

public class Aplicacao {
    public static void main(String[] args) {
        // 1. Objeto original: custa 5.
        Sorvete pedido = new SorveteSimples();
        // 2. Cobertura envolve o original e acrescenta 2.
        pedido = new Cobertura(pedido);
        // 3. Granulado envolve a cobertura e acrescenta 1.
        pedido = new Granulado(pedido);

        // 4. Chamadas entram de fora para dentro e os resultados voltam somados:
        // Granulado -> Cobertura -> SorveteSimples -> 5 + 2 + 1 = 8.
        System.out.println(pedido.descricao());
        System.out.println("Preco: " + pedido.preco());
    }
}
