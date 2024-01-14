package com.funcionalidade;

import java.util.ArrayList;

import com.entidade.Despesa;

public class Gerenciador {

	private static ArrayList<Despesa> listaDespesas = new ArrayList<Despesa>();

	public static void adicionarDespesa(Despesa despesa) {
		listaDespesas.add(despesa);
	}

	public static boolean removerDespesa(String nome) {
		for (Despesa d : listaDespesas) {
			if (d.getNome().equals(nome)) {
				listaDespesas.remove(d);
				return true;
			}
		}
		return false;

	}

	public static void limparDespesa() {
		listaDespesas.clear();
	}
	
	public static boolean verificarNome(String nome) {
		for(Despesa d : listaDespesas) {
			if(d.getNome().equalsIgnoreCase(nome)) {
				return true;				
			}
		}
		return false;
	}
	
	public static double calcularCustoMensal() {
		double produto = 0;
		double soma = 0;

		for (Despesa d : listaDespesas) {
			produto = d.getValor() * d.getRecorrencia();
			soma += produto;
		}

		return soma;

	}

	public static Despesa getMaiorDespesa() {
		double produto = 0;
		double maior = 0;
		Despesa maiorDespesa = null;

		for (Despesa d : listaDespesas) {
			produto = d.getValor() * d.getRecorrencia();

			if (produto > maior) {
				maior = produto;
				maiorDespesa = d;
			}
		}

		return maiorDespesa;
	}

	public static String descreveDespesa() {
		String msg = "Despesas cadastradas: \n";
		if (listaDespesas.isEmpty()) {
			msg = "Não existem despesas cadastradas";
		} else {
			for (Despesa d : listaDespesas) {
				msg += String.format("%s | Valor: R$%.2f | Recorrência: %d\n", d.getNome(), d.getValor(),
						d.getRecorrencia());
			}
		}
		return msg;
	}
	
	public static String printarDespesa(Despesa d) {
		return String.format("%s | Valor: R$%.2f | Recorrência: %d", d.getNome(), d.getValor(),
				d.getRecorrencia());
		
	}

	public static int sizeLista() {
		return listaDespesas.size();
	}
	
	public static boolean tentarNumero(String valor) {
		try {
			Double.parseDouble(valor);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String mostrarMenu() {
		return """
				1) Listar despesas
				2) Exibir maior despesa e custo mensal
				3) Cadastrar despesa
				4) Remover uma despesa
				5) Limpar todas as despesas
				6) Sair
				\n Digite uma opção:
				""";
	}

}
