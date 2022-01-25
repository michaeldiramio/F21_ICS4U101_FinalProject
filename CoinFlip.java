import java.util.*;
import java.text.*;
import java.awt.Color;
import DLibX.*;


public class CoinFlip extends Game {

  public void run(Player p, DConsole dc) {

    System.out.println("Welcome to coin flip");
    System.out.println("Choose either heads or tails and watch the coin flip to see if you win!");

    boolean play = false;

    while(!play) {
    
    
    Scanner sc = new Scanner(System.in); // initiates booleans, ints, scanner, object, and strings
    Coin c1 = new Coin();
    String input = "";
    String response = "";
    boolean check = false;
    boolean vGame = false;
    boolean vInput = false;
    boolean validanswer = false;
    double wager = 0;
    
    while(!vInput) {
    System.out.print("Input the amount of money to bet: ");
    response = sc.nextLine();
    System.out.println();

      try {
        if (response.contains("xx")) { //gets the amount you want to bet
          vInput = true;
        } else {
          wager = Double.parseDouble(response);
          if (0 < wager && wager <= p.getMoney()) {
            vInput = true;
            vGame = true;
          } else if (wager <= 0) {
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

    while(!check) { // gets the users to pick what side of the coin they want to bet on and make sure they answer
      System.out.println("Heads or Tails?");

      input = sc.nextLine();

      if (input.equals("Heads")) {
        check = true;
      } else if(input.equals("Tails")) {
        check = true;  
      } else {
        System.out.println("That is invalid, try again");
      }
    }

    //They have picked heads or tails and this should be the logic to decide if they won or not 

    int result = c1.flip(); // flips the coin

    if (input.equals("Heads") && result == 0) { // sees if the user one or lost
      System.out.println("YOU WON!");
    } else if(input.equals("Tails") && result == 1) {
      System.out.println("YOU WON!");
    } else{
      System.out.println("Sorry you lost");
    }

    while(!validanswer) { // checks to see if the player wants to play again and gives a proper response
    System.out.println("Would you like to play again?: Yes or No");
    input = sc.nextLine();
     if (input.equals("Yes")) {
       System.out.println("Ok!");
      validanswer = true;
     } else if(input.equals("No")) {
       System.out.println("Ok!");
       play = true;
       validanswer = true;
     } else {
       System.out.println("That is invalid");
     }

    }

      dc.pause(1000); //for testing

    }
  }
}
    
