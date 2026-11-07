// CASO: depositar dinheiro em uma conta e mostrar o saldo.
// Modelo -> Conta; Visao -> TelaConta; Controlador -> ControladorConta.
class Conta {
    private double saldo;

    public void depositar(double valor) {
        // A regra pertence ao modelo, independentemente de como ele e exibido.
        if (valor <= 0) {
            throw new IllegalArgumentException("Deposito deve ser positivo");
        }
        saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }
}

class TelaConta {
    public void mostrarSaldo(double saldo) {
        System.out.println("Saldo: " + saldo);
    }
}

class ControladorConta {
    private Conta conta;
    private TelaConta tela;

    public ControladorConta(Conta conta, TelaConta tela) {
        this.conta = conta;
        this.tela = tela;
    }

    public void depositar(double valor) {
        // 3. Encaminha a operacao para quem conhece as regras.
        conta.depositar(valor);
        // 4. Le o resultado e solicita sua exibicao.
        tela.mostrarSaldo(conta.getSaldo());
    }
}

public class Aplicacao {
    public static void main(String[] args) {
        // 1. Conecta modelo, visao e controlador.
        ControladorConta controlador = new ControladorConta(new Conta(), new TelaConta());
        // 2. Simula uma acao do usuario. Fluxo: controlador -> conta -> tela.
        controlador.depositar(100); // Exibe 100.
        controlador.depositar(50);  // Exibe 150.
    }
}
