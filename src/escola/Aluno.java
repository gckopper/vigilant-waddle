package escola;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private long codigo;
    private ArrayList<Nota> notas = new ArrayList<>();
    /**
     * @param nome
     * @param codigo
     */
    public Aluno(String nome, long codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }
    
}
