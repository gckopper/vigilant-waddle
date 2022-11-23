package escola;

public class Disciplina {
    private String nome;
    private long codigo;

    public Disciplina(String nome, long codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public long getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return nome + ' ' + '(' + codigo + ')';
    }
    
}
