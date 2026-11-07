// CASO: trocar a regra de calculo do frete de um pedido.
// Estrategia -> CalculoFrete; Contexto -> PedidoCompra.
interface CalculoFrete {
    double calcular(double peso);
}

class FreteNormal implements CalculoFrete {
    @Override
    public double calcular(double peso) {
        return peso * 5;
    }
}

class FreteExpresso implements CalculoFrete {
    @Override
    public double calcular(double peso) {
        return peso * 10;
    }
}

class PedidoCompra {
    private CalculoFrete frete;

    public PedidoCompra(CalculoFrete frete) {
        this.frete = frete;
    }

    public void setFrete(CalculoFrete frete) {
        this.frete = frete;
    }

    public double calcularFrete(double peso) {
        // Delega o calculo ao objeto atualmente guardado em frete.
        return frete.calcular(peso);
    }
}

public class Aplicacao {
    public static void main(String[] args) {
        // 1. Cria o pedido com a estrategia normal.
        PedidoCompra pedido = new PedidoCompra(new FreteNormal());
        // 2. Pedido -> FreteNormal.calcular(2) -> retorna 10.
        System.out.println("Normal: " + pedido.calcularFrete(2));

        // 3. Troca somente a estrategia, mantendo o mesmo pedido.
        pedido.setFrete(new FreteExpresso());
        // 4. Pedido -> FreteExpresso.calcular(2) -> retorna 20.
        System.out.println("Expresso: " + pedido.calcularFrete(2));
    }
}
