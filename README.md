# Trabalho Final - Pilhas

## Estrutura de Dados I

### Objetivo

Implementar um **Validador de Expressões** utilizando uma estrutura de dados do tipo **Pilha**.

A pilha pode ser:

- Estática
- Dinâmica

⚠️ **Não é permitido utilizar a classe `Stack` da linguagem Java.**

Devem ser utilizados os modelos de implementação de pilha apresentados em aula.

---

## 1. Validação de Delimitadores

O validador deve analisar os seguintes símbolos:

- `{ }`
- `[ ]`
- `( )`

### Funcionamento

Sempre que um símbolo de abertura for encontrado, ele deve ser inserido no topo da pilha.

Dessa forma, o delimitador mais interno da expressão estará sempre no topo, permitindo verificar corretamente os fechamentos.

### Exemplo da lógica

1. Encontrou um símbolo de abertura → empilha.
2. Encontrou um símbolo de fechamento → compara com o topo da pilha.
3. Se forem compatíveis → remove o topo e continua.
4. Se forem incompatíveis → a expressão é inválida.

---

## Erros Detectáveis

### 1. Símbolos incompatíveis

Quando um delimitador de fechamento não corresponde ao símbolo que está no topo da pilha.

**Exemplo:**

```text
([)
```

O `)` tenta fechar um `(`, mas o topo da pilha contém `[`.

---

### 2. Pilha vazia antes da hora

Quando um delimitador de fechamento é encontrado, mas não existe nenhum delimitador de abertura correspondente.

**Exemplo:**

```text
5 + 3)
```

Há mais fechamentos do que aberturas.

---

### 3. Delimitadores não fechados

Ao finalizar a análise, a pilha ainda possui elementos.

**Exemplo:**

```text
(5 + [3 * 2]
```

Existe pelo menos um delimitador aberto que nunca foi fechado.

---

## 2. Validação de Operadores

Além dos delimitadores, o validador deve verificar a utilização correta dos operadores.

### Regras

#### Não permitir dois operadores consecutivos

**Inválido:**

```text
5 + * 3
2 / / 4
```

---

#### Operadores binários precisam de dois operandos

Um operador não pode:

- Estar no início da expressão;
- Estar no final da expressão.

**Inválido:**

```text
+ 5 - 2
```

```text
5 + 3 -
```

---

#### Operadores não podem ficar ao lado de delimitadores sem operandos

Não pode existir um operador imediatamente após uma abertura ou imediatamente antes de um fechamento.

**Inválido:**

```text
( * 3)
```

```text
(3 + )
```

---

## 3. Método Main

O método `main` deve ser implementado exatamente conforme o exemplo abaixo:

```java
public static void main(String[] args) {

    String[] testes = {
        "5 + 3 * [(2 - 1)]",      // VÁLIDA
        "5 + * 3",               // INVÁLIDA (dois operadores seguidos)
        "(5 + 3) / / 2",         // INVÁLIDA (dois operadores seguidos)
        "+ 5 - 2",               // INVÁLIDA (começa com operador)
        "5 + 3 -",               // INVÁLIDA (termina com operador)
        "5 + ( * 3)",            // INVÁLIDA (operador após abertura)
        "5 + (3 - )",            // INVÁLIDA (fechamento após operador)
        "{5 + [3 * (2 / 2)]}"    // VÁLIDA
    };

    System.out.println("--- Validador de Expressões ---");

    for (String string : testes) {
        System.out.printf(
            "Expressão: %-25s -> %s\n",
            string,
            (isValida(string) ? "VÁLIDA" : "INVÁLIDA")
        );
    }
}
```

---

## Resultado Esperado

```text
--- Validador de Expressões ---

Expressão: 5 + 3 * [(2 - 1)]      -> VÁLIDA
Expressão: 5 + * 3                -> INVÁLIDA
Expressão: (5 + 3) / / 2          -> INVÁLIDA
Expressão: + 5 - 2                -> INVÁLIDA
Expressão: 5 + 3 -                -> INVÁLIDA
Expressão: 5 + ( * 3)             -> INVÁLIDA
Expressão: 5 + (3 - )             -> INVÁLIDA
Expressão: {5 + [3 * (2 / 2)]}    -> VÁLIDA
```