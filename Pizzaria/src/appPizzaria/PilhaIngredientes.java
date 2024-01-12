package appPizzaria;

public class PilhaIngredientes {
	public Ingrediente[] vetor;
	public int ponteiro;

	public PilhaIngredientes() {
		this.ponteiro = -1;// a pilha esta vazia na posicao -1
		this.vetor = new Ingrediente[5]; // 5 posicoes

	}

	public Ingrediente[] getVetor() {
		return vetor;
	}

	public void setVetor(Ingrediente[] vetor) {
		this.vetor = vetor;
	}

	public int getPonteiro() {
		return ponteiro;
	}

	public void setPonteiro(int ponteiro) {
		this.ponteiro = ponteiro;
	}
	/**
	 * retorna se pilha esta vazio ou n�o
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (this.ponteiro == -1) {
			return true;
		}
		return false;
	}

	public int tamanho() {
		if (this.isEmpty()) {
			return 0;
		}
		return this.ponteiro + 1;
	}

	public void adicionar(Ingrediente valor) {
		if (this.ponteiro < this.vetor.length - 1) {
			this.ponteiro++;
			this.vetor[ponteiro] = valor;
			System.out.print("\nIngrediente salvo com sucesso! \n ");
			System.out.println("");
		}
		else {
			System.out.print("\nLimite de ingredientes atingido! \n ");
			System.out.println("");
		}
	}
	public void remover() {
		if (this.ponteiro != -1 && this.ponteiro <= this.vetor.length - 1) {
			this.vetor[this.ponteiro]=null;
			this.ponteiro--;
			System.out.print("\nIngrediente eliminado com sucesso! \n ");
			System.out.println("");

		}
		else {
			System.out.print("\nNão existe esse ingrediente para ser removido! \n ");
			System.out.println("");
		}
		
	}
	
	public void imprimir() {
		for(Ingrediente v: vetor ) {
			if(v!=null) {
				System.out.println(v.getNome());
			}
		}
	}
}

