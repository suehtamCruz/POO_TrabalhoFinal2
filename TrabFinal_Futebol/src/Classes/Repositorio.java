package Classes;


import java.util.ArrayList;

import Exceptions.ElementoRepetidoException;

public class Repositorio {

	public Repositorio() {	}
	
	public static ArrayList<Treinador> treinadores = new ArrayList<Treinador>();
	public static ArrayList<Federacao> federacoes = new ArrayList<Federacao>();
	public static ArrayList<Clube> clubes = new ArrayList<Clube>();

	
	public static ArrayList<Clube1divisao> primeiraDivisao = new ArrayList<Clube1divisao>();
	public static ArrayList<Clube2divisao> segundaDivisao = new ArrayList<Clube2divisao>();
	public static int qtdClubes = 0;
	public static ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	
	/**
	 * 
	 * @param nome Nome do treinador a ser procurado.
	 * @return Retorna true caso não haja treinador com o mesmo nome; 
	 */
	public boolean treinadorUnique(String nome) {
		for(Treinador trein : treinadores) {
			if(trein.getNome().equals(nome)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param nome Nome do jogador.
	 * @return Retorna true caso o jogador não esteja presente na lista e false se ja existir registro.
	 */
	public boolean jogadorIsUnique(String nome) {
		for(Jogador joga : jogadores) {
			if(joga.getNome().equals(nome)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param nome Nome da federação a ser procurada;
	 * @return Retorna true se a federação for unica assim podendo ser criada.
	 */
	public boolean federacaoUnique(String nome){
		for(Federacao federa : federacoes) {
			if(federa.getNome().equals(nome)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param nome Nome do clube a ser procurado;
	 * @return Retorna true se o clube for unico ou false se ja existe.
	 */
	public boolean clubeIsUnique(String nome) {
		for(Clube club : clubes) {
			if(club.getNome().equals(nome)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean clube1IsUnique(String nome) {
		for(Clube1divisao club : primeiraDivisao) {
			if(club.getNome().equals(nome)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean clube2IsUnique(String nome) {
		for(Clube2divisao club : segundaDivisao) {
			if(club.getNome().equals(nome)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 
	 * @param treinador Treinador a ser adicionado.
	 * @throws ElementoRepetidoException Excessão que trata equidade de treinadores.
	 */
	public void adicionaTreinador(Treinador treinador) throws ElementoRepetidoException {
			
			if(treinadorUnique(treinador.getNome())) {
				treinadores.add(treinador);	
			}else {
				throw new ElementoRepetidoException("Treinador já existente, impossivel criar um novo.");
			}
		
	}
	
	/**
	 * 
	 * @param jogador Jogador a ser adiciondo.
	 * @throws ElementoRepetidoException Excessão que trata equidade de jogadores
	 */
	public void adicionaJogador(Jogador jogador) throws ElementoRepetidoException{
		if(jogadorIsUnique(jogador.getNome())) {
			jogadores.add(jogador);
			
			System.out.println("Jogador adicionado a lista");
		}else {
			System.out.println("Jogador já existente, impossivel criar um novo");
			throw new ElementoRepetidoException("Jogador já existente, impossivel criar um novo.");
		}
	}
	
	/**
	 * 
	 * @param federacao Adiciona uma nova federação caso ela seja unica na lista de federações
	 * @throws ElementoRepetidoException Excessão que trata equidade de federações.
	 */
	public void adicionaFederacao(Federacao federacao) throws ElementoRepetidoException{
		try {	
			if(federacaoUnique(federacao.getNome())) {
				federacoes.add(federacao);
				System.out.println("Federação adicionada com sucesso!");
			}else {
				throw new ElementoRepetidoException("Federação já existente, impossivel criar uma nova.");
				
			}
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param clube Clube a ser adicionado ao grupo geral de clubes
	 * @throws ElementoRepetidoException
	 */
	public void adicionaCLube(Clube clube) throws ElementoRepetidoException{
		if(clubeIsUnique(clube.getNome() )) {
			clubes.add(clube);
			qtdClubes++;
			System.out.println("Clube adicionado com sucesso!");
		}else {
			throw new ElementoRepetidoException("Clube ja existente, utilize outro nome para a criação");
		}
	}
	
	public void adicionaCLube1Divisao(Clube1divisao clube) throws ElementoRepetidoException{
		if(clube1IsUnique(clube.getNome() )) {
			primeiraDivisao.add(clube);
			qtdClubes++;
			System.out.println("Clube adicionado com sucesso!");
		}else {
			throw new ElementoRepetidoException("Clube ja existente, utilize outro nome para a criação");
		}
	}
	
	public void adicionaCLube2Divisao(Clube2divisao clube) throws ElementoRepetidoException{
		if(clube2IsUnique(clube.getNome() )) {
			segundaDivisao.add(clube);
			qtdClubes++;
			System.out.println("Clube adicionado com sucesso!");
		}else {
			throw new ElementoRepetidoException("Clube ja existente, utilize outro nome para a criação");
		}
	}

	/**
	 * 
	 * @param treinador Treinador a ser buscado
	 * @return Retorna o treinador caso o nome passado como parametro seja encontrado entre todos os treinadores.
	 */
	public Treinador buscaTreinador(String treinador) {
		for(Treinador trein : treinadores) {
			if(trein.getNome().equals(treinador)) {
				return trein;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param nome Nome da federação a ser procurada
	 * @return Retorna a federação caso encontre ela na lista de federações.
	 */
	public Federacao buscaFederacao(String nome) {
		for(Federacao federa : federacoes) {
			if(federa.getNome().equals(nome)) {
				System.out.println("Federação encontrada!");
				return federa;
			}
		}
		System.out.println("Federação não encontrada!");
		return null;
	}
	
	/**
	 * 
	 * @param clube Nome do clube a ser procurado entre todas as federações.
	 * @return Retorna a federação caso ache o clube.
	 */
	public Federacao buscaFederacaoPeloClube(String clube) {
		for(Federacao federa : federacoes) {
			if(federa.buscaClube(clube)) {
				return federa;
			}
		}
		return null;
	}
	/**
	 * 
	 * @param nome Nome do clube a ser procurado
	 * @return Retorna o clube ou null caso não encontre
	 */
	public Clube1divisao buscaClube1Divisao(String nome) {
		for(Clube1divisao club : primeiraDivisao) {
			if(club.getNome().equals(nome)) {
				return club;
			}
		}return null;
	}
	
	/**
	 * 
	 * @param nome Nome do clube a ser procurado
	 * @return Retorna o clube ou null caso não encontre
	 */
	public Clube2divisao buscaClube2Divisao(String nome) {
		for(Clube2divisao club : segundaDivisao) {
			if(club.getNome().equals(nome)) {
				return club;
			}
		}return null;
	}
	
	
	/**
	 * 
	 * @param treinador Nome do treinador a ser procurado.
	 * @return Retorna o treinador caso exista ou NULL caso não enconte o treinador em questão.
	 */
	public Clube buscarClubePeloTreinador(String treinador) {
		for(Clube club : clubes) {
			if(club.getTreinador().equals(treinador)) {
				return club;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param nome Nome do jogador a ser buscado em todos os clubes
	 * @return Retorna o jogador caso o encontre ou null caso não encontre. 
	 */
	public Jogador buscaJogador(String nome) {
		Jogador jogador = null;
		for(Jogador joga : jogadores) {
			if(joga.getNome().equals(nome)) {
				jogador = joga;
				break;
			}
		}
		if(jogador == null) {
			System.out.println("Jogador não encontrado");
			return jogador;
		}
		System.out.println("Jogador encontrado!");
		return jogador;
	}
	
	/**
	 * 
	 * @param nome Nome do clube a ser procurado na lista 
	 * @return Retorna o clube caso encontre ou Null caso não encontre.
	 */
	public Clube buscaClube(String nome) {
		System.out.println("quantidade de clubes : " + qtdClubes);
		
		for(Clube1divisao club : primeiraDivisao) {
			System.out.println("Time de primeira divisão");
			if(club.getNome().equals(nome)) {
		
				return (Clube)club;
			}
		}
		for(Clube2divisao club : segundaDivisao) {
			System.out.println("Time de segunda divisão");
			if(club.getNome().equals(nome)) {

				return (Clube)club;
			}
		}
		System.out.println("Clube não encontrado!");
		return null;
	}
	
	/**
	 * 
	 * @param federacao Federação a ser procurada na lista.
	 * @return Retorna o indice da federação caso encontre na lita ou -1 caso não encontre.
	 */
	public int indexFederacaoEncontrada(Federacao federacao) {
		return federacoes.indexOf(federacao);
	}

	/**
	 * 
	 * @param treinador Nome do treinador a ser procurado e removido.
	 * @return Retorna true se o treinador for removido ou false se não for removido.
	 */
	public boolean removeTreinador(String treinador) {
		Treinador treinadorRemove = buscaTreinador(treinador);
		if(treinadorRemove == null) {
			return false;			
		}else {
			treinadores.remove(treinadorRemove);
			return true;			
		}
	}
	
	/**
	 *  
	 * @param nomeJogador Nome do jogador a ser removido
	 * @param clube Clube em que ele atua.
	 * @return Retorna true caso o jogador tenha sido removido com sucesso ou false caso contrário.
	 */
	public boolean removeJogador(String nomeJogador, String clube) {
		Clube clubeRemoveJogador = null;
		for(Clube club : clubes) {
			if(club.getNome().equals(clube)) {
				clubeRemoveJogador = club;
			}
		}
		if(clubeRemoveJogador == null) {
//			System.out.println("Clube não encontrado!");
			return false;
		}
		Jogador jogadorRemove = clubeRemoveJogador.buscaJogador(nomeJogador);
		if(jogadorRemove == null) {
//			System.out.println("Jogador não encontrado no time " + clubeRemoveJogador.getNome() + ".");
			return false;
		}
		boolean removed = clubeRemoveJogador.demiteJogador(jogadorRemove.getNome());
		if(removed) {
			jogadores.remove(jogadorRemove);
		}
		return removed;
	}
	
	/**
	 * 
	 * @param nome Nome do clube a ser removido dos clubes gerais ou das sub-divisões.
	 * @return Retorna true se o clube for removido ou false se nao conseguir remover
	 */
	public boolean removeClube(Clube clube) {
		Federacao removeClube = null;
		for(Clube1divisao club : primeiraDivisao) {
				if(club.getNome().equals(clube.getNome())) {
					primeiraDivisao.remove(club);
					removeClube = buscaFederacaoPeloClube(club.getNome());
					removeClube.removeClube(clube.getNome());
					qtdClubes--;
					return true;
				}
		}
		
		for(Clube2divisao club : segundaDivisao) {
			if(club.getNome().equals(clube.getNome())) {
				segundaDivisao.remove(club);
				removeClube = buscaFederacaoPeloClube(club.getNome());
				removeClube.removeClube(clube.getNome());
				qtdClubes--;
				return true;
			}
		}
		return false;
	}
	
	/**
	 *  
	 * @param nomeJogador Nome do jogador a ser removido
	 * @return Retorna true caso o jogador tenha sido removido com sucesso ou false caso contrário.
	 */
	public boolean deletaJogadorPeloNome(String nome) {
		Jogador deletaJogador = null;
		for(Jogador joga : jogadores) {
			if(joga.getNome().equals(nome)) {
				jogadores.remove(joga);
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param nome Nome da federação a ser removida
	 * @return Retorna true se apagar a federação ou false se não for encontrada.
	 */
	public boolean removeFederacao(String nome) {
		for(Federacao federa : federacoes) {
			if(federa.getNome().equals(nome)) {
				federacoes.remove(federa);
				return true;
			}
		}
		return false;
	}
	
	
	public int indiceJogador (Jogador joga) {
		return jogadores.indexOf(joga);
	}
	
	/**
	 * 
	 * @param nome Nome antigo do jogador.
	 * @param jogadorAtualizado Jogador atualizado para ser inserido na lista do clube.
	 * @return True se conseguir atualizar ou false se não conseguir.
	 */
	public boolean atualizaJogador(String nome,Jogador jogadorAtualizado) {
		Clube clubeJogador = null;
	
		for(Clube1divisao club : primeiraDivisao) {
			if(club.buscaJogador(nome) != null) {
				clubeJogador = club;
				break;
			}
		}
		for(Clube2divisao club : segundaDivisao) {
			if(club.buscaJogador(nome) != null) {
				clubeJogador = club;
				break;
			}
		}	

		if(clubeJogador == null) {
			
			System.out.println("Atualizou jogador sem clube");
		
			return true;
			
		}

		return true;
		
	}
	
	/**
	 * 
	 * @param index Indice a ser atualizado
	 * @param federacaoAtualizada Nova federação
	 * @return Retorna true caso consiga atualizar a federação.
	 */
	public boolean atualizaFederacao(int index, Federacao federacaoAtualizada) {
		try {
			federacoes.set(index, federacaoAtualizada);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 
	 * @param federa Federação que o clube pertence
	 * @param index Indice do clube no 
	 * @param clube
	 * @return
	 */
	public boolean atualizaClube(Federacao federa, int index , Clube clube) {
		if(federa.atualizaClube(index, clube)) {
			federa.atualizaClube(index, clube);
			clubes.set(index, clube);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param time1 time que vende
	 * @param time2 time que compra 
	 * @param nomeJogador Nome do jogador
	 * @return
	 * @throws ElementoRepetidoException 
	 */
	public boolean realizaTransferencia(String time1, String time2, String nomeJogador) throws ElementoRepetidoException {
		Clube clubeVende = buscaClube(time1);
		Clube clubeCompra= buscaClube(time2);
		
		Jogador jogadorTransfere = clubeVende.buscaJogador(nomeJogador);
		
		if(clubeVende == null || clubeCompra == null || jogadorTransfere == null) {
			return false;
		}
		clubeVende.demiteJogador(nomeJogador);
		clubeCompra.contrataJogador(jogadorTransfere);
		jogadorTransfere.setTime(clubeCompra);
		return true;
	}
}
