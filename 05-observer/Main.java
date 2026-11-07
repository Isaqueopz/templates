// PARA ESTUDAR: comece pelo main no final e acompanhe as chamadas.
// As classes acima do main definem os tipos; declarar uma classe nao executa seus metodos.

import java.util.ArrayList;
import java.util.List;

// Contrato de quem deseja receber notificacoes.
interface Observador {
    // O sujeito envia o estado como parametro quando avisa o observador.
    void atualizar(String estado);
}

// Um interessado: define sua propria reacao ao aviso.
class ObservadorA implements Observador {
    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public void atualizar(String estado) {
        System.out.println("A recebeu: " + estado);
    }
}

// Outro interessado: recebe o mesmo aviso e pode reagir de outra forma.
class ObservadorB implements Observador {
    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public void atualizar(String estado) {
        System.out.println("B recebeu: " + estado);
    }
}

// Objeto observado: guarda seu estado e os interessados cadastrados.
class Sujeito {
    // Lista inicialmente vazia. Guarda qualquer implementacao de Observador.
    private List<Observador> observadores = new ArrayList<>();
    // Estado atual do sujeito.
    private String estado;

    public void adicionar(Observador observador) {
        // Cadastra para os proximos avisos; nao notifica neste momento.
        observadores.add(observador);
    }

    public void remover(Observador observador) {
        // Retira da lista; nao recebera os proximos avisos.
        observadores.remove(observador);
    }

    // Mudar o estado tambem dispara as notificacoes neste exemplo.
    public void setEstado(String estado) {
        // Atualiza o atributo antes de avisar os interessados.
        this.estado = estado;
        // Visita cada observador ainda cadastrado.
        for (Observador observador : observadores) {
            // Chama a reacao do observador real, enviando o novo estado.
            observador.atualizar(this.estado);
        }
    }
}

public class Main {
    // Ponto de entrada: a execucao do programa comeca aqui.
    public static void main(String[] args) {
        // 1. Cria o objeto que sera observado.
        Sujeito sujeito = new Sujeito();
        // 2. Guarda A em uma variavel para poder remove-lo depois.
        Observador a = new ObservadorA();
        // 3. Cadastra A.
        sujeito.adicionar(a);
        // 4. Cria e cadastra B.
        sujeito.adicionar(new ObservadorB());
        // 5. Atualiza o estado: A e B imprimem uma mensagem cada.
        sujeito.setEstado("Novo estado");
        // 6. Remove somente A.
        sujeito.remover(a);
        // 7. Atualiza novamente: agora somente B recebe o aviso.
        sujeito.setEstado("Outro estado");
    }
}
