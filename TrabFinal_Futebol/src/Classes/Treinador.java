package Classes;

public class Treinador extends Pessoa{
	
	private String licensa;
	private Clube clube = null;
	private String nome;
	
	public Treinador(String nome, int idade, double salario, String licensa) {
		super(idade,salario);
		this.licensa = licensa;	
		this.nome = nome;
	}
	
	

	public String getNome() {	return this.nome; }

	@Override
	public double getSalario() { return this.Salario; }

	@Override
	public int getIdade() {	return this.idade;	}

	@Override
	public String getTime() {	return this.clube.getNome();	}
	
	public String getLicensa() { return this.licensa; }
	
	
	public void setNome(String nome) { this.nome = nome; }
	
	public void setClube(Clube clube) {	this.clube = clube; }
	
	public void setLicensa(String licensa) { this.licensa = licensa; }
	
	@Override
	/**
	 * @param valor Valor de aumento no salario. 
	 * Aumenta o salário caso o valor passado como parâmetro seja maior que zero.
	 */
	public void aumentaSalario(double valor) {
		if(valor > 0) {
			this.Salario += valor;
		}else {
			System.out.println("INFORME UM AUMENTO VÁLIDO!");
		}
	}
	
	@Override
	/**
	 * @param valor Valor a ser diminuido no salario. 
	 * Dimunui o salário caso o salario atual menos o desconto seja maior ou igual a 0, caso seja menor zera o salário. 
	 */
	public void diminuiSalario(double valor) {
		if(this.Salario - valor >= 0) {
			this.Salario-=valor;
		}else{
			this.Salario = 0;
		}
	}
	
	/**
	 * Mostra o treinador e todos os seus atributos.
	 */
	public void show() {
		System.out.println("Nome: " + getNome() + ", idade: " + getIdade() + ", salário" + getSalario() + ", time: " 
							+ (clube == null ? "sem clube" : getTime())
						   + ", licensa: " + getLicensa() );
	}
	

}
