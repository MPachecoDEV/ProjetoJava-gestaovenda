

import java.util.ArrayList;
import java.util.Scanner;

public class Desafio5 {
    public static void main(String[] args) {
        String palavra;
        Scanner input = new Scanner(System.in);
        ArrayList<Character> palavraSeparada = new ArrayList<>();
        
        System.out.print("Digite a palavra: ");
        palavra = input.next();

        
        for (int i = 0; i < palavra.length(); i++) { 
            char letra = palavra.charAt(i);
            palavraSeparada.add(letra);
        }
        
        for (int i = 0; i < palavraSeparada.size() / 2; i++) {
            char temp = palavraSeparada.get(i);
            palavraSeparada.set(i, palavraSeparada.get(palavraSeparada.size() - 1 - i));
            
            palavraSeparada.set(palavraSeparada.size() - 1 - i, temp);
        }
        
        StringBuilder builder = new StringBuilder();
        for(char c : palavraSeparada) {
            builder.append(c);
        }
        
        System.out.printf("A palavra inserida ao contrario: %s", builder);
    }    
}
