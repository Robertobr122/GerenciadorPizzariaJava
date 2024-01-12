package appPizzaria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDadosMemoria {
    private static int qtd_servido = 0;
    private String[] ingredientes = new String[1];
    private int[] contagem = new int[ingredientes.length];
    private static int pos = 0;
    private int mediaIngredientes = 0;

    CardapioSingleton cardapio = new CardapioSingleton();
    
    private Map<String, Integer> ingredientes_fabrica = new HashMap<>();

    public void addIncrementa() {
        this.qtd_servido++;
    }

    public int retornarQtdServidosItem() {
        return this.qtd_servido;
    }

    public void addIngredientes(String nome) {
        if (pos == ingredientes.length) {
            String[] aux = new String[ingredientes.length + 1];
            int[] contaux = new int[aux.length];
            for (int i = 0; i < ingredientes.length; i++) {
                aux[i] = this.ingredientes[i];
            }
            this.contagem = contaux;
            this.ingredientes = aux;
            this.ingredientes[pos] = nome;
            this.pos++;
        } else {
            this.ingredientes[pos] = nome;
            this.pos++;
        }
        ingredientes_fabrica.put(nome, ingredientes_fabrica.getOrDefault(nome, 0) + 1);
    }

    public int getMediaIngredientes() {
    	 if (qtd_servido == 0) {
             return 0; 
         }
         mediaIngredientes = ingredientes.length / qtd_servido;
         return mediaIngredientes;
    }

    public String ingredienteMaisUtlizado() {
        int maior = 0;
        String nomeMaior = "";
        for (String s : ingredientes_fabrica.keySet()) {
            if (ingredientes_fabrica.get(s) > maior) {
                maior = ingredientes_fabrica.get(s);
                nomeMaior = s;
            }
        }
        return nomeMaior;
    }

	}

