# Projeto-Clinica

## Ponto de Partida ☕
<p>  Já faz mais ou menos 6 meses que comecei a programar e durante todo esse tempo eu estive focando meus estudos na <b>linguagem C </b> 🤖. No entanto, na minha faculdade começamos a ver a matéria de programação orientada a objetos na linguagem Java e isso fez eu pensar: É um ótimo momento para colocar os meus conhecimentos em prática e criar um projeto simples para ver como me saio.
<br>
  Eis então que estou aqui em uma tarde de sábado e decido criar uma clínica médica 🥼(não me pergunte de onde veio essa ideia), eu apenas pensei que seria uma boa maneira de implementar algumas estruturas de dados que eu venho estudando só que dessa vez utilizando da orientação a objeto do Java ao meu favor. A seguir irei descrever quais foram as minhas ideias para a implementação das "mecânicas da clínica", vou tentar explicar de uma maneira que mesmo uma pessoa que nunca estudou estrutura de dados consiga entender 😁.</p>

## Criando a Base 🏣

<p>  A primeira coisa que fiz foi criar uma base para o projeto. Comecei criando uma classe abstrata pessoa que funcionará como uma base para criar outras classes como funcionários e pacientes. Decidi implementar uma classe abstrata em vez de uma interface pois a maioria dos atributos que uma pessoa possui também serão compartilhados entre as sub-classes. Após isso criei alguns atributos comuns como nome, idade e CPF; e também criei um método que valida se um CPF é válido ou não para impedir que um dado falso fosse colocado em uma pessoa.
<br>
  Além disso, criei uma classe Paciente que seria a representação de qualquer cliente da clínica, essa classe teria um atributo de validação para ver se ele é ativo ou não na clínica. Essa classe herda de pessoa, no futuro isso será muito útil pois habilita que eu use polimorfismo nas estruturas de dados que eu irei criar, permitindo que qualquer classe ligada a pessoa seja intânciada pelas estruturas. Por fim, agora nos resta criar as estruturas em si, que vão permitir o funcionamento da clínica.
</p>

## Fila de Pacientes 👩🏻‍🦳

<p>  Toda vez que vamos em uma clínica ou em um hospital já sabemos que vamos passar horas esperando para sermos atendidos(por isso nos chamam de pacientes 🤡). Piadas a parte, uma das estruturas mais importantes para o funcionamento da clínica é a fila de espera para ser atendido, algo semelhante a aquelas senhas que pegamos em uma maquininha. Nesse tipo de situação esperamos que as pessoas sejam atendidas na ordem em que elas chegaram, ou seja, a primeira pessoa a chegar no hospital será a primeira a ser chamada.
<br>
  Em estruturas de dados quando queremos que o primeiro dado a entrar seja o primeiro a sair nós usamos um tipo espcial de Lista chamado <b>Fila</b>. No entanto, nessa ocasião decidi usar um tipo especial de Fila chamdo <i>Fila de Prioridade</i>. A diferença entre as duas é o fato de que na de prioridade os elementos da fila possuem pesos, e quanto maior o seu peso mais cedo ele será atendido. Optei por usar essa estrutura pois é comum que algumas situações de saúde exigam mais urgênia que outras, então é justo que essas pessoas sejam atendidas mais rápido que as outras. Isso também se aplica a casos de prioridade como idosos ou gestantes. Felizmente, a implementação desse tipo de estrutura é muito simples exigindo apenas alguns métodos que retornam informações importantes como tamanho da fila, e os métodos de inserção, remoção e consultar o próximo elemento.
<br>
  Após isso está pronto, uma maneira funcional de garantir um atendimento justo para os clientes. A próxima tarefa seria uma maneira de registrar esses pacientes para manter seus dados salvos no sistema da clínica.</p>

## Registro de Pacientes 📖
### Listas

<p>
  Quando penso em um sistema de registro, vem na minha cabeça algo similar a uma lista telefônica. Um lugar cheio de elementos ordenados e de <b>fácil busca</b>(levando em conta que todos os dados estejam ordenados). No entanto, quando falamos de programação temos que lembrar que tudo tem um preço computacional. Buscar um elemento em uma lista não é de graça e dependendo da situação pode se tornar uma operação muito ineficiente. Vamos pensar primeiro em uma lista desordenada, para procurar um elemento teremos que olhar índice por índice até achar o que estamos procurando(isso se acharmos), esse tipo de busca tem complexidade O(N) ou linear, ou seja, cresce proporcionalmente ao número de pacientes registrados.
<br>
  No entanto, existe um tipo de busca que é semelhante a aquela que fazemos em uma lista telefônica ordenada chamada <b>Busca Binária</b>. Esse algoritmo procura o elemento pensando em como ele estará posicionado na lista de acordo com a sua ordem. É como se procurassemos a página 450 de um livro, abrimos ele no meio e se estamos na página 300 nós continuamos passando páginas para a frente e eliminamos todas aquelas que estão anteas da 300, já que evidentemente elas serão menores que 450. Este é o princípio, sempre abrir na metade e eliminar aqueles que temos certeza que não são o elemento. Já que sempre estamos limpando a lista pela metade esse tipo de algoritmo tem complexidade O(logN), sendo bem melhor que a busca linear. 
<br>
  Mas nem tudo são flores, para a busca binária funcionar a lista deve estar ordenada e garantir isso também não é de graça. Ordenar uma lista geralmente é uma tarefa cara de complexidade maior que O(N)(as vezes bem maior), e garantir que os elementos sempre serão inseridos em ordem também não sai barato. Todos esses fatores tornam a lista uma opção viável mas alguns problemas de eficiência. Sendo assim, decidi ir por outro caminho. Não vou usar uma lista para guardar o registro dos pacientes, mas sim outra estrutura muito conhecida e utilizada para situações desse tipo: o <i>HashMap</i>.
</p>

### HashMaps
