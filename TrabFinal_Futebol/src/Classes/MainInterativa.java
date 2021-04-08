package Classes;

import java.util.Scanner;

import javax.swing.JOptionPane;

import Controllers.Controller;
import Exceptions.ArgumentoInvalidoException;
import Exceptions.ElementoRepetidoException;

public class MainInterativa {

	public static void main(String[] args) throws ElementoRepetidoException, ArgumentoInvalidoException {
		
		Controller controle = new Controller();
		Scanner scanf = new Scanner(System.in);

		JOptionPane.showMessageDialog(null,"COMANDOS:\n"
				+ "'criaJogador'- Cria um jogador passando seus dados.\n"
				+ "'criaTreinador' -  Cria treinador com os dados passados.\n"
				+ "'criaClube' - Cria um clube com os dados passados.\n"
				+ " 'criaFederacao' - Cria federação com os dados passados\n "
				+ " 'deletaJogador' - Deleta jogador pelo seu nome.\n"
				+ " 'deletaClube' - Deleta um clube pelo seu nome.\n"
				+ " 'deletaTreinador' - Deleta treinador pelo seu nome\n "
				+ " 'deletaFederacao' - Deleta federação pelo seu nome.\n"
				+ " 'atualizaJogador' - Atualiza alguns dados do jogador passado.\n"
				+ " 'atualizaTreinador' - Atualiza o treinador seguindo os passos dados.\n"
				+ " 'atualizaClube' - Atualiza um time com os dados pedidos.\n "
				+ " 'atualizaFederacao' - Atualiza uma federação com os dados pedidos.\n  "
				+ " '' - Busca jogador pelo seu nome.\n"
				+ " 'buscaTreinador' - Busca Treinador pelo seu nome.\n"
				+ " 'buscaClube' - Busca clube pelo nome.\n  "
				+ " 'buscaFederacao' - Busca federação pelo seu nome.\n "
				+ " 'comandos' - Mostra novamente os comandos.\n ");
		
		System.out.println("INFORME UM COMANDO VÁLIDO.");
		String comando = scanf.nextLine();
	
		while(comando != "exit") {
			switch(comando) {
			
			
				case "criaJogador":
					controle.criarJogador();
					comando = "";
					break;
					
				case "criaTreinador":
					controle.criaTreinador();
					comando = "";
					break;
					
				case "criaClube":
					controle.criaTime();
					comando = "";
					break;
					
				case "criaFederacao":
					controle.criarFederacao();
					comando = "";
					break;
					
				case "deletaJogador":
					controle.deletaJogador();
					comando = "";
					break;
					
				
				case "deletaClube":
					System.out.println("Informe o nome do clube a ser deletado:");
					String nomeClubeDeleta = scanf.nextLine();
					
					controle.deletaCLube(nomeClubeDeleta);
					comando = "";
					break;
					
				
				case "deletaTreinador":
					System.out.println("Informe o nome do treinador a ser removido:");
					String nomeTreinador = scanf.nextLine();
					controle.deletaTreinador(nomeTreinador);
					comando = "";
					break;
					
				case "deletaFederacao":
					System.out.println("Informe o nome da federação a ser removida:");
					String nomeFederacao = scanf.nextLine();
					controle.deletaFederacao(nomeFederacao);
					comando = "";
					break;
					
				
				case "atualizaJogador":
					scanf.nextLine();
					System.out.println("Informe o nome do jogador a ser atualizado:");
					String nomeJogadorAtualiza = scanf.nextLine();
					scanf.nextLine();
					controle.atualizarJogador(nomeJogadorAtualiza);
					comando = "";
					break;
			
				
				case "atualizaTreinador":
					System.out.println("Informe o nome do treinador a ser atualizado:");
					String nomeTreinadorAtualiza = scanf.nextLine();
					scanf.nextLine();
					controle.atualizaTreinador(nomeTreinadorAtualiza);
					comando = "";
					break;
				
					
				case "atualizaClube":
					System.out.println("Informe o nome do clube a ser atualizado");
					String nomeClubeAtualizar = scanf.nextLine();
					scanf.nextLine();
					controle.atualizarClube(nomeClubeAtualizar);
					comando = "";
					break;
					
				
				case "atualizaFederacao":
					System.out.println("Informe o nome da federação a ser  atualizada:");
					String nomeFederacaoAtualiza = scanf.nextLine();
					scanf.nextLine();
					controle.atualizarFederacao(nomeFederacaoAtualiza);
					comando = "";
					break;
					
				
				case "buscaJogador":
					System.out.println("Nome do jogador a ser procurado:");
					String nomeJogador = scanf.nextLine();
					scanf.nextLine();
					controle.buscaJogador(nomeJogador);
					comando = "";
					break;
					
			
				case "buscaTreinador":
					System.out.println("Informe o nome do treinador a ser procurado.");
					String treinadorBusca = scanf.nextLine();
					controle.buscaTreinador(treinadorBusca);
					comando = "";
					break;
					
				
				case "buscaClube":
					String nomeClubeBuscar;
					System.out.println("Informe o nome do clube a ser procurado");
					nomeClubeBuscar = scanf.nextLine();
					scanf.nextLine();
					controle.buscaClube(nomeClubeBuscar);
					comando = "";
					break;
					
					
				case "buscaFederacao":
					String nomeFederacaoBuscar;
					System.out.println("Informe o nome da federação a ser procurada");
					
					nomeFederacaoBuscar = scanf.nextLine();
					controle.buscaFederacao(nomeFederacaoBuscar);
					comando = "";
					break;
					
				case "contrataJogador":
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
				
					
				case "demiteJogador":
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
					
				case "transfereJogador":
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
				case "comandos":
					JOptionPane.showMessageDialog(null,"COMANDOS:\n"
							+ "'criaJogador'- Cria um jogador passando seus dados.\n"
							+ "'criaTreinador' -  Cria treinador com os dados passados.\n"
							+ "'criaClube' - Cria um clube com os dados passados.\n"
							+ " 'criaFederacao' - Cria federação com os dados passados\n "
							+ " 'deletaJogador' - Deleta jogador pelo seu nome.\n"
							+ " 'deletaClube' - Deleta um clube pelo seu nome.\n"
							+ " 'deletaTreinador' - Deleta treinador pelo seu nome\n "
							+ " 'deletaFederacao' - Deleta federação pelo seu nome.\n"
							+ " 'atualizaJogador' - Atualiza alguns dados do jogador passado.\n"
							+ " 'atualizaTreinador' - Atualiza o treinador seguindo os passos dados.\n"
							+ " 'atualizaClube' - Atualiza um time com os dados pedidos.\n "
							+ " 'atualizaFederacao' - Atualiza uma federação com os dados pedidos.\n  "
							+ " 'buscaJogador' - Busca jogador pelo seu nome.\n"
							+ " 'buscaTreinador' - Busca Treinador pelo seu nome.\n"
							+ " 'buscaClube' - Busca clube pelo nome.\n  "
							+" ' contrataJogador' - Contrata Jogador."
							+ "  demiteJogador' - Demite jogador'"
							+ " 'transfereJogador' - Transfere um jogador de um time para outro."
							+ " 'buscaFederacao' - Busca federação pelo seu nome.\n "
							+ " 'comandos' - Mostra novamente os comandos.\n ");
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
