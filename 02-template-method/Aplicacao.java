// CASO: preparar cafe e cha seguindo uma mesma receita.
// Correspondencia: Processo -> Bebida; ProcessoA/B -> Cafe/Cha.
abstract class Bebida {
    // Template Method: a ordem fica aqui, em um unico lugar.
    public final void preparar() {
        System.out.println("Fervendo agua");
        prepararIngrediente();
        System.out.println("Colocando no copo");
        adicionarComplemento();
    }

    protected abstract void prepararIngrediente();
    protected abstract void adicionarComplemento();
}

class Cafe extends Bebida {
    @Override
    protected void prepararIngrediente() {
        System.out.println("Coando cafe");
    }

    @Override
    protected void adicionarComplemento() {
        System.out.println("Adicionando leite");
    }
}

class Cha extends Bebida {
    @Override
    protected void prepararIngrediente() {
        System.out.println("Colocando saquinho de cha");
    }

    @Override
    protected void adicionarComplemento() {
        System.out.println("Adicionando limao");
    }
}

public class Aplicacao {
    public static void main(String[] args) {
        // 1. Cria o cafe e entra na receita herdada de Bebida.
        Bebida bebida = new Cafe();
        // 2. Agua -> ingrediente de Cafe -> copo -> complemento de Cafe.
        bebida.preparar();

        System.out.println();
        // 3. A mesma receita agora chama as etapas implementadas por Cha.
        bebida = new Cha();
        bebida.preparar();
    }
}
