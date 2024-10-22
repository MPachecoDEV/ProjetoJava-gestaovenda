

import java.util.HashMap;
import java.util.Map;

public class Desafio4 {
    public static void main(String[] args) {
        
        Map<String, Double> distribuidora = new HashMap<>();
        
        distribuidora.put("SP", 67836.43);
        distribuidora.put("RJ", 36678.66);
        distribuidora.put("MG", 29229.88);
        distribuidora.put("ES", 27165.48);
        distribuidora.put("Outros", 19849.53);
        
        double faturamentoTotal = 0;
        
        for (double valor : distribuidora.values()) {
            faturamentoTotal += valor;
        }
        
        System.out.println("Porcentagem de faturamento por estado: ");
        for (Map.Entry<String, Double> entry : distribuidora.entrySet()) {
            String estado = entry.getKey();
            Double porcentagem = (entry.getValue() / faturamentoTotal) * 100;
            System.out.printf("%s: %.2f%%\n", estado, porcentagem);
        }
        
    }
   
}
