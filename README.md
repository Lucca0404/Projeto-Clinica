# Projeto-Clinica

## Ponto de Partida ☕
<p>Já faz mais ou menos 6 meses que comecei a programar e durante todo esse tempo eu estive focando meus estudos na <b>linguagem C </b> 🤖. No entanto, na minha faculdade começamos a ver a matéria de programação orientada a objetos na linguagem Java e isso fez eu pensar: É um ótimo momento para colocar os meus conhecimentos em prática e criar um projeto simples para ver como me saio.
<br>
Eis então que estou aqui em uma tarde de sábado e decido criar uma clínica médica 🥼(não me pergunte de onde veio essa ideia), eu apenas pensei que seria uma boa maneira de implementar algumas estruturas de dados que eu venho estudando só que dessa vez utilizando da orientação a objeto do Java ao meu favor. A seguir irei descrever quais foram as minhas ideias para a implementação das "mecânicas da clínica", vou tentar explicar de uma maneira que mesmo uma pessoa que nunca estudou estrutura de dados consiga entender 😁.</p>

## Criando a base 🏣

<p>A primeira coisa que fiz foi criar uma base para o projeto. Comecei criando uma classe abstrata pessoa que funcionará como uma base para criar outras classes como funcionários e pacientes. Decidi implementar uma classe abstrata em vez de uma interface pois a maioria dos atributos que uma pessoa possui também serão compartilhados entre as sub-classes. Após isso criei alguns atributos comuns como nome, idade e CPF; e também criei um método que valida se um CPF é válido ou não para impedir que um dado falso fosse colocado em uma pessoa.
<br>
Além disso, criei uma classe Paciente que seria a representação de qualquer cliente da clínica, essa classe teria um atributo de validação para ver se ele é ativo ou não na clínica. Essa classe herda de pessoa, no futuro isso será muito útil pois habilita que eu use polimorfismo nas estruturas de dados que eu irei criar, permitindo que qualquer classe ligada a pessoa seja intânciada pelas estruturas. Por fim, agora nos resta criar as estruturas em si que vão permitir o funcionamento da clínica.
</p>

