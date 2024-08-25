package bep;

public class Bordado {
  private int id;
  private int quantidadeLinhas;
  private int quantidadeColunas;
  private String[][] bordado = new String[quantidadeLinhas][quantidadeColunas];

  public Bordado(int id, int quantidadeLinhas, int quantidadeColunas) {
    this.id = id;
    this.quantidadeLinhas = quantidadeLinhas;
    this.quantidadeColunas = quantidadeColunas;
  }

  public int getQuantidadeLinhas() {
    return this.quantidadeLinhas;
  }

  public int getQuantidadeColunas() {
    return this.quantidadeColunas;
  }

  public void setNo(String no, int linha, int coluna) {
    this.bordado[linha][coluna] = no;
  }

  public String toString() {
    return this.id + " ";
  }

}