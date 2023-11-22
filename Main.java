package facisa;

public class Main {

	public static void main(String[] args) {
		GerenciadorDespesas gerenciador = new GerenciadorDespesas();
		Despesa netflix = new Despesa("netflix", 10, 2);
		Despesa primeVideo = new Despesa("prime", 15, 3);
		Despesa HBO = new Despesa("HBO MAX", 20, 2);
		Despesa NBA = new Despesa("NBA", 70, 1);
		
		//Adicione uma despesa
		
		gerenciador.adicionarDespesa(netflix);
		gerenciador.adicionarDespesa(primeVideo);
		gerenciador.adicionarDespesa(HBO);
		gerenciador.adicionarDespesa(NBA);
		
		//Printa despesas
		gerenciador.descreveDespesa();
		
		//Remover uma despesa
		System.out.println("\nRemover uma despesa:");
		gerenciador.removerDespesa("PRIME");
		
		
		//Printa despesas após remover uma
		System.out.println("\nDescrevendo após remover: ");
		gerenciador.descreveDespesa();
		
		//Custo Mensal e maior despesa
		System.out.println("\nCusto Mensal: " + gerenciador.calcularCustoMensal());
		System.out.println("\nMaior Despesa: " + "\nNome: " + gerenciador.getMaiorDespesa().getNome() +  " | Valor: " + gerenciador.getMaiorDespesa().getValor()
				+ " | Recorrência: " + gerenciador.getMaiorDespesa().getRecorrencia());
		
		
		//Apagando tudo e printando
		
		System.out.println("\nLimpar Despesas:");
		gerenciador.limparDespesa();
		
		gerenciador.descreveDespesa();
		
		
		
		
		
		
	}
}
