package Classes;

import java.util.Scanner;

import javax.swing.JOptionPane;

import Controllers.Controller;
import Exceptions.ArgumentoInvalidoException;
import Exceptions.ElementoRepetidoException;
import View.Viewer;

public class MainInterativa {

	public static void main(String[] args) throws ElementoRepetidoException, ArgumentoInvalidoException {
		
		Controller controle = new Controller();
		Scanner scanf = new Scanner(System.in);
		Viewer visao = new Viewer();
		
		JOptionPane.showMessageDialog(null,"COMANDOS:\n"
				+ " 1 / 'criaJogador'- Cria um jogador passando seus dados.\n"
				+ " 2 / 'criaTreinador' -  Cria treinador com os dados passados.\n"
				+ " 3 / 'criaClube' - Cria um clube com os dados passados.\n"
				+ " 4 / 'deletaJogador' - Deleta jogador pelo seu nome.\n"
				+ " 5 / 'criaFederacao ' - Cria uma federaçãao pelo nome.\n"
				+ " 6 / 'deletaClube' - Deleta um clube pelo seu nome.\n"
				+ " 7 / 'deletaTreinador' - Deleta treinador pelo seu nome\n "
				+ " 8 / 'deletaFederacao' - Deleta federação pelo seu nome.\n"
				+ " 9 / 'atualizaJogador' - Atualiza alguns dados do jogador passado.\n"
				+ " 10 / 'atualizaTreinador' - Atualiza o treinador seguindo os passos dados.\n"
				+ " 11 / 'atualizaClube' - Atualiza um time com os dados pedidos.\n "
				+ " 12 / 'atualizaFederacao' - Atualiza uma federação com os dados pedidos.\n  "
				+ " 13 / 'buscaJogador' - Busca jogador pelo seu nome.\n"
				+ " 14 / 'buscaTreinador' - Busca Treinador pelo seu nome.\n"
				+ " 15 / 'buscaClube' - Busca clube pelo nome.\n  "
				+ " 16 / 'buscaFederacao' - Busca federação pelo seu nome.\n "
				+ " 17 / 'contrataJogador' - Realiza a contratação de um jogador previamente criado.\n"	
				+ " 18 / 'demiteJogador' - Faz a demissao de um jogador previamente contratado.\n"
				+ " 19 / 'transfereJogador' - Faz a transferencia de um time pra outro.\n"
				+ " 20 / 'comandos' - Mostra novamente os comandos.\n ");
		
		System.out.println("INFORME UM COMANDO VÁLIDO.");
		String comando = scanf.nextLine();
	
		while(comando != "exit") {
			switch(comando) {
			
			
				case "1":
					controle.criarJogador();
					comando = "";
					break;
					
				case "2":
					controle.criaTreinador();
					comando = "";
					break;
					
				case "3":
					controle.criaTime();
					comando = "";
					break;
					
				case "5":
					controle.criarFederacao();
					comando = "";
					break;
					
				case "4":
					controle.deletaJogador();
					comando = "";
					break;
					
				
				case "6":
					System.out.println("Informe o nome do clube a ser deletado:");
					String nomeClubeDeleta = scanf.nextLine();
					
					controle.deletaCLube(nomeClubeDeleta);
					comando = "";
					break;
					
				
				case "7":
					System.out.println("Informe o nome do treinador a ser removido:");
					String nomeTreinador = scanf.nextLine();
					controle.deletaTreinador(nomeTreinador);
					comando = "";
					break;
					
				case "8":
					System.out.println("Informe o nome da federação a ser removida:");
					String nomeFederacao = scanf.nextLine();
					controle.deletaFederacao(nomeFederacao);
					comando = "";
					break;
					
				
				case "9":
					scanf.nextLine();
					System.out.println("Informe o nome do jogador a ser atualizado:");
					String nomeJogadorAtualiza = scanf.nextLine();
					scanf.nextLine();
					controle.atualizarJogador(nomeJogadorAtualiza);
					comando = "";
					break;
			
				
				case "10":
					System.out.println("Informe o nome do treinador a ser atualizado:");
					String nomeTreinadorAtualiza = scanf.nextLine();
					scanf.nextLine();
					controle.atualizaTreinador(nomeTreinadorAtualiza);
					comando = "";
					break;
				
					
				case "11":
					System.out.println("Informe o nome do clube a ser atualizado");
					String nomeClubeAtualizar = scanf.nextLine();
					scanf.nextLine();
					controle.atualizarClube(nomeClubeAtualizar);
					comando = "";
					break;
					
				
				case "12":
					System.out.println("Informe o nome da federação a ser  atualizada:");
					String nomeFederacaoAtualiza = scanf.nextLine();
					scanf.nextLine();
					controle.atualizarFederacao(nomeFederacaoAtualiza);
					comando = "";
					break;
					
				
				case "13":
					scanf.nextLine();
					int opcao;
					System.out.println("Deseja buscar por nome ou ver todos os jogadores cadastrados?");
					System.out.println("1 - por nome, 2 - Geral");
					opcao=scanf.nextInt();
					scanf.nextLine();
					switch (opcao) {
					case 1:
						System.out.println("Nome do jogador a ser procurado:");
						String nomeJogador = scanf.nextLine();
						scanf.nextLine();
						controle.buscaJogador(nomeJogador);
						scanf.nextLine();
						comando = "";
						break;
					
					case 2:
						visao.mostraJogadores();
						comando = "";
						scanf.nextLine();
						break;
					default:
						comando = "";
						break;
					}
					break;
					
			
				case "14":
					scanf.nextLine();
					int opcao1;
					System.out.println("Deseja buscar por nome ou ver todos os treinadores cadastrados?");
					System.out.println("1 - por nome, 2 - Geral");
					opcao1=scanf.nextInt();
					scanf.nextLine();
					switch (opcao1) {
					case 1:
						System.out.println("Informe o nome do treinador a ser procurado.");
						String treinadorBusca = scanf.nextLine();
						controle.buscaTreinador(treinadorBusca);
						comando = "";
						break;
					
					case 2:
						visao.mostraTreinadores();
						scanf.nextLine();
						comando = "";
						break;
					default:
						
						break;
					}
					
					comando = "";
					break;
					
				
				case "15":
					scanf.nextLine();
					int opcao2;
					System.out.println("Deseja buscar por nome ou ver todos os clubes cadastrados?");
					System.out.println("1 - por nome, 2 - Geral");
					opcao2=scanf.nextInt();
					scanf.nextLine();
					switch (opcao2) {
					case 1:
						String nomeClubeBuscar;
						System.out.println("Informe o nome do clube a ser procurado");
						nomeClubeBuscar = scanf.nextLine();
						scanf.nextLine();
						controle.buscaClube(nomeClubeBuscar);
						scanf.nextLine();
						comando = "";
						break;
					
					case 2:
						visao.mostraClubes();
						scanf.nextLine();
						comando = "";
						break;
					default:
						comando = "";	
						break;
					}
					
					break;
					
					
				case "16":
					scanf.nextLine();
					int opcao3;
					System.out.println("Deseja buscar por nome ou ver todos as federações cadastrados?");
					System.out.println("1 - por nome, 2 - Geral");
					opcao3=scanf.nextInt();
					scanf.nextLine();
					switch (opcao3) {
					case 1:
						String nomeFederacaoBuscar;
						System.out.println("Informe o nome da federação a ser procurada");
						
						nomeFederacaoBuscar = scanf.nextLine();
						controle.buscaFederacao(nomeFederacaoBuscar);
						scanf.nextLine();
						comando = "";
						break;
					
					case 2:
						visao.mostraFederacoes();
						scanf.nextLine();
						comando = "";
						break;
					default:
						comando = "";
						break;
					}
					break;
						
				case "17":
					System.out.println("Nome do clube para adicionar o jogador");
					String nomeClubeAdcJogador = scanf.nextLine();
					scanf.nextLine();
					Clube clube = controle.buscaClubeParaAdicionar(nomeClubeAdcJogador);
					if(clube  == null ) {
						System.out.println("Clube inexistente.");
						comando ="";
						break;
					}
					System.out.println("Informe o nome do jogador a ser adicionado no clube: " + clube.getNome());
					String nomeJogadorAdicionar = scanf.nextLine();
					scanf.nextLine();
					Jogador jogadorParaAdicionar = controle.buscaJogadorParaAdiocionar(nomeJogadorAdicionar);
					if(jogadorParaAdicionar == null) {
						System.out.println("Não foi possivel adicionar o jogador.");
						comando ="";
						break;
					}
					System.out.println("Jogador: " + jogadorParaAdicionar.getNome() + " adicionado ao clube: " + clube.getNome());
					clube.contrataJogador(jogadorParaAdicionar);
					jogadorParaAdicionar.setTime(clube);
					comando = "";
					break;
					
				case "18":
					System.out.println("Nome do clube para demitir o jogador");
					String nomeClubeRemoveJogador = scanf.nextLine();
					scanf.nextLine();
					Clube clubeRemove = controle.retornaClube(nomeClubeRemoveJogador);
					if(clubeRemove  == null ) {
						System.out.println("Clube inexistente.");
						comando ="";
						break;
					}
					System.out.println("Nome do jogador para remover do : " + clubeRemove.getNome());
					String nomeJogadorRemove = scanf.nextLine();
					scanf.nextLine();
					Jogador jogadorRemove = clubeRemove.buscaJogador(nomeJogadorRemove);
					
					if(jogadorRemove == null) {
						System.out.println("Jogador nao encontrado");
						comando ="";
						break;
					}

					if(clubeRemove.demiteJogador(nomeJogadorRemove)) {
						System.out.println("Jogador removido com sucesso!");
						jogadorRemove.setTime(null);
						comando ="";
						break;
					}
					System.out.println("Erro ao remover Jogador!");
					comando ="";
					break;
					
				case "19":
					scanf.nextLine();
					System.out.println("Nome do time que vende");
					String timeVende = scanf.nextLine();
					scanf.nextLine();
					System.out.println("Nome do time que compra ");
					String timeCompra = scanf.nextLine();
					scanf.nextLine();
					System.out.println("Nome do jogador");
					String nomeJogadorVendido = scanf.nextLine();
					scanf.nextLine();
					
					controle.RealizaTransferencia(timeVende, timeCompra, nomeJogadorVendido);
					
					comando = "";
					break;
					
				case "20":
					JOptionPane.showMessageDialog(null,"COMANDOS:\n"
							+ " 1 / 'criaJogador'- Cria um jogador passando seus dados.\n"
							+ " 2 / 'criaTreinador' -  Cria treinador com os dados passados.\n"
							+ " 3 / 'criaClube' - Cria um clube com os dados passados.\n"
							+ " 4 / 'deletaJogador' - Deleta jogador pelo seu nome.\n"
							+ " 5 / 'criaFederacao ' - Cria uma federaçãao pelo nome.\n"
							+ " 6 / 'deletaClube' - Deleta um clube pelo seu nome.\n"
							+ " 7 / 'deletaTreinador' - Deleta treinador pelo seu nome\n "
							+ " 8 / 'deletaFederacao' - Deleta federação pelo seu nome.\n"
							+ " 9 / 'atualizaJogador' - Atualiza alguns dados do jogador passado.\n"
							+ " 10 / 'atualizaTreinador' - Atualiza o treinador seguindo os passos dados.\n"
							+ " 11 / 'atualizaClube' - Atualiza um time com os dados pedidos.\n "
							+ " 12 / 'atualizaFederacao' - Atualiza uma federação com os dados pedidos.\n  "
							+ " 13 / 'buscaJogador' - Busca jogador pelo seu nome.\n"
							+ " 14 / 'buscaTreinador' - Busca Treinador pelo seu nome.\n"
							+ " 15 / 'buscaClube' - Busca clube pelo nome.\n  "
							+ " 16 / 'buscaFederacao' - Busca federação pelo seu nome.\n "
							+ " 17 / 'contrataJogador' - Realiza a contratação de um jogador previamente criado.\n"	
							+ " 18 / 'demiteJogador' - Faz a demissao de um jogador previamente contratado.\n"
							+ " 19 / 'transfereJogador' - Faz a transferencia de um time pra outro.\n"
							+ " 20 / 'comandos' - Mostra novamente os comandos.\n ");
					comando = "";
					break;
					
					default : 
						System.out.println("Informe um comando válido");
						comando = scanf.nextLine();
						break;
			}
		}
		
		scanf.close();
	}

}
