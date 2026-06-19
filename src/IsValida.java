public class IsValida {
    public static boolean isValida(String expressao) {
        Pilha pilha = new Pilha(expressao.length());

        // Remove espaços em branco para facilitar a verificação
        expressao = expressao.replaceAll("\\s+", "");

        // Verifica operadores
        String operadores = "+-*/";
        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (operadores.indexOf(c) != -1) {
                // Verifica se o operador está no início ou no final da expressão
                if (i == 0 || i == expressao.length() - 1) {
                    return false; // Operador no início ou no final
                }
                // Verifica se há outro operador imediatamente antes ou depois do operador atual, mesmo com espaços entre eles
                if (i > 0 && operadores.indexOf(expressao.charAt(i - 1)) != -1) {
                    return false; // Dois operadores seguidos
                }

                if (i < expressao.length() - 1 && operadores.indexOf(expressao.charAt(i + 1)) != -1) {
                    return false; // Dois operadores seguidos
                }

                // Verifica se o operador está após uma abertura, ou antes de um fechamento
                if (i > 0 && (expressao.charAt(i - 1) == '(' || expressao.charAt(i - 1) == '{' || expressao.charAt(i - 1) == '[')) {
                    return false; // Operador após abertura
                }
                if (i < expressao.length() - 1 && (expressao.charAt(i + 1) == ')' || expressao.charAt(i + 1) == '}' || expressao.charAt(i + 1) == ']')) {
                    return false; // Operador antes de fechamento
                }
            }
        }

        // Verifica os parênteses, colchetes e chaves
        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                pilha.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (pilha.isEmpty()) {
                    return false; // Fechamento sem abertura correspondente
                }
                char topo = pilha.pop();
                if ((c == ')' && topo != '(') ||
                    (c == '}' && topo != '{') ||
                    (c == ']' && topo != '[')) {
                    return false; // Fechamento não corresponde à abertura
                }
            }
        }

        return pilha.isEmpty(); // Verifica se todas as aberturas foram fechadas
    }
    
}
