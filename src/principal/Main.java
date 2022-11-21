package principal;

import ui.TUI;
import ui.UserInterface;

public class Main {
    public static void main(String []args) {
        // TODO carregar informações do arquivo
        UserInterface userInterface = new TUI();
        userInterface.autoMenu(Menu.class);
        // TODO salvar o estado da aplicação
    }
}
