package Controllers;

import java.util.Scanner;

import Classes.Clube;
import Classes.Clube1divisao;
import Classes.Clube2divisao;
import Classes.Federacao;
import Classes.Jogador;
import Classes.Repositorio;
import Classes.Treinador;
import Exceptions.ArgumentoInvalidoException;
import Exceptions.ElementoRepetidoException;
import View.Viewer;

public class Controller {
	
	
	Treinador treinador = null;	
	Scanner scanf = new Scanner(System.in);
	Repositorio repo = new Repositorio();
	Viewer view = new Viewer();
	/**
	 * @throws ElementoRepetidoException 
	 * @apiNote Cria um jogador com os dados passados pelo usuário.
	 */
	public void criarJogador() throws ElementoRepetidoException {
		String nome; String posicao; String time;
		int idade; int numero;
		double salario;
		scanf.nextLine();
		System.out.println("Nome do jogador:");
		nome = scanf.nextLine();
		scanf.nextLine();
		System.out.println("Idade do jogador:");
		idade = scanf.nextInt();
		System.out.println("Salário do jogador:");
		salario = scanf.nextDouble();
		System.out.println("Posição que ele joga:");
		posicao = scanf.next();
		scanf.nextLine();
		System.out.println("E por ultimo o seu número da camisa:");
		numero = scanf.nextInt();
		
		Jogador jogador = new Jogador(nome , idade , salario , posicao , numero);
		repo.adicionaJogador(jogador);
		System.out.println("Jogador " + jogador.getNome() + " criado com sucesso!");
		
	}
	
	/**
	 * @throws ElementoRepetidoException 
	 * @apiNote Cria um treinador com os dados passados, e adiciona o mesmo a uma lista de treinadores gerais.
	 */
	public void criaTreinador() throws ElementoRepetidoException {
		String nome; String time; String licensa;
		double salario;
		int idade; 
		scanf.nextLine();
		System.out.println("Informe o nome do treinador");
		nome = scanf.nextLine();
		scanf.nextLine();
		System.out.println("Idade do treinador: ");
		idade = scanf.nextInt();
		System.out.println("Agora o salário:");
		salario = scanf.nextDouble();
		
		System.out.println("Sua licensa");
		licensa = scanf.next();
		scanf.nextLine();
		treinador = new Treinador(nome , idade , salario , licensa);
		repo.adicionaTreinador(treinador);
		System.out.println("Treinador " + treinador.getNome() + " criado com sucesso!" );
	}
	
	/**
	 * @apiNote Cria uma nova federaçao caso o nome da mesma seja unico.
	 * @throws ElementoRepetidoException
	 */
	public void criarFederacao() throws ElementoRepetidoException {
		scanf.nextLine();
		String nomeFederacao;
		System.out.println("Informe o nome da nova federaçao");
		nomeFederacao = scanf.nextLine();
		scanf.nextLine();
		Federacao federa = new Federacao(nomeFederacao);
		repo.adicionaFederacao(federa);
		
	}
	
