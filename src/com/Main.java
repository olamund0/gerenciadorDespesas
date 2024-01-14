package com;

import javax.swing.JOptionPane;

import com.entidade.Despesa;
import com.funcionalidade.Gerenciador;

public class Main {

	public static void main(String[] args) {

		String opcao = "1";

		while (!opcao.equals("6")) {
			opcao = JOptionPane.showInputDialog(null, Gerenciador.mostrarMenu(), "Gerenciador de despesas", 3);

			if (opcao == null) {
				opcao = "6";
			}

			else if (opcao.equals("1")) {
				JOptionPane.showMessageDialog(null, Gerenciador.descreveDespesa());

			} else if (opcao.equals("2")) {
				custoMensal();

			} else if (opcao.equals("3")) {
				cadastrarDespesa();

			} else if (opcao.equals("4")) {
				removerDespesa();

			} else if (opcao.equals("5")) {
				limparDespesas();

			} else if (opcao.equals("6")) {
				JOptionPane.showMessageDialog(null, "Obrigado por usar nosso sistema");

			} else {
				JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", 0);
			}

		}

	}

	private static void custoMensal() {
		if (Gerenciador.sizeLista() == 0) {
			JOptionPane.showMessageDialog(null, "Cadastre despesas para exibir o custo mensal e maior despesa");
		} else {
			Despesa despesa = Gerenciador.getMaiorDespesa();
			double custoMensal = Gerenciador.calcularCustoMensal();
			JOptionPane.showMessageDialog(null, "Maior despesa (" + Gerenciador.printarDespesa(despesa) + ")"
					+ String.format("\nCusto mensal de todas despesas: R$%.2f", custoMensal));

		}
	}

	private static void cadastrarDespesa() {
		String nome = JOptionPane.showInputDialog("Digite o nome da despesa: ");
		if (nome == null)
			return;

		if (Gerenciador.verificarNome(nome)) {
			JOptionPane.showMessageDialog(null, "Despesa já existente");
			return;
		}

		String valor = JOptionPane.showInputDialog("Digite o valor da despesa: ");
		if (valor == null)
			return;

		valor = valor.replace(",", ".");
		if (!Gerenciador.tentarNumero(valor)) {
			JOptionPane.showMessageDialog(null, "Valor inválido!");
			return;
		}

		String recorrencia = JOptionPane.showInputDialog("Quantas vezes ela ocorre no mês: ");
		if (recorrencia == null)
			return;

		if (!Gerenciador.tentarNumero(recorrencia)) {
			JOptionPane.showMessageDialog(null, "Valor inválido!");
			return;
		}

		Despesa novaDespesa = new Despesa(nome, Double.parseDouble(valor), Integer.parseInt(recorrencia));
		Gerenciador.adicionarDespesa(novaDespesa);
		JOptionPane.showMessageDialog(null,
				"Despesa cadastrada com sucesso! \n\n" + Gerenciador.printarDespesa(novaDespesa));

	}

	private static void removerDespesa() {
		if (Gerenciador.sizeLista() == 0) {
			JOptionPane.showMessageDialog(null, "Não existem despesas para remover");
		} else {
			String nome = JOptionPane.showInputDialog(null,
					Gerenciador.descreveDespesa() + "\nDigite o nome da despesa que deseja remover: ");

			if (Gerenciador.removerDespesa(nome)) {
				JOptionPane.showMessageDialog(null, nome + " removida com sucesso");

			} else {
				JOptionPane.showMessageDialog(null, "Despesa não encontrada");
			}
		}

	}

	private static void limparDespesas() {
		if (Gerenciador.sizeLista() == 0) {
			JOptionPane.showMessageDialog(null, "Não existem despesas para remover");

		} else {
			int num = JOptionPane.showConfirmDialog(null, "Deseja realmente remover todas despesas? Se sim, aperte YES", "Confirme",
					JOptionPane.YES_NO_OPTION);

			if (num == 0) {
				Gerenciador.limparDespesa();
				JOptionPane.showMessageDialog(null, "Despesas removidas com sucesso!");
			
			} else {
				JOptionPane.showMessageDialog(null, "Operação cancelada!");
			}
		}

	}

}
