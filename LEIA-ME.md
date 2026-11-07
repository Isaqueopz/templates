# Templates para memorizar

Inclui todos os seis padroes GoF desenvolvidos nas aulas 1 a 8 e um exemplo
adicional de MVC, apresentado na aula 2. Nao e o catalogo inteiro dos 23 GoF.
Os numeros das pastas sao identificadores, nao numeros das aulas.

Cada pasta possui um programa independente. Todos os tipos ficam no mesmo
Main.java para simplificar. Compile e execute dentro da pasta escolhida:

```text
javac Main.java
java Main
```

Nao compile as pastas juntas: elas possuem classes Main com o mesmo nome.
Se separar as classes em arquivos, cada classe public deve ficar em um arquivo
com o mesmo nome (por exemplo, ProdutoA.java).

## 1. Composite

Memorize: interface comum + folha + grupo com lista da interface.

- Componente: operacao comum.
- Folha: realiza a operacao diretamente.
- Grupo: guarda componentes e chama a operacao de cada um.
- Um Grupo tambem e um Componente: por isso cabe dentro de outro Grupo.

Para adaptar: Componente -> ItemMenu; Folha -> Opcao; Grupo -> Menu;
executar -> exibir. A operacao tambem pode retornar valores, como preco ou peso;
nesse caso, adapte a assinatura em todos os participantes e a agregacao no grupo.

## 2. Template Method

Memorize: classe abstrata com sequencia final + etapas abstratas + subclasses.

- executar: Template Method; define a ordem e o comportamento comum.
- etapaEspecifica: cada subclasse fornece sua implementacao.
- final impede sobrescrever o metodo executar.

Para adaptar: Processo -> Missao; ProcessoA -> MissaoCombate;
ProcessoB -> MissaoExploracao; etapaEspecifica -> realizarObjetivo.
Adicione outras etapas abstratas se necessario, como calcularRecompensa().

Hook opcional (somente se o enunciado pedir uma etapa opcional):

```java
// Dentro de Processo:
protected void depois() {} // implementacao padrao vazia
```

Chame depois() dentro de executar(), na posicao desejada. As subclasses podem
sobrescrever depois(), mas nao sao obrigadas.

## 3. Factory Method

Memorize: produto + produtos concretos + criador + criadores concretos.

- Produto: contrato do objeto criado.
- ProdutoA/B: implementacoes desse contrato.
- Criador.criar: Factory Method; retorna a abstracao Produto.
- Criador.executar: usa o produto sem escolher sua classe concreta.
- CriadorA/B: decidem qual produto instanciar.

Para adaptar: Produto -> Missao; ProdutoA -> MissaoCombate;
ProdutoB -> MissaoExploracao; Criador -> CriadorMissao;
CriadorA -> CriadorCombate; usar -> executar.

O new permanece nos criadores concretos. O main escolhe o criador.
Nao substitua os criadores por um unico metodo com if/switch: esse outro formato
e uma fabrica simples, e nao demonstra a estrutura de Factory Method pedida aqui.

## Java essencial

- implements: classe implementa uma interface; seus metodos implementados aqui sao public.
- extends: classe herda de outra classe.
- abstract: classe nao pode ser instanciada; metodo abstrato nao tem corpo.
- @Override: compilador verifica se o metodo sobrescreve/implementa outro.
- protected: nos exemplos, permite que as subclasses implementem as etapas.
- new: cria um objeto concreto.
- super(componente): chama o construtor da superclasse.
- super.executar(): chama a implementacao de executar da superclasse.
- TipoBase objeto = new TipoConcreto(): referencia pela abstracao.

## 4. Strategy (aula 3)

Memorize: interface de algoritmo + implementacoes + contexto que delega.

- Estrategia: contrato do algoritmo.
- EstrategiaA/B: algoritmos alternativos.
- Contexto: guarda uma estrategia e delega a ela a execucao.
- setEstrategia: permite trocar o algoritmo durante a execucao.

