class Modelo {
    private int valor;

    public void incrementar() {
        valor++;
    }

    public int getValor() {
        return valor;
    }
}

class Visao {
    public void exibir(int valor) {
        System.out.println("Valor: " + valor);
    }
}

class Controlador {
    private Modelo modelo;
    private Visao visao;

    public Controlador(Modelo modelo, Visao visao) {
        this.modelo = modelo;
        this.visao = visao;
    }

    public void incrementar() {
        modelo.incrementar();
        visao.exibir(modelo.getValor());
    }
}

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador(new Modelo(), new Visao());
        controlador.incrementar();
        controlador.incrementar();
    }
}
