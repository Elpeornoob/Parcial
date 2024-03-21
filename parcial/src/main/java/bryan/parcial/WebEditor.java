package bryan.parcial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import bryan.stack.list.Stack;

public class WebEditor {
    private Stack<String> etiquetas;

    public WebEditor(){
        etiquetas = new Stack<>();
    }

    private boolean readHTML(String nombreDeArchivo){

        try (BufferedReader br = new BufferedReader(new FileReader(nombreDeArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return false;
        }

    }
}
