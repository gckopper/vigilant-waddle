package principal;

import java.util.ArrayList;

import escola.Aluno;
import escola.Disciplina;
import ui.MenuName;
import ui.UserInterface;

public class Menu {
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    @MenuName("Hello world")
    public void hello(UserInterface ui) {
        ui.output(this.toString());
    }
    // TODO Inserir aluno
    // TODO Inserir disciplina
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
