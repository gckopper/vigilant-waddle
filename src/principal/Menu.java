package principal;

import java.util.ArrayList;

import escola.Aluno;
import escola.Disciplina;
import ui.MenuName;
import ui.UserInterface;

public class Menu {
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    @MenuName("to string")
    public void hello(UserInterface ui) {
        ui.output(this.toString());
    }
    @MenuName("Inserir aluno")
    public void adicionaAluno(UserInterface ui) {
        String nome = ui.question("Qual o nome do aluno");
        long codigo = ui.question("Qual o código do aluno", Long.MAX_VALUE, 0);
        alunos.add(new Aluno(nome, codigo));
    }
    @MenuName("Inserir disciplina")
    public void adicionaDisciplina(UserInterface ui) {
        String nome = ui.question("Qual o nome do aluno");
        long codigo = ui.question("Qual o código do aluno", Long.MAX_VALUE, 0);
        disciplinas.add(new Disciplina(nome, codigo));
    }
    // TODO Adicionar nota na avaliação
    // TODO Calcular média
    // TODO Listar todos os alunos com as suas disciplinas e médias (aritmética e ponderada) com resultado final (aprovado >= 7, reprovado < 7)

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Menu [alunos=");
        builder.append(alunos);
        builder.append(", disciplinas=");
        builder.append(disciplinas);
        builder.append("]");
        return builder.toString();
    }
}
