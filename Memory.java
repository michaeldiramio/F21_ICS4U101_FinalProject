import java.util.*;
import DLibX.*;
import java.awt.*;
import java.awt.image.*;

public class Memory extends Game {

  public void run(Player p, DConsole dc) {

    boolean end = false; //game not ended

    //draw background
    dc.drawImage("Memory_Images/tableBackground.jpg", 225, 150);

    //memory cards deck
    ArrayList<String> cards = new ArrayList<String>();

    //add cards to deck
    for (int i = 1; i < 14; i++){
      String cardC = ("Card_Images/" + i + "c.png");
      String cardD = ("Card_Images/" + i + "d.png");
      String cardH = ("Card_Images/" + i + "h.png");
      String cardS = ("Card_Images/" + i + "s.png");

      cards.add(cardC);
      cards.add(cardD);
      cards.add(cardH);
      cards.add(cardS);
    }

    //new 'deck' of dealt cards
    ArrayList<String> dealtCards = this.dealCards(cards, dc);
    //print cards face down
    this.printBacks(dc);

    //draw
    dc.redraw();

    //pause (so doesn't click twice)
    try {
      Thread.sleep(400);
    } catch (InterruptedException e) {
      System.out.println("error");
    }

    //flipped cards
    String card1 = null;
    String card2 = null;

    //x and y for first and second card
    int card1X = -1;
    int card1Y = -1;
    int card2X = -1;
    int card2Y = -1;

    //variables
    int lives = 3; //three chances
    int matches = 0; //records matches

    //get bet
    double bet = this.bet(p);

    while (!end){

      //get mouse position
      int mouseX = dc.getMouseXPosition();
      int mouseY = dc.getMouseYPosition();

      if(dc.isMouseButton(1)) {        

        //---card flipping---
        //top row
        if (mouseY > 17 && mouseY < 134){
          if (mouseX > 37 && mouseX < 113){//leftmost card

            //record as first or second flip
            if (card1 == null){//first flip
              card1 = dealtCards.get(0);
              dc.drawImage(dealtCards.get(0), 75, 75);//flip card

              card1X = 75; //record coordinates
              card1Y = 75;

            } else if (card2 == null){//second flip
              card2 = dealtCards.get(0);
              dc.drawImage(dealtCards.get(0), 75, 75);//flip card

              card2X = 75; //record coordinates
              card2Y = 75;
            }
          } else if (mouseX > 138 && mouseX < 212){//midleft

            //record as first or second flip
            if (card1 == null){//first flip
              card1 = dealtCards.get(1);
              dc.drawImage(dealtCards.get(1), 175, 75);//flip card

              card1X = 175; //record coordinates
              card1Y = 75;

            } else if (card2 == null){//second flip
              card2 = dealtCards.get(1);
              dc.drawImage(dealtCards.get(1), 175, 75);//flip card

              card2X = 175; //record coordinates
              card2Y = 75;
            }
          } else if (mouseX > 237 && mouseX < 315){//midright

            //record as first or second flip
            if (card1 == null){//first flip
              card1 = dealtCards.get(2);
              dc.drawImage(dealtCards.get(2), 275, 75);//flip card

              card1X = 275; //record coordinates
              card1Y = 75;

            } else if (card2 == null){//second flip
              card2 = dealtCards.get(2);
              dc.drawImage(dealtCards.get(2), 275, 75);//flip card

              card2X = 275; //record coordinates
              card2Y = 75;
            }

          } else if (mouseX > 339 && mouseX < 413){//rightmost

            //record as first or second flip
            if (card1 == null){//first flip
              card1 = dealtCards.get(3);
              dc.drawImage(dealtCards.get(3), 375, 75);//flip card

              card1X = 375; //record coordinates
              card1Y = 75;

            } else if (card2 == null){//second flip
              card2 = dealtCards.get(3);
              dc.drawImage(dealtCards.get(3), 375, 75);//flip card

              card2X = 375; //record coordinates
              card2Y = 75;
            }

          }
        
        //bottom row
        } else if (mouseY > 76 && mouseY < 284){
          if (mouseX > 37 && mouseX < 113){//leftmost card

            //record as first or second flip
            if (card1 == null){//first flip
              card1 = dealtCards.get(4);
              dc.drawImage(dealtCards.get(4), 75, 225);//flip card

              card1X = 75; //record coordinates
              card1Y = 225;

            } else if (card2 == null){//second flip
              card2 = dealtCards.get(4);
              dc.drawImage(dealtCards.get(4), 75, 225);//flip card

              card2X = 75; //record coordinates
              card2Y = 225;

            }
          } else if (mouseX > 138 && mouseX < 212){//midleft

            //record as first or second flip
            if (card1 == null){//first flip
              card1 = dealtCards.get(5);
              dc.drawImage(dealtCards.get(5), 175, 225);//flip card

              card1X = 175; //record coordinates
              card1Y = 225;

            } else if (card2 == null){//second flip
              card2 = dealtCards.get(5);
              dc.drawImage(dealtCards.get(5), 175, 225);//flip card

              card2X = 175; //record coordinates
              card2Y = 225;

            }
          } else if (mouseX > 237 && mouseX < 315){//midright

            //record as first or second flip
            if (card1 == null){//first flip
              card1 = dealtCards.get(6);
              dc.drawImage(dealtCards.get(6), 275, 225);//flip card

              card1X = 275; //record coordinates
              card1Y = 225;

            } else if (card2 == null){//second flip
              card2 = dealtCards.get(6);
              dc.drawImage(dealtCards.get(6), 275, 225);//flip card

              card2X = 275; //record coordinates
              card2Y = 225;

            }

          } else if (mouseX > 339 && mouseX < 413){//rightmost

            //record as first or second flip
            if (card1 == null){//first flip
              card1 = dealtCards.get(7);
              dc.drawImage(dealtCards.get(7), 375, 225);//flip card

              card1X = 375; //record coordinates
              card1Y = 225;

            } else if (card2 == null){//second flip
              card2 = dealtCards.get(7);
              dc.drawImage(dealtCards.get(7), 375, 225);//flip card

              card2X = 375; //record coordinates
              card2Y = 225;

            }

          }
        }

        dc.redraw();

        //pause (so doesn't click twice)
        try {
          Thread.sleep(200);
        } catch (InterruptedException e) {
          System.out.println("error");
        }

        //check for match
        if (card1 != null && card2 != null){

          //pause so player can read cards
          try {
            Thread.sleep(300);
          } catch (InterruptedException e) {
            System.out.println("error");
          }

          if (card1 == card2){
            //match found
            matches = matches + 1;
            System.out.println("Matches: " + matches);

            //check if won
            if (matches > 3){
              //won
              end = true;
              double winnings = (bet * 2);
              p.changeMoney(+winnings);
            }

          //incorrect match
          } else {
            lives = lives - 1;
            System.out.println("Lives remaining: " + lives);

            //check if game over 
            if (lives < 1){
              end = true;
            }

            //reflip cards
            dc.drawImage("Card_Images/card_back.png", card1X, card1Y);
            dc.drawImage("Card_Images/card_back.png", card2X, card2Y);

          }

          //--reset--
          //reset flips
          card1 = null;
          card2 = null;
      
        }
      }

      dc.pause(20);
      dc.redraw();

    }
  }

