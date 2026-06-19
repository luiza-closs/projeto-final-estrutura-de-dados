public class Pilha {
    private char[] dados;
    private int topo;

    public Pilha(int capacidade) {
        dados = new char[capacidade];
        topo = -1;
    }

    public void push(char item) {
        if (topo < dados.length - 1) {
            topo++;
            dados[topo] = item;
        } else {
            System.out.println("Pilha cheia!");
        }
    }

    public char pop() {
        if (topo >= 0) {
            char item = dados[topo];
            topo--;
            return item;
        } else {
            System.out.println("Pilha vazia!");
            return '\0'; // Retorna um caractere nulo para indicar pilha vazia
        }
    }

    public char topo(){
        return dados[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

}
