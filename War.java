import java.util.*;
import java.text.*;
import java.awt.Color;
import DLibX.*;

public class War extends Game {

  public void run(Player p, DConsole dc){

    boolean validInput = false;
    boolean validGame = false;
    double bet = 0;

    //allow the player to bet 
    Scanner sc = new Scanner(System.in);
    String input;

    while (!validInput){

      System.out.print("Input the amount of money to bet: ");
      input = sc.nextLine();
      System.out.println();

      try {
        if (input.contains("xx")) {
          validInput = true;
        } else {
          bet = Double.parseDouble(input);
          if (0 < bet && bet <= p.getMoney()) {
            validInput = true;
            validGame = true;
          } else if (bet <= 0) {
            System.out.println("You cannot bet zero or less. Please input a proper bet, or input 'xx' to return to the menu.");
            System.out.println();
          } else {
            System.out.println("You don't have that much money. Please input a proper bet, or input 'xx' to return to the menu.");
            System.out.println();
          }
        }

      } catch (Exception e) {
        System.out.println("Something has gone wrong. Please input a proper bet, or input 'xx' to return to the menu.");
        System.out.println();
      }

    }

    //Initialize variables here
    ModularDeck md = new ModularDeck();
    ModularDeck playerWin = new ModularDeck(new ArrayList<Card>());
    ModularDeck oppWin = new ModularDeck(new ArrayList<Card>());
    md.shuffle();
    int oppChoice;
    int playerChoice;
    boolean winnerDecided;
    boolean gameRunning = true;
    ArrayList<Card> card = new ArrayList<>();

    //split the deck
    ModularDeck playerDeck = md.splitInTwo();
    ModularDeck oppDeck = md;

    while (gameRunning) {

      Card playerCard = playerDeck.drawCard();
      Card oppCard = oppDeck.drawCard();

      dc.pause(1000);


      winnerDecided = false; 

      //loop to compare the cards played
      //store cards in an array here

      while (!winnerDecided) {
        if (playerCard.getNum() < oppCard.getNum()) {
          //Opp wins
          oppWin.addCard(playerCard);
          oppWin.addCard(oppCard);
          for (int i = 0; i < card.size(); i++) {
            oppWin.addCard(card.get(i));
          }

          winnerDecided = true;
          card = new ArrayList<>();

        } else if (playerCard.getNum() > oppCard.getNum()) {
          //Player wins
          playerWin.addCard(playerCard);
          playerWin.addCard(oppCard);
          for (int i = 0; i < card.size(); i++) {
            playerWin.addCard(card.get(i));
          }

          winnerDecided = true;
          card = new ArrayList<>();

        } else {
          //Tie?
          card.add(playerCard);
          card.add(oppCard);
        }
      }


      //once a player is out of cards the seperate pile is added to their current hand
      if(playerDeck.checkSize() == 0 || oppDeck.checkSize() == 0) {
        while (playerWin.checkSize() > 0) {
          playerDeck.addCard(playerWin.drawCard());
        }
        while (oppWin.checkSize() > 0) {
          oppDeck.addCard(oppWin.drawCard());
        }
        if (playerDeck.checkSize() == 0) {
          System.out.println("The opponent wins!");        
        } else if (oppDeck.checkSize() == 0) {
          System.out.println("You win!");
        }

      }

    }
  //end while gameRunning here }

  }

}