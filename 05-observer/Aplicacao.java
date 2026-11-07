// CASO: cliente e restaurante recebem avisos de mudanca do pedido.
// Sujeito -> PedidoEntrega; Observador -> InteressadoPedido.
interface InteressadoPedido {
    void atualizar(String status);
}

class Cliente implements InteressadoPedido {
    @Override
    public void atualizar(String status) {
        System.out.println("Cliente recebeu: " + status);
    }
}

class Restaurante implements InteressadoPedido {
    @Override
    public void atualizar(String status) {
        System.out.println("Restaurante recebeu: " + status);
    }
}

class PedidoEntrega {
    private java.util.List<InteressadoPedido> interessados = new java.util.ArrayList<>();
    private String status;

    public void adicionar(InteressadoPedido interessado) {
        interessados.add(interessado);
    }

    public void remover(InteressadoPedido interessado) {
        interessados.remove(interessado);
    }

    public void setStatus(String status) {
        this.status = status;
        // A mudanca dispara avisos para todos que continuam cadastrados.
        for (InteressadoPedido interessado : interessados) {
            interessado.atualizar(this.status);
        }
    }
}

public class Aplicacao {
    public static void main(String[] args) {
        // 1. Cria o pedido e cadastra dois interessados.
        PedidoEntrega pedido = new PedidoEntrega();
        Cliente cliente = new Cliente();
        pedido.adicionar(cliente);
        pedido.adicionar(new Restaurante());

        // 2. setStatus -> percorre lista -> Cliente.atualizar e Restaurante.atualizar.
        pedido.setStatus("Em preparo");
        pedido.setStatus("Saiu para entrega");

        // 3. Remove o cliente: apenas o restaurante recebe o proximo aviso.
        pedido.remover(cliente);
        pedido.setStatus("Entregue");
    }
}
