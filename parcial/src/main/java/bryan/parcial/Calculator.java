package bryan.parcial;

import java.util.Scanner;

import bryan.linkedlist.doubly.LinkedList;
import bryan.linkedlist.node.doubly.LinkedNode;
import bryan.util.iterator.Iterator;

public class Calculator {
    private LinkedList<Integer> numero1;
    private LinkedList<Integer> numero2;
    
    public Calculator(){
        numero1 = new LinkedList<>();
        numero2 = new LinkedList<>();
    }

    public void ingresarDatos(){
        Scanner lectura = new Scanner(System.in);
        boolean condicion = true;
        do {
            System.out.println("--------------------------------");
            System.out.println("Numero 1");
            System.out.println("Para terminar digite x");
            System.out.println("Ingrese un digito: ");
            String sNumero = lectura.next();
            if(sNumero.equals("x")){
                break;
            }
            try {
                int iNumero = Integer.parseInt(sNumero);
                numero1.add(iNumero);
            } catch (NumberFormatException e) {
                System.out.println("Error: El valor ingresado no es un número entero válido.");
            }
        } while (condicion);
        do {
            System.out.println("--------------------------------");
            System.out.println("Numero 2");
            System.out.println("Para terminar digite x");
            System.out.println("Ingrese un digito: ");
            String sNumero = lectura.next();
            if(sNumero.equals("x")){
                break;
            }
            try {
                int iNumero = Integer.parseInt(sNumero);
                numero2.add(iNumero);
            } catch (NumberFormatException e) {
                System.out.println("Error: El valor ingresado no es un número entero válido.");
            }
        } while (condicion);
    }

    public void resta(){
        LinkedList<Integer> resultado = new LinkedList<>();
        Iterator<Integer> it1 = numero1.reverseIterator();
        Iterator<Integer> it2 = numero2.reverseIterator();
        int restante = 0;

        while (it1.hasNext() || it2.hasNext() || restante != 0) {
            int valor1 = it1.hasNext() ? it1.next() : 0;
            int valor2 = it2.hasNext() ? it2.next() : 0;
            int resta = valor1 - valor2 - restante;
            if (resta < 0) {
                resta += 10;
                restante = 1;
            } else {
                restante = 0;
            }
            resultado.addFirst(resta);
        }

        StringBuilder str = new StringBuilder(resultado.size()); // Crea un StringBuilder para almacenar la cadena de dígitos
        Iterator<Integer> it = resultado.iterator(); // Obtiene un iterador para la lista resultado
        while (it.hasNext()) {
            int numeroR = it.next(); // Obtiene el siguiente número de la lista resultado
            str.append(numeroR); // Agrega el número al StringBuilder
            System.out.print(numeroR); // Imprime el número en la consola
        }
        System.out.println(); // Imprime un salto de lí111nea al final para mejorar la legibilidad
        System.out.println("Resultado de la resta: " + str);
    }

    public void modulo(){
        
    }

    public static void main (String[] args){
        Calculator calculadora = new Calculator();
        calculadora.ingresarDatos();
        calculadora.resta();
    }
}