	/**
	 * @apiNote Cria um time baseado na sua divisão e com todos os atributos de um clube, e automaticamente insere em sua 
	 * 			federação adicionando aos times de cada federação.
	 * @throws ElementoRepetidoException
	 */
	public void criaTime() throws ElementoRepetidoException {
		
		Treinador treinador; 
		Federacao federacao;
		
		String presidente;
		String cidade; 
		String treinadorNome;
		String nomeFederacao;
		double saldo;
		int divisao;
		scanf.nextLine();
		System.out.println("Informe a divisao do time que deseja criar , 1 para primeira 2 para segunda:");
		divisao = scanf.nextInt();
		
		System.out.println("Agora o nome do novo clube");
		String nomeClube =scanf.next();
		scanf.nextLine();
		
		System.out.println("Informe o nome do treinador do seu time");
		treinadorNome = scanf.nextLine();
		scanf.nextLine();
		treinador = repo.buscaTreinador(treinadorNome);
		if(treinador == null) {
			System.out.println("Treinador inexistente, crie " + treinadorNome + " para continuar.");
			return;
		}
		
		System.out.println("Informe a federação que seu clube pertence");
		nomeFederacao = scanf.nextLine();
		scanf.nextLine();
		federacao = repo.buscaFederacao(nomeFederacao);
		if(federacao == null) {
			System.out.println("Federação inexistente, crie " + nomeFederacao + " para continuar.");
			return;
		}
		
		System.out.println("Qual o nome do presidente do : " + nomeClube + " :");
		presidente = scanf.nextLine();
		scanf.nextLine();
		System.out.println(nomeClube + " é de qual cidade");
		cidade = scanf.nextLine();
		scanf.nextLine();
		System.out.println("O saldo inicial do seu clube:");
		saldo = scanf.nextDouble();
		
		if(divisao == 1) {
			Clube1divisao clube = new Clube1divisao(nomeClube,treinador,federacao,presidente,cidade,saldo);
			
			federacao.adicionaClube(clube);
			repo.adicionaCLube1Divisao(clube);
			treinador.setClube(clube);
			System.out.println("Time de primeira divisao criado com sucesso e adicionada a sua federação!");
		}
		if(divisao == 2) {
			Clube2divisao clube = new Clube2divisao(nomeClube,treinador,federacao,presidente,cidade,saldo);
			federacao.adicionaClube(clube);
			repo.adicionaCLube2Divisao(clube);
			treinador.setClube(clube);
			System.out.println("Time de segunda divisao criado com sucesso e adicionada a sua federação!");
			
		}
		
	}
	
	/**
	 * 
	 * @param federacao Nome da Federação a qual o time que quer remover pertence.
	 * @param nomeClube Nome do clube a ser removido.
	 *  Busca pela federação e pelo clube, apos encontrar remove o clube da federação passada.
	 */
	public void deletaClube(String federacao, String nomeClube) {
		Federacao federacaoDeleta = repo.buscaFederacao(federacao);
		if(federacaoDeleta == null) {
			System.out.println("Federação inexistente!");
			return;
		}
		boolean remove = federacaoDeleta.removeClube(nomeClube);
		if(remove) {
			System.out.println("Clube deletado com sucesso!");
		}else {
			System.out.println("Erro ao deletar o clube: " + nomeClube+".");
		}
	}
	
	/**
	 * 
	 * @param nome Nome do treinador a ser deletado.
	 * @apiNote Busca tanto no geral como nos clubes para achar onde o treinador atua, o remove do time setando o atributo Treinador como
	 * 			NULL e remove do quadro geral de teinadores.
	 */
	public void deletaTreinador(String nome) {
		Treinador deletaTreinador = repo.buscaTreinador(nome);
		
		if(deletaTreinador == null) {
			System.out.println("impossivel deletar treinador : ErrorCntroller");
			return;
		}
		if(repo.removeTreinador(nome)){
			System.out.println("Treinador removido com sucesso!");
			return;
		}else {
			System.out.println("impossivel deletar treinador : ErrorCntroller");
			return;
		}
		
		
	}
	
	/**
	 * @apiNote Deleta jogador pelos dados passados.
	 */
	public void deletaJogador() {
		System.out.println("Informe o nome do jogador a ser removido:");
		String nomeJogadorRemove = scanf.nextLine();
		scanf.nextLine();
		boolean removed = repo.deletaJogadorPeloNome(nomeJogadorRemove);
		
		if(removed) {
			System.out.println("Jogador removido!!");
			return;
		}
		System.out.println("Nao foi possivel remover jogador!");
		return;
	}
	
	/**
	 * 
	 * @param nome Nome do clube a ser removido tanto dos grupos gerais quanto da sua respectiva federação.
	 */
	public void deletaCLube(String nome) {
		Clube clube = repo.buscaClube(nome);
		if(clube == null) {
			System.out.println("Erro ao deletar clube : controller");
			return;
		}
		if(repo.removeClube(clube)) {
			System.out.println("Clube removido com sucesso!");	
			return;
		}
		System.out.println("Impossivel remover : repositorioError");
		return;
	}
	
