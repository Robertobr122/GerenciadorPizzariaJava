package appPizzaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizzaria {
	CardapioSingleton cardapio;
	List<Pedido> pedidos;
	BaseDadosMemoria baseDados = new BaseDadosMemoria();
	Pizza pizza = new Pizza();
		
	public Pizzaria(){
		this.cardapio = cardapio.obterMesa();
		this.pedidos = new ArrayList<Pedido>();
	}

	public void criarPizza() {
	    Pizza pizza = new Pizza();
	    List<String> naoEscolhidos = new ArrayList<>();

	    if (cardapio.getIngredientes_fabrica().isEmpty()) {
	        this.cardapio.imprimirIgredientes();
	    } else {
	        Scanner sc = new Scanner(System.in);
	        this.cardapio.imprimirIgredientes();
	        System.out.println("");
	        System.out.println("1) Adicionar ingrediente");
	        System.out.println("2) Remover/desfazer ingrediente ");
	        System.out.println("3) Concluir a criação");
	        System.out.println("Escolha uma opção: ");
	        int opcao = sc.nextInt();

	        while (true) {
	            this.cardapio.imprimirIgredientes();
	            System.out.println("");
	            System.out.println("Ingredientes escolhidos: ");
	            pizza.imprimirIngrediente();
	            
	            if (opcao == 1) {
	                System.out.println("");
	                System.out.println("Escolha a opção do ingrediente para adicionar: ");
	                Scanner scanner = new Scanner(System.in);
	                int ing = scanner.nextInt();
	                Ingrediente ingred = buscarIngredientePor(ing);
	                pizza.addIngrediente(ingred);
	            } else if (opcao == 2) {
	                pizza.removerIngrediente();
	            } else {
	                for (Ingrediente ingredienteFabrica : cardapio.getIngredientes_fabrica()) {
	                    if (!pizza.contemIngrediente(ingredienteFabrica)) {
	                        naoEscolhidos.add(ingredienteFabrica.getNome());
	                    }
	                }

	                if (pizza.getIngredientes().ponteiro > -1) {
	                    Scanner t = new Scanner(System.in);
	                    System.out.print("\nQual será o nome da sua pizza? Digite aqui: ");
	                    String nome = t.nextLine();
	                    pizza.setNome(nome);
	                    // Adicionar a pizza no cardapio
	                    this.cardapio.adicionarPizzaCardapio(pizza);

	                    for (Ingrediente ii : pizza.getIngredientes().getVetor()) {
	                        if (ii != null) {
	                            baseDados.addIngredientes(ii.getNome());
	                        }
	                    }
	                    System.out.print("\nA Pizza \"" + nome + "\" foi finalizada!");
	                    break;
	                } else {
	                    System.out.print("\nCriação não finalizada. A pizza deve receber até 5 ingredientes.\n");
	                    break;
	                }
	            }
	            System.out.println("");
	            System.out.println("1) Adicionar ingrediente");
	            System.out.println("2) Remover/desfazer ingrediente ");
	            System.out.println("3) Concluir a criação");
	            System.out.println("");
	            System.out.println("Escolha uma opção: ");
	            opcao = sc.nextInt();
	        }
	    }
	    System.out.println("");
	    System.out.println("\nIngredientes não escolhidos:");
	    for (String ingrediente : naoEscolhidos) {
	        System.out.println(ingrediente);
	    }
	}
			
	 public void exibirEstatisticas() {
	        System.out.println("Quantidade de pizzas servidas: " + baseDados.retornarQtdServidosItem());
	        System.out.println("Quantidade média de ingredientes por pizza: " + baseDados.getMediaIngredientes());
	        System.out.println("Ingrediente mais pedido: " + baseDados.ingredienteMaisUtlizado());

	
	}

	public void criarPedido() {
		if(this.cardapio.getPizzas().isEmpty()){
			System.out.print("\nLamento, não temos pizzas cadastradas!");
			System.out.println("");
		}
		else {
		this.cardapio.imprimirPizzas();
		System.out.println("");
		Scanner sc= new Scanner(System.in);
		System.out.println("Escolha a opção do pedido: ");
		int dado = sc.nextInt();
		System.out.println("Escolha o número da mesa: ");
		int dado2 = sc.nextInt();
		
		Pedido pedido = new Pedido(this.cardapio.getPizzas().get(dado),dado2);
		this.pedidos.add(pedido);
		
		for(Pedido p: this.pedidos) {
			iniciarPedido(p);
		}
		this.imprimirPedido();
		}
		
	}
	public boolean verificarStatus(int numero) {
		for(Pedido p: this.pedidos) {
			if(p.getNumero_mesa()==numero) {	
			return	p.status_pedido;
			}
			System.out.print(p.isStatus_pedido());
		}
		return false;
	}
	
	public Pedido buscarPedido(int numeroMesa) {
		for(Pedido p:this.pedidos) {
			if(p.getNumero_mesa()==numeroMesa) {
				return p;
			}
			
		}
		return null;
	}
	
	public void iniciarPedido(Pedido p) {
	    Thread threadMultiplicador = new Thread(p);
	    threadMultiplicador.start();

		
	}
	
	public void servirPedido() {
		this.imprimirPedido();
		System.out.print("Digite aqui o número da mesa: ");
		Scanner sc = new Scanner(System.in);
		int numero_msa= sc.nextInt();
		if(!this.verificarStatus(numero_msa)) {
			if(buscarPedido(numero_msa)== null) {
				System.out.print("\nO pedido não está pronto ainda! \n");
			}else {
				System.out.print("\nO pedido não está pronto ainda! \n");
			}
			

		}
		else {
			if(buscarPedido(numero_msa)==null) {
				System.out.print("\nParece que o pedido não existe. Tente novamente! \n");
				
			}
			else {
				//this.baseDados.incrementarQuantidadePizza();
				Pedido p =  buscarPedido(numero_msa);
				System.out.println("");
				System.out.print("Pedido entregue a mesa: "+ p.getNumero_mesa() + " | " +  "A pizza do sabor: " + p.getPizza().getNome());
				this.pedidos.remove(p);
				this.baseDados.addIncrementa();	
			}
			
		}
		
		
	}

	public void adicionarIngredienteCardapio(String nome) {
		 if(this.verificarIngrediente(nome))
		 {
			 System.out.print("\nO ingrediente já existe! \n \n ");
		 }else {
			 this.cardapio.getIngredientes_fabrica().add(new Ingrediente(nome));
			 System.out.print("\n Ingrediente adicionado com sucesso! \n ");
			 //System.out.print(this.cardapio.getIngredientes_fabrica());
			 baseDados.addIngredientes(nome);
			// baseDados.incrementarIngrediente();
			 //baseDados.getDados_ingredientes_totais().add(nome);
			 
		 }

	}
	private boolean verificarIngrediente(String nome) {
		for(Ingrediente i: this.cardapio.getIngredientes_fabrica() ) {
			if(i.getNome().equals(nome)) {
				return true;
			}
		}
	return false;
	}
	
	private Ingrediente buscarIngredientePor(int id) {
		return this.cardapio.getIngredientes_fabrica().get(id);
	}
	private void imprimirPedido() {
		for(Pedido p : this.pedidos) {
			System.out.print("\n Pedidos atuais: "+p+" \n");
		}
	}
	

}

