package Classes;

import java.util.ArrayList;

import Exceptions.ElementoRepetidoException;

public class Federacao {
	private String nome;
	protected ArrayList<Clube> clubes = new ArrayList<Clube>();
	
	public Federacao(String nome) {	this.nome = nome;	}

	public String getNome() { return this.nome; }
	
	public void setNome(String nome) { this.nome = nome; }
	
	/**
	 * 
	 * @param nome Nome para ser verificado.
	 * @return Retorna true se for unico e false se ja existir.
	 */
	public boolean clubeIsUnique(String nome) {
		for(Clube clube : clubes) {
			if(clube.getNome().equals(nome)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param clube Clube a ser adicionado a federa��o.
	 * @throws ElementoRepetidoException
	 */
	public void adicionaClube(Clube clube) throws ElementoRepetidoException{
		if(clubeIsUnique(clube.getNome())) {
			clubes.add(clube);
		}else {
			throw new ElementoRepetidoException("Clube j� existente na confedera��o.");
		}
	}
	
	/**
	 * 
	 * @param nome Nome do clube a ser removido
	 * @return Retorna true caso o clube seja encontrado e removido, e false caso nao seja possivel remover o clube.
	 */
	public boolean removeClube(String nome) {
		for(Clube club : clubes) {
			if(club.getNome().equals(nome)) {
				clubes.remove(club);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param nome Nome do clube a ser procurado
	 * @return Retorna true se achar o clube na federa��o ou false caso o clube n�o fa�a parte.
	 */
	public boolean buscaClube(String nome) {
		for(Clube club : clubes) {
			if(club.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param nome Nome do clube a ser procurado na lista
	 * @return Retorna o clube caso encontre ou null caso n�o encontre.
	 */
	public Clube buscaClubeEretorna(String nome) {
		for(Clube club : clubes) {
			if(club.getNome().equals(nome)) {
				return club;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param clube Clube na lista de clubes.
	 * @return Retorna o indice do clube na lista caso encontre ou -1 caso n�o encontre.
	 */
	public int indexClubeEncontrado(Clube clube) {
		return clubes.indexOf(clube);
	}
	
	/**
	 *  
	 * @param index Indice do clube nos clubes da federa��o
	 * @param club Novo clube.
	 * @return Retorna true caso consiga atualizar o clube ou false caso contr�rio.
	 */
	public boolean atualizaClube(int index, Clube club) {
		try {
			clubes.set(index, club);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * Nem tem o que falar n�o, so mostra os times da federa��o, kkkkk.
	 */
	public void mostraClubes() {
		for(Clube club : clubes) {
			club.show();
		}
	}
	
	/**
	 * Mostra por enquanto s� o nome da federa��o, depois adiciona mais coisas. 	
	 */
	public void show() {
		System.out.println("Nome : " + getNome());
	}
}
