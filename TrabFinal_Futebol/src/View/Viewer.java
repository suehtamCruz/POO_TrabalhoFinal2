package View;

import Classes.Clube;
import Classes.Federacao;
import Classes.Jogador;
import Classes.Repositorio;
import Classes.Treinador;

public class Viewer {
	Clube clube = null;
	
	Federacao federacao = null;
	
	Repositorio repo = new Repositorio();
	
	/**
	 * 
	 * @param joga Nome do jogador a ser procurado.
	 */
	public void mostraJogador(String nomeJogador) {
		Jogador jogador = repo.buscaJogador(nomeJogador);
		if(jogador == null) {
			System.out.println("Erro ao ver jogador");
			return;
		}
		System.out.println("Jogador encontrado!\n");
		jogador.show();
	}
	
	/**
	 * @apiNote Mostra todos os jogadores ja criados.
	 */
	public void mostraJogadores() {
		for(Jogador joga : repo.jogadores) {
			joga.show();
		}
	}
	
	/**
	 * 
	 * @param nomeTreinador Nome do treinador a ser procurado.
	 */
	public void mostraTreinador(String nomeTreinador) {
		Treinador treina = repo.buscaTreinador(nomeTreinador);
		
		if(treina == null) {
			System.out.println("Treinador não encontrado!");
			return;
		}
		System.out.println("Treinador encontrado!\n");
		treina.show();
	}
	
	/**
	 * @apiNote Mostra todos os treinadores ja criados.
	 */
	public void mostraTreinadores() {
		for(Treinador treina : repo.treinadores) {
			treina.show();
		}
	}
	
	
	/**
	 * 
	 * @param nomeClube Nome do clube a ser procurado.
	 */
	public void mostraClube(String nomeClube) {
		Clube clubeBusca = repo.buscaClube(nomeClube);
		if(clubeBusca == null) {
			System.out.println("Clube não encontrado. view");
			return;
		}
		System.out.println("Clube encontrado!\n");
		clubeBusca.show();
	}
	
	/**
	 * @apiNote Mostra todos os clubes já criados.
	 */
	public void mostraClubes() {
		
		for(Clube club : repo.clubes) {
			club.show();
		}
	}
	
	/**
	 * 
	 * @param nomeFederacao Nome da federação a ser 
	 */
	public void mostraFederacao(String nomeFederacao) {
		Federacao federacaoBuscar = repo.buscaFederacao(nomeFederacao);
		if(federacaoBuscar == null) {
			System.out.println("Federacão não encontrada.");
			return;
		}
		System.out.println("Federação encontrada!\n");
		federacaoBuscar.show();
	}
	
	
	/**
	 * @apiNote Mostra todas as federações ja criadas.
	 */
	public void mostraFederacoes() {
		for(Federacao federa : repo.federacoes) {
			federa.show();
		}
	}
	
	
}
