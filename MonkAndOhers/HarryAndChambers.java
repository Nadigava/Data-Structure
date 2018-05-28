package Harryspidy;

import java.util.*;
import java.util.LinkedList;


public class HarryAndChambers {

	// Se crea una clase para almacenar la información de cada una
	// de las arañas
    private static class Spider {
    	// El poder de la araña
        int power;
        // El índice de la araña en la fila original
        int originalIndex;
    }

    public static void main(String[] args) {
    	// Se declara la entrada de datos
        Scanner in = new Scanner(System.in);
        // Se declara la cantidad de araña en la fila
        System.out.print("Digite la cantidad de arañas en la fila:");
        int n = in.nextInt();
        // Se declara la cantidad de iteraciones sobre la fila
        System.out.print("Digite La cantidad de iteraciones:");
        int x = in.nextInt();
        // Se declara la fila de las arañas
        Queue<Spider> queue = new LinkedList<>();
        // Se inicializan las arañas
        for (int i = 0; i < n; i++){
            Spider s = new Spider();
            System.out.print("Digite el poder de la araña " + (i+1) + " :");
            s.power = in.nextInt();

            // Se añade el índice de la añara en la fila original
            s.originalIndex = i+1;
            queue.add(s);
        }
        // Arreglo temporal de arañas por cada iteración
        Spider[] temp = new Spider[x];

        for (int i = 0; i < x; i++){
            int j = 0, maxIndex = 0;
            while (!queue.isEmpty() && j < x){
            	// Se saca la araña de la fila y se pone en el arreglo temporal
                Spider tempSpider = queue.remove();
                temp[j] = tempSpider;
                // Se almacena el índice de la araña con mayor poder
                if (tempSpider.power > temp[maxIndex].power){
                    maxIndex = j;
                }
                j++;
            }
            // Se imprime el índice original de la araña con mayor poder
            System.out.print(temp[maxIndex].originalIndex + " ");
            j--;
            // Se le resta en uno el poder de las arañas que van de regreso a la fila
            for (int k = 0 ; k <= j; k++){
                if (temp[k].power > 0){
                    temp[k].power -= 1;
                }
                // Sí la araña no tiene el máximo poder, se añade de nuevo a la fila
                if (k != maxIndex){
                    queue.add(temp[k]);
                }
            }
        }
    }
}