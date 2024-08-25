public class Mapa {
  public static void main(String[] args) {
    Ponto p1 = new Ponto();
    Ponto p2 = new Ponto();
    p1.x = 20;
    p1.y = 10;
    p2.x = 0;
    p2.y = -10;

    System.out.println(p1.distancia(p2));

  }
}