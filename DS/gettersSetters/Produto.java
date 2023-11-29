/* 
 * 1 - Baseado na classe Produto, criar um construtor que receba todos os atributos da classe como par�metros.
 * 2 - Criar um m�todo chamado exibirProduto() que exiba o produto criado por meio do construtor
 * */

package cadastroProduto;

public class Produto {
	  private int idProduto;
	  private String produto;
	  private String descricaoProduto;
	  private int valorProduto;
	  private String dataDoCadastro;
	  
	public Produto(int idProduto, String produto, String descricaoProduto, int valorProduto, String dataDoCadastro) {
		this.idProduto = idProduto;
		this.produto = produto;
		this.descricaoProduto = descricaoProduto;
		this.valorProduto = valorProduto;
		this.dataDoCadastro = dataDoCadastro;
	}
	  
	  public String getProduto() {
		  return produto;
	  }
	  
	  public void setProduto(String produto) {
		  this.produto = produto;
	  }
	  
	  public int getIdProduto() {
		  return idProduto;
	  }
	  
	  public void setIdProduto(int idProduto) {
		  this.idProduto = idProduto;
	  }
	  
	  public String getDescricaoProduto() {
		  return descricaoProduto;
	  }
	  
	  public void setDescricaoProduto(String descricaoProduto) {
		  this.descricaoProduto = descricaoProduto;
	  }
	  
	  public int getValorProduto() {
		  return valorProduto;
	  }
	  
	  public void setValorProduto(int valorProduto) {
		  this.valorProduto = valorProduto;
	  }
	  
	  public String getDataDoCadastro() {
		  return dataDoCadastro;
	  }
	  
	  public void setDataDoCadastro(String dataDoCadastro) {
		  this.dataDoCadastro = dataDoCadastro;
	  }
	  
	  public void exibirProduto() {
		  System.out.println("Com base nos dados inseridos, o produto cadastrado foi: ");
		  System.out.println( "C�digo ID: " + getIdProduto()
	  							+ "\nProduto: " + getProduto()
  								+ "\nDescri��o: " + getDescricaoProduto()
								+ "\nValor: R$ " + getValorProduto()
								+ "\nData do Cadastro: " + getDataDoCadastro());
	  }
}
