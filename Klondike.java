import java.util.*;
import java.text.*;
import java.awt.Color;
import DLibX.*;

public class Klondike extends Game {

  public void run(Player p, DConsole dc) {

    //x = arrayname[slot u want];
    //x is now = to that int
    dc.clear();
    DecimalFormat df = new DecimalFormat("0.00");
    Scanner sc = new Scanner(System.in);
    Dice die = new Dice(dc, 50 , 50);
    boolean con = true;
    double bet = 0;
    double money = p.getMoney();
    int one = 0;
    int two = 0;
    int three = 0;
    int four = 0;
    int five = 0;
    int six = 0;
    int pOne = 0;
    int pTwo = 0;
    int pThree = 0;
    int pFour = 0;
    int pFive = 0;
    int pSix = 0;
    int gameScore = 0;
    int playerScore = 0;


    
    System.out.println("Are you ready to test your luck!?");
    System.out.println("Grab your dice, and be ready to roll!"); 
    System.out.println("In order to win you will need more matching dice faces than the dealer."); 
    System.out.println("In the event that dealer and player have the same number of matching dice the winner is determined by the value of the dice. The values are as follows 1 > 6 > 5 > 4 > 3 > 2");
    System.out.println("If the dealer and player would tie, the win goes to the dealer");
    System.out.println();

    dc.drawImage("Klondike_images/GreenTable.png", 225, 150);
    dc.redraw();

    while(con == true) {
      System.out.println("Your current balance allows for a wager up to: $"+ p.getMoney());
      System.out.println("Place your wager: ");
      bet = sc.nextDouble();
      sc.nextLine();
 

      while(bet > p.getMoney() || bet < 1){
          System.out.println("invalid bet");
          bet = sc.nextDouble();
        }
    p.setMoney(money - bet);
    die.rollDice(5);
    
    die.drawDice(dc);
    dc.redraw();
    dc.pause(5000);
   int dr1 = die.getResults(0);
   int dr2 = die.getResults(1);
   int dr3 = die.getResults(2);
   int dr4 = die.getResults(3);
   int dr5 = die.getResults(4);

   System.out.println("Dealer dice roll 1 = "+ dr1);
   System.out.println("Dealer dice roll 2 = "+ dr2);
   System.out.println("Dealer dice roll 3 = "+ dr3);
   System.out.println("Dealer dice roll 4 = "+ dr4);
   System.out.println("Dealer dice roll 5 = "+ dr5);



   if (dr1 == 1) {
      one++ ;
   } else if (dr1 == 2) {
      two++ ;
   } else if (dr1 == 3) {
      three++ ;
   } else if (dr1 == 4) {
      four++ ;
   } else if (dr1 == 5) {
      five++ ;
   } else {
      six++ ;
   }

   if (dr2 == 1) {
      one++ ;
   } else if (dr2 == 2) {
      two++ ;
   } else if (dr2 == 3) {
      three++ ;
   } else if (dr2 == 4) {
      four++ ;
   } else if (dr2 == 5) {
      five++ ;
   } else {
      six++ ;
   }

   if (dr3 == 1) {
      one++ ;
   } else if (dr3 == 2) {
      two++ ;
   } else if (dr3 == 3) {
      three++ ;
   } else if (dr3 == 4) {
      four++ ;
   } else if (dr3 == 5) {
      five++ ;
   } else {
      six++ ;
   }

   if (dr4 == 1) {
      one++ ;
   } else if (dr4 == 2) {
      two++ ;
   } else if (dr4 == 3) {
      three++ ;
   } else if (dr4 == 4) {
      four++ ;
   } else if (dr4 == 5) {
      five++ ;
   } else {
      six++ ;
   }

   if (dr5 == 1) {
      one++ ;
   } else if (dr5 == 2) {
      two++ ;
   } else if (dr5 == 3) {
      three++ ;
   } else if (dr5 == 4) {
      four++ ;
   } else if (dr5 == 5) {
      five++ ;
   } else {
      six++ ;
   }

   //System.out.println(one);
   //System.out.println(two);
   //System.out.println(three);
   //System.out.println(four);
   //System.out.println(five);
   //System.out.println(six);

   if (one == 5){ // 5 of kind
     gameScore = 1;
   } else if (two == 5) {
     gameScore = 2;
   } else if (three == 5) {
     gameScore = 3;
   } else if (four == 5) {
     gameScore = 4;
   } else if (five == 5) {
     gameScore = 5;
   } else if (six == 5) {
     gameScore = 6;
   } else if (one == 4) { //four of kind
     gameScore = 7;
   } else if (two == 4) {
     gameScore = 8;
   } else if (three == 4) {
     gameScore = 9;
   } else if (four == 4) {
     gameScore = 10;
   } else if (five == 4) {
     gameScore = 11;
   } else if (six == 4) {
     gameScore = 12;
   } else if (one == 3) { // Three of kind
     gameScore = 13;
   } else if (two == 3) {
     gameScore = 14;
   } else if (three == 3) {
     gameScore = 15;
   } else if (four == 3) {
     gameScore = 16;
   } else if (five == 3) {
     gameScore = 17;
   } else if (six == 3) {
     gameScore = 18;
   } else if (one == 2) {// Pairs
     gameScore = 19;
   } else if (two == 2) {
     gameScore = 20;
   } else if (three == 2) {
     gameScore = 21;
   } else if (four == 2) {
     gameScore = 22;
   } else if (five == 2) {
     gameScore = 23;
   } else if (six == 2) {
     gameScore = 24;
   } else if (one == 1) { // One of a kind
     gameScore = 25;
   } else if (two == 1) {
     gameScore = 26;
   } else if (three == 1) {
     gameScore = 27;
   } else if (four == 1) {
     gameScore = 28;
   } else if (five == 1) {
     gameScore = 29;
   } else if (six == 1) {
     gameScore = 30;
   }

   //System.out.println(gameScore);

   dc.clear();

   Dice pDie = new Dice(dc, 50 , 50);
    dc.drawImage("Klondike_images/GreenTable.png", 225, 150);
    pDie.rollDice(5);
    pDie.drawDice(dc);
    dc.redraw();
   int pr1 = pDie.getResults(0);
   int pr2 = pDie.getResults(1);
   int pr3 = pDie.getResults(2);
   int pr4 = pDie.getResults(3);
   int pr5 = pDie.getResults(4);

   System.out.println("Player dice roll 1 = "+ pr1);
   System.out.println("Player dice roll 2 = "+ pr2);
   System.out.println("Player dice roll 3 = "+ pr3);
   System.out.println("Player dice roll 4 = "+ pr4);
   System.out.println("Player dice roll 5 = "+ pr5);



   if (pr1 == 1) {
      pOne++ ;
   } else if (pr1 == 2) {
      pTwo++ ;
   } else if (pr1 == 3) {
      pThree++ ;
   } else if (pr1 == 4) {
      pFour++ ;
   } else if (pr1 == 5) {
      pFive++ ;
   } else {
      pSix++ ;
   }

   if (pr2 == 1) {
      pOne++ ;
   } else if (pr2 == 2) {
      pTwo++ ;
   } else if (pr2 == 3) {
      pThree++ ;
   } else if (pr2 == 4) {
      pFour++ ;
   } else if (pr2 == 5) {
      pFive++ ;
   } else {
      pSix++ ;
   }

   if (pr3 == 1) {
      pOne++ ;
   } else if (pr3 == 2) {
      pTwo++ ;
   } else if (pr3 == 3) {
      pThree++ ;
   } else if (pr3 == 4) {
      pFour++ ;
   } else if (pr3 == 5) {
      pFive++ ;
   } else {
      pSix++ ;
   }

   if (pr4 == 1) {
      pOne++ ;
   } else if (pr4 == 2) {
      pTwo++ ;
   } else if (pr4 == 3) {
      pThree++ ;
   } else if (pr4 == 4) {
      pFour++ ;
   } else if (pr4 == 5) {
      pFive++ ;
   } else {
      pSix++ ;
   }

   if (pr5 == 1) {
      pOne++ ;
   } else if (pr5 == 2) {
      pTwo++ ;
   } else if (pr5 == 3) {
      pThree++ ;
   } else if (pr5 == 4) {
      pFour++ ;
   } else if (pr5 == 5) {
      pFive++ ;
   } else {
      pSix++ ;
   }

   // System.out.println(pOne); Used for testing purposes of dice values
   //System.out.println(pTwo);
   // System.out.println(pThree);
   //System.out.println(pFour);
   //System.out.println(pFive);
   //System.out.println(pSix);

   if (pOne == 5){ // 5 of kind
     playerScore = 1;
   } else if (pTwo == 5) {
     playerScore = 2;
   } else if (pThree == 5) {
     playerScore = 3;
   } else if (pFour == 5) {
     playerScore = 4;
   } else if (pFive == 5) {
     playerScore = 5;
   } else if (pSix == 5) {
     playerScore = 6;
   } else if (pOne == 4) { //four of kind
     playerScore = 7;
   } else if (pTwo == 4) {
     playerScore = 8;
   } else if (pThree == 4) {
     playerScore = 9;
   } else if (pFour == 4) {
     playerScore = 10;
   } else if (pFive == 4) {
     playerScore = 11;
   } else if (pSix == 4) {
     playerScore = 12;
   } else if (pOne == 3) { // Three of kind
     playerScore = 13;
   } else if (pTwo == 3) {
     playerScore = 14;
   } else if (pThree == 3) {
     playerScore = 15;
   } else if (pFour == 3) {
     playerScore = 16;
   } else if (pFive == 3) {
     playerScore = 17;
   } else if (pSix == 3) {
     playerScore = 18;
   } else if (pOne == 2) {// Pairs
     playerScore = 19;
   } else if (pTwo == 2) {
     playerScore = 20;
   } else if (pThree == 2) {
     playerScore = 21;
   } else if (pFour == 2) {
     playerScore = 22;
   } else if (pFive == 2) {
     playerScore = 23;
   } else if (pSix == 2) {
     playerScore = 24;
   } else if (pOne == 1) { // One of a kind
     playerScore = 25;
   } else if (pTwo == 1) {
     playerScore = 26;
   } else if (pThree == 1) {
     playerScore = 27;
   } else if (pFour == 1) {
     playerScore = 28;
   } else if (pFive == 1) {
     playerScore = 29;
   } else if (pSix == 1) {
     playerScore = 30;
   }

   //System.out.println(gameScore); Used for testing puposes to see games scoring system
   //System.out.println(playerScore);

   if (playerScore < gameScore) {
     System.out.println("You win");
     double newMoney = money + bet*2; 
     System.out.println("New balance is $"+ newMoney );
   } else if (gameScore <= playerScore) {
     System.out.println("You lose");
   }

  }
}
}
