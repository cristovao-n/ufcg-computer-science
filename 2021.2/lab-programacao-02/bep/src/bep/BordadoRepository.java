package bep;

public class BordadoRepository {
  private static final int MAX_QUANTIDADE_BORDADOS = 10;
  private Bordado[] bordados = new Bordado[MAX_QUANTIDADE_BORDADOS];

  public int getQuantidadeBordadosDisponivelParaCadastro() {
    return MAX_QUANTIDADE_BORDADOS - bordados.length;
  }

  public void cadastrarBordado(int id, int quantidadeLinhas, int quantidadeColunas) throws Exception {
    boolean haRangeInvalido = !ehValidoRangeId(id) || !ehValidoRangeLinhas(quantidadeLinhas)
        || !ehValidoRangeColunas(quantidadeColunas);
    if (haRangeInvalido) {
      throw new Exception("ERRO!");
    }

    Bordado bordado = new Bordado(id, quantidadeLinhas, quantidadeColunas);
    this.bordados[id] = bordado;

  }

  public void atualizarBordado(int id, String no, int linha, int coluna) throws Exception {
    if (!this.haBordado(id)) {
      throw new Exception("ERRO!");
    }
    Bordado bordado = this.bordados[id];
    boolean haRangeInvalido = !this.ehValidoRangeId(id) || !this.ehValidoRangeNo(no) || !this.ehValidoRangeLinhas(linha)
        || !this.ehValidoRangeColunas(coluna);
    boolean haAtributoBordadoInvalido = !this.ehValidoLinhaBordado(linha, bordado)
        || !this.ehValidoColunaBordado(coluna, bordado);

    if (haRangeInvalido || haAtributoBordadoInvalido) {
      throw new Exception("ERRO!");
    }

    bordado.setNo(no, linha, coluna);

  }

  public String imprimirBordado(int id) throws Exception {
    if (!this.haBordado(id)) {
      throw new Exception("ERRO!");
    }
    Bordado bordado = this.bordados[id];
    return bordado.toString();
  }

  private boolean haBordado(int id) {
    return this.bordados[id] != null;
  }

  private boolean ehValidoLinhaBordado(int linha, Bordado bordado) {
    return linha <= bordado.getQuantidadeLinhas();

  }

  private boolean ehValidoColunaBordado(int coluna, Bordado bordado) {
    return coluna <= bordado.getQuantidadeColunas();
  }

  private boolean ehValidoRangeId(int id) {
    final int MIN_ID = 0;
    final int MAX_ID = 0;
    return id >= MIN_ID && id <= MAX_ID;
  }

  private boolean ehValidoRangeNo(String no) {
    final String NO_VALIDOS = "/\\|-x ";
    return NO_VALIDOS.contains(no);
  }

  private boolean ehValidoRangeLinhas(int quantidadeLinhas) {
    final int MIN_QUANTIDADE_LINHAS = 2;
    final int MAX_QUANTIDADE_LINHAS = 100;
    return quantidadeLinhas >= MIN_QUANTIDADE_LINHAS && quantidadeLinhas <= MAX_QUANTIDADE_LINHAS;
  }

  private boolean ehValidoRangeColunas(int quantidadeColunas) {
    final int MIN_QUANTIDADE_COLUNAS = 2;
    final int MAX_QUANTIDADE_COLUNAS = 100;
    return quantidadeColunas >= MIN_QUANTIDADE_COLUNAS && quantidadeColunas <= MAX_QUANTIDADE_COLUNAS;

  }

}
