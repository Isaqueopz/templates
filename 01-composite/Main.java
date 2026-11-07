import java.util.ArrayList;
import java.util.List;

interface Componente {
    void executar();
}

class Folha implements Componente {
    @Override
    public void executar() {
        System.out.println("Executando folha");
    }
}

class Grupo implements Componente {
    private List<Componente> filhos = new ArrayList<>();

    public void adicionar(Componente componente) {
        filhos.add(componente);
    }

    @Override
    public void executar() {
        for (Componente filho : filhos) {
            filho.executar();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Grupo subgrupo = new Grupo();
        subgrupo.adicionar(new Folha());

        Grupo grupo = new Grupo();
        grupo.adicionar(new Folha());
        grupo.adicionar(subgrupo);
        grupo.executar();
    }
}
