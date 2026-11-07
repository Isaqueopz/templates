// PARA ESTUDAR: comece pelo main no final e acompanhe as chamadas.
// As classes acima do main definem os tipos; declarar uma classe nao executa seus metodos.

// Guarda os dados e as regras. Nao precisa conhecer a Visao nem o Controlador.
class Modelo {
    // Atributo int inicia em zero automaticamente.
    private int valor;

    public void incrementar() {
        // Regra deste exemplo: aumenta o valor em uma unidade.
        valor++;
    }

    public int getValor() {
        // Devolve o valor atual para quem chamou getValor().
        return valor;
    }
}

// Responsavel por apresentar os dados recebidos.
class Visao {
    public void exibir(int valor) {
        System.out.println("Valor: " + valor);
    }
}

// Recebe uma acao e coordena o trabalho do Modelo e da Visao.
class Controlador {
    // Referencia ao objeto que guarda os dados.
    private Modelo modelo;
    // Referencia ao objeto que apresenta os dados.
    private Visao visao;

    // Construtor: recebe os dois colaboradores prontos.
    public Controlador(Modelo modelo, Visao visao) {
        // Guarda o Modelo recebido no atributo do controlador.
        this.modelo = modelo;
        // Guarda a Visao recebida no atributo do controlador.
        this.visao = visao;
    }

    public void incrementar() {
        // Primeiro pede ao Modelo para mudar o dado.
        modelo.incrementar();
        // Depois consulta o valor atualizado e o entrega a Visao para imprimir.
        visao.exibir(modelo.getValor());
    }
}

public class Main {
    // Ponto de entrada: a execucao do programa comeca aqui.
    public static void main(String[] args) {
        // 1. Cria Modelo e Visao; entrega os dois ao novo Controlador.
        Controlador controlador = new Controlador(new Modelo(), new Visao());
        // Recebe a acao -> Modelo soma 1 -> Visao mostra. Primeira chamada: 1; segunda: 2.
        controlador.incrementar();
        // Recebe a acao -> Modelo soma 1 -> Visao mostra. Primeira chamada: 1; segunda: 2.
        controlador.incrementar();
    }
}
