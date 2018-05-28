package Cards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Throwingcardsaway {
	
	public static void main (String [] abc) throws IOException {
		// Se declara el objeto que va a leer el archivo desde el disco duro.
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		// Pedir el número de cartas del primer mazo
		System.out.print("Digite el número de cartas del mazo:");
		s=br.readLine();
		// Se leen cada una de las líneas del archivo
		while (!s.equals("0")) {
			// Se convierte cada uno de las cadenas de caracteres en números
			int N=Integer.parseInt(s);
			// Se declara la fila de las cartas
			Queue<Integer> deck=new LinkedList<>();
			// Se añaden las cartas desde la carta 1 hasta la carta N 
			for (int i=1;i<=N;i++) deck.offer(i);
			// La fila de cartas que se descartaron
			Queue<Integer> ans=new LinkedList<>();
			
			// Proceso principal que se ejecuta mientras hayan más de 1 carta
			while (deck.size()>=2) {		
				// Se pasa la primera carta de la fila principal a la fila de
				// cartas descartadas
				ans.offer(deck.poll());
				// Se saca la primera carta de la fila y se reubica al final
				deck.offer(deck.poll());
			}
			
			// Crear el objeto que se usara para imprimir la respuesta
			StringBuilder sb=new StringBuilder();
			sb.append("Cartas descartadas:");
			if (ans.size()>0) sb.append(" ");
			while (ans.size()>0) {
				// Sacar una carta de la fila de cartas descartadas y añadirlas
				// a la cadena de caracteres de la respuesta
				sb.append(ans.poll());
				// Si queda una todavía otra carta, imprimir la coma y el espacio
				if (ans.size()>0) sb.append(", ");
			}
			sb.append("\nCarta que permanece: ");
			//Añadir la última carta a la cadena de caracteress
			sb.append(deck.poll());
			System.out.println(sb.toString());
			
			// Pedir el número de cartas del siguinte mazo
			System.out.print("Digite el número de cartas del mazo:");
			s=br.readLine();
			
		}
	}
}