Para adaptar: Estrategia -> CalculoFrete; EstrategiaA -> FreteNormal;
EstrategiaB -> FreteExpresso; Contexto -> Pedido. Se o calculo precisar de dados
ou retorno, ajuste executar() em todas as estrategias e no contexto.

Justificativa: encapsula algoritmos intercambiaveis, permitindo trocar o
comportamento sem alterar a classe que os utiliza.

## 5. Observer (aula 4)

Memorize: interface observador + observadores concretos + sujeito com lista.

- Observador: contrato de notificacao.
- ObservadorA/B: reagem a notificacao.
- Sujeito: registra/remove observadores e notifica quando seu estado muda.
- Esta versao envia o estado como parametro (push).

Para adaptar: Sujeito -> Pedido; ObservadorA -> Cliente;
ObservadorB -> Restaurante; estado -> status.

Justificativa: notifica automaticamente varios interessados sem o sujeito
depender das classes concretas dos observadores.

## 6. Decorator (aula 5)

Memorize: interface comum + objeto base + decorador que guarda a interface
+ decoradores concretos que acrescentam comportamento e delegam.

- ComponenteBase: comportamento original.
- Decorador: envolve outro Componente e delega a chamada.
- DecoradorA/B: acrescentam comportamento antes ou depois da delegacao.
- O main pode combinar os decoradores na ordem desejada.

Para adaptar: Componente -> Notificador; ComponenteBase -> Email;
DecoradorA -> Log; DecoradorB -> Monitoramento; executar -> enviar.
Com parametros e retornos, mantenha as assinaturas compativeis em todos os tipos.

Justificativa: combina responsabilidades adicionais por composicao, sem criar
uma subclasse para cada combinacao possivel.

## 7. MVC (aula 2, adicional)

Memorize: modelo cuida dos dados/regras; visao apresenta; controlador coordena.

- Modelo: estado e regra de incrementar.
- Visao: exibicao.
- Controlador: recebe a acao, chama o modelo e atualiza a visao.
- Main: conecta os objetos e simula a entrada do usuario.

Este e um MVC minimo de console com atualizacao explicita pelo controlador.
Para reproduzir a notificacao automatica apresentada na aula, combine com Observer:
o modelo atua como sujeito e a visao se registra como observadora.

Para adaptar: Modelo -> Conta; incrementar -> depositar;
Visao -> TelaConta; Controlador -> ControladorConta.

Justificativa: separa regras de negocio, apresentacao e coordenacao da entrada.

## Como reconhecer e justificar os outros tres

- Composite (aula 6): hierarquia parte-todo; trata folhas e grupos pela mesma
  interface, permitindo grupos dentro de outros grupos.
- Template Method (aula 7): sequencia comum com etapas variaveis; centraliza o
  algoritmo e permite especializar etapas sem alterar sua ordem.
- Factory Method (aula 8): criacao variavel; delega a escolha do produto concreto
  para subclasses, mantendo o uso dependente da abstracao.

## Diferencas para nao confundir

- Strategy troca um algoritmo por composicao; Template Method especializa
  etapas por heranca.
- Decorator envolve um componente para adicionar comportamento; Composite
  agrupa varios componentes em uma arvore.
- Strategy escolhe como fazer; Factory Method especializa qual objeto criar.
- Observer avisa os interessados; Composite executa uma operacao na estrutura.

Os templates sao pontos de partida: atributos, parametros, retornos, validacoes
e regras do enunciado precisam ser acrescentados conforme o problema.

## Template Method junto com Factory Method

Na atividade de missoes, Missao pode ser a classe abstrata com o Template Method
executar(). As missoes concretas herdam dela. CriadorMissao declara um Factory
Method que retorna Missao, e cada criador concreto instancia uma modalidade.
O produto de Factory Method pode ser uma classe abstrata; nao precisa ser interface.
