package principal;

import ui.MenuName;
import ui.UserInterface;

public abstract class Menu {
    @MenuName("Hello world")
    public static void hello(UserInterface ui) {
        ui.output("Hello world!");
    }
    // TODO Inserir aluno
    // TODO Inserir disciplina
    // TODO Adicionar nota na avaliação
    // TODO Calcular média
    // TODO Listar todos os alunos com as suas disciplinas e médias (aritmética e ponderada) com resultado final (aprovado >= 7, reprovado < 7)
}
