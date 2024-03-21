package bryan.parcial;

import bryan.linkedlist.doubly.LinkedList;

public class Poly {
    
    public LinkedList<Object> restarPolinomios(LinkedList<Integer> polinomio1, LinkedList<Integer> polinomio2) {
		LinkedList<Object> listRes = new LinkedList<Object>();
		Object[] array1 = polinomio1.toArray();
		Object[] array2 = polinomio2.toArray();
		int n = Math.max(array1.length, array2.length);
		int[] resultado = new int[n];
		if (n == array1.length) {
			for (int i = array1.length; i > 1; i--) {
				resultado[i - 1] = (int) array1[i - 1] - (int) array2[i - 2];
			}
			resultado[0] = (int) array1[0];
		} else {
			for (int i = array2.length; i > 1; i--) {
				resultado[i - 1] = (int) array2[i - 1] - (int) array1[i - 2];
			}
			resultado[0] = (int) array2[0];
		}
		for (int i : resultado) {
			listRes.add(i);
		}
		return listRes;
	}

	public LinkedList<Object> derivarPolinomio(LinkedList<Integer> polinomio) {
		LinkedList<Object> listRes = new LinkedList<Object>();
		Object[] resultado = new Object[polinomio.size()];
		Object[] array = new Object[polinomio.size()];
		array = polinomio.toArray();
		resultado[0] = 0;
		listRes.add(0);
		for (int i = array.length; i > 1; i--) {
			resultado[array.length - (array.length - 1)] = (i - 1) * (int) array[array.length - i];
			listRes.add(resultado[1]);
		}
		return listRes;
	}

	public static int evaluarPolinomio(LinkedList<Integer> polinomio, int a, int b) {
		int resultadoA = 0;
		int resultadoB = 0;
		Object[] array = polinomio.toArray();

		for (int i = array.length - 1; i >= 0; i--) {
			resultadoA = resultadoA * a + (int) array[i];
			resultadoB = resultadoB * b + (int) array[i];
		}
		return resultadoB - resultadoA;
	}


}
