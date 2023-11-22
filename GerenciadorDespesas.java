package facisa;

import java.util.ArrayList;

public class GerenciadorDespesas {
	
	ArrayList<Despesa> listaDespesas = new ArrayList<Despesa>();
	ArrayList<Double> custoTotal = new ArrayList<Double>();

	
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
		listaDespesas.removeAll(listaDespesas);
	}
	
	public double calcularCustoMensal() {
		
		double valor = 0;
		int recorrencia = 0;
		double produto = 0;
		
		for(Despesa d : listaDespesas) {
			valor += d.getValor();
			recorrencia += d.getRecorrencia();
			
			produto = valor * recorrencia;
			
			custoTotal.add(produto);
			
			valor = 0;
			recorrencia = 0;
			produto = 0;
			
		}
		double soma = 0;
		
		for(double d : custoTotal) {
			soma += d;			
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


