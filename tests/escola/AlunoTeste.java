package escola;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AlunoTeste {
    private static final Aluno ALUNO = new Aluno("jão", 0);
    @Test
    void testAdicionaNota() {
        assertTrue(ALUNO.adicionaNota(0, new Disciplina("testAdicionaNota", 0)));
    }

    @Test
    void testProcuraNota() {
        Disciplina disciplina = new Disciplina("testProcuraNota", 1);
        ALUNO.adicionaNota(8, disciplina);
        Nota nota = ALUNO.procuraNota(disciplina);
        assertEquals(8, nota.media());
    }
}
