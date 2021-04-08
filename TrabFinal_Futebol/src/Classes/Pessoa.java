package Classes;

public abstract class Pessoa {
	
	protected int idade;
	protected double Salario;
	protected Clube time;
	
	
	public Pessoa( int idade, double salario) {
		this.idade = idade;
		
		this.Salario = salario;

	}
	public Pessoa() {};
	
	
	
	public abstract double getSalario();
	public abstract int getIdade();
	public abstract String getTime();
	
	public abstract void aumentaSalario(double valor);
	public abstract void diminuiSalario(double valor);
	
}