  //deal cards
  public ArrayList<String> dealCards(ArrayList<String> cards, DConsole dc){
    //randomize list
    Collections.shuffle(cards);

    //create small deck
    ArrayList<String> selectCards = new ArrayList<String>();
    for (int i = 0; i < 4; i++){
      //add two matching cards
      selectCards.add(cards.get(i));
      selectCards.add(cards.get(i));
    }

    //randomize new list
    Collections.shuffle(selectCards);

    return selectCards;
    
  }

  //print cards face down
  public void printBacks(DConsole dc){
    //print top row
    int x = 75; //int to change x value in for loop
    //print cards
    for (int i = 0; i < 4; i++){
      dc.drawImage("Card_Images/card_back.png", x, 75);
      x = x + 100;
    }

    //print bottom row
    x = 75; //for changing x value
    //print cards
    for (int i = 4; i < 8; i++){
      dc.drawImage("Card_Images/card_back.png", x, 225);
      x = x + 100;
    }

  }

  public double bet(Player p){
    //scanner
    Scanner sc = new Scanner(System.in);

    //declare variables
    boolean validInput = false;
    double bet = 0;

    //check input validity
    while (!validInput){

    System.out.print("Bet: ");
    String betInput = sc.nextLine();

    try {
      bet = Double.parseDouble(betInput);
      if (0 < bet && bet <= p.getMoney()) {
        validInput = true;
        p.changeMoney(-bet);

      } else if (bet <= 0) {
        System.out.println("Bet must be > 0\n");
      } else {
        System.out.println("Insufficient funds\n");
      }

      } catch (Exception e) {
        System.out.println("Invalid input\n");
      }
    }
    return bet;
  }

}