import java.util.*;
import java.util.LinkedList;

public class MonkAndPhilosopherStone {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Digite la cantidad de monedas en la bolsa de harry: ");
        int n = in.nextInt(); //Se digita el valor de N
        Queue<Integer> a = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) 
    	{	//Valor de A
        	System.out.print("Digite el valor de la moneda " + i + ": ");
        	a.add(in.nextInt());
    	}
        System.out.print("Digite la cantidad de intrucciones a realizar: ");
        int q = in.nextInt(); 
        System.out.print("Digite el valor para dormir a Monk: ");
        int value = in.nextInt(), sum = 0;
        							
        boolean valueFound = false; 
        Stack<Integer> stack = new Stack<>(); 
        
      //"q" Cantidad de instrucciones que hay que ejecutar
      //"value" cantidad de valor para dormir a Monk
      //"sum" valor de la sumatoria de las monedas que se le agregan a Monk 
      //"valueFound" Para cuando se haya encontrado el valor que se necesita
        
        while (q != 0 && !valueFound)
        {
            String s = in.next();
            if (s.equals("Harry"))
        	{
            	int temp = a.remove(); //Sacar la moneda de Harry para Monk
            	sum += temp;		//suma la nueva moneda	
            	stack.push(temp);	//agrega la moneda a Monk
        	}
            else if (s.equals("Remove"))
        	{
        		int temp = stack.pop(); //saca la moneda Monk
            	sum -= temp; //resta la suma de monedas de Monk
        	}
            
            if (sum == value)	//Si la suma y el valor para dormir son iguales
        	{
            	System.out.print("Monk se durmió: ");
            	valueFound = true;	//Se encuentra el valor de la cantidad de monedas 
        	}					//que se necesitan para dormir a Monk
            q--;
        }
        
        if (valueFound) //Imprimir el tamaño de la pila, para saber la cantidad de monedas
    	{
        	System.out.println(stack.size());
    	}
        
        else //Si no se logro la cantidad necesaria
        {
            System.out.println("-1");
        }
    }
}