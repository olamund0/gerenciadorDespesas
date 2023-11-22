package facisa;

import java.util.ArrayList;

public class GerenciadorDespesas {
	
	ArrayList<Despesa> listaDespesas = new ArrayList<Despesa>();

	
	public void adicionarDespesa(Despesa despesa) {
		listaDespesas.add(despesa);
	}

	public void removerDespesa(String nome) {
		
		for(Despesa d : listaDespesas) {			
			if(d.getNome().equalsIgnoreCase(nome)) {
				listaDespesas.remove(d);
				System.out.println("Despesa removida!");
				break;
			} 
		}
		
	}
	
	public void limparDespesa() {
		listaDespesas.clear();
	}
	
	public double calcularCustoMensal() {
		double produto = 0;
		double soma = 0;
		
		for(Despesa d : listaDespesas) {
			
			produto = d.getValor() * d.getRecorrencia();
			
			soma += produto;	
		}
		
		return soma;
		
	}
	
	public Despesa getMaiorDespesa() {
		double produto = 0; 
		double maior = 0;
		Despesa maiorDespesa = null;
		
		for(Despesa d : listaDespesas) {
			produto = d.getValor() * d.getRecorrencia();
			
			if(produto > maior) {
				maior = produto;
				maiorDespesa = new Despesa(d.getNome(), d.getValor(), d.getRecorrencia());
			}
		}
		
		return maiorDespesa;
	}
	
	public void descreveDespesa() {	
		System.out.println("Despesas: ");
			
		for(Despesa d : listaDespesas) {
			System.out.println("\nNome: "+ d.getNome());
			System.out.println("Valor: "+ d.getValor());
			System.out.println("Recorrencia: "+ d.getRecorrencia());
		}
	}
	
}


