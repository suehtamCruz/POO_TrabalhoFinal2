package Classes;

import Exceptions.ArgumentoInvalidoException;

public class Jogador extends Pessoa{
	
	private String posicao;
	private int numeroCamisa;
	private Clube clube = null;
	private String nome; 
	public Jogador( String nome , int idade, double salario ,String posicao,int numero) {
		super(idade,salario);
		this.posicao = posicao;
		this.numeroCamisa = numero;
		this.nome = nome;
 		
	}
	public Jogador(){
		
	}
	
	public String getNome() {	return this.nome;	}
	
	@Override
	public double getSalario() {	return this.Salario;	}

	@Override
	public int getIdade() { return this.idade; }
	
	public Clube getTodoClube() { return this.clube; } 
	
	@Override
	public String getTime() {	return this.clube.getNome();	}
	public String getPosicao() { return this.posicao; }
	public int getNumero() { return this.numeroCamisa; }
	
	public void setNome(String nome) { this.nome = nome; }
	public void setPosicao(String posicao) { this.posicao = posicao; }
	public void setTime(Clube clube) {	this.clube = clube;	}
	
	@Override
	/**
	 * @param valor Valor de aumento no salario. 
	 * Aumenta o sal�rio caso o valor passado como par�metro seja maior que zero.
	 */
	public void aumentaSalario(double valor) {
		if(valor > 0) {
			this.Salario += valor;
		}else {
			System.out.println("INFORME UM AUMENTO V�LIDO!");
		}
	}
	
	@Override
	/**
	 * @param valor Valor a ser diminuido no salario. 
	 * Dimunui o sal�rio caso o salario atual menos o desconto seja maior ou igual a 0, caso seja menor zera o sal�rio. 
	 */
	public void diminuiSalario(double valor) {
		if(this.Salario - valor >= 0) {
			this.Salario-=valor;
		}else{
			this.Salario = 0;
		}
	}
	/**
	 * 
	 * @param numero
	 * @throws ArgumentoInvalidoException
	 */
	public void trocarCamisa(int numero) throws ArgumentoInvalidoException{
		if(numero > 0) {
			this.numeroCamisa = numero;
			return;
		}else {	
			throw new ArgumentoInvalidoException("NUMERO DE CAMISA INV�LIDO!");
		}
	}
	/**
	 * @apiNote M�todo que mostra o jogador, todos os seus atributos.
	 */
	
	public void show() {
		System.out.println("Nome : " + getNome() + ", idade: " + getIdade() +", time: " + (clube == null ? "sem clube" : getTime()) + ", sal�rio: "+ getSalario() +
							", posi��o: " + getPosicao() + ", numero da camisa: " + getNumero());
	}
	
}