	/**
	 * 
	 * @param nome Nome da federação a ser removida.
	 */
	public void deletaFederacao(String nome) {
		boolean removed = repo.removeFederacao(nome);
		
		if(removed) {
			System.out.println("Federação removida com sucesso!");
			return;
		}else {
			System.out.println("Erro ao remover federação!");
			return;
		}
	}
	
	/**
	 * 
	 * @param nomeJogador Nome do jogador para ser atualizadas as informações : Nome, Posicao, Numero da camisa.
	 */
	public void atualizarJogador(String nomeJogador) {
		
		Jogador jogadorUpdate = repo.buscaJogador(nomeJogador);
		if(jogadorUpdate == null) {
			System.out.println("Impossivel atualizar jogador : controllerError");
			return;
		}else {
			System.out.println("encontrou no controller " + jogadorUpdate.getNome());
		}
		
//		Jogador jogadorAuxiliar = new Jogador();
//		jogadorAuxiliar = jogadorUpdate;
		
		scanf.nextLine();
		System.out.println("Informe o novo nome");
		String novoNome = scanf.nextLine();
		scanf.nextLine();
		System.out.println("novo nome " + novoNome);
		
		System.out.println("Agora a posição do jogador.");
		String novaPosicao = scanf.next();
		
		System.out.println("E o novo numero da camisa:");
		int novoNumero = scanf.nextInt();
		
		jogadorUpdate.setNome(novoNome);
		try{
			jogadorUpdate.trocarCamisa(novoNumero);
		}catch(ArgumentoInvalidoException args) {
			args.getMessage();
		}
			
		jogadorUpdate.setPosicao(novaPosicao);
		
		boolean atualizado = repo.atualizaJogador(nomeJogador,jogadorUpdate);
		if(atualizado) {
			System.out.println("Jogador " + jogadorUpdate.getNome() +" atualizado com sucesso!");
			jogadorUpdate.show();			
		}else {
			System.out.println("Erro ao atualizar o jogador!");
		}
		
	}
	
	/**
	 * 
	 * @param nomeFederacao Nome da federação a ser atualizada.
	 */
	public void atualizarFederacao(String nomeFederacao) {
		Federacao federacaoAtualiza = repo.buscaFederacao(nomeFederacao);
		if(federacaoAtualiza == null) {
			System.out.println("Erro ao atualizar federação");
			return;
		}
		System.out.println("Informe o novo nome da federação: " + federacaoAtualiza.getNome());
		String novoNome = scanf.nextLine();
		federacaoAtualiza.setNome(novoNome);
	
		int index = repo.indexFederacaoEncontrada(federacaoAtualiza);
		if(index == -1) {
			System.out.println("Erro ao atualizar a federação");
			return;
		}
		boolean atualizado = repo.atualizaFederacao(index, federacaoAtualiza);
		if(atualizado) {
			System.out.println("Federação atualizada com sucesso com novo nome: " + federacaoAtualiza.getNome() +".");
		}else {
			System.out.println("Erro ao atualizar a federação.");
		}
	}
	
