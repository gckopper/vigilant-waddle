package ui;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ResourceBundle;

public abstract class UserInterface {
    private static final ResourceBundle configBundle = ResourceBundle.getBundle("ui.Menu");
    protected String inputLine(){
        return null;
    }
    protected char inputChar(){
        return 0;
    }
    protected int inputInt() throws NumberFormatException {
        return 0;
    }
    protected long inputLong()  throws NumberFormatException {
        return 0;
    }
    protected double inputDouble()  throws NumberFormatException {
        return 0.0;
    }
    public void output(String text) {}
    public String question(boolean lock, String prompt, String... acceptable) {
        String answer;
        do {
            output(prompt);
            answer = inputLine();
            for (String accept : acceptable) {
                if (answer.equals(accept)) {
                    lock = false;
                    break;
                }
            }
        } while (lock && acceptable.length != 0);
        return answer;
    }
    public long question(boolean lock, String prompt, long ceiling, long floor) {
        long answer = 0;
        do {
            output(prompt);
            try {
                answer = inputLong();
                if (answer <= ceiling && answer >= floor) {
                    lock = false;
                    break;
                }
            } catch (Exception e) {
                output(configBundle.getString("NumberFormatException"));
            }
        } while (lock);
        return answer;
    }
    public int question(boolean lock, String prompt, int ceiling, int floor) {
        int answer = 0;
        do {
            output(prompt);
            try {
                answer = inputInt();
                if (answer <= ceiling && answer >= floor) {
                    lock = false;
                    break;
                }
            } catch (Exception e) {
                output(configBundle.getString("NumberFormatException"));
            }
        } while (lock);
        return answer;
    }
    public String question(String prompt, String... acceptable) {
        return question(true, prompt, acceptable);
    }
    public int question(String prompt, int ceiling, int floor) {
        return question(true, prompt, ceiling, floor);
    }
    public long question(String prompt, long ceiling, long floor) {
        return question(true, prompt, ceiling, floor);
    }

    public Object menu(String prompt, Object[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        String[] option = new String[array.length];
        for (int i = 0; i < option.length; i++) {
            option[i] = array[i].toString();
        }
        int answer = menu(prompt, option);
        return array[answer];
    }

    public int menu(String prompt, String... options) { 
        output(prompt);
        return menu(options);
    }

    public int menu(String... options) {
        StringBuilder prompt = new StringBuilder();
        for (int i = 0; i < options.length; i++) {
            prompt.append(i + 1);
            prompt.append('.');
            prompt.append(' ');
            prompt.append(options[i]);
            prompt.append('\n');
        }
        return question(prompt.toString(), options.length, 1) - 1;
    }

    public void autoMenu(Class<?> menuClass) {
        Method[] methods = filter(menuClass.getMethods());
        String[] opcoes = new String[methods.length + 1];
        for (int i = 0; i < opcoes.length - 1; i++) {
            opcoes[i] = methods[i].getAnnotation(MenuName.class).value();
        }
        opcoes[opcoes.length - 1] = configBundle.getString("LeaveKey");
        int input;
        while (true) {
            input = menu(opcoes);
            if (input == opcoes.length - 1) {
                break;
            }
            Method method = methods[input];
            try {
                if (method.getParameterCount() == 0) {
                    method.invoke(null);
                    continue;
                }
                if (method.getParameterCount() == 1 && UserInterface.class.isAssignableFrom(method.getParameterTypes()[0])) {
                    method.invoke(null, this);
                    continue;
                }
            } catch (IllegalAccessException e) {
                output(String.format("%s%s%s", configBundle.getString("ErrorPermisionKey"), e, configBundle.getString("ErrorMsgEnd")));
            } catch (IllegalArgumentException e) {
                output(String.format("%s%s%s", configBundle.getString("ErrorArgsKey"), e, configBundle.getString("ErrorMsgEnd")));
            } catch (InvocationTargetException e) {
                output(String.format("%s%s%s", configBundle.getString("ErrorTargetKey"), e, configBundle.getString("ErrorMsgEnd")));
            }
        } 
    }

    private static Method[] filter(Method[] methods) {
        int size = methods.length;
        for (int i = 0; i < methods.length; i++) {
            if (!methods[i].isAnnotationPresent(MenuName.class)) {
                methods[i] = null;
                size--;
            }
        }
        Method[] result = new Method[size];
        for (int i = 0; i < result.length; i++) {
            if (methods[i] != null) {
                result[i] = methods[i];
            }
        }
        return result;
    }
}
