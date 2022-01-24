import java.util.*;
import java.text.*;
import java.awt.Color;
import DLibX.*;

public class Crash extends Game {

  public void run(Player p, DConsole dc) {

    DecimalFormat df = new DecimalFormat("0.00");
    boolean validGame = false;
    boolean validInput = false;
    double bet = 0;

    System.out.println("Welcome to a game I came up with in the shower this morning!");
    System.out.println("This is shamelessly and unapologetically based on a game that I've seen in online gambling websites, I even stole the name.");
    System.out.println("This is going to be a short introduction of the rules.");
    System.out.println("You can either choose to roll the dice or cash out.");
    System.out.println("Rolling the dice will increase the return percent on your bet, but there are two faces that will end your run.");
    System.out.println("Cashing out takes the return and ends the game. There is no penalty associated with it.");
    System.out.println();

    dc.drawImage("CrashAssets/crash_title.png", 225, 150);
    dc.redraw();

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

    if (validGame) {
      p.changeMoney(-bet);
      System.out.println("You have: " + df.format(p.getMoney()) + " dollars that have not been wagered.");
      System.out.println();
      double mouseX;
      double mouseY;
      int clickCooldown = 0;
      boolean gameRunning = true;
      double modifier = 1.0;
      int diceRolled = 0;
      Dice parentDie = new Dice(dc, 0 , 0);

      while (gameRunning) {
        mouseX = dc.getMouseXPosition();
        mouseY = dc.getMouseYPosition();

        //Draw the interface
        dc.drawImage("CrashAssets/table.png", 225, 150);
        dc.setPaint(Color.BLACK);
        dc.drawString(df.format(bet*modifier), 81.5, 225);
        dc.drawString(df.format(bet), 368.5, 225);
        //draws the latest 5 dice
        for (int i = 0; i < 5; i++) {
          if (i < diceRolled) {
            if (parentDie.getResults((diceRolled - 1)-i) == 2) {
              dc.drawImage("CrashAssets/roll2.png", 97.5 + (i*65), 97.5);
            }
            if (parentDie.getResults((diceRolled - 1)-i) == 3) {
              dc.drawImage("CrashAssets/roll3.png", 97.5 + (i*65), 97.5);
            }
            if (parentDie.getResults((diceRolled - 1)-i) == 4) {
              dc.drawImage("CrashAssets/roll4.png", 97.5 + (i*65), 97.5);
            }
            if (parentDie.getResults((diceRolled - 1)-i) == 5) {
              dc.drawImage("CrashAssets/roll5.png", 97.5 + (i*65), 97.5);
            }
            if (parentDie.getResults((diceRolled - 1)-i) == 1 || parentDie.getResults((diceRolled - 1)-i) == 6) {
              dc.drawImage("CrashAssets/roll16.png", 97.5 + (i*65), 97.5);
            }
          }
        }
        
        if (320 > mouseX && mouseX > 130 && 225.5 > mouseY && mouseY > 184.5) {
          dc.drawImage("CrashAssets/staylit.png", 225, 205);
            if (dc.getMouseButton(1)) {
              //roll le dice
              parentDie.rollDice(1);
              diceRolled++;

              //Add it to the modifier or lose
              double temp = parentDie.getResults(diceRolled-1);
              if (parentDie.getResults(diceRolled-1) == 6 || parentDie.getResults(diceRolled-1) == 1) {
                //Lose
                if (diceRolled == 1) {
                  dc.drawImage("CrashAssets/roll16.png", 97.5, 97.5);
                }
                gameRunning = false;
                dc.redraw();
                System.out.println("The dice have crashed!");
                dc.redraw();
                System.out.println();
              } else {
                temp/=25;
                modifier += temp;
              }
            }
        } else {
          dc.drawImage("CrashAssets/staydark.png", 225, 205);
        }
        if (320 > mouseX && mouseX > 130 && 275.5 > mouseY && mouseY > 234.5) {
          if (dc.getMouseButton(1)) {
            //cash out
            gameRunning = false;
            p.changeMoney(bet*modifier);
          }
          dc.drawImage("CrashAssets/golit.png", 225, 255);
        } else {
          dc.drawImage("CrashAssets/godark.png", 225, 255);
        }

        dc.redraw();
        if (diceRolled > 0) {
          if (parentDie.getResults(diceRolled-1) == 6 || parentDie.getResults(diceRolled-1) == 1) {
            dc.pause(2000);
          } else {
            dc.pause(20);
          }
        }
      } //while gameRunning
      
    } //if validGame
    

  } //run method

} //class