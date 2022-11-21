package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class TUI extends UserInterface{
    private static final ResourceBundle configBundle = ResourceBundle.getBundle("ui.Menu");

    @Override
    protected String inputLine() {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));  
        try {
            return obj.readLine();
        } catch (IOException e) {
            System.err.println(configBundle.getString("IOException"));
        }
        return null;
    }

    @Override
    protected char inputChar() {
        return inputLine().charAt(0);
    }

    @Override
    protected int inputInt() throws NumberFormatException {
        return Integer.parseInt(inputLine());
    }

    @Override
    protected long inputLong() throws NumberFormatException {
        return Long.parseLong(inputLine());
    }

    @Override
    public void output(String text) {
        System.out.println(text);
    }
    
}
