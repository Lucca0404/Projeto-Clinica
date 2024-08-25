# Projeto-Clinica

## Ponto de Partida ☕
<p>  Já faz mais ou menos 6 meses que comecei a programar e durante todo esse tempo eu estive focando meus estudos na <b>linguagem C </b> 🤖. No entanto, na minha faculdade começamos a ver a matéria de programação orientada a objetos na linguagem Java e isso fez eu pensar: É um ótimo momento para colocar os meus conhecimentos em prática e criar um projeto simples para ver como me saio.
<br>
  Eis então que estou aqui em uma tarde de sábado e decido criar uma clínica médica 🥼(não me pergunte de onde veio essa ideia), eu apenas pensei que seria uma boa maneira de implementar algumas estruturas de dados que eu venho estudando só que dessa vez utilizando da orientação a objeto do Java ao meu favor. A seguir irei descrever quais foram as minhas ideias para a implementação das "mecânicas da clínica", vou tentar explicar de uma maneira que mesmo uma pessoa que nunca estudou estrutura de dados consiga entender 😁.</p>

## Criando a Base 🏣
### Classe Abstrata Pessoa

<p>  A primeira coisa que fiz foi criar uma base para o projeto. Comecei criando uma classe abstrata pessoa que funcionará como uma base para criar outras classes como funcionários e pacientes. Decidi implementar uma classe abstrata em vez de uma interface pois a maioria dos atributos que uma pessoa possui também serão compartilhados entre as sub-classes. Após isso criei alguns atributos comuns como nome, idade e CPF; e também criei um método que valida se um CPF é válido ou não para impedir que um dado falso fosse colocado em uma pessoa.
<br>

### Classe Paciente
  Além disso, criei uma classe Paciente que seria a representação de qualquer cliente da clínica, essa classe teria um atributo de validação para ver se ele é ativo ou não na clínica. Essa classe herda de pessoa, no futuro isso será muito útil pois habilita que eu use polimorfismo nas estruturas de dados que eu irei criar, permitindo que qualquer classe ligada a pessoa seja intânciada pelas estruturas. Por fim, agora nos resta criar as estruturas em si, que vão permitir o funcionamento da clínica.
</p>

## Fila de Pacientes 👩🏻‍🦳

### Filas

<p>  Toda vez que vamos em uma clínica ou em um hospital já sabemos que vamos passar horas esperando para sermos atendidos(por isso nos chamam de pacientes 🤡). Piadas a parte, uma das estruturas mais importantes para o funcionamento da clínica é a fila de espera para ser atendido, algo semelhante a aquelas senhas que pegamos em uma maquininha. Nesse tipo de situação esperamos que as pessoas sejam atendidas na ordem em que elas chegaram, ou seja, a primeira pessoa a chegar no hospital será a primeira a ser chamada.
<br>

### Filas de Prioridade

  Em estruturas de dados quando queremos que o primeiro dado a entrar seja o primeiro a sair nós usamos um tipo espcial de Lista chamado <b>Fila</b>. No entanto, nessa ocasião decidi usar um tipo especial de Fila chamdo <i>Fila de Prioridade</i>. A diferença entre as duas é o fato de que na de prioridade os elementos da fila possuem pesos, e quanto maior o seu peso mais cedo ele será atendido. Optei por usar essa estrutura pois é comum que algumas situações de saúde exigam mais urgênia que outras, então é justo que essas pessoas sejam atendidas mais rápido que as outras. Isso também se aplica a casos de prioridade como idosos ou gestantes.
<br>
  Felizmente, a implementação desse tipo de estrutura é muito simples: primeiro criei uma interface chamada FilaPrioridade, interfaces são como contratos que obrigam que todos que a implementam possuam seus métodos, então é uma ótima maneira de garantir que todas as classes dessa estrutura funcionem de forma coerente. Depois disso tive que criar alguns métodos que retornam importantes como tamanho da fila, método de inserção, remoção e o de consultar o próximo elemento. Detalhe que como utilizei a classe abstrata pessoa nos métodos da fila, isso possibilita que eu criei essa estrutura para qualquer classe que herde de pessoa, assim não limitando apenas a uma fila de pacientes.
<br>
  Após isso está pronto, uma maneira funcional de garantir um atendimento justo para os clientes. A próxima tarefa seria uma maneira de registrar esses pacientes para manter seus dados salvos no sistema da clínica.</p>

## Registro de Pacientes 📖
### Listas e Algoritmos de Busca 🔎

<p>
  Quando penso em um sistema de registro, vem na minha cabeça algo similar a uma lista telefônica. Um lugar cheio de elementos ordenados e de <b>fácil busca</b>(levando em conta que todos os dados estejam ordenados). No entanto, quando falamos de programação temos que lembrar que tudo tem um preço computacional. Buscar um elemento em uma lista não é de graça e dependendo da situação pode se tornar uma operação muito ineficiente. Vamos pensar primeiro em uma lista desordenada, para procurar um elemento teremos que olhar índice por índice até achar o que estamos procurando(isso se acharmos), esse tipo de busca tem complexidade O(N) ou linear, ou seja, cresce proporcionalmente ao número de pacientes registrados.
