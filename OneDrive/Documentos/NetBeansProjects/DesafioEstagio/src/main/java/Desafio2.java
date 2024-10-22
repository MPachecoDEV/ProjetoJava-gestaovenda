

import java.util.Scanner;

public class Desafio2 {
    public static void main(String[] args) {
        int n1 = 0; //   
        int n2 = 1; // 
        int n3; // 
        
        int valorInserido;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Digite um numero: ");
        valorInserido = input.nextInt();
        
        
        while (n2 <= valorInserido) {  
            System.out.println(n2 + " "); //
            n3 = n2;
            n2 += n1;
            n1 = n3;
        }
        
        
        if (n1 == valorInserido) {
            System.out.println("O valor inserido: " + valorInserido + " Esta na sequencia de fibonnaci");
        } else {
            System.out.println("O valor inserido: " + valorInserido + " Nao esta na sequencia de fibonnaci");
        }
    }
}
