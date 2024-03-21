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

    public void resta(){
        Scanner lectura = new Scanner(System.in);
        boolean condicion = true;
        do {
            System.out.println("--------------------------------");
            System.out.println("Numero 1, minuendo");
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
            System.out.println("Numero 2, sustraendo");
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

        StringBuilder str = new StringBuilder(resultado.size()); 
        Iterator<Integer> it = resultado.iterator(); 
        while (it.hasNext()) {
            int numeroR = it.next(); 
            str.append(numeroR); 
            System.out.print(numeroR); 
        }
        System.out.println(); 
        System.out.println("Resultado de la resta: " + str);
    }

    public void modulo(){
        Scanner lectura = new Scanner(System.in);
        boolean condicion = true;
        do {
            System.out.println("--------------------------------");
            System.out.println("Numero 1, dividendo");
            System.out.println("Para terminar digite x");
            System.out.println("Ingrese un digito: ");
            String sNumero = lectura.next();
            if (sNumero.equals("x")) {
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
            System.out.println("Numero 2, divisor");
            System.out.println("Para terminar digite x");
            System.out.println("Ingrese un digito: ");
            String sNumero = lectura.next();
            if (sNumero.equals("x")) {
                break;
            }
            try {
                int iNumero = Integer.parseInt(sNumero);
                if (iNumero == 0) {
                    System.out.println("Error: No se puede dividir por cero.");
                    return;
                }
                numero2.add(iNumero);
            } catch (NumberFormatException e) {
                System.out.println("Error: El valor ingresado no es un número entero válido.");
            }
        } while (condicion);

        if (numero1.isEmpty() ||numero2.isEmpty()) {
            System.out.println("Error: La lista de dividendo o divisor está vacía.");
            return;
        }

        if (numero2.peek() == 0) {
            System.out.println("Error: No se puede dividir por cero.");
            return;
        }

        LinkedList<Integer> resultado = new LinkedList<>();
        int resto = 0;

        Iterator<Integer> itDividendo = numero1.reverseIterator();
        Iterator<Integer> itDivisor = numero2.reverseIterator();

        while (!numero1.isEmpty()) {
            int digitoDividendo = numero1.pollLast(); // Obtener y eliminar el último dígito del dividendo
            int digitoDivisor = numero2.pollLast(); // Obtener y eliminar el último dígito del divisor
    
            int division = digitoDividendo + resto * 10;
            int moduloParcial = division % digitoDivisor;
    
            if (moduloParcial < 0) {
                moduloParcial += digitoDivisor;
                division -= moduloParcial + digitoDivisor;
            }
    
            resto = division / digitoDivisor;
            resultado.addFirst(moduloParcial);
        }


        // Print the result
        StringBuilder str = new StringBuilder(resultado.size());
        Iterator<Integer> it = resultado.iterator();
        while (it.hasNext()) {
            int numeroR = it.next();
            str.append(numeroR);
            System.out.print(numeroR);
        }
        System.out.println();
        System.out.println("Resultado del módulo: " + str);
    }

    public static void main (String[] args){
        System.out.println("Presione: ");
        System.out.println("1. Para realizar una resta");
        System.out.println("2. Para calcular el modulo");
        Scanner lectura = new Scanner(System.in);
        int opcion = lectura.nextInt();

        switch (opcion) {
            case 1:
            Calculator calculadora1 = new Calculator();
            calculadora1.resta();
                break;
            
            case 2:
            Calculator calculadora2 = new Calculator();
            calculadora2.modulo();
                break;

            default:
                break;
        }
        
    }
}
