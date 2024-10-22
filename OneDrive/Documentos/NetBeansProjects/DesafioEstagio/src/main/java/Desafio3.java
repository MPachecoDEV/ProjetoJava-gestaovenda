

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Desafio3 {
    public static void main(String[] args) {
        
        double menorValor, maiorValor, mediaMensal = 0, soma = 0;
        
        
        double dados[] = {31490.7866, 37277.9400, 37708.4303, 0.0000, 0.0000, 17934.2269, 0.0000, 6965.1262, 24390.9374,14279.6481, 0.0000,
                        0.0000, 39807.6622, 27261.6304, 39775.6434, 29797.6232, 17216.5017, 0.0000, 0.0000, 12974.2000, 28490.9861, 8748.0937,
                        8889.0023, 17767.5583, 0.0000, 0.0000, 3071.3283, 48275.2994, 10299.6761, 39874.1073}; 
        
        Arrays.sort(dados);
        
        menorValor = dados[0];
        maiorValor = dados[29];
        
        ArrayList<Double> dadosFiltrados = new ArrayList<>();
        
        for (double valor : dados) {
            if (valor != 0) {
                dadosFiltrados.add(valor);
            }      
        }  
        
        for (int i = 0; i < dadosFiltrados.size(); i++) {
            soma += dados[i]; 
        }
        
        System.out.println(soma);
        
        mediaMensal = soma / dadosFiltrados.size();
        
        System.out.println(mediaMensal);
        
        ArrayList<Double> dadosMaiorQueMedia = new ArrayList<>();
        
        for (double valor : dadosFiltrados) {
            if (valor < mediaMensal) {
            } else {
                dadosMaiorQueMedia.add(valor);
            }      
        }  
        
        System.out.printf("Menor valor: %.2f \nMaior valor: %.2f\n", menorValor, maiorValor); 
        
        System.out.println("Dias no mes em que o faturamento foi maior que a media mensal: " + dadosMaiorQueMedia.size());
    }
}
