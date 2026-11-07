import java.util.ArrayList;
import java.util.List;

interface Observador {
    void atualizar(String estado);
}

class ObservadorA implements Observador {
    @Override
    public void atualizar(String estado) {
        System.out.println("A recebeu: " + estado);
    }
}

class ObservadorB implements Observador {
    @Override
    public void atualizar(String estado) {
        System.out.println("B recebeu: " + estado);
    }
}

class Sujeito {
    private List<Observador> observadores = new ArrayList<>();
    private String estado;

    public void adicionar(Observador observador) {
        observadores.add(observador);
    }

    public void remover(Observador observador) {
        observadores.remove(observador);
    }

    public void setEstado(String estado) {
        this.estado = estado;
        for (Observador observador : observadores) {
            observador.atualizar(this.estado);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Sujeito sujeito = new Sujeito();
        Observador a = new ObservadorA();
        sujeito.adicionar(a);
        sujeito.adicionar(new ObservadorB());
        sujeito.setEstado("Novo estado");
        sujeito.remover(a);
        sujeito.setEstado("Outro estado");
    }
}
