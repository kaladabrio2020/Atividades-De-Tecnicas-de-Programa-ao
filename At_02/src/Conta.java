public class Conta {
	private String numero;
	public  double saldo ;
	public Conta (String numero){
		this.numero = numero ;
		saldo = 0.0 ;
	}
	public void creditar(double valor){
		saldo = valor + saldo;
	}
	public void debitar (double valor){
		saldo = saldo - valor;
	}
	public String getNumero(){
		return numero;
	}

	public double getSaldo (){
		return saldo;
	}

	public void transferindo(double valor){
		saldo = valor + saldo;
	}
}