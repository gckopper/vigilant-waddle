package armazenamento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ArmazenadorTeste {
    private static final Armazenador<String> armazenador = new Armazenador<>(String.class, "testes.json");
    @Test   
    public void testaLeArquivoVazio() {
        Armazenador<String> armazenador = new Armazenador<>(String.class, "vazio.json");
        assertEquals("",armazenador.leArquivo());
    }  
    @Test   
    public void testaGuarda() {
        armazenador.salvar("BATATA");
    } 
    @Test   
    public void testaCarregar() {
        String text = armazenador.carregar();
        assertEquals("BATATA", text);
    } 

    
}
