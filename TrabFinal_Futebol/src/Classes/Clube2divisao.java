package Classes;

import Exceptions.ElementoRepetidoException;

public class Clube2divisao extends Clube{
	
	public String nomeClube;
	public Clube2divisao (String nome,Treinador treinador ,Federacao federacao, String presidente, String cidade, double saldo) {
		super( treinador , federacao , presidente , cidade , saldo);
		nomeClube = nome;
		this.saldo -= treinador.getSalario();
	}
	
	
	@Override
	public double getSaldo() {	return this.saldo;	}

	@Override
	public String getNome() { return this.nomeClube; }
	
	@Override
	public void setNome(String nome) { this.nomeClube = nome; }

	@Override
	public String getPresidente() { return this.presidente; }

	@Override
	public String getCidade() { return this.cidade; }
	
	@Override
	public String getTreinador() {	return this.treinador.getNome(); }

	@Override
	public void setTreinador(Treinador treinador) {	this.treinador = treinador;	}

	@Override
	public Jogador buscaJogador(String nome) {
		for(Jogador joga : this.jogadores) {
			if(joga.getNome().equals(nome)) {
				return joga;
			}
		}
		return null;
	}
	
	@Override
	public boolean demiteJogador(String nome) {
		for(Jogador joga : this.jogadores) {
			if(joga.getNome().equals(nome)) {
				this.jogadores.remove(joga);
				this.saldo += joga.getSalario();
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexJogadorEncontrado(Jogador joga) {
		return this.jogadores.indexOf(joga);
	}
	
	@Override
	public void atualizaJogador(int index, Jogador joga) {
		try {
			this.jogadores.set(index, joga);
			System.out.println("Jogador atualizado com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public boolean jogadorIsUnique(String nome ) {
		for(Jogador joga : jogadores) {
			if(joga.getNome().equals(nome)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean contrataJogador(Jogador jogador) throws ElementoRepetidoException {
		if(jogadorIsUnique(jogador.getNome())) {
			this.saldo -= jogador.getSalario();
			if(this.saldo < 0 ) {
				System.out.println("Impossivel contratar pois o time quebrou");
				return false;
			}
			
			jogadores.add(jogador);
			
			System.out.println("Jogador adicionado com sucesso!");
			return true;
		}else{
			throw new ElementoRepetidoException("Jogador ja existe no clube.");
		}
	}

	
	@Override
	public void show() {
		System.out.println("Nome: " + nomeClube + ", treinador: "+ treinador.getNome() + ", federação: " + federacao.getNome()	
							+ ", presidente: " + getPresidente() + ", cidade: " + getCidade() + ", saldo: " + getSaldo());
	}

	@Override
	public void mostraJogadores() {
		for(Jogador joga : jogadores) {
			joga.show();
		}
	}

}
