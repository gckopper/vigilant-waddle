package armazenamento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ArmazenadorTeste {
    private static final Armazenador<String> armazenador = new Armazenador<>(String.class, "testes.json");
    @Test   
    public void testaLeArquivoVazio() {
        assertEquals("",armazenador.leArquivo("test"));
    }  
}
