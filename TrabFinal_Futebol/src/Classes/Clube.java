package Classes;

import java.util.ArrayList;

import Exceptions.ElementoRepetidoException;

public abstract class Clube {
	
	protected double saldo;
	protected ArrayList<Jogador> jogadores = new ArrayList<Jogador>(); 
	public Treinador treinador;
	protected String presidente;
	protected String cidade;
	protected Federacao federacao;
	public String nome;
	
	public Clube(Treinador treinador ,Federacao federacao, String presidente, String cidade, double saldo) {
		this.saldo = saldo;
		this.treinador = treinador;
		this.presidente = presidente;
		this.cidade = cidade;
		
		this.federacao = federacao;
	}
	
	public abstract double getSaldo(); 
	public abstract String getNome();
	public abstract String getTreinador();
	public abstract String getPresidente();	
	public abstract String getCidade();
	
	public abstract void setTreinador(Treinador treinador);
	public abstract void setNome(String nome);
	
	public abstract boolean contrataJogador(Jogador jogador) throws ElementoRepetidoException;
	public abstract boolean demiteJogador(String nome);

	public abstract Jogador buscaJogador(String nome);
	public abstract void atualizaJogador(int index, Jogador joga);
	public abstract int indexJogadorEncontrado(Jogador Joga);
	
	public abstract void show();
	public abstract void mostraJogadores();
}
