package escola;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NotaTeste {
    public static final Disciplina DISCIPLINA = new Disciplina("teste", 0);
    @Test   
    public void testaMediaAritmeticaZeroENull() {
        Nota nota = new Nota(0.0, DISCIPLINA);
        assertEquals(0.0, nota.media());
    } 
    @Test 
    public void testaMediaZeroEZero() {
        Nota nota = new Nota(0.0, 0.0, DISCIPLINA);
        assertEquals(0.0, nota.media());
    }
    @Test 
    public void testaConstrutorMenos1() {
        assertThrowsExactly(NumberFormatException.class, ()->{
            new Nota(-0.1, 0.0, DISCIPLINA);
        });
    }
    @Test 
    public void testaMediaPonderada2e8() {
        Nota nota = new Nota(2, 8, DISCIPLINA);
        assertEquals(6, nota.media());
    }
    @Test 
    public void testaMediaPonderada8eNull() {
        Nota nota = new Nota(8, DISCIPLINA);
        assertEquals(8, nota.media());
    }
    @Test 
    public void testaAdicionaNota() {
        Nota nota = new Nota(8, DISCIPLINA);
        nota.adicionaNota(2);
        assertEquals(4, nota.media());
    }
}
