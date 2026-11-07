// PARA ESTUDAR: comece pelo main no final e acompanhe as chamadas.
// As classes acima do main definem os tipos; declarar uma classe nao executa seus metodos.

import java.util.ArrayList;
import java.util.List;

// Contrato comum: tanto uma Folha quanto um Grupo podem executar().
interface Componente {
    void executar();
}

// Elemento simples: faz seu trabalho diretamente e nao guarda filhos.
class Folha implements Componente {
    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public void executar() {
        System.out.println("Executando folha");
    }
}

// Elemento composto: tambem e um Componente, mas guarda outros componentes.
class Grupo implements Componente {
    // Lista vazia. Aceita Folha e Grupo porque ambos implementam Componente.
    private List<Componente> filhos = new ArrayList<>();

    // Recebe um objeto pela interface: pode ser folha ou grupo.
    public void adicionar(Componente componente) {
        // Guarda a referencia na lista; ainda nao executa o objeto.
        filhos.add(componente);
    }

    // Verifica que este metodo implementa ou sobrescreve um metodo do tipo base.
    @Override
    public void executar() {
        // Percorre os filhos na ordem em que foram adicionados.
        for (Componente filho : filhos) {
            // Se for Folha, imprime. Se for Grupo, percorre os filhos dele (recursao).
            filho.executar();
        }
    }
}

public class Main {
    // Ponto de entrada: a execucao do programa comeca aqui.
    public static void main(String[] args) {
        // 1. Cria um grupo menor, inicialmente vazio.
        Grupo subgrupo = new Grupo();
        // 2. Cria uma folha e a coloca no grupo menor.
        subgrupo.adicionar(new Folha());

        // 3. Cria o grupo principal.
        Grupo grupo = new Grupo();
        // 4. Adiciona uma folha diretamente ao grupo principal.
        grupo.adicionar(new Folha());
        // 5. Adiciona o grupo menor: grupo principal = [folha, subgrupo[folha]].
        grupo.adicionar(subgrupo);
        // 6. Executa a primeira folha e depois o subgrupo, que executa sua folha. Imprime duas vezes.
        grupo.executar();
    }
}
