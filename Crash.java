import java.util.*;
import java.text.*;
import java.awt.Color;
import DLibX.*;

public class Crash extends Game {

  public void run(Player p, DConsole dc) {

    //Variables for later use
    DecimalFormat df = new DecimalFormat("0.00");
    boolean validGame = false;
    boolean validInput = false;
    double bet = 0;

    //Instructionms
    System.out.println("Welcome to a game I came up with in the shower this morning!");
    System.out.println("This is shamelessly and unapologetically based on a game that I've seen in online gambling websites, I even stole the name.");
    System.out.println("This is going to be a short introduction of the rules.");
    System.out.println("You can either choose to roll the dice or cash out.");
    System.out.println("Rolling the dice will increase the return percent on your bet, but there are two faces that will end your run.");
    System.out.println("Cashing out takes the return and ends the game. There is no penalty associated with it.");
    System.out.println();

    //Drawing a loading screen
    dc.drawImage("CrashAssets/crash_title.png", 225, 150);
    dc.redraw();

    //Generic form for taking string input
    Scanner sc = new Scanner(System.in);
    String input;

    while (!validInput){

      //Prompt for and store user input
      System.out.print("Input the amount of money to bet: ");
      input = sc.nextLine();
      System.out.println();

      //Abusing try-catch loop to catch incorrect input instead of bugs
      try {
        //exit code
        if (input.contains("xx")) {
          validInput = true;
        } else {
          //Parse input to a double. this is the line that throws the error if it is an invalid input
          bet = Double.parseDouble(input);
          //We can assume the bet is actually a proper double now. Validate that it is a valid amount of money
          if (0 < bet && bet <= p.getMoney()) {
            //It was a valid input and the bet is valid
            validInput = true;
            validGame = true;
          } else if (bet <= 0) {
            //Retry
            System.out.println("You cannot bet zero or less. Please input a proper bet, or input 'xx' to return to the menu.");
            System.out.println();
          } else {
            //Retry
            System.out.println("You don't have that much money. Please input a proper bet, or input 'xx' to return to the menu.");
            System.out.println();
          }
        }

      } catch (Exception e) {
        //Retry
        System.out.println("Something has gone wrong. Please input a proper bet, or input 'xx' to return to the menu.");
        System.out.println();
      }

    }

    //The exit command is a valid input but not a valid game so we skip the actual game loop
    if (validGame) {
      //Take away the bet
      p.changeMoney(-bet);
      //Let them know their remaining balance
      System.out.println("You have: " + df.format(p.getMoney()) + " dollars that have not been wagered.");
      System.out.println();

      //Tracking for boxes
      double mouseX;
      double mouseY;

      //So the game loop doesnt end when i dont want it to
      boolean gameRunning = true;

      //Self explanatory
      double modifier = 1.0;

      //Read the name bro
      int diceRolled = 0;

      //Name is a relic of a previous way I intended to structure the code, just know that this is how the dice get rolled
      Dice parentDie = new Dice(dc, 0 , 0);

      while (gameRunning) {

        //Update mouse posiitions
        mouseX = dc.getMouseXPosition();
        mouseY = dc.getMouseYPosition();

        //This literally just draws the interface
        dc.drawImage("CrashAssets/table.png", 225, 150);
        dc.setPaint(Color.BLACK);
        dc.drawString(df.format(bet*modifier), 81.5, 225);
        dc.drawString(df.format(bet), 368.5, 225);

        //Draws the latest five dice
        for (int i = 0; i < 5; i++) {
          //This stops it from printing dice that have not been rolled yet
          if (i < diceRolled) {
            //A 2 was rolled
            if (parentDie.getResults((diceRolled - 1)-i) == 2) {
              dc.drawImage("CrashAssets/roll2.png", 97.5 + (i*65), 97.5);
            }
            //A 3 was rolled
            if (parentDie.getResults((diceRolled - 1)-i) == 3) {
              dc.drawImage("CrashAssets/roll3.png", 97.5 + (i*65), 97.5);
            }
            //Et cetera
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
        
        //Within the roll again box
        if (320 > mouseX && mouseX > 130 && 225.5 > mouseY && mouseY > 184.5) {
          //Draw the shiny lit up box that looks cool :)
          dc.drawImage("CrashAssets/staylit.png", 225, 205);
          //If you click the box
            if (dc.getMouseButton(1)) {
              //roll a dice
              parentDie.rollDice(1);
              diceRolled++;

              //Add it to the modifier or lose depending on the role
              double temp = parentDie.getResults(diceRolled-1);

              if (parentDie.getResults(diceRolled-1) == 6 || parentDie.getResults(diceRolled-1) == 1) {
                //Lose
                //It wasnt printing properly on a loss how i wanted it to and this assignment is due early tomorrow so i make it print again cause i lazy
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
                //Game is not in fact supposed to run any more
                gameRunning = false;
                //DRAW IT DRAW IT DRAW IT
                dc.redraw();
                //Prompt
                System.out.println("The dice have crashed!");
                System.out.println();
              } else {
                //This wasn't a loss
                //The roll of the dice over 25 makes it add itself times 4 as a percent, which is what is actually displayed in the UI on my dice images
                temp/=25;
                modifier += temp;
              }
            }
        } else {
          //The mouse wasn't over that box so it is drawn in dark
          dc.drawImage("CrashAssets/staydark.png", 225, 205);
        }

        //Other box
        if (320 > mouseX && mouseX > 130 && 275.5 > mouseY && mouseY > 234.5) {
          //If box clicked
          if (dc.getMouseButton(1)) {
            //cash out
            gameRunning = false;
            p.changeMoney(bet*modifier);
          }
          //This isn't in the if statement it just ended up right here in the code for some reason
          dc.drawImage("CrashAssets/golit.png", 225, 255);
        } else {
          //It isnt being hovered so its drawn in dark
          dc.drawImage("CrashAssets/godark.png", 225, 255);
        }

        //DRAW IT
        dc.redraw();

        if (diceRolled > 0) {
          //If it was a loss i want to make them look at the loss dice lmao
          if (parentDie.getResults(diceRolled-1) == 6 || parentDie.getResults(diceRolled-1) == 1) {
            dc.pause(2000);
          } else {
            //if it wasnt a loss the normal pause
            dc.pause(20);
          }
        }
      } //while gameRunning
      
    } //if validGame
    

  } //run method

} //class