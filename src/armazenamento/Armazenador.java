package armazenamento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class Armazenador<T> {
    private final Class<T> tipo;
    private final String nome;

    public Armazenador(Class<T> tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    public void salvar(T objeto) {
        Gson gson = new Gson();
        escrever(gson.toJson(objeto));
    }
    public T carregar() {
        Gson gson = new Gson();
        String arquivo = leArquivo();
        if (arquivo == "") {
            return null;
        }
        T objeto = gson.fromJson(arquivo, tipo);
        return objeto;
    }

    public String leArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(nome))) {
            return bufferedReaderToString(reader);
        } catch (FileNotFoundException e) {
            try {
                File file = new File(nome);
                file.createNewFile();
              } catch (IOException error) {
                e.printStackTrace();
              }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String bufferedReaderToString(BufferedReader b) throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = b.readLine()) != null) {
            	stringBuilder.append(line);
            	stringBuilder.append('\n');
            }
            b.close();
            
            String content = stringBuilder.toString();
            System.out.println(content);
            return content;
    }

    private void escrever(String content) {
        try {
            FileWriter myWriter = new FileWriter(nome);
            myWriter.write(content);
            myWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
    }
}
