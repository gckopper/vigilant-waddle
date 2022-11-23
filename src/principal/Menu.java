package principal;

import java.util.ArrayList;

import escola.Aluno;
import escola.Disciplina;
import ui.MenuName;
import ui.UserInterface;

public class Menu {
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    @MenuName("Inserir aluno")
    public void adicionaAluno(UserInterface ui) {
        String nome = ui.question("Qual o nome do aluno?");
        long codigo = ui.question("Qual o código do aluno?", Long.MAX_VALUE, 0);
        alunos.add(new Aluno(nome, codigo));
    }
    @MenuName("Inserir disciplina")
    public void adicionaDisciplina(UserInterface ui) {
        String nome = ui.question("Qual o nome da disciplina?");
        long codigo = ui.question("Qual o código da disciplina?", Long.MAX_VALUE, 0);
        disciplinas.add(new Disciplina(nome, codigo));
    }

    @MenuName("Adicionar nota")
    public void adicionaNota(UserInterface ui) {
        double valor = ui.question("Qual a nota?", 10.0, 0.0);
        Disciplina disciplina = procuraDiciplina(ui);
        if (disciplina == null) {
            ui.output("Disciplina não encontrada");
            return;
        }
        Aluno aluno = procuraAluno(ui);
        if (aluno == null) {
            ui.output("Aluno não encontrado");
            return;
        }
        if (!aluno.adicionaNota(valor, disciplina))
            ui.output("Não foi possivel adicionar a nota para o usuário");
    }

    private Disciplina procuraDiciplina(UserInterface ui) {
        long codigo = ui.question("Qual o código da disciplina?", Long.MAX_VALUE, 0);
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo() == codigo) {
                return disciplina;
            }
        }
        return null;
    }

    private Aluno procuraAluno(UserInterface ui) {
        long codigo = ui.question("Qual o código do aluno?", Long.MAX_VALUE, 0);
        for (Aluno aluno : alunos) {
            if (aluno.getCodigo() == codigo) {
                return aluno;
            }
        }
        return null;
    }

    @MenuName("Calcular média")
    public void media(UserInterface ui) {
        Aluno aluno = procuraAluno(ui);
        if (aluno == null) {
            ui.output("Aluno não encontrado");
            return;
        }
        ui.output(aluno.toString());
    }
    @MenuName("Listar todos os alunos")
    public void listar(UserInterface ui) {
        for (Aluno aluno : alunos) {
            ui.output(aluno.toString());
        }
    }
}
