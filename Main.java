import DLibX.*;

public class Main {

  public static void main(String[] args) {
    for testing
    DConsole dc = new DConsole(450, 300);
    dc.fillRect(200, 200, 50, 90);
    dc.redraw();

    

    //deck tests
    System.out.println("Hello");

    Deck d = new Deck(52);
    d.shuffle();
    System.out.println(d.getNumberOfCards());
    
  }
  
}