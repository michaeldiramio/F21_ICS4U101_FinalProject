import DLibX.*;

public class Main {

  public static void main(String[] args) {
   // for testing
    DConsole dc = new DConsole(450, 300);
    dc.fillRect(200, 200, 50, 90);
    

    Card test = new Card('s',7);
    dc.drawImage(test.printCard(), 50, 50);
   while(true){ 
    test.flipCard();
    dc.drawImage(test.printCard(), 50, 50);
    dc.redraw();


    dc.pause(200);
    dc.clear();

    //deck tests
    System.out.println("Hello");

    Deck d = new Deck(52);
    d.shuffle();
    System.out.println(d.getNumberOfCards());
    
  }
  

    
  }
  }

