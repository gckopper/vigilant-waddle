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

    public Nota procuraNota(Disciplina disciplina) {
        for (Nota nota : notas) {
            if (nota != null && nota.getDisciplina().getCodigo() == disciplina.getCodigo()) {
                return nota;
            }
        }
        return null;
    }

    public boolean adicionaNota(double nota, Disciplina disciplina) {
        Nota nota2 =  procuraNota(disciplina);
        if (nota2 == null) {
            nota2 = new Nota(disciplina);
            if (!notas.add(nota2)) {
                return false;
            }
        }
        return nota2.adicionaNota(nota);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(nome);
        result.append(":\n");
        for (Nota nota : notas) {
            if (nota != null) {
                result.append('\t');
                result.append(nota.toString());
                result.append('\n');
            }
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public String getNome() {
        return nome;
    }

    public long getCodigo() {
        return codigo;
    }

    
}