<br>
  No entanto, existe um tipo de busca que é semelhante a aquela que fazemos em uma lista telefônica ordenada chamada <b>Busca Binária</b>. Esse algoritmo procura o elemento pensando em como ele estará posicionado na lista de acordo com a sua ordem. É como se procurassemos a página 450 de um livro, abrimos ele no meio e se estamos na página 300 nós continuamos passando páginas para a frente e eliminamos todas aquelas que estão anteas da 300, já que evidentemente elas serão menores que 450. Este é o princípio, sempre abrir na metade e eliminar aqueles que temos certeza que não são o elemento. Já que sempre estamos limpando a lista pela metade esse tipo de algoritmo tem complexidade O(logN), sendo bem melhor que a busca linear. 
<br>
  Mas nem tudo são flores, para a busca binária funcionar a lista deve estar ordenada e garantir isso também não é de graça. Ordenar uma lista geralmente é uma tarefa cara de complexidade maior que O(N)(as vezes bem maior), e garantir que os elementos sempre serão inseridos em ordem também não sai barato. Todos esses fatores tornam a lista uma opção viável mas alguns problemas de eficiência. Sendo assim, decidi ir por outro caminho. Não vou usar uma lista para guardar o registro dos pacientes, mas sim outra estrutura muito conhecida e utilizada para situações desse tipo: o <i>HashMap</i>.
</p>

### HashMaps 🗺️

<p>
  Acabamos de ver que tudo na programação tem um custo computacional. Porém existe um tipo de complexidade denominada O(1), isso significa que indendente da entrada de dados essa operação sempre será constante. E como se mesmo que nossa lista tivesse 1000, 10000 ou 1000000 de itens a busca por um elemento demandaria sempre a mesma quantidade de tempo. Parece bom demais para ser verdade né? Mas acredite existe uma estrutura que funciona assim. HashMaps(ou dicionários) são uma abstração de uma lista comum, neles os dados não sõ inseridos em uma ordem específica, no inicio ou no final. Mas sim de acordo com uma chave especial calculada a partir de uma característica do próprio elemento(esse tipo de estrutura sem começo e final bem definido é catálogada como estrutura desordenada). Caso tenha ficado confuso não se preocupe vou explicar passo a passo como eles funcionam. 
<br>
  Basicamente, a primeira coisa que fazemos ao trabalhar com um HashMap é criar uma <i>Função Hash</i>, não se assuste com esse nome, o objetivo dela é simples: caluclar a posição que o elemento terá na estrutura, vamos pensar por exemplo em um CPF, já que cada pessoa possui um só seu, a função hash irá devolver um valor diferente para cada CPF que mandarmos para ela (ou pelo menos em um mundo ideal seria assim), fazendo assim com que para achar um pessoa basta colocar o CPF dela na função e depois pegar o resultado e acessar essa posição. Como a função sempre devolve o mesmo valor para uma determinada entrada(determinística) a localização do item é sempre garantida e praticamente instantânea.
<br>
  Bom já sabemos que nada é perfeito então você já deve estar esperando pelo "mas". Apesar dessa estrutura ser a ideal para buscas, ela possui um problema crónico. Pois mesmo que todas as entradas da função hash sejam diferentes ainda existe a possibilidade dela retornar dois valores iguais, ou seja, duas pessoas diferentes ocupariam a mesma posição. Isso caracteriza uma colisão, um problema comum de HashMaps. Existem várias maneiras de adiá-la mas em determiando momento ela vai acontecer, e quando isso ocorrer devemos estar preparados. Para isso existem os tratamentos de colisão, dois muito conhecidos são o <b>endereçamento aberto</b> e o <b>encadeamento separado</b>. não vou explicar como eles funcionam aqui mas vou dizer qual escolhi e como implementei(se quiser saber mais pesquise sobre tratamento de colisões em HashMaps). No meu caso optei por utilizar o endereçamento aberto por dois motivos: o primeiro é que esse tipo de abordagem não ocupa muita memória em contra-partida com o encadeamento separado, e o segundo é o fato de eu poder utilizar o atributo "ativo" dos pacientes ao meu favor. Basicamente, lembra que eu criei um atributo que diz se aquele paciente ainda está ativo na clínica? ele será de extrema utilidade aqui, pois quando um paciente ficar inativo nós usaremos o espaço que ele ocupava para colocar outro no lugar, e faremos isso usando a famosa <i>Sondagem Linear</i>, um dos métodos mais simples de tratamento de colisões. Ela evita que endereços que já estão ocupados sejam ocupados novamente utilizando uma função linear simples para calcular uma nova posição para o elemento, evitando as colisões(abordagem do endereçamento aberto).
<br>
  Por fim temos o nosso HashMap esquematizado, agora nos resta a implementação. Essa é a parte mais fácil, basta criar o método que será nossa função hash(escolhi o método da divisão), criar um método que calcule um valor baseado no CPF do paciente, um de tamanho, um de inserção, um de busca e um que verifica se o paicente já foi cadastrado. Novamente utilizei a abordagem da interface, mas dessa vez para utilizar o atributo ativo do paciente existem duas possibilidades: ou dar esse atributo para a classe pessoa e manter o polimorfismo(escolhi essa), ou criar um HashMap que seja específico para Pacientes. Após isso, basta criar uma classe que implemente esses métodos que chamei de RegistroDePacientes e fim de papo. Nossa clínica funcional está pronta para ser utilizada ou melhorada.
</p>
