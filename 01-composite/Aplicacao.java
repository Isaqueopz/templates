// CASO: calcular o preco de uma compra com produtos e caixas dentro de caixas.
// Correspondencia: Componente -> ItemCompra; Folha -> ProdutoLoja; Grupo -> Caixa.
interface ItemCompra {
    double calcularPreco();
}

// Folha: sabe seu proprio preco e nao possui filhos.
class ProdutoLoja implements ItemCompra {
    private double preco;

    public ProdutoLoja(double preco) {
        this.preco = preco;
    }

    @Override
    public double calcularPreco() {
        return preco;
    }
}

// Composto: aceita produtos ou outras caixas pela mesma interface.
class Caixa implements ItemCompra {
    private java.util.List<ItemCompra> itens = new java.util.ArrayList<>();

    public void adicionar(ItemCompra item) {
        itens.add(item);
    }

    @Override
    public double calcularPreco() {
        double total = 0;
        for (ItemCompra item : itens) {
            // Produto devolve seu preco; caixa calcula o total dos proprios filhos.
            total += item.calcularPreco();
        }
        return total;
    }
}

public class Aplicacao {
    public static void main(String[] args) {
        // 1. Monta a caixa menor: 10 + 20 = 30.
        Caixa caixaMenor = new Caixa();
        caixaMenor.adicionar(new ProdutoLoja(10));
        caixaMenor.adicionar(new ProdutoLoja(20));

        // 2. A caixa principal recebe um produto de 50 e a caixa menor.
        Caixa compra = new Caixa();
        compra.adicionar(new ProdutoLoja(50));
        compra.adicionar(caixaMenor);

        // 3. A chamada percorre a arvore: 50 + (10 + 20) = 80.
        System.out.println("Total: " + compra.calcularPreco());
    }
}
