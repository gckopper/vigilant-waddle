package principal;

import armazenamento.Armazenador;
import ui.TUI;
import ui.UserInterface;

public class Main {
    public static void main(String []args) {
        Armazenador<Menu> armazenador = new Armazenador<>(Menu.class, "db.json");
        Menu menu = armazenador.carregar();
        if (menu == null) {
            menu = new Menu();
        }
        UserInterface userInterface = new TUI();
        userInterface.autoMenu(Menu.class, menu);
        armazenador.salvar(menu);
    }
}
