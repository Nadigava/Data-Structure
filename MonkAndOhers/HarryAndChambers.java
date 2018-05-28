package Harryspidy;

import java.util.*;
import java.util.LinkedList;


public class HarryAndChambers {

	// Se crea una clase para almacenar la informaci�n de cada una
	// de las ara�as
    private static class Spider {
    	// El poder de la ara�a
        int power;
        // El �ndice de la ara�a en la fila original
        int originalIndex;
    }

    public static void main(String[] args) {
    	// Se declara la entrada de datos
        Scanner in = new Scanner(System.in);
        // Se declara la cantidad de ara�a en la fila
        System.out.print("Digite la cantidad de ara�as en la fila:");
        int n = in.nextInt();
        // Se declara la cantidad de iteraciones sobre la fila
        System.out.print("Digite La cantidad de iteraciones:");
        int x = in.nextInt();
        // Se declara la fila de las ara�as
        Queue<Spider> queue = new LinkedList<>();
        // Se inicializan las ara�as
        for (int i = 0; i < n; i++){
            Spider s = new Spider();
            System.out.print("Digite el poder de la ara�a " + (i+1) + " :");
            s.power = in.nextInt();

            // Se a�ade el �ndice de la a�ara en la fila original
            s.originalIndex = i+1;
            queue.add(s);
        }
        // Arreglo temporal de ara�as por cada iteraci�n
        Spider[] temp = new Spider[x];

        for (int i = 0; i < x; i++){
            int j = 0, maxIndex = 0;
            while (!queue.isEmpty() && j < x){
            	// Se saca la ara�a de la fila y se pone en el arreglo temporal
                Spider tempSpider = queue.remove();
                temp[j] = tempSpider;
                // Se almacena el �ndice de la ara�a con mayor poder
                if (tempSpider.power > temp[maxIndex].power){
                    maxIndex = j;
                }
                j++;
            }
            // Se imprime el �ndice original de la ara�a con mayor poder
            System.out.print(temp[maxIndex].originalIndex + " ");
            j--;
            // Se le resta en uno el poder de las ara�as que van de regreso a la fila
            for (int k = 0 ; k <= j; k++){
                if (temp[k].power > 0){
                    temp[k].power -= 1;
                }
                // S� la ara�a no tiene el m�ximo poder, se a�ade de nuevo a la fila
                if (k != maxIndex){
                    queue.add(temp[k]);
                }
            }
        }
    }
}