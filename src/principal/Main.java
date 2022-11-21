package principal;

import ui.TUI;
import ui.UserInterface;

public class Main {
    public static void main(String []args) {
        UserInterface userInterface = new TUI();
        userInterface.autoMenu(Menu.class);
    }
}
