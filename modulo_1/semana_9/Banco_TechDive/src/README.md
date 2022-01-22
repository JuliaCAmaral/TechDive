# Projeto referente aos exercícios 1 e 2 da semana 9

## Exercício 1:
Dado um sistema bancário que possui uma classe abstrata Conta e subclasses concretas ContaCorrente e ContaPoupanca que herdam de Conta.
Crie uma classe "Agencia", que deve possuir uma List de Conta, chamada "contas". 
Lembrando: em uma lista de Conta, você pode colocar tanto ContaCorrente quanto ContaPoupanca, e qualquer outra subclasse de Conta.

Crie um método "void adiciona(Conta c)" e outro “int getQuantidadeDeContas()”, que devem manipular a lista.

Teste esses métodos através do método main.


## Exercício 2:
Na classe Agencia do exercício anterior, crie um método "Conta buscaPorTitular(String nomeDoTitular)" que procura por uma Conta cujo titular seja "equals" ao "nomeDoTitular" passado como argumento.

Obs.: Considere que cada Conta possui um atributo "Cliente titular", e a classe Cliente possui, dentre seus atributos, um "String nome".