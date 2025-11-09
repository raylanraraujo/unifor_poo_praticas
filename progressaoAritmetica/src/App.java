import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args)  {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite a quantidade: ");
        int quantidade = teclado.nextInt();
        int[] array = new int[quantidade];
        
        System.out.print("Digite o início: ");
        int inicio = teclado. nextInt();

        System.out.print("Digite a razão da PA:");
        int razao = teclado.nextInt();
        teclado.close();

        for(int i = 0; i < quantidade; i++){
            array[i] = inicio + (razao * i);
        }

        System.out.println(Arrays.toString(array));
    }
}
