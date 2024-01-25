public class Pilha {
    private final Object[] elementos;
    private final int tamanhoMaximo;
    private int quantidade = 0;

    public Pilha(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.elementos = new Object[tamanhoMaximo];
    }

    public boolean estaVazia() {
        return this.quantidade == 0;
    }

    public int tamanho() {
        return this.quantidade;
    }

    public void empilha(String elemento) {
        if (this.quantidade == this.tamanhoMaximo) {
            throw new PilhaCheiaException("Não é possível empilhar em uma pilha cheia");
        }
        this.elementos[quantidade] = elemento;
        this.quantidade++;
    }

    public Object desempilha() {
        if (this.estaVazia()) {
            throw new PilhaVaziaException("Não é possível desempilhar de uma pilha vazia");
        }
        Object topo = this.topo();
        this.quantidade--;
        return topo;
    }

    public Object topo() {
        return elementos[quantidade - 1];
    }
}
