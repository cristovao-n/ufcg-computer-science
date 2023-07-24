public class Ponto {
  public int x;
  public int y;

  public Ponto() {
  }

  public Ponto(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public double distancia(Ponto p) {
    int xDist = this.x - p.x;
    int yDist = this.y - p.y;

    return Math.sqrt(xDist * xDist + yDist * yDist);

  }

}
