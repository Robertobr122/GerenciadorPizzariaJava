package appPizzaria;

public class Pedido implements Runnable {
	
	Pizza pizza;
	int numero_mesa;
	int numero_pedido;
	boolean status_pedido=false;
	public Pedido(Pizza pizza, int numero_mesa) {
		this.pizza=pizza;
		this.numero_mesa=numero_mesa;
		
	}
	
	public String toString() {
		return "Número da mesa: " + this.getNumero_mesa()+ " | " + "Pizza escolhida: " + this.pizza.getNome();
	}

	public int getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(int numero_pedido) {
		this.numero_pedido = numero_pedido;
	}


	public boolean isStatus_pedido() {
		return status_pedido;
	}

	public void setStatus_pedido(boolean status_pedido) {
		this.status_pedido = status_pedido;
	}

	public Pizza getPizza() {
		return pizza;
	}
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	public int getNumero_mesa() {
		return numero_mesa;
	}
	public void setNumero_mesa(int numero_mesa) {
		this.numero_mesa = numero_mesa;
	}

	@Override
	public void run() {
		this.status_pedido=true;	
	}
	
}

