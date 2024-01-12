package appPizzaria;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer opcao = 0;

		Pizzaria fachada = new Pizzaria();
		
		while(opcao!=6) {
				System.out.println("");
			    System.out.println("--------------------BEM VINDO A UNIPIZZARIA 🍕--------------------");
	            System.out.println("1) Criar uma pizza");
	            System.out.println("2) Criar um novo pedido");
	            System.out.println("3) Servir um pedido");
	            System.out.println("4) Adicionar ingredientes");
	            System.out.println("5) Estatísticas dos pedidos");
	            System.out.println("6) Sair");
	            System.out.println("------------------------------------------------------------------");

	            System.out.print("Digite sua opção: ");
	            System.out.print("");
	            opcao = sc.nextInt();
	            
		if(opcao==1) {
			System.out.println("Vamos criar uma pizza!");
			fachada.criarPizza();
		}
		else if(opcao==2) {
			fachada.criarPedido();
		}
		else if(opcao==3) {
			fachada.servirPedido();
		}
		
		else if(opcao==4) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Digite o ingrediente que deseja adicionar: ");
			String ing= scanner.nextLine();
			fachada.adicionarIngredienteCardapio(ing);
		}
		else if(opcao==5) {
			fachada.exibirEstatisticas();
			
		}

	}
		System.out.println("");
		System.out.print("Agradecemos por sua preferência. Volte sempre! ");
}}


