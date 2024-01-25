import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PilhaTest {
    private Pilha pilha;
    private final int TAMANHO_MAXIMO = 10;
    @BeforeEach
    public void antesDeTodos() {
        this.pilha = new Pilha(this.TAMANHO_MAXIMO);
    }

    @AfterAll
    static void depoisDeTodos() {
        System.out.println("Depois de todos");
    }

    @Test
    @DisplayName("Pilha vazia")
    void pilhaVazia() {
        assertTrue(this.pilha.estaVazia());
        assertEquals(0, this.pilha.tamanho());
    }

    @Test
    @DisplayName("Pilha com um elemento")
    void empilhaUmElemento() {
        this.pilha.empilha("primeiro");
        assertFalse(pilha.estaVazia());
        assertEquals(1, this.pilha.tamanho());
        assertEquals("primeiro", this.pilha.topo());
    }

    @Test
    @DisplayName("Pilha com dois elemento")
    void empilhaEDesempilha() {
        this.pilha.empilha("primeiro");
        this.pilha.empilha("segundo");
        assertEquals(2, this.pilha.tamanho());
        assertEquals("segundo", this.pilha.topo());
        Object desempilhado = this.pilha.desempilha();
        assertEquals(1, this.pilha.tamanho());
        assertEquals("primeiro", this.pilha.topo());
        assertEquals("segundo", desempilhado);
    }

    @Test
    @DisplayName("Remove da pilha vazia")
    void removeDaPilhaVazia() {
        assertThrows(PilhaVaziaException.class, () -> pilha.desempilha());
    }

    @Test
    @DisplayName("Adiciona na pilha cheia")
    void adicionaNaPilhaCheia() {
        // Se o tamanho máximo for 10, o erro deve ocorrer na décima primeira inserção
        // nas inserções anteriores, não deve ocorrer erro
        for (int i = 0; i < this.TAMANHO_MAXIMO; i++) {
            pilha.empilha("elemento " + i);
        }
        assertThrows(PilhaCheiaException.class, () -> pilha.empilha("boom"));
    }

}
