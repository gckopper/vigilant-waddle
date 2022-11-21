package principal;

import ui.MenuName;
import ui.UserInterface;

public abstract class Menu {
    @MenuName("Hello world")
    public static void hello(UserInterface ui) {
        ui.output("Hello world!");
    }

}
