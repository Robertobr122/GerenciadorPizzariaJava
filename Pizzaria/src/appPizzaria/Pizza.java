package appPizzaria;

public class Pizza {
	private String nome;
	
	PilhaIngredientes ingredientes = new PilhaIngredientes();
	int qtd_ing=0;

	public void imprimirPizza() {
		System.out.print("\nPizza: " + this.getNome()+"\nIngredientes: ");
		this.ingredientes.imprimir();
		System.out.print("\n------------------------------------------------------------------\n");
		System.out.println("");
	
	}
	public void addIngrediente(Ingrediente ing) {
			this.ingredientes.adicionar(ing);
	}
	public void removerIngrediente() {
			this.ingredientes.remover();
	}
	public void imprimirIngrediente() {
		this.ingredientes.imprimir();
	}
	
	public PilhaIngredientes getIngredientes() {
		return this.ingredientes;
	}
	
	public Ingrediente[] todosIngrediente() {
		return this.ingredientes.getVetor();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQtd_ing() {
		return qtd_ing;
	}
	public void setQtd_ing(int qtd_ing) {
		this.qtd_ing = qtd_ing;
	}
	public void setIngredientes(PilhaIngredientes ingredientes) {
		this.ingredientes = ingredientes;
	}
	 public boolean contemIngrediente(Ingrediente ingrediente) {
	        for (Ingrediente ing : ingredientes.getVetor()) {
	            if (ing != null && ing.equals(ingrediente)) {
	                return true;
	            }
	        }
	        return false;
	    }

}