	/**
	 * 
	 * @param nome Nome do clube a ser atualizado
	 * @throws ElementoRepetidoException 
	 */
	public void atualizarClube(String nome) throws ElementoRepetidoException {
		Clube1divisao clubePrimeira = repo.buscaClube1Divisao(nome); 
		Clube2divisao clubeSegunda = repo.buscaClube2Divisao(nome); 	
		Clube aux = null;
		int verificaDivisao = 0;
		
		if( clubePrimeira != null) {
			verificaDivisao = 1;
			if(repo.removeClube(clubePrimeira)) {
				aux = clubePrimeira;
			
			}
		}
		if( clubeSegunda!= null) {
			verificaDivisao = 2;
			if(repo.removeClube(clubeSegunda)) {
				aux = clubeSegunda;
				
			}
		}
		scanf.nextLine();
		System.out.println("informe o novo nome do Clube");
		String novoNome = scanf.nextLine();
		scanf.nextLine();
		System.out.println("novo nome clube : " + novoNome);
		switch(verificaDivisao) {
			case 1:
				aux.setNome(novoNome);
				repo.adicionaCLube1Divisao((Clube1divisao)aux);
				
				break;
			case 2:
				aux.setNome(novoNome);
				repo.adicionaCLube2Divisao((Clube2divisao)aux);
				break;
				
			default:
				System.out.println("Clube nã encontrado!: errorController");
				break;
		}
		System.out.println("Clube atualizado com sucesso");
		
		if(verificaDivisao == 1) 
		{
			aux.show();
		}
		
		if(verificaDivisao == 2) 
		{
			aux.show();
		}
	}
	
	/**
	 * 
	 * @param nome Nome do treinador que quer atualizar.
	 * @throws ElementoRepetidoException 
	 */
	public void atualizaTreinador(String nome ) throws ElementoRepetidoException {
		Treinador treinadorUpdate = repo.buscaTreinador(nome);
		if(treinadorUpdate == null) {
			System.out.println("Treinador não encontrado!");
			return;
		}
		boolean removed = repo.removeTreinador(treinadorUpdate.getNome());
		if(!removed) {
			System.out.println("Imposssivel remover : errorControler-Repositorio");
			return;
		}
		
		System.out.println("Informe o novo nome do treinador");
		
		String novoNome = scanf.nextLine();
		scanf.nextLine();
		System.out.println("novo nome controler : " + novoNome);
		
		treinadorUpdate.setNome(novoNome);
		System.out.println("Informe a nova licensa do " + treinadorUpdate.getNome());
		String novaLicensa = scanf.nextLine();
		scanf.nextLine();
		treinadorUpdate.setLicensa(novaLicensa);
		repo.adicionaTreinador(treinadorUpdate);
		System.out.println("Treinador atualizado com sucesso : controler");
	}
	
	
	
	/**
	 * 
	 * @param nome Nome do jogador a ser procurado.
	 */
	public void buscaJogador(String nome) {
		view.mostraJogador(nome);
	}
	
	/**
	 * 
	 * @param nome Nome do treinador a ser buscado.
	 */
	public void buscaTreinador(String nome) {
		view.mostraTreinador(nome);
	}
	
	/**
	 * 
	 * @param nome Nome do clube a ser buscado.
	 */
	public void buscaClube(String nome) {
		view.mostraClube(nome);
	}
	
	public Clube retornaClube(String nome) {
		return repo.buscaClube(nome);
	}
	
	/**
	 * 
	 * @param nome Nome da federação a ser procurada
	 */
	public void buscaFederacao(String nome) {
		view.mostraFederacao(nome);
	}
	
	/**
	 * 
	 * @param nomeClube Nome do clube 
	 * @return Retorna o clube ou null caso não encontre.
	 */
	public Clube buscaClubeParaAdicionar(String nomeClube) {
		Clube clubeAdiciona = repo.buscaClube(nomeClube);
		return clubeAdiciona;
	}
	
	/**
	 * 
	 * 
	 * @param nomeJogador Nome do jogador a ser procurado
	 * @return retorna o jogador ou null caso não encontre.
	 */
	public Jogador buscaJogadorParaAdiocionar(String nomeJogador) {
		Jogador jogadorAdicionar = repo.buscaJogador(nomeJogador);
		return jogadorAdicionar;
	}
	
	public void RealizaTransferencia(String time1 ,String time2 , String jogador) throws ElementoRepetidoException {
		if(repo.realizaTransferencia(time1, time2, jogador)) {
			System.out.println("Sucesso na transferencia");
			return;
		}
		System.out.println("erro");
		return;
	}
}
