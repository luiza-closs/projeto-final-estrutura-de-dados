# Trabalho Final - Pilhas
### Estrutura de Dados I
Implementar um Validador de Expressões, utilizando uma estrutura de dados denominada pilha. A pilha pode ser estática ou dinâmica e não pode ser utilizada a classe Stack existente na linguagem de programação Java. Devem ser utilizados os modelos de código de pilha exibidos em aula.
1. O validador de expressões deve avaliar os símbolos **{ }**, **[ ]** e **( )**.
Ideia geral
- Sempre que um símbolo de abertura for encontrado, ele deve ser colocado no topo da pilha, pois dessa forma o símbolo de abertura mais interno da expressão sempre estará no topo.

- Quando um símbolo de fechamento for encontrado, ele deve combinar com aquele que está no topo da pilha. Se combinar, o topo é removido e a análise continua. Caso contrário, há um erro. Erros detectáveis
    
- Símbolos incompatíveis: exemplo, se um parêntese **)** for encontrado, mas o topo da pilha tem um colchete **[**, há um problema.

- Pilha esvazia antes da hora: exemplo, se for encontrado um parêntese **)** e a pilha estiver vazia, significa que há mais fechamentos do que aberturas.

- Pilha com elementos no final: se a expressão avaliada finalizar e a pilha ainda possuir elementos, significa que algum delimitador foi aberto, mas nunca fechado.
2. O Validador de Expressões também deve:
- Impedir dois operadores seguidos (como 5 + * 3 ou 2 / / 4).
- operadores binários precisam de dois operandos. Ou seja, se o operador estiver no índice 0 da expressão ou no último caractere da expressão, há um erro.
- um operador não pode estar ao lado de um parêntese, colchete ou chave sem um número entre eles, por isso é necessário fazer essa validação: “( *” e “+ )”.
3. O método main do trabalho deve ser igual ao implementado abaixo:

```java
public static void main(String[] args) {
 String[] testes = {
 "5 + 3 * [(2 - 1)]", // VÁLIDA
 "5 + * 3", // INVÁLIDA (dois operadores
seguidos)
 "(5 + 3) / / 2", // INVÁLIDA (dois operadores
seguidos)
 "+ 5 - 2", // INVÁLIDA (começa com operador)
 "5 + 3 -", // INVÁLIDA (termina com operador)
 "5 + ( * 3)", // INVÁLIDA (operador após
abertura)
 "5 + (3 - )", // INVÁLIDA (fechamento após
operador)
 "{5 + [3 * (2 / 2)]}" // VÁLIDA
 };
 System.out.println("--- Validador de Expressões ---");
 for (String string : testes) {
 System.out.printf("Expressão: %-25s -> %s\n", string,
(isValida(string) ? "VÁLIDA" : "INVÁLIDA"));
 }
 }
```