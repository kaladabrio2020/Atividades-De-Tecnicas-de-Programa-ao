public class BancoArray {   
  private Conta[] contas;
  private int indice = 0;
  private double taxa_de_juros = 1.0;
  private Object Conta;
  public BancoArray(){
    contas = new Conta[100];
  }
  
  public void cadastrar(Conta conta){
    contas[indice] = conta;
    indice++;
  }   
  
  private Conta procurar(String numero){
    for(int i = 0; i < indice; i++) {
      if(contas[i].getNumero().equals(numero)) {
        return contas[i];
      }
    }
    return null;
  } 
  
  public void creditar(String numero, double valor){
    Conta conta = procurar(numero);
    if (conta != null) {
      conta.creditar(valor);
    } else { 
      System.out.println("Conta Inexistente!");
    }
  }
    public void debitar(String numero, double valor){
      Conta conta = procurar(numero);
      if (conta != null) {
        conta.debitar(valor);
      } else {
        System.out.println("Conta Inexistente!");
      }
    }
  
  public double saldo(String numero) {
    Conta conta = procurar(numero);
    if (conta != null) {
      return conta.getSaldo();
    } else { 
      System.out.println("Conta Inexistente!");
    }
    return 0;
  }
  
  public void transferir(String origem, String destino, double valor){
    Conta contaOrigem = procurar(origem);
    if(contaOrigem != null) {
      Conta contaDestino = procurar(destino);
      if(contaDestino != null) {
        if(contaOrigem.getSaldo() > valor) {
          contaOrigem.debitar(valor);
          contaDestino.creditar(valor);
        } else {
          System.out.println("Saldo Insuficiente!");
        }
      } else {
        System.out.println("Conta Destino nº " + destino + " Inexistente!");        
      }
    } else {
      System.out.println("Conta Origem nº " + origem + " Inexistente!");
    }
  }  
  
  void renderJuros(String numero) {
    Conta conta;
    conta = procurar(numero);
    if (conta != null){
      if (Conta instanceof ContaPoupanca) ((ContaPoupanca) conta).RenderJuros(this.taxa_de_juros);
    }
    else               System.out.println("None");

    
  }
	public void SetTaxa(double taxa_de_juros){
		this.taxa_de_juros = taxa_de_juros;
	}
	public double GetTaxa(){
		return this.taxa_de_juros;
	}
}