package appPizzaria;


import java.util.ArrayList;
import java.util.List;

public class CardapioSingleton {
	
	private List<Ingrediente> ingredientes_fabrica = new ArrayList<Ingrediente>();  
	private static CardapioSingleton cardapio;
	private List<Pizza> pizzas = new ArrayList<Pizza>();
	
	CardapioSingleton(){
		ingredientes_fabrica.add(new Ingrediente("Pepperoni"));
		ingredientes_fabrica.add(new Ingrediente("Queijo Mussarela"));
		ingredientes_fabrica.add(new Ingrediente("Frango"));
		ingredientes_fabrica.add(new Ingrediente("Camarão"));
		ingredientes_fabrica.add(new Ingrediente("Carne de Sol"));
		ingredientes_fabrica.add(new Ingrediente("Bacon"));
		ingredientes_fabrica.add(new Ingrediente("Queijo Cheddar"));
		ingredientes_fabrica.add(new Ingrediente("Cream Cheese"));
		ingredientes_fabrica.add(new Ingrediente("Catupiry"));
	}
	
	public void imprimirPizzas() {
		int count = 0;
		for(Pizza p: this.pizzas) {
			System.out.println("");
			System.out.print("Opção: " + count);
			count++;
			p.imprimirPizza();			
		}
	
	}
	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public void imprimirIgredientes() {
		int count = 0;
		System.out.println("\nEscolha seus ingredientes: \n");
		for(Ingrediente i:ingredientes_fabrica ) {
			System.out.print(count+". "+i.nome+" \n");
			count++;
			
		}
		if(count==0) {
			System.out.println("O cardápio está vazio, por favor adicionar mais ingredientes! \n");
		}
	}
	
	public void adicionarPizzaCardapio(Pizza p) {
		this.pizzas.add(p);
	}
	
	public static CardapioSingleton obterMesa() {
		if (cardapio == null) {
			cardapio = new CardapioSingleton();
		}
		return cardapio;
	}

	public List<Ingrediente> getIngredientes_fabrica() {
		return ingredientes_fabrica;
	}

	public void setIngredientes_fabrica(List<Ingrediente> ingredientes_fabrica) {
		this.ingredientes_fabrica = ingredientes_fabrica;
	}

	public static CardapioSingleton getCardapio() {
		return cardapio;
	}

	public static void setCardapio(CardapioSingleton cardapio) {
		CardapioSingleton.cardapio = cardapio;
	}
	
}


